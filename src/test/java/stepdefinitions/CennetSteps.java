package stepdefinitions;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.Cennet;

import java.time.Duration;
import java.util.Set;


public class CennetSteps {
    //  private static final Logger logger = LogManager.getLogger(GoogleSteps.class);
    WebDriver driver = Hooks.getDriver();
    Cennet cennet = new Cennet(driver);
    BasePage basepage = new BasePage(driver);
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void scroll(WebElement element){
        JSUtilities.scrollToElement(DriverManager.getDriver(), element);}

    public static void execute(WebElement element){
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);}


    @Given("Kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String url) {
        DriverManager.getDriver().get(ConfigReader.getProperty(url));
        // logger.info("Kullanici InstuLearn anasayfaya gider");

    }

    @Given("Kullanici senkronizasyon için {int} saniye bekler")
    public void kullanici_senkronizasyon_için_saniye_bekler(Integer saniye) {
        WaitHelper.bekle(3);

    }


    @Then("Kullanici title in {string} oldugunu test eder")
    public void kullaniciTitleInOldugunuTestEder(String expectedTitle) {
        String actualTitle = DriverManager.getDriver().getTitle();
        System.out.println(DriverManager.getDriver().getTitle());
        Assertions.assertEquals(expectedTitle, actualTitle);
        // logger.info("Kullanici title in \"Home | InstuLearn\" oldugunu test eder");
    }

    //---------------------------------------------------------------------------------------------------------
    //US004   tc001
    @Given("Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder")
    public void kullaniciAnaSayfaBarindaRegisterLinkiniGorurVeGoruldugunuTestEder() {
        Assertions.assertTrue(cennet.registerButton.isDisplayed());
        //  logger.info("Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder");
    }

    //Tc002
    @And("Kullanici  register linkini tiklar")
    public void kullaniciRegisterLinkiniTiklar() {
        basepage.click(cennet.registerButton);
        //  logger.info("Kullanici  register linkini tiklar");
    }

    //TC003

    @Then("Kullanici register sayfasının sol bolumunde ilgili resmin gorunur oldugunu test eder")
    public void kullanici_register_sayfasının_sol_bolumunde_ilgili_resmin_gorunur_oldugunu_test_eder() {

        Assertions.assertTrue(cennet.registerImage.isDisplayed());

    }

    //Tc004
    @Given("Kullanici register sayfasının sag bolumunde signup formunu gorur")
    public void kullanici_register_sayfasının_sag_bolumunde_signup_formunu_gorur() {
        Assertions.assertTrue(cennet.signupForm.isDisplayed());

    }

    @Given("Kullanici email texboxını görür")
    public void kullanici_email_texboxını_görür() {
        Assertions.assertTrue(cennet.emailtexbox.isDisplayed());

    }

    @Given("Kullanici email texboxına tıklar ve aktifligini test eder")
    public void kullanici_email_texboxına_tıklar_ve_aktifligini_test_eder() {
        cennet.emailtexbox.click();

    }

    //Tc005
    @When("Kullanici register sayfasinda signup butonunu gorur ve goruldugunu test eder")
    public void kullanici_register_sayfasinda_signup_butonunu_gorur_ve_goruldugunu_test_eder() {
        Assertions.assertTrue(cennet.signupButton.isDisplayed());

    }


    //TC006
    @Then("Kullanıcı account type nı  student olarak secer ve tıklar")
    public void kullanıcı_account_type_nı_student_olarak_secer_ve_tıklar() {
        cennet.studentButton.click();

    }

    @Then("Kullanici  email olarak {string} girer")
    public void kullanici_email_olarak_girer(String gecerliEmail) {
        cennet.emailtexbox.sendKeys(ConfigReader.getProperty(gecerliEmail));

    }

    @Then("Kullanici  fullName olarak {string} girer")
    public void kullanici_full_name_olarak_girer(String gecerliFullName) {
        cennet.fullNameTexbox.sendKeys(ConfigReader.getProperty(gecerliFullName));


    }

    @Then("Kullanici  password olarak {string} girer")
    public void kullanici_password_olarak_girer(String gecerliPassword) {
        cennet.passwordTexbox.sendKeys(ConfigReader.getProperty(gecerliPassword));

    }

    @Then("Kullanici  retype password olarak {string} girer")
    public void kullanici_retype_password_olarak_girer(String gecerliRetypePassword) {
        cennet.rtypePasswordTexbox.sendKeys(ConfigReader.getProperty(gecerliRetypePassword));
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

    }


    @Then("Kullanici I agree with terms & rules checbox ını tiklar")
    public void kullanici_ı_agree_with_terms_rules_checbox_ını_tiklar() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.termsRulesCheckbox);
    }

    @When("Kullanici signup butonuna tiklar")
    public void kullanici_signup_butonuna_tiklar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.signupButton);
        cennet.signupButton.click();
    }

    @When("basarili giris yapabildigini test eder")
    public void basarili_giris_yapabildigini_test_eder() {
        Assertions.assertTrue(cennet.profilName.isDisplayed());


    }


    @And("uyari mesaji aldigini  test eder")
    public void uyariMesajiAldiginiTestEder() {
        Assertions.assertTrue(cennet.TheEmailMustBeAValidEmailAddressMesaji.isDisplayed());
    }

    @Then("email olarak {string} girer")
    public void emailOlarakGirer(String gecersizEmail) {
        cennet.emailtexbox.sendKeys(ConfigReader.getProperty(gecersizEmail));

    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String gecersizPassword) {
        cennet.passwordTexbox.sendKeys(ConfigReader.getProperty(gecersizPassword));

    }

    @When("The password uyari mesaji aldigini  test eder")
    public void the_password_uyari_mesaji_aldigini_test_eder() {
        Assertions.assertTrue(cennet.thePasswordConfirmationDoesNotMatchMesaji.isDisplayed());

    }

    @And("The email field is required uyari mesaji aldıgini test eder")
    public void theEmailFieldIsRequiredUyariMesajiAldıginiTestEder() {
        Assertions.assertTrue(cennet.TheEmailFieldIsRequiredMesaji.isDisplayed());

    }

    @And("The full name field is required uyari mesaji aldıgini test eder")
    public void theFullNameFieldIsRequiredUyariMesajiAldıginiTestEder() {
        Assertions.assertTrue(cennet.TheFullNameFieldIsRequiredMesaji.isDisplayed());
    }

    @Then("The password field is required uyari mesaji aldıgini test eder")
    public void thePasswordFieldIsRequiredUyariMesajiAldıginiTestEder() {

        Assertions.assertTrue(cennet.ThePasswordFieldIsRequiredMesaji.isDisplayed());

    }


    @Then("The password confirmation field is required uyari mesaji aldıgini test eder")
    public void thePasswordConfirmationFieldIsRequiredUyariMesajiAldıginiTestEder() {
        Assertions.assertTrue(cennet.thePasswordConfirmationDoesNotMatchMesaji.isDisplayed());
    }

    @Then("The term field is required uyari mesaji aldıgini test eder")
    public void theTermFieldIsRequiredUyariMesajiAldıginiTestEder() {
        Assertions.assertTrue(cennet.TheTermFieldIsRequiredMesaji.isDisplayed());
    }

    @Then("time zone alaninda America\\/Nome  secenegini tiklar")
    public void timeZoneAlanindaAmericaNomeSeceneginiTiklar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.timeZoneDropDown);
        // cennet.timeZoneDropDown.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.optionAmericaNome);
        // cennet.optionAmericaNome.click();
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cennet.timeZoneDropDown);
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();",cennet.optionAmericaNome);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }


    @When("signup butonuna tiklar")
    public void signupButonunaTiklar() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.signupButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cennet.signupButton);
    }

    @When("Kullanici time zone alaninda America\\/Nome  secenegini tiklar")
    public void kullaniciTimeZoneAlanindaAmericaNomeSeceneginiTiklar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.timeZoneDropDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.optionAmericaNome);
    }

    // -------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //   US031     //
    //TC001------------------------------
    @When("ana sayfa barinda login linkine tiklar")
    public void ana_sayfa_barinda_login_linkine_tiklar() {
        cennet.loginLink.click();
        WaitHelper.bekle(1);

    }

    @Then("email alanina {string} girer")
    public void email_alanina_girer(String insGecerliEmail) {
        cennet.insEmailTexbox.sendKeys(ConfigReader.getProperty(insGecerliEmail));
    }

    @Then("password alanina {string} girer")
    public void password_alanina_girer(String insGecerliPassword) {
        cennet.insPasswordTexbox.sendKeys(ConfigReader.getProperty(insGecerliPassword));

    }

    @When("Login butonuna tiklar")
    public void login_butonuna_tiklar() {
        cennet.loginButton.click();

    }

    @Then("deshboard sayfasına ulasir")
    public void deshboard_sayfasına_ulasir() {
        Assertions.assertTrue(cennet.deshboardPanel.isDisplayed());

    }
