package stepdefinitions;
import io.cucumber.java.*;                 // Before, After, AfterStep, Scenario
import io.cucumber.java.en.*;              // Given, When, Then, And
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.Yusuf;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.JSUtilities;
import utilities.ReusableMethods;
// ===== Extent =====
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
// ===== Excel (Apache POI) =====
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.nio.file.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class YusufSteps {

    // ------------ DRIVER & PAGE ------------
    private WebDriver driver;
    private Yusuf yusuf;

    // ------------ RAPOR / EXCEL sabitleri ------------
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static final String REPORT_DIR = System.getProperty("user.dir") + File.separator + "reports";
    private static final String SPARK_HTML = REPORT_DIR + File.separator + "ExtentReport.html";
    private static final String EXCEL_PATH = REPORT_DIR + File.separator + "step-results.xlsx";
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // EKRAN GÖRÜNTÜSÜ klasörü -> @Before içinde dolduracağız
    private String screenshotDir;

    private LocalDateTime scenarioStart;
    private int stepIndex = 0;

    private static void ensureDirs() {
        try { Files.createDirectories(Paths.get(REPORT_DIR)); } catch (Exception ignored) {}
    }

    // ==================== SCENARIO BAŞLANGICI (TEK @Before!) ====================
    @Before(order = 0)
    public void setUp(Scenario scenario) {
        ensureDirs();

        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(SPARK_HTML);
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "InstuLearn");
        }

        // Kullanıcı istediği klasörü verebilsin:
        //  1) Maven param: -DscreenshotDir=C:/BenimKlasor
        //  2) config.properties: screenshotDir=C:/BenimKlasor
        //  3) default: <project>/reports/screenshots
        screenshotDir = resolveScreenshotDir();

        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        yusuf = new Yusuf(driver);

        ExtentTest t = extent.createTest(scenario.getName());
        test.set(t);

        scenarioStart = LocalDateTime.now();
        stepIndex = 0;

        excelAppendRow("SCENARIO_START", scenario.getName(), "INFO", TS.format(scenarioStart), "");
    }

    // ==================== HER ADIM SONRASI (TEK @AfterStep!) ====================
    @AfterStep
    public void afterEachStep(Scenario scenario) {
        stepIndex++;
        String label = "STEP_" + stepIndex;
        captureAndAttach(scenario, label);
        excelAppendRow("STEP", label, "INFO", TS.format(LocalDateTime.now()), scenario.getName());
    }

    // ==================== SCENARIO BİTİŞİ (TEK @After!) ====================
    @After(order = 0)
    public void tearDown(Scenario scenario) {
        String status = scenario.isFailed() ? "FAIL" : "PASS";

        if (scenario.isFailed()) {
            try {
                // Ek hata görseli
                String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                test.get().fail("Scenario failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
                byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(png, "image/png", "SCENARIO FAILED");
            } catch (Exception ignored) {}
        } else {
            test.get().pass("Scenario passed");
        }

        excelAppendRow("SCENARIO_END", scenario.getName(), status, TS.format(LocalDateTime.now()), "");

        try { extent.flush(); } catch (Exception ignored) {}
        try { DriverManager.quitDriver(); } catch (Exception ignored) {}
    }

    // ==================== SCREENSHOT HELPER ====================
    private void captureAndAttach(Scenario scenario, String label) {
        try {
            if (driver == null) return;

            // Dosya ismi: STEP_1_2025-10-03_12-33-45.png
            String fileName = label + "_" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".png";

            Path dest = Paths.get(screenshotDir, fileName);
            Files.createDirectories(dest.getParent());

            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(dest, png); // diske kaydet

            // 1) Cucumber HTML raporuna ekle
            scenario.attach(png, "image/png", label);

            // 2) Extent raporuna DOSYA YOLUYLA ekle (relative path)
            Path reportDir = Paths.get(SPARK_HTML).getParent().toAbsolutePath();   // .../reports
            Path screenshotAbs = dest.toAbsolutePath();
            String relativeToReport = reportDir.relativize(screenshotAbs).toString(); // screenshots/STEP_...png

            if (test.get() != null) {
                test.get().info(label,
                        MediaEntityBuilder.createScreenCaptureFromPath(relativeToReport, fileName).build());
            }
        } catch (Exception e) {
            System.err.println("Screenshot alınamadı: " + e.getMessage());
            if (test.get() != null) {
                test.get().warning(label + " -> Screenshot alınamadı: " + e.getMessage());
            }
        }
    }

    // ==================== SCREENSHOT DİZİNİ ÇÖZ ====================
    private String resolveScreenshotDir() {
        // 1) JVM parametresi
        String viaSys = System.getProperty("screenshotDir");
        if (viaSys != null && !viaSys.isBlank()) return viaSys;

        // 2) config.properties
        try {
            String viaCfg = ConfigReader.getProperty("screenshotDir");
            if (viaCfg != null && !viaCfg.isBlank()) return viaCfg;
        } catch (Throwable ignored) {}

        // 3) varsayılan
        return REPORT_DIR + File.separator + "screenshots";
    }

    // ==================== EXCEL HELPER ====================
    private static synchronized void excelAppendRow(String type, String message, String status,
                                                    String time, String extra) {
        try {
            XSSFWorkbook wb;
            Sheet sh;
            File f = new File(EXCEL_PATH);

            if (f.exists()) {
                try (FileInputStream in = new FileInputStream(f)) {
                    wb = new XSSFWorkbook(in);
                }
                sh = wb.getSheet("Results");
                if (sh == null) sh = wb.createSheet("Results");
            } else {
                wb = new XSSFWorkbook();
                sh = wb.createSheet("Results");
                Row header = sh.createRow(0);
                header.createCell(0).setCellValue("Type");
                header.createCell(1).setCellValue("Message");
                header.createCell(2).setCellValue("Status");
                header.createCell(3).setCellValue("Time");
                header.createCell(4).setCellValue("Extra");
            }

            int rowNum = sh.getLastRowNum() + 1;
            if (rowNum == 0 && sh.getRow(0) != null) rowNum = 1;

            Row r = sh.createRow(rowNum);
            r.createCell(0).setCellValue(type == null ? "" : type);
            r.createCell(1).setCellValue(message == null ? "" : message);
            r.createCell(2).setCellValue(status == null ? "" : status);
            r.createCell(3).setCellValue(time == null ? "" : time);
            r.createCell(4).setCellValue(extra == null ? "" : extra);

            try (FileOutputStream out = new FileOutputStream(EXCEL_PATH)) {
                wb.write(out);
            }
            wb.close();
        } catch (Exception e) {
            System.err.println("Excel yazım hatası: " + e.getMessage());
        }
    }

    // ==================== AŞAĞIDA SENİN TÜM STEPLERİN (AYNEN) ====================

    //-----------------26-START-----------------
    @Given("The user accesses the homepage using the relevant URL.")
    public void the_user_accesses_the_homepage_using_the_relevant_url() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
    }

    @Given("The user clicks {string} and logs in with their valid instructor email and password.")
    public void the_user_clicks_and_logs_in_with_their_valid_instructor_email_and_password(String string) {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @And("The user scrolls down until they see the My Certificates link.")
    public void theUserScrollsDownUntilTheySeeTheMyCertificatesLink() {
        WebElement certificatesLink = yusuf.myCertificatesLink;
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", certificatesLink);
        ReusableMethods.waitForVisibility(certificatesLink, 5);
        Assertions.assertTrue(certificatesLink.isDisplayed(), "My Certificates link is not visible!");
    }

    @Then("The user clicks the Certificates button.")
    public void theUserClicksTheCertificatesButton() {
        WebElement certificatesButton = yusuf.certificatesButton;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();
    }

    @Given("The user clicks list.")
    public void theUserClicksList() {
        WebElement listButton = yusuf.listButton;
        ReusableMethods.waitForVisibility(listButton, 5);
        Assertions.assertTrue(listButton.isDisplayed(), "List button is not visible!");
        listButton.click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks Achievements.")
    public void theUserClicksAchievements() {
        WebElement achievements = yusuf.achievements;
        ReusableMethods.waitForVisibility(achievements, 5);
        Assertions.assertTrue(achievements.isDisplayed(), "List button is not visible!");
        achievements.click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks Certificate Verification.")
    public void theUserClicksCertificateVerification() {
        WebElement certificateValidation = yusuf.certificateValidation;
        ReusableMethods.waitForVisibility(certificateValidation, 5);
        Assertions.assertTrue(certificateValidation.isDisplayed(), "Certificate Verification button is not visible!");
        certificateValidation.click();
        ReusableMethods.waitFor(2);
        DriverManager.getDriver().navigate().back();
        ReusableMethods.waitFor(2);
    }

    @And("The user returns to the page first.")
    public void theUserReturnsToThePageFirst() {
        WebElement completionCertificates = yusuf.completionCertificates;
        ReusableMethods.waitForVisibility(completionCertificates, 5);
        Assertions.assertTrue(completionCertificates.isDisplayed(), "Certificate Verification button is not visible!");
        completionCertificates.click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks Certificates of Completion The page scrolls down until the user sees the exit link first.")
    public void theUserClicksCertificatesOfCompletionThePageScrollsDownUntilTheUserSeesTheExitLinkFirst() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
    }

    @Then("The user clicks the Exit button first.")
    public void theUserClicksTheExitButtonFirst() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }

    //---11---

    @Given("The user clicks the List.")
    public void theUserClicksTheList() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);

        //-----click Certificates----
        WebElement certificatesButton = yusuf.certificatesButton;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();

        //-----click List----
        WebElement listButton = yusuf.listButton;
        ReusableMethods.waitForVisibility(listButton, 5);
        Assertions.assertTrue(listButton.isDisplayed(), "List button is not visible!");
        listButton.click();
        ReusableMethods.waitFor(2);
    }

    //---12---
    @Then("Confirms that the Certificate statistics link is visible and active.")
    public void confirmsThatTheCertificateStatisticsLinkIsVisibleAndActive() {
        WebElement certificateStatisticsLink = yusuf.certificateStatisticsLink;
        ReusableMethods.waitForVisibility(certificateStatisticsLink, 5);
        Assertions.assertTrue(certificateStatisticsLink.isDisplayed(), "Certificate Statistics link is not visible!");
        Assertions.assertTrue(certificateStatisticsLink.isEnabled(), "Certificate Statistics link is not active!");
    }

    //---13---
    @And("The user sees and clicks the filtering icons.")
    public void theUserSeesAndClicksTheFilteringIcons() {
        // From date zone
        WebElement fromDate = yusuf.fromDateIcon;
        ReusableMethods.waitForVisibility(fromDate, 5);
        Assertions.assertTrue(fromDate.isDisplayed(), "From date icon is not visible!");
        fromDate.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(yusuf.fromDateIcon, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_Yusuf"));
        ReusableMethods.waitFor(1);

        // To date zone
        WebElement toDate = yusuf.toDateIcon;
        ReusableMethods.waitForVisibility(toDate, 5);
        Assertions.assertTrue(toDate.isDisplayed(), "To date icon is not visible!");
        toDate.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(yusuf.toDateIcon, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_to"));
        ReusableMethods.waitFor(1);

        // Course dropdown
        WebElement courseDropdown = yusuf.courseDropdown;
        ReusableMethods.waitForVisibility(courseDropdown, 5);
        Assertions.assertTrue(courseDropdown.isDisplayed(), "Course dropdown is not visible!");
        courseDropdown.click();
        ReusableMethods.waitFor(1);

        // Quiz dropdown
        WebElement quizDropdown = yusuf.quizDropdown;
        ReusableMethods.waitForVisibility(quizDropdown, 5);
        Assertions.assertTrue(quizDropdown.isDisplayed(), "Quiz dropdown is not visible!");
        quizDropdown.click();
        ReusableMethods.waitFor(1);

        // Grade input zone
        WebElement gradeBox = yusuf.gradeInput;
        ReusableMethods.waitForVisibility(gradeBox, 5);
        Assertions.assertTrue(gradeBox.isDisplayed(), "Grade input is not visible!");
        gradeBox.click();
        ReusableMethods.waitFor(1);

        // Show Results button
        WebElement showResultsButton = yusuf.showResultsButton;
        ReusableMethods.waitForVisibility(showResultsButton, 5);
        Assertions.assertTrue(showResultsButton.isDisplayed(), "Show Results button is not visible!");
        showResultsButton.click();
        ReusableMethods.waitFor(2);
    }

    //---14---
    @And("The page scrolls down until the user sees the exit link.")
    public void thePageScrollsDownUntilTheUserSeesTheExitLink() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
    }

    //---15---
    @Then("The user clicks the Exit button.")
    public void theUserClicksTheExitButton() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }

    //---16---
    @Given("The user clicks the {string} heading.")
    public void theUserClicksTheHeading(String arg0) {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);

        //-----click Certificates----
        WebElement certificatesButton = yusuf.certificatesButton;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();

        WebElement certificateStatisticsLink = yusuf.certificateStatisticsLink;
        ReusableMethods.waitForVisibility(certificateStatisticsLink, 5);
        Assertions.assertTrue(certificateStatisticsLink.isDisplayed(), "Certificate Statistics link is not visible!");
        Assertions.assertTrue(certificateStatisticsLink.isEnabled(), "Certificate Statistics link is not active!");
    }

    //---17---
    @Then("The user sees the {string} heading.")
    public void theUserSeesTheHeading(String arg0) {
        WebElement achievements = yusuf.achievements;
        ReusableMethods.waitForVisibility(achievements, 5);
        Assertions.assertTrue(achievements.isDisplayed(), "List button is not visible!");
        achievements.click();
        ReusableMethods.waitFor(2);
    }

    //---18---
    @And("The user sees and clicks the filter icons.")
    public void theUserSeesAndClicksTheFilterIcons() {
        WebElement fromDate = yusuf.fromDateIconachievements;
        ReusableMethods.waitForVisibility(fromDate, 5);
        Assertions.assertTrue(fromDate.isDisplayed(), "From date icon is not visible!");
        fromDate.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(yusuf.fromDateIconachievements, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_Yusuf"));
        ReusableMethods.waitFor(1);

        WebElement toDate = yusuf.toDateIconachievements;
        ReusableMethods.waitForVisibility(toDate, 5);
        Assertions.assertTrue(toDate.isDisplayed(), "To date icon is not visible!");
        toDate.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(yusuf.toDateIconachievements, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_to"));
        ReusableMethods.waitFor(1);

        WebElement courseDropdown = yusuf.courseDropdownachievements;
        ReusableMethods.waitForVisibility(courseDropdown, 5);
        Assertions.assertTrue(courseDropdown.isDisplayed(), "Course dropdown is not visible!");
        courseDropdown.click();
        ReusableMethods.waitFor(1);

        WebElement quizDropdown = yusuf.quizDropdownachievements;
        ReusableMethods.waitForVisibility(quizDropdown, 5);
        Assertions.assertTrue(quizDropdown.isDisplayed(), "Quiz dropdown is not visible!");
        quizDropdown.click();
        ReusableMethods.waitFor(1);

        WebElement gradeBox = yusuf.gradeInputachievements;
        ReusableMethods.waitForVisibility(gradeBox, 5);
        Assertions.assertTrue(gradeBox.isDisplayed(), "Grade input is not visible!");
        gradeBox.click();
        ReusableMethods.waitFor(1);

        WebElement showResultsButton = yusuf.showResultsButtonachievements;
        ReusableMethods.waitForVisibility(showResultsButton, 5);
        Assertions.assertTrue(showResultsButton.isDisplayed(), "Show Results button is not visible!");
        showResultsButton.click();
        ReusableMethods.waitFor(2);
    }

    //---19---
    @And("The user clicks the Certificates button again.")
    public void theUserClicksTheCertificatesButtonAgain() {
        WebElement certificatesButton = yusuf.certificatesButton;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();
    }

    //---20---
    @And("The user scrolls down until they see the exit link.")
    public void theUserScrollsDownUntilTheySeeTheExitLink() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
    }

    //---21---
    @Then("The user clicks the Exit button again.")
    public void theUserClicksTheExitButtonAgain() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }

    //---22---
    @Given("The user clicks the Certificate Verification banner.")
    public void theUserClicksTheCertificateVerificationBanner() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);

        WebElement certificatesButton = yusuf.certificatesButton;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();

        WebElement certificateStatisticsLink = yusuf.certificateStatisticsLink;
        ReusableMethods.waitForVisibility(certificateStatisticsLink, 5);
        Assertions.assertTrue(certificateStatisticsLink.isDisplayed(), "Certificate Statistics link is not visible!");
        Assertions.assertTrue(certificateStatisticsLink.isEnabled(), "Certificate Statistics link is not active!");
    }

    //---23---
    @Then("The user sees the ID and captcha.")
    public void theUserSeesTheIDAndCaptcha() {
        WebElement certificateValidation = yusuf.certificateValidation;
        ReusableMethods.waitForVisibility(certificateValidation, 5);
        Assertions.assertTrue(certificateValidation.isDisplayed(), "Certificate Verification button is not visible!");
        certificateValidation.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.certificate_id, 2).sendKeys(ConfigReader.getProperty("CertificateID"));
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.Captcha_yusuf, 2).sendKeys(ConfigReader.getProperty("Captcha_yusuf"));
        ReusableMethods.waitFor(2);
        WebElement showResultsButton = yusuf.submit;
        ReusableMethods.waitForVisibility(showResultsButton, 5);
        Assertions.assertTrue(showResultsButton.isDisplayed(), "Show Results button is not visible!");
        showResultsButton.click();
        ReusableMethods.waitFor(2);
    }

    //---24---
    @And("The user returns to the page.")
    public void theUserReturnsToThePage() {
        DriverManager.getDriver().navigate().back();
        ReusableMethods.waitFor(2);
        try {
            String title = DriverManager.getDriver().getTitle();
            System.out.println("Returned to page: " + title);
        } catch (Exception ignored) {}
    }

    //---25---
    @And("The page scrolls down until the user sees the exit link again.")
    public void thePageScrollsDownUntilTheUserSeesTheExitLinkAgain() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
    }

    //---26---
    @Then("The user clicks the Exit button last again.")
    public void theUserClicksTheExitButtonLastAgain() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }

    //---27---
    @Given("The user clicks the Completion Certificates heading.")
    public void theUserClicksTheCompletionCertificatesHeading() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);

        WebElement certificatesButton = yusuf.certificatesButton;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();

        WebElement certificateStatisticsLink = yusuf.certificateStatisticsLink;
        ReusableMethods.waitForVisibility(certificateStatisticsLink, 5);
        Assertions.assertTrue(certificateStatisticsLink.isDisplayed(), "Certificate Statistics link is not visible!");
        Assertions.assertTrue(certificateStatisticsLink.isEnabled(), "Certificate Statistics link is not active!");
    }

    //---28---
    @Then("The user sees the Filter certificates heading.")
    public void theUserSeesTheFilterCertificatesHeading() {
        WebElement completionCertificates = yusuf.completionCertificates;
        ReusableMethods.waitForVisibility(completionCertificates, 5);
        Assertions.assertTrue(completionCertificates.isDisplayed(), "Certificate Verification button is not visible!");
        completionCertificates.click();
        ReusableMethods.waitFor(2);
    }

    //---29---
    @And("The user clicks the Show Results heading.")
    public void theUserClicksTheShowResultsHeading() {
        WebElement fromDate = yusuf.fromDateIconCompletionCertificates;
        ReusableMethods.waitForVisibility(fromDate, 5);
        Assertions.assertTrue(fromDate.isDisplayed(), "From date icon is not visible!");
        fromDate.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(yusuf.fromDateIconCompletionCertificates, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_Yusuf"));
        ReusableMethods.waitFor(1);

        WebElement toDate = yusuf.toDateIconCompletionCertificates;
        ReusableMethods.waitForVisibility(toDate, 5);
        Assertions.assertTrue(toDate.isDisplayed(), "To date icon is not visible!");
        toDate.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(yusuf.toDateIconCompletionCertificates, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_to"));
        ReusableMethods.waitFor(1);

        WebElement courseDropdown = yusuf.courseDropdownCompletionCertificates;
        ReusableMethods.waitForVisibility(courseDropdown, 5);
        Assertions.assertTrue(courseDropdown.isDisplayed(), "Course dropdown is not visible!");
        courseDropdown.click();
        ReusableMethods.waitFor(1);

        WebElement showResultsButton = yusuf.showResultsButtonCompletionCertificates;
        ReusableMethods.waitForVisibility(showResultsButton, 5);
        Assertions.assertTrue(showResultsButton.isDisplayed(), "Show Results button is not visible!");
        showResultsButton.click();
        ReusableMethods.waitFor(2);
    }

    //---30---
    @And("The page scrolls down until the user sees the exit link last.")
    public void thePageScrollsDownUntilTheUserSeesTheExitLinkLast() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
    }

    //---31---
    @Then("The user clicks the Exit button last.")
    public void theUserClicksTheExitButtonLast() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }

    //---32---
    @And("The user closes the page.")
    public void theUserClosesThePage() {
        DriverManager.getDriver().quit();
    }

    //-----------------26-THE-END-----------------

    //****************************************@@@@@@@@@@@****************************************

    //-----------------38-START-----------------

    @Given("The user accesses the homepage with the relevant URL \\(first)")
    public void theUserAccessesTheHomepageWithTheRelevantURLFirst() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks Login and logs in with valid instructor credentials \\(first)")
    public void theUserClicksLoginAndLogsInWithValidInstructorCredentialsFirst() {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        Yusuf headerPage = new Yusuf(driver);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", headerPage.emailBox);
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) driver).executeScript(highlightScript, headerPage.emailBox);
        Assertions.assertTrue(headerPage.emailBox.isDisplayed(), "Log In link is not visible!");
        ReusableMethods.waitFor(4);

        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", headerPage.passwordBox);
        String highlightScript1 =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) driver).executeScript(highlightScript1, headerPage.passwordBox);
        Assertions.assertTrue(headerPage.passwordBox.isDisplayed(), "Log In link is not visible!");
        ReusableMethods.waitFor(4);

        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @And("The user scrolls down the page \\(first)")
    public void theUserScrollsDownThePageFirst() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
    }

    @Then("The Log Out link at the bottom of the left menu should be visible and clickable \\(first)")
    public void theLogOutLinkAtTheBottomOfTheLeftMenuShouldBeVisibleAndClickableFirst() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }
    //------1-THE-END------

    //------2-START------

    @Given("The user accesses the homepage with the relevant URL \\(second)")
    public void theUserAccessesTheHomepageWithTheRelevantURLSecond() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks Login and logs in with valid instructor credentials \\(second)")
    public void theUserClicksLoginAndLogsInWithValidInstructorCredentialsSecond() {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @And("The user scrolls up the page \\(second)")
    public void theUserScrollsDownThePageSecond() {
        WebElement instulearn = yusuf.instulearn;
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", instulearn);
        ReusableMethods.waitForVisibility(instulearn, 5);
        Assertions.assertTrue(instulearn.isDisplayed(), "My Certificates link is not visible!");
        yusuf.instulearn.click();

        ReusableMethods.waitForVisibility(yusuf.hoverTargetSpan, 10);
        JSUtilities.scrollToElement(driver, yusuf.hoverTargetSpan);
        try {
            new Actions(driver)
                    .moveToElement(yusuf.hoverTargetSpan)
                    .pause(Duration.ofMillis(200))
                    .perform();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles:true, cancelable:true, view:window});" +
                            "arguments[0].dispatchEvent(ev);",
                    yusuf.hoverTargetSpan
            );
        }

        ReusableMethods.waitFor(1);
        WebElement target = yusuf.dropdownLogoutLink;
        JSUtilities.scrollToElement(driver, target);
        ReusableMethods.waitForVisibility(target, 5);
        yusuf.dropdownLogoutLink.click();
    }

    @Then("The Log Out link at the up of the right menu should be visible and clickable \\(second)")
    public void theLogOutLinkAtTheBottomOfTheLeftMenuShouldBeVisibleAndClickableSecond() {
        try {
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("window.scrollTo(0,0)");
        } catch (Exception ignored) {}

        WebElement loginBtn = yusuf.headerLoginButton;

        ReusableMethods.waitForVisibility(loginBtn, 10);
        Assertions.assertAll(
                () -> Assertions.assertTrue(loginBtn.isDisplayed(),
                        "Login button is not visible in the header!"),
                () -> Assertions.assertTrue(loginBtn.isEnabled(),
                        "Login button is not enabled!")
        );

        try {
            String txt = loginBtn.getText().trim().toLowerCase();
            Assertions.assertTrue(
                    txt.contains("login") || txt.contains("log in") || txt.contains("sign in"),
                    "Unexpected header button text: " + txt
            );
        } catch (Exception ignored) {}
    }
    //------2-THE-END------


    @Given("The user accesses the homepage with the relevant URL \\(third)")
    public void theUserAccessesTheHomepageWithTheRelevantURLThird() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks Login and logs in with valid instructor credentials \\(third)")
    public void theUserClicksLoginAndLogsInWithValidInstructorCredentialsThird() {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @And("The user scrolls down the page \\(third)")
    public void theUserScrollsDownThePageThird() {
        WebDriver driver = DriverManager.getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.waitFor(1);
    }

    @And("The user clicks the Log Out link at the bottom of the left menu \\(third)")
    public void theUserClicksTheLogOutLinkAtTheBottomOfTheLeftMenuThird() {
        WebElement exit = yusuf.logoutLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 5);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
        ReusableMethods.waitFor(2);
    }

    @Then("The Log In button in the down left corner should be displayed \\(third)")
    public void theLogInButtonInThedownleftCornerShouldBeDisplayedThird() {
        WebElement exitButton = yusuf.logoutexit;
        ReusableMethods.waitForVisibility(exitButton, 5);
        Assertions.assertTrue(exitButton.isDisplayed(), "Exit button is not visible!");
        exitButton.click();
        ReusableMethods.waitFor(2);
    }

    @Given("The user accesses the homepage with the relevant URL \\(fourth)")
    public void theUserAccessesTheHomepageWithTheRelevantURLFourth() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks Sign In and logs in with valid instructor credentials \\(fourth)")
    public void theUserClicksSignInAndLogsInWithValidInstructorCredentialsFourth() {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks the Home button in the header \\(fourth)")
    public void theUserClicksTheHomeButtonInTheHeaderFourth() {
        WebDriver driver = DriverManager.getDriver();
        Yusuf yusuf = new Yusuf(driver);
        ReusableMethods.waitForVisibility(yusuf.navbarLogoImage, 5);
        JSUtilities.scrollToElement(driver, yusuf.navbarLogoImage);
        yusuf.navbarLogoImage.click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks the profile icon in the upper right corner \\(fourth)")
    public void theUserClicksTheProfileIconInTheUpperRightCornerFourth() {
        WebDriver driver = DriverManager.getDriver();
        Yusuf yusuf = new Yusuf(driver);
        ReusableMethods.waitForVisibility(yusuf.profileIcon, 5);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red'; " +
                        "arguments[0].style.backgroundColor='yellow';",
                yusuf.profileIcon
        );
        ReusableMethods.waitFor(5);
    }

    @Then("The exit link should be visible and clickable in the dropdown menu \\(fourth)")
    public void theExitLinkShouldBeVisibleAndClickableInTheDropdownMenuFourth() {
        yusuf.profileIcon.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.hoverTargetSpan, 10);
        JSUtilities.scrollToElement(driver, yusuf.hoverTargetSpan);
        try {
            new Actions(driver)
                    .moveToElement(yusuf.hoverTargetSpan)
                    .pause(Duration.ofMillis(200))
                    .perform();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles:true, cancelable:true, view:window});" +
                            "arguments[0].dispatchEvent(ev);",
                    yusuf.hoverTargetSpan
            );
        }
        ReusableMethods.waitFor(1);
        WebElement target = yusuf.dropdownLogoutLink;
        JSUtilities.scrollToElement(driver, target);
        ReusableMethods.waitForVisibility(target, 5);
        yusuf.dropdownLogoutLink.click();
    }

    @Given("The user accesses the homepage with the relevant URL \\(fifth)")
    public void theUserAccessesTheHomepageWithTheRelevantURLFifth() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks Sign In and logs in with valid instructor credentials \\(fifth)")
    public void theUserClicksSignInAndLogsInWithValidInstructorCredentialsFifth() {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 10).sendKeys(ConfigReader.getProperty("team2InstructorEmail_Yusuf"));
        ReusableMethods.waitForVisibility(yusuf.passwordBox, 10).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks the Home button in the header \\(fifth)")
    public void theUserClicksTheHomeButtonInTheHeaderFifth() {
        WebDriver driver = DriverManager.getDriver();
        Yusuf yusuf = new Yusuf(driver);
        ReusableMethods.waitForVisibility(yusuf.navbarLogoImage, 5);
        JSUtilities.scrollToElement(driver, yusuf.navbarLogoImage);
        yusuf.navbarLogoImage.click();
        ReusableMethods.waitFor(2);
    }

    @And("The user clicks the profile icon in the upper right corner \\(fifth)")
    public void theUserClicksTheProfileIconInTheUpperRightCornerFifth() {
        WebDriver driver = DriverManager.getDriver();
        Yusuf yusuf = new Yusuf(driver);
        ReusableMethods.waitForVisibility(yusuf.profileIconshow, 5);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red'; " +
                        "arguments[0].style.backgroundColor='yellow';",
                yusuf.profileIconshow
        );
        ReusableMethods.waitFor(5);
    }

    @And("The user clicks the Log Out link in the dropdown menu \\(fifth)")
    public void theUserClicksTheLogOutLinkInTheDropdownMenuFifth() {
        yusuf.profileIcon.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(yusuf.hoverTargetSpan, 10);
        JSUtilities.scrollToElement(driver, yusuf.hoverTargetSpan);
        try {
            new Actions(driver)
                    .moveToElement(yusuf.hoverTargetSpan)
                    .pause(Duration.ofMillis(200))
                    .perform();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles:true, cancelable:true, view:window});" +
                            "arguments[0].dispatchEvent(ev);",
                    yusuf.hoverTargetSpan
            );
        }
        ReusableMethods.waitFor(1);
        WebElement target = yusuf.dropdownLogoutLink;
        JSUtilities.scrollToElement(driver, target);
        ReusableMethods.waitForVisibility(target, 5);
        yusuf.dropdownLogoutLink.click();
    }

    @Then("The Log In button in the upper right corner should be displayed \\(fifth)")
    public void theLogInButtonInTheUpperRightCornerShouldBeDisplayedFifth() {
        Yusuf headerPage = new Yusuf(driver);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", headerPage.loginLink);

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";

        ((JavascriptExecutor) driver).executeScript(highlightScript, headerPage.loginLink);

        Assertions.assertTrue(headerPage.loginLink.isDisplayed(), "Log In link is not visible!");
        ReusableMethods.waitFor(11);
        DriverManager.getDriver().quit();
    }

    //-----------------38-THE-END-----------------

    // ****************************************@@@@@@@@@@@****************************************

    //-----------------41-START-----------------

    @Given("The user accesses the homepage with the relevant URL \\(sixth)")
    public void the_user_accesses_the_homepage_with_the_relevant_url_sixth() {
        DriverManager.getDriver().get(ConfigReader.getProperty("loginPageUrl_Yusuf"));
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks Sign In and logs in with valid student credentials \\(sixth)")
    public void the_user_clicks_sign_ın_and_logs_in_with_valid_student_credentials_sixth() {
        ReusableMethods.waitForVisibility(yusuf.emailBox, 5).sendKeys(ConfigReader.getProperty("team2StudentEmail_Yusuf"));
        Yusuf headerPage = new Yusuf(driver);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", headerPage.emailBox);
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) driver).executeScript(highlightScript, headerPage.emailBox);
        Assertions.assertTrue(headerPage.emailBox.isDisplayed(), "Log In link is not visible!");
        ReusableMethods.waitFor(2);

        ReusableMethods.waitForVisibility(yusuf.passwordBox, 5).sendKeys(ConfigReader.getProperty("team2Password_Yusuf"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", headerPage.passwordBox);
        String highlightScript1 =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) driver).executeScript(highlightScript1, headerPage.passwordBox);
        Assertions.assertTrue(headerPage.passwordBox.isDisplayed(), "Log In link is not visible!");
        ReusableMethods.waitFor(2);

        yusuf.buttonByText("Login").click();
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks the Courses submenu in the Dashboard Sidebar \\(sixth)")
    public void the_user_clicks_the_courses_submenu_in_the_dashboard_sidebar_sixth() {
        WebElement certificatesLink = yusuf.myCoursesLink;
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", certificatesLink);
        ReusableMethods.waitForVisibility(certificatesLink, 5);
        Assertions.assertTrue(certificatesLink.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, certificatesLink);
    }

    @Then("The Courses submenu should be visible and accessible \\(sixth)")
    public void the_courses_submenu_should_be_visible_and_accessible_sixth() {
        WebElement certificatesButton = yusuf.myCoursesLink;
        ReusableMethods.waitForVisibility(certificatesButton, 5);
        Assertions.assertTrue(certificatesButton.isDisplayed(), "Certificates button is not visible!");
        certificatesButton.click();
    }

    @And("log out exit")
    public void logOutExit() {
        WebElement logout = yusuf.logoutLinkInSidebar;
        JSUtilities.scrollToElement(DriverManager.getDriver(), logout);
        ReusableMethods.waitForVisibility(logout, 5);
        Assertions.assertTrue(logout.isDisplayed(), "Logout link is not visible!");
        logout.click();
        ReusableMethods.waitFor(2);
    }

    @Given("The user clicks the Courses submenu in the Dashboard Sidebar \\(seventh)")
    public void the_user_clicks_the_courses_submenu_in_the_dashboard_sidebar_seventh() {
        WebElement myCoursesLink = yusuf.myCoursesLink;
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", myCoursesLink);
        ReusableMethods.waitForVisibility(myCoursesLink, 5);
        Assertions.assertTrue(myCoursesLink.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, myCoursesLink);
        ReusableMethods.waitFor(2);
        myCoursesLink.click();
    }

    @Then("The My Purchases, My Reviews and Favorites submenus should be visible and accessible \\(seventh)")
    public void the_my_purchases_my_reviews_and_favorites_submenus_should_be_visible_and_accessible_seventh() {
        WebElement Mypurchases = yusuf.Mypurchases;
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", Mypurchases);
        ReusableMethods.waitForVisibility(Mypurchases, 5);
        Assertions.assertTrue(Mypurchases.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, Mypurchases);
        Mypurchases.click();
    }

    @Then("The user clicks the Sign Out button \\(seventh)")
    public void the_user_clicks_the_sign_out_button_seventh() {
        WebElement logout = yusuf.logoutLinkInSidebar;
        JSUtilities.scrollToElement(DriverManager.getDriver(), logout);
        ReusableMethods.waitForVisibility(logout, 5);
        Assertions.assertTrue(logout.isDisplayed(), "Logout link is not visible!");
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.border='2px solid red';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='yellow';" +
                        "el.style.animation='blink 1s step-start 3';" +
                        "var style=document.getElementById('blinkStyle');" +
                        "if(!style){style=document.createElement('style');style.id='blinkStyle';" +
                        "style.innerHTML='@keyframes blink {50% {opacity: 0;}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, logout);
        ReusableMethods.waitFor(3);
        logout.click();
        ReusableMethods.waitFor(2);
    }

    @Given("The user clicks the Courses submenu in the Control Panel Sidebar \\(eighth)")
    public void the_user_clicks_the_courses_submenu_in_the_control_panel_sidebar_eighth() {
        WebElement myCoursesLink = yusuf.myCoursesLink;
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", myCoursesLink);
        ReusableMethods.waitForVisibility(myCoursesLink, 5);
        Assertions.assertTrue(myCoursesLink.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, myCoursesLink);
        myCoursesLink.click();
    }

    @Given("The user clicks the My Purchases submenu \\(eighth)")
    public void the_user_clicks_the_my_purchases_submenu_eighth() {
        WebElement Mypurchases = yusuf.Mypurchases;
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", Mypurchases);
        ReusableMethods.waitForVisibility(Mypurchases, 5);
        Assertions.assertTrue(Mypurchases.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, Mypurchases);
        Mypurchases.click();
    }

    @And("The user verifies the presence of Learning page, Join, Invoice and Feedback panes \\(eighth)")
    public void theUserVerifiesThePresenceOfLearningPageJoinInvoiceAndFeedbackPanesEighth() {
        WebDriver driver = DriverManager.getDriver();
        JSUtilities.scrollToElement(driver, yusuf.myActivityLink);
        ReusableMethods.waitForVisibility(yusuf.myActivityLink, 5);
        Assertions.assertTrue(yusuf.myActivityLink.isDisplayed(), "My activity is not visible!");
        highlightRainbow(driver, yusuf.myActivityLink);
        ReusableMethods.waitFor(2);

        JSUtilities.scrollToElement(driver, yusuf.myPurchasesLink);
        ReusableMethods.waitForVisibility(yusuf.myPurchasesLink, 5);
        Assertions.assertTrue(yusuf.myPurchasesLink.isDisplayed(), "My purchases is not visible!");
        highlightRainbow(driver, yusuf.myPurchasesLink);
        ReusableMethods.waitFor(2);
    }

    private void highlightRainbow(WebDriver driver, WebElement element) {
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.border='2px solid blue';" +
                        "el.style.background='rgba(255,255,0,0.3)';" +
                        "el.style.padding='3px 6px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow {" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) driver).executeScript(highlightScript, element);
    }

    @When("The user clicks the Invoice submenu \\(eighth)")
    public void the_user_clicks_the_invoice_submenu_eighth() {
        WebDriver driver = DriverManager.getDriver();
        if (driver.findElements(yusuf.invoiceSubmenuBy).isEmpty()) {
            System.out.println("⚠ Invoice submenu not found — continue.");
            return;
        }
        driver.findElement(yusuf.invoiceSubmenuBy).click();
    }

    @Given("The user clicks the Courses submenu in the Control Panel Sidebar \\(ninth)")
    public void the_user_clicks_the_courses_submenu_in_the_control_panel_sidebar_ninth() {
        WebDriver driver = DriverManager.getDriver();
        WebElement myCoursesLink = yusuf.myCoursesLink;
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", myCoursesLink);
        ReusableMethods.waitForVisibility(myCoursesLink, 5);
        Assertions.assertTrue(myCoursesLink.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, myCoursesLink);
        myCoursesLink.click();
    }

    @Given("The user clicks the My Purchases submenu \\(ninth)")
    public void the_user_clicks_the_my_purchases_submenu_ninth() {
        WebDriver driver = DriverManager.getDriver();
        WebElement Mypurchases = yusuf.Mypurchases;
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", Mypurchases);
        ReusableMethods.waitForVisibility(Mypurchases, 5);
        Assertions.assertTrue(Mypurchases.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, Mypurchases);
        Mypurchases.click();
    }

    @Given("The user verifies the presence of Learning page, Join, Invoice and Feedback panes \\(ninth)")
    public void the_user_verifies_the_presence_of_learning_page_join_ınvoice_and_feedback_panes_ninth() {
        WebDriver driver = DriverManager.getDriver();
        ReusableMethods.waitForClickability(yusuf.Mypurchasesvisible, 5);
        yusuf.Mypurchasesvisible.click();
        ReusableMethods.waitFor(2);
    }

    @When("The user clicks the Learning page submenu \\(ninth)")
    public void the_user_clicks_the_learning_page_submenu_ninth() {
        WebDriver driver = DriverManager.getDriver();
        ReusableMethods.waitForVisibility(yusuf.learnPage, 5);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String rainbowScript =
                "var el = arguments[0];" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='3px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.fontWeight='bold';" +
                        "el.style.animation='rainbow 3s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:red;text-decoration-color:red}" +
                        "16%{color:orange;text-decoration-color:orange}" +
                        "33%{color:yellow;text-decoration-color:yellow}" +
                        "50%{color:green;text-decoration-color:green}" +
                        "66%{color:blue;text-decoration-color:blue}" +
                        "83%{color:indigo;text-decoration-color:indigo}" +
                        "100%{color:violet;text-decoration-color:violet}" +
                        "}';document.head.appendChild(style);}";
        js.executeScript(rainbowScript, yusuf.learnPage);
        Assertions.assertTrue(yusuf.learnPage.isDisplayed(), "Learn link is not visible!");
        ReusableMethods.waitFor(5);
    }

    @Then("The Learning page should be displayed successfully \\(ninth)")
    public void the_learning_page_should_be_displayed_successfully_ninth() {
        DriverManager.getDriver().navigate().back();
        ReusableMethods.waitFor(2);
    }

    @Then("The user clicks the Log Out button \\(ninth)")
    public void the_user_clicks_the_log_out_button_ninth() {
        WebDriver driver = DriverManager.getDriver();
        WebElement logout = yusuf.logoutLinkInSidebar;
        JSUtilities.scrollToElement(DriverManager.getDriver(), logout);
        ReusableMethods.waitForVisibility(logout, 5);
        Assertions.assertTrue(logout.isDisplayed(), "Logout link is not visible!");
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.border='2px solid red';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='yellow';" +
                        "el.style.animation='blink 1s step-start 3';" +
                        "var style=document.getElementById('blinkStyle');" +
                        "if(!style){style=document.createElement('style');style.id='blinkStyle';" +
                        "style.innerHTML='@keyframes blink {50% {opacity: 0;}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, logout);
        ReusableMethods.waitFor(3);
        logout.click();
        ReusableMethods.waitFor(2);
    }

    @Given("The user clicks the Courses submenu in the Control Panel Sidebar \\(tenth)")
    public void the_user_clicks_the_courses_submenu_in_the_control_panel_sidebar_tenth() {
        WebDriver driver = DriverManager.getDriver();
        WebElement myCoursesLink = yusuf.myCoursesLink;
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", myCoursesLink);
        ReusableMethods.waitForVisibility(myCoursesLink, 5);
        Assertions.assertTrue(myCoursesLink.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, myCoursesLink);
        myCoursesLink.click();
    }

    @Given("The user clicks the Favorites submenu \\(tenth)")
    public void the_user_clicks_the_favorites_submenu_tenth() {
        WebDriver driver = DriverManager.getDriver();
        WebElement myFavoritesLink = yusuf.myFavoritesLink;
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", myFavoritesLink);
        ReusableMethods.waitForVisibility(myFavoritesLink, 5);
        Assertions.assertTrue(myFavoritesLink.isDisplayed(), "My Certificates link is not visible!");

        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.transition='all .3s ease';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.borderRadius='6px';" +
                        "el.style.padding='2px 6px';" +
                        "el.style.background='linear-gradient(90deg, rgba(30,144,255,.15), rgba(165,94,234,.15))';" +
                        "el.style.animation='rainbow 2s linear infinite';" +
                        "var style=document.getElementById('rainbowStyle');" +
                        "if(!style){style=document.createElement('style');style.id='rainbowStyle';" +
                        "style.innerHTML='@keyframes rainbow{" +
                        "0%{color:#ff4757}20%{color:#ffa502}40%{color:#2ed573}" +
                        "60%{color:#1e90ff}80%{color:#a55eea}100%{color:#ff4757}}';" +
                        "document.head.appendChild(style);}";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(highlightScript, myFavoritesLink);
        myFavoritesLink.click();
    }

    @Then("The selected course should be visible under Favorite Courses heading \\(tenth)")
    public void the_selected_course_should_be_visible_under_favorite_courses_heading_tenth() {
        WebDriver driver = DriverManager.getDriver();
        ReusableMethods.waitForVisibility(yusuf.favoriteCoursesText, 2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.fontWeight='bold';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.color='red';" +
                        "el.style.textDecorationColor='red';";
        js.executeScript(highlightScript, yusuf.favoriteCoursesText);
        Assertions.assertTrue(yusuf.favoriteCoursesText.isDisplayed(), "");
    }

    @Then("The user verifies the presence of the Remove menu \\(tenth)")
    public void the_user_verifies_the_presence_of_the_remove_menu_tenth() {
        WebDriver driver = DriverManager.getDriver();
        ReusableMethods.waitForVisibility(yusuf.removeVisible, 2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.fontWeight='bold';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.color='red';" +
                        "el.style.textDecorationColor='red';";
        js.executeScript(highlightScript, yusuf.removeVisible);
        Assertions.assertTrue(yusuf.removeVisible.isDisplayed(), " ");
        yusuf.removeVisible.click();
        ReusableMethods.waitFor(3);
    }

    @When("The user clicks the Remove submenu \\(tenth)")
    public void the_user_clicks_the_remove_submenu_tenth() {
        WebDriver driver = DriverManager.getDriver();
        ReusableMethods.waitForVisibility(yusuf.remove, 2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String highlightScript =
                "var el = arguments[0];" +
                        "el.style.fontWeight='bold';" +
                        "el.style.textDecoration='underline';" +
                        "el.style.textDecorationThickness='2px';" +
                        "el.style.textUnderlineOffset='4px';" +
                        "el.style.color='red';" +
                        "el.style.textDecorationColor='red';";
        js.executeScript(highlightScript, yusuf.remove);
        Assertions.assertTrue(yusuf.remove.isDisplayed(), " ");
        yusuf.remove.click();
        ReusableMethods.waitFor(3);

        // ESC
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.waitFor(2);
    }
}
