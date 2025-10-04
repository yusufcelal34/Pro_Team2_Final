package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Aysenur;
import utilities.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class AysenurSteps {

    Aysenur aysenur = new Aysenur();

    // class içinde, en üste ekledik
    private String parentHandle;
    private String childHandle;
    private boolean switchedToNewWindow;
    private String lastFaqQuestion;

    @Given("The user goes to the homepage URL")
    public void the_user_goes_to_the_homepage_url() {

        DriverManager.getDriver().get(ConfigReader.getProperty("url"));

    }

    @When("The user verifies the visibility of the body section heading {string}")
    public void the_user_verifies_the_visibility_of_the_body_section_heading(String HeadingText) {

        String expected = "Transform Your Future with InstuLearn...";
        String actual = aysenur.homePageTitle.getText();

        Assert.assertEquals(actual, expected);

    }

    @When("The user views the search box in the body section")
    public void theUserViewsTheSearchBoxInTheBodySection() {

        aysenur.searchBox.isDisplayed();

    }

    @Then("The user verifies that the placeholder text in the search box is {string}")
    public void theUserVerifiesThatThePlaceholderTextInTheSearchBoxIs(String PlaceholderText) {

        String expectedText = "Search courses and instructors...";
        String actualText = aysenur.searchBoxText.getAttribute("placeholder");

        Assert.assertEquals(expectedText, actualText);

    }

    @When("The user types {string} into the search box")
    public void theUserTypesIntoTheSearchBox(String searchText) {

        aysenur.searchBox.sendKeys(searchText);

    }

    @Then("The user verifies that the text in the search box is {string}")
    public void theUserVerifiesThatTheTextInTheSearchBoxIs(String expectedText) {

        String actualText = aysenur.searchBox.getAttribute("value");

        Assert.assertEquals(expectedText, actualText);
    }

    @When("The user types {string} into the search box and presses Enter")
    public void theUserTypesIntoTheSearchBoxAndPressesEnter(String searchText) {

        aysenur.searchBox.sendKeys(searchText + Keys.ENTER);

    }

    @Then("The user verifies that the URL has changed")
    public void theUserVerifiesThatTheURLHasChanged() {

        String startingUrl = "https://qa.instulearn.com";
        String currentUrl = DriverManager.getDriver().getCurrentUrl();

        Assert.assertNotEquals(startingUrl, currentUrl);
    }


    @When("The user verifies that the search button on the homepage is visible")
    public void theUserVerifiesThatTheSearchButtonOnTheHomepageIsVisible() {

        aysenur.searchButton.isDisplayed();

    }

    @When("The user clicks the search button")
    public void theUserClicksTheSearchButton() {
        aysenur.searchButton.click();
    }

    @When("The user scrolls to the {string} heading")
    public void theUserScrollsToTheHeading(String heading) {
        WebElement headingElement = resolveHeading(heading);
        JSUtilities.scrollToElement(DriverManager.getDriver(), headingElement);
    }

    @Then("The user verifies that the {string} heading is visible")
    public void theUserVerifiesThatTheHeadingIsVisible(String heading) {
        WebElement headingElement = resolveHeading(heading);
        Assert.assertTrue(headingElement.isDisplayed());

    }


    private WebElement resolveHeading(String heading) {
        switch (heading.trim()) {
            case "Latest bundles":
                return aysenur.latestBundlesTitle;
            case "Upcoming Courses":
                return aysenur.upcomingCoursesTitle;
            case "Trending Categories":
                return aysenur.trendingCategoriesTitle;
            case "Bestselling Courses":
                return aysenur.bestsellingCoursesTitle;
            case "Free Courses":
                return aysenur.freeCoursesTitle;
            case "Discounted Courses":
                return aysenur.discountedCoursesTitle;
            default:
                throw new AssertionError("Unknown heading: " + heading);
        }
    }

    @Then("The user verifies that the price, duration, date, and instructor information are displayed on the course cards.")
    public void theUserVerifiesThatThePriceDurationDateAndInstructorInformationAreDisplayedOnTheCourseCards() {

        aysenur.cardElement.isDisplayed();

        List<WebElement> elementList = Arrays.asList(aysenur.price, aysenur.duration, aysenur.instructorInformation, aysenur.date);

        Assert.assertTrue(aysenur.price.isDisplayed());
        Assert.assertTrue(aysenur.duration.isDisplayed());
        Assert.assertTrue(aysenur.instructorInformation.isDisplayed());
        Assert.assertTrue(aysenur.date.isDisplayed());
    }

    @When("The user clicks the card")
    public void theUserClicksTheCard() {

        aysenur.cardElement.click();
    }

    @Then("The user verify card visibility")
    public void theUserVerifyCardVisibility() {

        Assert.assertTrue(aysenur.trendingCategoriesCards.isDisplayed());

    }




    @When("The user clicks the {string} button in the homepage header")
    public void theUserClicksTheButtonInTheHomepageHeader(String arg0) {

        aysenur.loginButton.click();

    }

    @Then("The login screen is displayed")
    public void theLoginScreenIsDisplayed() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(aysenur.loginTitle.isDisplayed());

    }

    @When("The user enters the {string} address")
    public void theUserEntersTheAddress(String arg0) {

        aysenur.emailBox.sendKeys(ConfigReader.getProperty("emailAysenur"));

    }

    @And("The user enters the {string}")
    public void theUserEntersThe(String arg0) {

        aysenur.passwordBox.sendKeys(ConfigReader.getProperty("passwordAysenur"));

    }

    @When("The user clicks the Login button")
    public void theUserClicksTheLoginButton() {

        aysenur.loginLogButton.click();
    }

    @Then("The user verifies that they have logged in")
    public void theUserVerifiesThatTheyHaveLoggedIn() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(aysenur.dashboardLink.isDisplayed());

    }

    @When("The user clicks the {string} link")
    public void theUserClicksTheLink(String arg0) {

        aysenur.courseBundlesLink.click();

    }

    @When("The user clicks the {string} button")
    public void theUserClicksTheButton(String label) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement buttonToClick;
        switch (label.trim().toLowerCase(java.util.Locale.ROOT)) {
            case "new":
                buttonToClick = aysenur.newCbLink;            break;
            case "my bundles":
                buttonToClick = aysenur.myBundlesLink;       break;
            case "next":
                buttonToClick = aysenur.nextButton;            break;
            case "previous":
                buttonToClick = aysenur.previousButton;       break;
            case "send for review":
                buttonToClick = aysenur.sendForReviewButton;   break;
            case "save as draft":
                buttonToClick = aysenur.saveAsDraftButton;     break;
            case "delete":
                buttonToClick = aysenur.deleteButton;          break;
            default:
                throw new IllegalArgumentException("Button is undefined: " + label);
        }

        wait.until(ExpectedConditions.elementToBeClickable(buttonToClick)).click();

    }

    @Then("The user verifies that they are redirected to the related page")
    public void theUserVerifiesThatTheyAreRedirectedToTheRelatedPage() {

        String actualText = aysenur.basicInformationTittle.getText();
        String expected = "Basic Information";

        Assert.assertEquals(expected,actualText);


    }


    @When("The user fills the title field")
    public void theUserFillsTheTitleField() {

        aysenur.basicInfoTittleBox.sendKeys("Social Media Marketing");

    }


    private By resolveButtonBy(String field){
        String f = field.trim().toLowerCase(java.util.Locale.ROOT);
        if (f.equals("thumbnail"))
            return By.cssSelector("button.input-group-text.panel-file-manager[data-input='thumbnail']");
        if (f.equals("cover image"))
            return By.cssSelector("button.input-group-text.panel-file-manager[data-input='cover_image']");
        throw new IllegalArgumentException("Unknown field: " + field);
    }

    @When("The user clicks the {string} field")
    public void theUserClicksTheField(String field) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        WebElement trigger; // bu adım "Thumbnail" için
        switch (field.trim().toLowerCase(java.util.Locale.ROOT)) {
            case "thumbnail":   trigger = aysenur.basicInfoThumbnailButton; break;
            case "cover image": trigger = aysenur.basicInfoCoverImageButton; break;
            default: throw new IllegalArgumentException("Unknown field: " + field);
        }

        final String parent = driver.getWindowHandle();
        // 1) Tıklamadan ÖNCE mevcut handle’ları al (final olacak)
        final java.util.Set<String> before = new java.util.HashSet<>(driver.getWindowHandles());

        System.out.println("Before:" + before);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(trigger));
            new org.openqa.selenium.interactions.Actions(driver)
                    .moveToElement(trigger, 3, 3)
                    .pause(Duration.ofMillis(120))
                    .click()
                    .perform();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            WebElement fresh = wait.until(ExpectedConditions
                    .elementToBeClickable(resolveButtonBy(field)));
            new org.openqa.selenium.interactions.Actions(driver)
                    .moveToElement(fresh, 3, 3)
                    .pause(Duration.ofMillis(120))
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
        } catch (TimeoutException first) {
            // 4) Fallback: CTRL+Click ile yeni sekme zorla
            final java.util.Set<String> before2 = driver.getWindowHandles();
            new org.openqa.selenium.interactions.Actions(driver)
                    .keyDown(Keys.CONTROL)
                    .moveToElement(trigger, 3, 3).click()
                    .keyUp(Keys.CONTROL)
                    .perform();

            newHandle = new WebDriverWait(driver, Duration.ofSeconds(8)).until(d -> {
                java.util.Set<String> diff = new java.util.HashSet<>(d.getWindowHandles());
                diff.removeAll(before2);
                return diff.isEmpty() ? null : diff.iterator().next();
            });
        }
        // 5) Yeni pencereye geç
        driver.switchTo().window(newHandle);


    }

    private void closePopupAndReturnToParent() {
        WebDriver driver = DriverManager.getDriver();

        if (childHandle != null && driver.getWindowHandles().contains(childHandle)) {
            if (driver.getWindowHandle().equals(childHandle)) {
                driver.close(); // popup'ı kapat
            }
        }
        if (parentHandle != null && driver.getWindowHandles().contains(parentHandle)) {
            driver.switchTo().window(parentHandle); // parent'a dön
        } else if (!driver.getWindowHandles().isEmpty()) {
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
        }
        childHandle = null;
    }

    @Then("The user uploads an image")
    public void theUserUploadsAnImage() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        aysenur.itemClick.click();
        aysenur.confirmButton.click();

        // simdi ana pencereye geri donuyoruz
        // Pencere kapandı mı? (kapanmadıysa kapatıp parent'a dön)
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.numberOfWindowsToBe(1));
        } catch (TimeoutException e) {
            // 2) Kapanmadıysa: şu an child'taysan kapat, sonra diğerine geç
            String current = driver.getWindowHandle();
            java.util.Set<String> handles = driver.getWindowHandles();
            if (handles.size() > 1) {
                driver.close(); // bulunduğun child'ı kapat
                for (String h : driver.getWindowHandles()) {
                    if (!h.equals(current)) { driver.switchTo().window(h); break; }
                }
            }
        }

        // 3) GARANTİ: Tek handle'a switch + defaultContent + overlay temizliği
        try {
            java.util.Set<String> one = driver.getWindowHandles();
            if (!one.isEmpty()) driver.switchTo().window(one.iterator().next());
        } catch (Exception ignore) {}
        driver.switchTo().defaultContent();
        try {
            new WebDriverWait(driver, Duration.ofSeconds(6))
                    .until(ExpectedConditions.invisibilityOfElementLocated(
                            By.cssSelector(".modal-backdrop, .swal2-container, .toast, .block-ui, .loading, .spinner")));
        } catch (TimeoutException ignore) {}
    }


    @When("The user fills the Description field")
    public void theUserFillsTheDescriptionField() {

        String text = "Embark on a transformative journey into the dynamic world of social media marketing.";

        JSUtilities.scrollToElement(DriverManager.getDriver(), aysenur.basicInfoDescription);
        JSUtilities.clickWithJS(DriverManager.getDriver(), aysenur.basicInfoDescription);

        aysenur.basicInfoDescription.clear();
        aysenur.basicInfoDescription.sendKeys(text);

    }

    @Then("The user verifies that they have moved to the next step")
    public void theUserVerifiesThatTheyHaveMovedToTheNextStep() {

        aysenur.extraInformationTitle.isDisplayed();

    }


    /// ///////

    @Then("The user verifies the {string} title is visible")
    public void theUserVerifiesTheTitleIsVisible(String arg0) {

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(aysenur.myBundlesTitle));
        Assert.assertTrue(aysenur.myBundlesTitle.isDisplayed());
    }

    @When("The user confirms the deletion")
    public void theUserConfirmsTheDeletion() {

        aysenur.deleteConfirm.click();

    }

    @When("The user clicks the Category menu")
    public void theUserClicksTheCategoryMenu() {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aysenur.categoryDropdown)).click();

    }

    @Then("The user selects {string} from the dropdown")
    public void theUserSelectsFromTheDropdown(String option) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        if ("select".equalsIgnoreCase(aysenur.categoryDropdown.getTagName())) {
            new org.openqa.selenium.support.ui.Select(aysenur.categoryDropdown).selectByVisibleText(option);
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(aysenur.categoryDropdown)).click();
            By opt = By.xpath(
                    "//*[normalize-space()='" + option + "' and (self::option or self::li or self::div or self::span)]"
            );
            wait.until(ExpectedConditions.elementToBeClickable(opt)).click();
        }
    }

    @When("clicks on the price option")
    public void clicksOnThePriceOption() {

        aysenur.priceBox.click();

    }

    @Then("enters a price")
    public void entersAPrice() {

        aysenur.priceBox.sendKeys("50");
    }

    @When("clicks the New Plan button")
    public void clicksTheNewPlanButton() {


        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By newPlanBtn = By.id("webinarAddTicket");

        // Butona güvenli tıklama
        JSUtilities.scrollToElement(driver, driver.findElement(newPlanBtn));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(newPlanBtn)).click();
        } catch (Exception e) {
            JSUtilities.clickWithJS(driver, driver.findElement(newPlanBtn));
        }

        // Bu form açıldığında "Maximum 64 characters" placeholder'lı input DOM'a geliyor
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[placeholder='Maximum 64 characters']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Maximum 64 characters']")));

    }


    @When("fills in the Title field")
    public void fillsInTheTitleField() {

    /*   WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

       // Title kutusu (placeholder’a göre)
       By titleBox = By.xpath("//input[@placeholder='Maximum 64 characters']");

       WebElement input = wait.until(ExpectedConditions.elementToBeClickable(titleBox));
       input.clear();
       input.sendKeys("1-Week Discount");
     */

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By titleBox = By.cssSelector("input[placeholder='Maximum 64 characters']");

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(titleBox));
        JSUtilities.scrollToElement(driver, input);
        wait.until(ExpectedConditions.elementToBeClickable(input));
        try {
            input.click();
            input.clear();
            input.sendKeys("1-Week Discount");
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input',{bubbles:true}));",
                    input, "1-Week Discount"
            );
        }
    }

    @When("fills in the Discount field")
    public void fillsInTheDiscountField() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By discount = By.cssSelector("input.js-ajax-discount, input[name='ajax[new][discount]']");
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(discount));

        JSUtilities.scrollToElement(driver, el);     // görünecek yere getir
        JSUtilities.setInputFieldWithJS(driver, el, "70"); // direkt değeri yaz (click yok)
    }

    @When("clicks on the start date field")
    public void clicksOnTheStartDateField() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Start Date input
        By startInputBy = By.cssSelector("input[name='ajax[new][start_date]']");
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(startInputBy));

        // görüntüye getir + sticky header offset
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'}); window.scrollBy(0,-150);", input);

        // readonly varsa kaldır ve odakla
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly'); arguments[0].click();", input);
    }

    @Then("selects a date from the date picker")
    public void selectsADateFromTheDatePicker() {

        WebDriver driver = DriverManager.getDriver();

        // Seçeceğin tarih — örnek: bu ayın 5’i. Gerekirse parametreleştir.
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.M.d");
        LocalDate target = LocalDate.now().withDayOfMonth(5);
        String value = target.format(fmt);      // ör: 2025.11.5

        WebElement input = driver.findElement(By.cssSelector("input[name='ajax[new][start_date]']"));

        // yaz – eskiyi sil, yeniyi gir
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, value);

        // input/change event’lerini tetikle (bazı datepicker’lar zorunlu kılıyor)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));", input);

        // Popup açıksa Apply varsa kapat
        List<WebElement> apply = driver.findElements(By.xpath("//button[normalize-space()='Apply']"));
        if (!apply.isEmpty() && apply.get(0).isDisplayed()) {
            apply.get(0).click();
        }

    }

    @When("clicks the Apply button")
    public void clicksTheApplyButton() {

        //  WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.applyBtn"))).click();

        WebDriver driver = DriverManager.getDriver();

        // Olası locator adayları (daterangepicker için de ekledik)
        List<By> candidates = Arrays.asList(
                By.cssSelector("button.applyBtn"),
                By.cssSelector(".drp-buttons .applyBtn"),
                By.xpath("//button[normalize-space()='Apply']")
        );

        WebElement btn = null;
        for (By by : candidates) {
            List<WebElement> found = driver.findElements(by);
            if (!found.isEmpty() && found.get(0).isDisplayed()) {
                btn = found.get(0);
                break;
            }
        }

        // Buton görünür değilse step'i sessizce atla
        if (btn == null) {
            LoggerHelper.info("Apply button not present; skipping this step.");
            return;
        }

        // Görünüre getir ve güvenli tıkla (gerekirse JS fallback)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", btn);

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementClickInterceptedException.class)
                    .until(ExpectedConditions.elementToBeClickable(btn))
                    .click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }

    @When("clicks on the end date field")
    public void clicksOnTheEndDateField() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By endInputBy = By.cssSelector("input[name='ajax[new][end_date]']");
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(endInputBy));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'}); window.scrollBy(0,-150);", input);

        // readonly kaldır + odak ver
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly'); arguments[0].focus();", input);
    }

    @Then("selects a end date from the date picker")
    public void selectsAEndDateFromTheDatePicker() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-M-d");

        // start_date’i oku; okunamazsa bugünden 7 gün sonrası
        LocalDate target;
        try {
            String startVal = driver.findElement(By.cssSelector("input[name='ajax[new][start_date]']")).getAttribute("value");
            target = LocalDate.parse(startVal, fmt).plusDays(7);
        } catch (Exception e) {
            target = LocalDate.now().plusDays(7);
        }
        String value = target.format(fmt);

        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[name='ajax[new][end_date]']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly');", input);

        // yaz – eskiyi sil, yeniyi gir
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, value);

        // event’leri tetikle
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));", input);

        // blur/validasyonu tetiklemek için
        input.sendKeys(Keys.TAB);

        // değer yazılmadıysa JS ile zorla yaz
        String current = input.getAttribute("value");
        if (current == null || !current.trim().equals(value)) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                            "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
                    input, value);
            input.sendKeys(Keys.TAB);
        }
    }


    @When("clicks the Save button")
    public void clicksTheSaveButton() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Önce açık (show) akordeon içindeki Save’i dene; yoksa sayfadaki herhangi biri
        By inOpenCollapse = By.xpath("//div[contains(@class,'collapse') and contains(@class,'show')]//button[contains(@class,'js-save-ticket')]");
        List<WebElement> candidates = driver.findElements(inOpenCollapse);
        if (candidates.isEmpty()) {
            candidates = driver.findElements(By.xpath("//button[contains(@class,'js-save-ticket')]"));
        }

        if (candidates.isEmpty()) {
            throw new NoSuchElementException("Save button (.js-save-ticket) not found");
        }

        // Görünür olanı seç
        WebElement btn = candidates.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElse(candidates.get(0));

        // Görüntüye getir + sticky header offset
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'}); window.scrollBy(0,-120);", btn);

        // Tıklanabilir olana kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(btn));

        try {
            btn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }




    @Then("verifies that the new plan is created")
    public void verifiesThatTheNewPlanIsCreated() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // (opsiyonel) Formdaki Title değerini al
        String title = null;
        try {
            Object val = js.executeScript(
                    "var el=document.querySelector(\"input[name='ajax[new][title]']\");" +
                            "return el ? el.value : null;");
            if (val != null) title = val.toString().trim();
        } catch (Exception ignore) {}

        // Başarı bildirimi (toast/alert) gelmesini bekle (varsa)
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".alert-success, .toast, .iziToast")));
        } catch (TimeoutException ignore) { /* toast görünmeyebilir, sorun değil */ }

        // Listede yeni planı doğrula
        By rowLocator;
        if (title != null && !title.isEmpty()) {
            rowLocator = By.xpath(
                    "//*[contains(@class,'table') or contains(@class,'list') or contains(@class,'plans')]" +
                            "//*[normalize-space()='" + title + "']");
        } else {
            // Fallback: herhangi bir plan satırı/kartı görünsün
            rowLocator = By.xpath("(//table//tr[.//td] | //div[contains(@class,'plan') or contains(@class,'card')])[1]");
        }

        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));
        Assert.assertTrue("New pricing plan not visible in the list!", row.isDisplayed());
    }

    @When("The user clicks the Add Course button")
    public void theUserClicksTheAddCourseButton() {

        aysenur.addCourse.click();
    }


    @Then("The user sees the {string} heading")
    public void theUserSeesTheHeading(String expectedHeading) {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // h1–h5 veya span içindeki tam metni bekle
        By headingBy = By.xpath(
                "//*[self::h1 or self::h2 or self::h3 or self::h4 or self::h5 or self::span]" +
                        "[normalize-space()='" + expectedHeading + "']"
        );

        // Görünür olmasını bekle
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(headingBy));

        // DOM yeniden çizildiyse (stale) tazelenmiş halini bekle
        heading = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(headingBy)));

        String actual = heading.getText().trim();
        Assert.assertEquals(expectedHeading, actual);

    }

    @When("The user clicks the course selection dropdown")
    public void theUserClicksTheCourseSelectionDropdown() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(aysenur.selectCourseDropdown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'})", dd);
        try {
            dd.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dd);
        }

        // Select2 açıldı mı? Arama inputu görünmeli
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.select2-search__field")));

    }

    @When("The user selects the {string} course")
    public void theUserSelectsTheCourse(String option) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        if ("select".equalsIgnoreCase(aysenur.selectCourseDropdown.getTagName())) {
            new org.openqa.selenium.support.ui.Select(aysenur.selectCourseDropdown).selectByVisibleText(option);
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(aysenur.selectCourseDropdown)).click();
            By opt = By.xpath(
                    "//*[normalize-space()='"+option+"' and (self::option or self::li or self::div or self::span)]"
            );
            wait.until(ExpectedConditions.elementToBeClickable(opt)).click();
        }
    }

    @Then("The user verifies that it was created")
    public void theUserVerifiesThatItWasCreated() {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(12));

        String title = "meta social media marketing"; // case-insensitive
        By course = By.xpath(
                "//ul[@data-order-table='bundle_webinars']" +
                        "//li//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + title + "')]"
        );

        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(course));
        Assert.assertTrue("Course title not visible.", el.isDisplayed());
    }

    @When("The user clicks the New FAQ button")
    public void theUserClicksTheNewFAQButton() {

        aysenur.newFAQ.click();
    }

    @Then("The user sees the New FAQ heading")
    public void theUserSeesTheNewFAQHeading() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        final String expected = "New FAQ";

        By inModal = By.xpath(
                "//div[contains(@class,'modal') and contains(@class,'show')]"
                        + "//*[self::h1 or self::h2 or self::h3 or self::h4 or self::h5 or self::span]"
                        + "[normalize-space()='New FAQ']"
        );

        By anywhere = By.xpath(
                "//*[self::h1 or self::h2 or self::h3 or self::h4 or self::h5 or self::span]"
                        + "[normalize-space()='New FAQ']"
        );

        By used;
        WebElement heading;
        try {
            used = inModal;
            heading = wait.until(ExpectedConditions.visibilityOfElementLocated(used));
        } catch (TimeoutException e) {
            used = anywhere;
            heading = wait.until(ExpectedConditions.visibilityOfElementLocated(used));
        }

        // DOM yeniden çizildiyse, aynı locator’la tazelenmiş halini bekle
        heading = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(used)
        ));

        Assert.assertEquals(expected, heading.getText().trim());

    }

    @When("The user fills in the Title field")
    public void theUserFillsInTheTitleField() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By title = By.cssSelector("div[id^='collapseFaq'].show input[name='ajax[new][title]']");
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(title));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        el.clear();
        el.sendKeys("When will the new discount be available?");
    }

    @And("The user fills in the Answer box")
    public void theUserFillsInTheAnswerBox() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement answer = wait.until(ExpectedConditions.elementToBeClickable(aysenur.faqBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", answer);

        try {
            answer.click();
            answer.clear();
            answer.sendKeys("I follow you regularly. I am very satisfied. When will the new discount be?");
        } catch (Exception e) { // olası intercept/stale için JS fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];",
                    answer,
                    "I follow you regularly. I am very satisfied. When will the new discount be?");
        }
    }

    @And("The user clicks the Save button")
    public void theUserClicksTheSaveButton() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Kaydet
        By saveBtn = By.xpath("//button[contains(@class,'js-save-bundleWebinar') or normalize-space()='Save']");
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        btn.click();

        // Oluşan kursu (case-insensitive) listede bekle
        String course = "meta social media marketing";
        By newCourse = By.xpath(
                "//ul[@data-order-table='bundle_webinars']//li//*[contains(" +
                        "translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + course + "')]"
        );

        // Form kaybolsun VEYA satır görünsün VEYA buton staleness olsun
        wait.until(ExpectedConditions.or(
                ExpectedConditions.invisibilityOfElementLocated(By.id("newBundleWebinarForm")),
                ExpectedConditions.visibilityOfElementLocated(newCourse),
                ExpectedConditions.stalenessOf(btn)
        ));
    }

    @Then("The user verifies the FAQ was created")
    public void theUserVerifiesTheFAQWasCreated() {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));

        // Savunmacı kontrol: en son eklenen soru set edilmiş mi?
        Assert.assertNotNull("lastFaqQuestion null! Önce soru step'inde set edilmemiş.", lastFaqQuestion);

        // Sadece FAQ listesinin içinde ara
        By row = By.xpath(
                "//*[@id='faqsAccordion']" +
                        "//li[contains(@class,'accordion-row')]//*[normalize-space()=" + xPathLiteral(lastFaqQuestion) + "]"
        );

        // Görünür olmasını bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(row));
    }

    // Metinde tek/çift tırnak olursa XPath için güvenli literal üretelim
    private static String xPathLiteral(String s) {
        if (!s.contains("'"))  return "'" + s + "'";
        if (!s.contains("\"")) return "\"" + s + "\"";
        return "concat('" + s.replace("'", "',\"'\",'") + "')";
    }


    /// /// 13

    @When("The user clicks the Message to reviewer button")
    public void theUserClicksTheMessageToReviewerButton() {


    }


    @Then("The user sees the Message to reviewer heading")
    public void theUserSeesTheMessageToReviewerHeading() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // h1–h4/label/span içinde tam "Message to reviewer" metnini arar (ilk görüneni alır)
        By headingBy = By.xpath(
                "(//*[self::h1 or self::h2 or self::h3 or self::h4 or self::label or self::span]" +
                        "[normalize-space()='Message to reviewer'])[1]"
        );

        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(headingBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", heading);

        // Stale ihtimaline karşı tazele
        heading = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(headingBy)));

        String text = heading.getText().trim();
        // Başlıkta ek ifadeler olma ihtimaline karşı contains ile doğrula
        Assert.assertTrue("Heading not visible or text mismatch! Actual: " + text,
                text.equalsIgnoreCase("Message to reviewer") || text.toLowerCase().contains("message to reviewer"));
    }

    @When("The user fills in the message box")
    public void theUserFillsInTheMessageBox() {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement answer = wait.until(ExpectedConditions.elementToBeClickable(aysenur.messageBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", answer);

        try {
            answer.click();
            answer.clear();
            answer.sendKeys("I'm looking forward to the course, thank you");
        } catch (Exception e) { // olası intercept/stale için JS fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];",
                    answer,
                    "I'm looking forward to the course, thank you");
        }
    }

    @When("the user toggles the {string} switch")
    public void theUserTogglesTheSwitch(String arg0) {

        WebDriver d = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

        // Label’ı görünür ve tıklanabilir hale getir
        WebElement label = wait.until(ExpectedConditions.visibilityOf(aysenur.rulesSwitchLabel));
        ((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView({block:'center'});", label);

        if (!aysenur.rulesCheckbox.isSelected()) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(label)).click();
            } catch (Exception e) {
                // olası intercept/overlay için JS fallback
                ((JavascriptExecutor)d).executeScript("arguments[0].click();", label);
            }
            // state gerçekten değişene kadar bekle
            wait.until(ExpectedConditions.elementSelectionStateToBe(aysenur.rulesCheckbox, true));
        }

    }

    @Then("the user sees it is enabled")
    public void theUserSeesItIsEnabled() {

        WebDriver d = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(8));

        By rules = By.id("rulesSwitch");

        // Görünürlük bekleme; seçili olmasını bekle
        wait.until(ExpectedConditions.presenceOfElementLocated(rules));
        wait.until(driver -> driver.findElement(rules).isSelected());

        // Ek güvence: "Send for Review" aktifleşsin
        wait.until(ExpectedConditions.elementToBeClickable(aysenur.sendForReviewButton));

    }

    @Then("the user verifies the course bundle appears in the list")
    public void theUserVerifiesTheCourseBundleAppearsInTheList() {

        aysenur.finalCourseBundles.isDisplayed();
    }

    @When("The user clicks the three-dots menu")
    public void theUserClicksTheThreeDotsMenu() {

        aysenur.threeDort.click();
    }

    @Then("The user verifies that the list has opened")
    public void theUserVerifiesThatTheListHasOpened() {

        aysenur.threeDortDropdown.isDisplayed();
    }

    @When("The user clicks the Edit button")
    public void theUserClicksTheEditButton() {

        aysenur.edit.click();
    }

    @When("the user clicks Delete")
    public void theUserClicksDelete() {

        aysenur.deleteRed.click();

    }

}