// TC002-----------------------------------------------


    @Then("deshboard sidebar da Settings linkine tiklar")
    public void deshboard_sidebar_da_settings_linkine_tiklar() {

        WebElement exit = cennet.settingsLink;
        JSUtilities.scrollToElement(driver, exit);
        ReusableMethods.waitForVisibility(exit, 2);
        Assertions.assertTrue(exit.isDisplayed(), "Exit (Logout) link is not visible after navigation!");
        ReusableMethods.waitFor(2);
        cennet.settingsLink.click();

    }

    @Then("basic information sayfasina ulaşir")
    public void basic_information_sayfasina_ulaşir() {
        Assertions.assertTrue(cennet.basicInformationTitle.isDisplayed());
        ReusableMethods.waitFor(1);

    }
//TC003-----------------------------------------

    @Then("basic information email alanina {string} girer")
    public void basic_information_email_alanina_girer(String insGecerliEmail) {
        cennet.basicInfEmailTexbox.clear();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(cennet.basicInfEmailTexbox, 10).sendKeys(ConfigReader.getProperty("insGecerliEmail"));
        ReusableMethods.waitFor(1);
    }

    @Then("basic information name alanina {string} girer")
    public void basic_information_name_alanina_girer(String insName) {

        cennet.basicInfNameTexbox.clear();
        ReusableMethods.waitForVisibility(cennet.basicInfNameTexbox, 10).sendKeys(ConfigReader.getProperty("insName"));
        ReusableMethods.waitFor(1);
    }

    @Then("basic information password alanina {string} girer")
    public void basic_information_password_alanina_girer(String insGecerliPassword) {
        cennet.basicInfPasswordTexbox.clear();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(cennet.basicInfPasswordTexbox, 10).sendKeys(ConfigReader.getProperty("insGecerliPassword"));
        ReusableMethods.waitFor(1);


    }

    @Then("basic information retypepassword alanina {string} girer")
    public void basic_information_retypepassword_alanina_girer(String insRetypePassword) {
        cennet.basicInfRetypePasswordTexbox.clear();
        cennet.basicInfRetypePasswordTexbox.sendKeys(ConfigReader.getProperty(insRetypePassword));

    }

    @Then("basic information phone alanina {string} girer")
    public void basic_information_phone_alanina_girer(String phone) {
        cennet.phoneTexbox.clear();
        cennet.phoneTexbox.sendKeys(ConfigReader.getProperty(phone));

    }

    @Then("language menuden english secenegini tiklar")
    public void language_menuden_english_secenegini_tiklar() {
        Select select = new Select(cennet.languageDDown);
        cennet.languageDDown.click();
        select.selectByValue("EN");
        // cennet.languageEnglish.click();

    }

    @Then("basic information time zone menuden America\\/New_york secenegini tiklar")
    public void basic_information_time_zone_menuden_america_new_york_secenegini_tiklar() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.basicInfTimeZoneDDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.americaNewYork);

    }

    @Then("next butonuna tiklar")
    public void next_butonuna_tiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        cennet.nextButton.click();

    }

    @When("images sayfasina ulasir")
    public void images_sayfasina_ulasir() {
        Assertions.assertTrue(cennet.imagesTitle.isDisplayed());

    }

//TC004--------------------------------------

    @Then("basic information email olarak  {string} girer")
    public void basicInformationEmailOlarakGirer(String gecersizEmail) {
        cennet.basicInfEmailTexbox.clear();
        cennet.basicInfEmailTexbox.sendKeys(ConfigReader.getProperty(gecersizEmail));
    }

    @When("The email must be a valid email address  uyari mesajini alir")
    public void the_email_must_be_a_valid_email_address_uyari_mesajini_alir() {
        WaitHelper.bekle(5);
        Assertions.assertTrue(cennet.TheEmailMustBeAValidEmailAddressMesaji.isDisplayed());

    }

    //TC005 -----------------------------------------


    @Then("basic information password olarak {string} girer")
    public void basicInformationPasswordOlarakGirer(String gecersizPassword) {
        cennet.basicInfPasswordTexbox.clear();
        cennet.basicInfPasswordTexbox.sendKeys(ConfigReader.getProperty(gecersizPassword));
    }


    @When("The password confirmation does not match  uyari mesajini alir")
    public void the_password_confirmation_does_not_match_uyari_mesajini_alir() {
        WaitHelper.bekle(5);
        Assertions.assertTrue(cennet.thePasswordConfirmationDoesNotMatchMesaji.isDisplayed());


    }

    @Then("basic information  time zone menuden America\\/New_york secenegini tiklar")
    public void basicInformationTimeZoneMenudenAmericaNew_yorkSeceneginiTiklar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.basicInfTimeZoneDDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cennet.americaNewYork);

    }

    //TC006--------------------------------------------------


    @When("The email field is required  uyari mesajini alir")
    public void the_email_field_is_required_uyari_mesajini_alir() {
        WaitHelper.bekle(2);
        Assertions.assertTrue(cennet.TheEmailFieldIsRequiredMesaji.isDisplayed());
    }

    @And("email alanini bos birakir")
    public void emailAlaniniBosBirakir() {
        cennet.basicInfEmailTexbox.clear();

    }

    //TC007--------------------------------------------------

    @When("The full name field is required  uyari mesajini alir")
    public void the_full_name_field_is_required_uyari_mesajini_alir() {
        Assertions.assertTrue(cennet.TheFullNameFieldIsRequiredMesaji.isDisplayed());
    }

    @And("name alanini bos birakir")
    public void nameAlaniniBosBirakir() {
        cennet.basicInfNameTexbox.clear();
    }
    //TC008-------------------------------------------------------------------


    @When("The password field is required uyari mesajini alir")
    public void the_password_field_is_required_uyari_mesajini_alir() {
        String expectedMesaj = "The password field is required uyari mesajini alir";
        String actualMesaj = cennet.cikanUyari.getText();
        Assertions.assertEquals(actualMesaj, expectedMesaj);
    }

    @Then("password alanini bos birakir")
    public void passwordAlaniniBosBirakir() {
        cennet.basicInfPasswordTexbox.clear();
    }
    //TC009--------------------------------------------------------

    @And("retypePassword alanini bos birakir")
    public void retypepasswordAlaniniBosBirakir() {
        cennet.basicInfRetypePasswordTexbox.clear();
    }

    @When("The password confirmation does not match uyari mesajini alir")
    public void thePasswordConfirmationDoesNotMatchUyariMesajiniAlir() {
        Assertions.assertTrue(cennet.thePasswordConfirmationDoesNotMatchMesaji.isDisplayed());
    }
    //TC010-------------------------------------------------------------


    @Then("profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler")
    public void profileCoverLinkiAltındakiYukarıOkIkonunaTiklarVeResimEkler() {
        cennet.resimYuklemeTextBox.clear();

        cennet.resimYuklemeTextBox.sendKeys("/store/1707/Ekran görüntüsü 2025-09-13 212328.png");


    }

    @And("image save butonuna basıp kaydeder")
    public void imageSaveButonunaBasıpKaydeder() {
        execute(cennet.saveButton);
    }

   /* @And("select an image  butonuna tiklar ve resim ekler")
    public void selectAnImageButonunaTiklarVeResimEkler() {
        cennet.selectAnImageButton.click();
        WaitHelper.bekle(5);
        // Dosya yolunu kendi bilgisayarındaki resim dosyasına göre değiştir
        String imagePath = "\"C:\\Users\\CennetK\\Pictures\\Screenshots\\Ekran görüntüsü 2025-09-13 212328.png\"";

        // Input elementini bul
        WebElement selectAnImageButton = driver.findElement(By.xpath("//*[@id='userSettingForm']/input[1]"));

        // Gizli ise görünür hale getir
        // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", cennet.selectAnImageButton);
        // Dosya yolunu gönder
        cennet.selectAnImageButton.sendKeys(imagePath);
        //cennet.selectButton.click();

    }*/

   /* @Then("profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler")
    public void profileCoverLinkiAltındakiYukarıOkIkonunaTiklarVeResimEkler() {
    cennet.yukariOkIkonu.click();
        @When("The user clicks the {string} field")
        public void theUserClicksTheField(String field) {
            WebDriver driver = DriverManager.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(12));

            WebElement trigger; // bu adım "Thumbnail" için
            switch (field.trim().toLowerCase(java.util.Locale.ROOT)) {
                case "thumbnail":   trigger = aysenur.basicInfoThumbnailButton; break;
                case "cover image": trigger = aysenur.basicInfoCoverImageButton; break;
                default: throw new IllegalArgumentException("Unknown field: " + field);
            }

            final String parent = driver.getWindowHandle();
            // 1) Tıklamadan ÖNCE mevcut handle'ları al (final olacak)
            final java.util.Set<String> before = new java.util.HashSet<>(driver.getWindowHandles());

            System.out.println("Before:" + before);

            try {
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(trigger));
                new org.openqa.selenium.interactions.Actions(driver)
                        .moveToElement(trigger, 3, 3)
                        .pause(java.time.Duration.ofMillis(120))
                        .click()
                        .perform();
            } catch (org.openqa.selenium.ElementClickInterceptedException | org.openqa.selenium.StaleElementReferenceException e) {
                WebElement fresh = wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(resolveButtonBy(field)));
                new org.openqa.selenium.interactions.Actions(driver)
                        .moveToElement(fresh, 3, 3)
                        .pause(java.time.Duration.ofMillis(120))
                        .click()
                        .perform();
            }

            // 3) Yeni pencerenin handle'ını diff ile bul
            String newHandle = null;
            try {
                newHandle = wait.until(d -> {
                    java.util.Set<String> diff = new java.util.HashSet<>(d.getWindowHandles());
                    diff.removeAll(before);
                    return diff.isEmpty() ? null : diff.iterator().next();
                });
            } catch (org.openqa.selenium.TimeoutException first) {
                // 4) Fallback: CTRL+Click ile yeni sekme zorla
                final java.util.Set<String> before2 = driver.getWindowHandles();
                new org.openqa.selenium.interactions.Actions(driver)
                        .keyDown(org.openqa.selenium.Keys.CONTROL)
                        .moveToElement(trigger, 3, 3).click()
                        .keyUp(org.openqa.selenium.Keys.CONTROL)
                        .perform();

                newHandle = new WebDriverWait(driver, java.time.Duration.ofSeconds(8)).until(d -> {
                    java.util.Set<String> diff = new java.util.HashSet<>(d.getWindowHandles());
                    diff.removeAll(before2);
                    return diff.isEmpty() ? null : diff.iterator().next();
                });
            }
            // 5) Yeni pencereye geç
            driver.switchTo().window(newHandle);

        }*/

   /* @Then("profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler")
    public void profileCoverLinkiAltındakiYukarıOkIkonunaTiklarVeResimEkler() {

    }*/

    @And("about sayfasina ulasir")
    public void aboutSayfasinaUlasir() {
        Assertions.assertTrue(cennet.aboutLink.isDisplayed());
    }


    //TC011---------------------------------------------
    @Then("biography alanına {string} yazar")
    public void biographyAlanınaYazar(String biography) {
        cennet.biographyTexbox.clear();
        cennet.biographyTexbox.sendKeys(ConfigReader.getProperty(biography));
    }

    @Then("jobTitle  alanına {string} yazar")
    public void jobtitleAlanınaYazar(String jobTitle) {
        cennet.jobTitleTexbox.clear();
        cennet.jobTitleTexbox.sendKeys(ConfigReader.getProperty(jobTitle));
    }
    //TC012-------------------------------------

    @When("education sayfasina ulasir")
    public void educationSayfasinaUlasir() {
        WaitHelper.bekle(1);
        Assertions.assertTrue(cennet.educationLink.isDisplayed());
    }
    //TC013-------------------------------------------------------

    @And("Add Education butonuna tiklar eğitim bilgisini girer")
    public void addEducationButonunaTiklarEğitimBilgisiniGirer() {
        // Add education butonuna tıkla
        WaitHelper.bekle(2);
        execute( cennet.addEducationButton);
        WaitHelper.bekle(2);
      cennet.addEducationTexbox.sendKeys("Bilgisayar Programcılığı");


    }

    @Then("save butonuna basıp kaydeder")
    public void saveButonunaBasıpKaydeder() {
        // Save butonuna tıkla
        execute(cennet.addEducationSaveButton);


       /* // Kayıt ekranda görünsün diye bekleme + doğrulama
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement savedEducation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Bilgisayar Programcılığı Mezunu')]")
        ));
        Assertions.assertTrue(savedEducation.isDisplayed());*/
    }

    @Then("education next butonuna tiklar")
    public void educationNextButonunaTiklar() {

     execute(cennet.educationNextButton);


    }
    //TC013----------------------------------------------------

    @And("Add Education butonunu bos birakir")
    public void addEducationButonunuBosBirakir() {
        execute(cennet.addEducationButton);
        WaitHelper.bekle(2);
      execute(cennet.addEducationTexbox);
      WaitHelper.bekle(1);
      cennet.addEducationTexbox.clear();
        WaitHelper.bekle(1);

        /*JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", cennet.addEducationButton);
        cennet.addEducationButton.click();
        cennet.addEducationTexbox.sendKeys(".");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cennet.addEducationSaveButton);*/
    }

    @Then("add education save  butonuna tiklar")
    public void addEducationSaveButonunaTiklar() {
        execute(cennet.addEducationSaveButton);
    }

    @When("The value field is required uyari mesajini alir")
    public void theValueFieldIsRequiredUyariMesajiniAlir() {
        WaitHelper.bekle(3);
        Assertions.assertTrue(cennet.theValueFieldIsRequiredMesji.isDisplayed());
    }

    //TC014---------------------------------------------

    @And("ekranın sagında uc noktaya tiklar")
    public void ekranınSagındaUcNoktayaTiklar() {
        WaitHelper.bekle(5);
        Select select =new Select(cennet.ucNokta);
       // scroll(cennet.ucNokta);
        execute(cennet.ucNokta);
        WaitHelper.bekle(3);

    }

    @And("edit yazısına tiklar ve düzenleme yapar")
    public void editYazısınaTiklarVeDüzenlemeYapar() {
        cennet.editButton.click();

    }


    //TC015---------------------------------------------------------

    @Then("delete yazısına tiklar")
    public void deleteYazısınaTiklar() {
        cennet.deleteText.click();
    }

    @And("cıkan delete ikonuna tiklar ve siler")
    public void cıkanDeleteIkonunaTiklarVeSiler() {
        WaitHelper.bekle(3);
        cennet.deleteButton.click();
    }

    @When("experiences sayfasina ulasir")
    public void experiencesSayfasinaUlasir() {
        Assertions.assertTrue(cennet.experiencesLink.isDisplayed());

    }
//TC016-----------------------------------------------------------

    @And("experiences linkine tiklar")
    public void experiencesLinkineTiklar() {
        cennet.experiencesLink.click();
    }

    @And("Add experiences butonuna tiklar deneyim bilgisi girer")
    public void addExperiencesButonunaTiklarDeneyimBilgisiGirer() {
        cennet.addExperiencesButton.click();

        // Input görünene kadar bekle
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement addExperiencesTexbox = wait.until(ExpectedConditions.visibilityOf(cennet.addExperiencesTexbox));

        // Deneyim bilgisini yaz
        WaitHelper.bekle(7);
        cennet.addExperiencesTexbox.sendKeys("Selenium Test Otomasyonu Deneyimi");
    }


    //17-------------------------------------------


    @And("Add experiences alanını bos birakir")
    public void addExperiencesAlanınıBosBirakir() {
        WaitHelper.bekle(3);
        cennet.addExperiencesTexbox.sendKeys(".");
    }
//20--------------------------------------------------

    @And("skill topicks linkine tiklar")
    public void skillTopicksLinkineTiklar() {
        cennet.skillsLink.click();
    }

    @Then("SDET textini secer")
    public void sdetTextiniSecer() {
        cennet.sdetButton.click();
    }

    //21-----------------------------------------------------

    @And("identity&financial linkine tiklar")
    public void identityFinancialLinkineTiklar() {
        cennet.identyLink.click();
    }

    @And("account holder alanini doldurur")
    public void accountHolderAlaniniDoldurur() {
        cennet.accountHolderTexbox.sendKeys("Cennet");
    }

    @And("account ID alanini doldurur")
    public void accountIDAlaniniDoldurur() {
        cennet.accountId.sendKeys("martix");
    }
    //22--------------------------------------------

    @And("zoom API linkine tiklar")
    public void zoomAPILinkineTiklar() {
        cennet.zoomApiLink.click();
    }

    @And("Zoom Client ID alanini doldurur")
    public void zoomClientIDAlaniniDoldurur() {
        cennet.zoomClientId.sendKeys("zoom-client-id-deneme-001");
    }

    @And("Zoom Client Secret alanini doldurur")
    public void zoomClientSecretAlaniniDoldurur() {
        cennet.zoomClientSecret.sendKeys("zoom-client-secret-deneme-ABCD123");
    }

    @Then("Zoom Account ID alanini doldurur")
    public void zoomAccountIDAlaniniDoldurur() {
        cennet.zoomClientId.sendKeys("zoom-account-999999");
    }

    //23--------------------------------------------

    @And("extra information linkine tiklar")
    public void extraInformationLinkineTiklar() {
        cennet.extraInformationLink.click();
    }

    @And("female checkbox ini secer")
    public void femaleCheckboxIniSecer() {
        cennet.femaleChecbox.click();
    }

    @Then("Age olarak {string} girer")
    public void ageOlarakGirer(String arg0) {
        cennet.ageTexbox.sendKeys("45");
    }

    @And("meeting type olarak online secer")
    public void meetingTypeOlarakOnlineSecer() {
        cennet.onlineTexbox.click();
    }

    @When("extra information save butonuna basıp kaydeder")
    public void extraInformationSaveButonunaBasıpKaydeder() {
        cennet.saveButton.click();
    }

    @When("delete account butonuna basar ve hesabi siler")
    public void deleteAccountButonunaBasarVeHesabiSiler() {
        cennet.deleteAccountButton.click();
    }


}


