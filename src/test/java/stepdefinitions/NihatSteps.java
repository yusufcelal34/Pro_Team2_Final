package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Nihat;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

public class
    NihatSteps {
        static Actions actions = new Actions(DriverManager.getDriver());
        Nihat nihad=new Nihat();



        @Given("I am on the homepage")
        public void i_am_on_the_homepage() {
            DriverManager.getDriver().get(ConfigReader.getProperty("url"));
        }

        @When("I should see the {string} card")
        public void i_should_see_the_card(String string) throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.validateCertificatesCard);
            Thread.sleep(2000);

            Assertions.assertTrue(nihad.validateCertificatesCard.isDisplayed(), string + " card is not visible.");
            Thread.sleep(2000);

        }

        @When("I should click the {string} card")
        public void i_should_click_the_card(String string) {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(nihad.validateCertificatesCard));
            nihad.validateCertificatesCard.click(); // normal Selenium click dene

//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("arguments[0].click();", nihad.validateCertificatesCard);
        }



        @Then("I should be redirected to the {string} page")
        public void i_should_be_redirected_to_the_page(String string) {
            Assertions.assertTrue(nihad.certificateValidationPageTitle.isDisplayed(), string + " card is not visible.");
        }


//======================================================================================================================


        @When("I should see visibility the {string} card")
        public void i_should_see_visibility_the_card(String string) throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.reserveMeetingCard);
            Thread.sleep(2000);

            Assertions.assertTrue(nihad.reserveMeetingCard.isDisplayed(), string + " card is not visible.");
            Thread.sleep(2000);

        }


        @When("I click the {string} card")
        public void i_click_the_card(String string) {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(nihad.reserveMeetingCard));
            nihad.reserveMeetingCard.click();
        }

        @Then("I should be redirected related to the {string} page")
        public void i_should_be_redirected_related_to_the_page(String string) {

            Assertions.assertTrue(nihad.headerTitle.isDisplayed(), string + " card is not visible.");

        }
//======================================================================================================================


        @When("I check the {string} link visibility")
        public void i_check_the_link_visibility(String string) throws InterruptedException {
            Assertions.assertTrue(nihad.fourthNavLink.isDisplayed(), string + " card is not visible.");
            Thread.sleep(2000);
        }
        @When("I click the {string} link")
        public void i_click_the_link(String string) {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(nihad.validateCertificatesCard));
            nihad.fourthNavLink.click();
        }
        @Then("I have to redirected to the {string} page")
        public void i_have_to_redirected_to_the_page(String string) throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.productPriceBox);
            Thread.sleep(2000);
            Assertions.assertTrue(nihad.productPriceBox.isDisplayed(), string + " card is not visible.");
        }

//======================================================================================================================
        @Then("the text of {string} should be displayed")
        public void the_text_of_should_be_displayed(String string) throws InterruptedException {
            Assertions.assertTrue(nihad.fourthNavLink.isDisplayed(), string + " card is not visible.");
            Thread.sleep(2000);
        }

        @When("I click the \"Products\"list link")
        public void i_click_the_products_list_link() {
            nihad.fourthNavLink.click();



        }

        @Then("the text {string} should be displayed")
        public void the_text_should_be_displayed(String string) throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.productPriceBox);
            Thread.sleep(2000);
            Assertions.assertTrue(nihad.productPriceBox.isDisplayed(), string + " card is not visible.");
        }




        @Given("I am on the Products page")
        public void i_am_on_the_products_page() {
//        DriverManager.getDriver().get(ConfigReader.getProperty("producturlpage"));
            DriverManager.getDriver().get("https://qa.instulearn.com/products");
        }
        @Then("the search textbox should be visible and enabled")
        public void the_search_textbox_should_be_visible_and_enabled() throws InterruptedException {
            Assertions.assertTrue(nihad.searchTextBox.isDisplayed(),  " card is not visible.");
            Thread.sleep(2000);

        }
        @Then("the search button should be visible and enabled")
        public void the_search_button_should_be_visible_and_enabled() {
            nihad.searchButton.click();
            Assertions.assertTrue(nihad.searchButton.isEnabled(), "Search button is not enabled");

        }

        //==============================================================================================================

        @And("I click and reach {string} link")
        public void i_click_and_reach_link(String string) {
            nihad.fourthNavLink.click();

        }


        @Given("I am on the product page")
        public void i_am_on_the_product_page() {
            DriverManager.getDriver().get("https://qa.instulearn.com/products");


        }

        @When("I click the {string}, {string}, and {string} filters")
        public void i_click_the_and_filters(String string, String string2, String string3) {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            WebElement free = wait.until(ExpectedConditions.elementToBeClickable(nihad.freeElement));
            Assertions.assertTrue(nihad.freeElement.isEnabled(), "Free filtresi tıklanabilir değil");
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();",nihad.freeElement);


            Assertions.assertTrue(nihad.freeShippingElement.isEnabled(), "Free filtresi tıklanabilir değil");
            js.executeScript("arguments[0].click();",nihad.freeElement);



            Assertions.assertTrue(nihad.discountElement.isEnabled(), "Free filtresi tıklanabilir değil");
            js.executeScript("arguments[0].click();",nihad.freeElement);


        }
//



        @Then("Price, Seller, Product Name, and Description information of the selected product should be visible")
        public void price_seller_product_name_and_description_information_of_the_selected_product_should_be_visible() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            WebElement free = wait.until(ExpectedConditions.elementToBeClickable(nihad.productPriceBox));
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.productPriceBox);
           Assertions.assertTrue(nihad.productPriceBox.isDisplayed(), "pricebox" + "  not visible.");
            Assertions.assertTrue(nihad.updatedProductTitle.isDisplayed(), "pricebox" + "  not visible.");

            Assertions.assertTrue(nihad.userInlineAvatar.isDisplayed(), "avatar" + "  not visible.");
        }

        @Given("I select a product")
        public void i_select_a_product() {


            nihad.firstImageBox.click();

        }
//==================================================================================================
@And("I am login")
public void iAmLogin() {
nihad.loginButon.click();

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    WebElement emailBox = wait.until(ExpectedConditions.visibilityOf(nihad.emailTextBox));
    nihad.emailTextBox.clear();
    nihad.emailTextBox.sendKeys("nihad.student@instulearn.com");



    nihad.passWordTextBox.sendKeys("Learn.1406");

    nihad.Login.click();

}
        @Then("\"Add to Cart\"and buy now  button should be visible and enabled")
        public void add_to_cart_and_buy_now_button_should_be_visible_and_enabled() {
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
////            WebElement free = wait.until(ExpectedConditions.elementToBeClickable(nihad.productPriceBox));
//            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
////            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.productPriceBox);
////            nihad.firstImageBox.click();
//            ReusableMethods.waitFor(2000);
            Assertions.assertTrue(nihad.ratingStars.isDisplayed(), "Rating stars not visible.");
            Assertions.assertTrue(nihad.submitButton.isDisplayed(), "Submit butonu görünmüyor.");
            Assertions.assertTrue(nihad.submitButton.isEnabled(), "Free filtresi tıklanabilir değil.");

        }

        @Then("product details should be displayed")
        public void product_details_should_be_displayed() {

            Assertions.assertTrue(nihad.ratingStars.isDisplayed(), "Rating stars not visible.");
            Assertions.assertTrue(nihad.submitButton.isDisplayed(), "Submit butonu görünmüyor.");
            Assertions.assertTrue(nihad.submitButton.isEnabled(), "Free filtresi tıklanabilir değil.");
            Assertions.assertTrue(nihad.buyNowButton.isDisplayed(), "Buy Now butonu görünmüyor.");
            Assertions.assertTrue(nihad.buyNowButton.isEnabled(), "Buy Now butonu aktif değil.");
            Assertions.assertTrue(nihad.buyNowButton.isDisplayed(), "Buy Now butonu görünmüyor.");

        }

        @Then("rating and comments should be visible")
        public void rating_and_comments_should_be_visible() {

            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            WebElement free = wait.until(ExpectedConditions.elementToBeClickable(nihad.postCommentButton));
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.postCommentButton);
            nihad.commentTextArea.click();
            nihad.commentTextArea.sendKeys("This is my test comment.");
            nihad.postCommentButton.click();

        }

//===============================================
@Then("I Select buy know and click checkout and choose payment method")
public void iSelectBuyKnowAndClickCheckoutAndChoosePaymentMethod() {

nihad.buyNowButton.click();


    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    WebElement free = wait.until(ExpectedConditions.elementToBeClickable(nihad.checkoutButton));
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", nihad.checkoutButton);
    nihad.checkoutButton.click();

    JavascriptExecutor js1 = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].click();", nihad.stripeFrame);


    js.executeScript("arguments[0].click();", nihad.paymentSubmitButton);



    WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    WebElement free1 = wait.until(ExpectedConditions.elementToBeClickable(nihad.emailInput));


//    js.executeScript("arguments[0].click();", nihad.emailInput);
nihad.emailInput.click();
//nihad.spanlink.click();
    nihad.emailInput.sendKeys("nihad.student@instulearn.com");
    ReusableMethods.waitFor(2000);
    nihad.resetButton.click();

    nihad.cardNumberInput.sendKeys("4242424242424242");
nihad.cardExpiryInput.sendKeys("1126");
nihad.cardCvcInput.sendKeys("111");
nihad.billingNameInput.sendKeys("Nihad Farajov");



}


        @Then("click start payment and pay")
        public void clickStartPaymentAndPay() {
            nihad.submitButtonIconContainer.click();

        }

//=============================================================================================================

    @And("filter shouldbe visible")
    public void filterShouldbeVisible() {
        Assertions.assertTrue(nihad.customSwitch.isDisplayed(), "filter.");
    }




    @And("Ensure the links {string}, {string}, and {string} appear and are enabled under Certificates in the Dashboard sidebar.")
    public void ensureTheLinksAndAppearAndAreEnabledUnderCertificatesInTheDashboardSidebar(String arg0, String arg1, String arg2) {

        Assertions.assertTrue(nihad.certificatesSpan.isDisplayed(), "Submit butonu görünmüyor.");
        Assertions.assertTrue(nihad.certificatesSpan.isEnabled(), "Free filtresi tıklanabilir değil.");
        nihad.certificatesSpan.click();
        Assertions.assertTrue(nihad.achievementsLink.isDisplayed(), "Buy Now butonu görünmüyor.");
        Assertions.assertTrue(nihad.achievementsLink.isEnabled(), "Buy Now butonu aktif değil.");
        Assertions.assertTrue(nihad.certificateValidationLink.isDisplayed(), "Buy Now butonu görünmüyor.");
        Assertions.assertTrue(nihad.certificateValidationLink.isEnabled(), "Buy Now butonu aktif değil.");
        Assertions.assertTrue(nihad.completionCertificatesLink.isDisplayed(), "Buy Now butonu görünmüyor.");
        Assertions.assertTrue(nihad.completionCertificatesLink.isEnabled(), "Buy Now butonu aktif değil.");




    }


    @When("I click on the {string} link")
    public void iClickOnTheLink(String arg0) {
            nihad.certificatesSpan.click();
            nihad.achievementsLink.click();

    }

    @Then("my achievements statistics information should be visible on the page")
    public void my_achievements_statistics_information_should_be_visible_on_the_page() {
        Assertions.assertTrue(nihad.firstElement.isDisplayed(), "Buy Now butonu görünmüyor.");

        Assertions.assertTrue(nihad.secondElement.isDisplayed(), "Buy Now butonu görünmüyor.");
        Assertions.assertTrue(nihad.thirdElement.isDisplayed(), "Buy Now butonu görünmüyor.");


    }

    @When("I click on the dashboard {string} link")
    public void i_click_on_the_dashboard_link(String string) {
nihad.certificateValidationLink.click();
    }

    @Then("I should be redirected to the certificate validation page")
    public void i_should_be_redirected_to_the_certificate_validation_page() {
        String expectedUrl = "https://qa.instulearn.com/certificate_validation";

        WebDriverWait wait = new WebDriverWait(DriverManager.driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = DriverManager.driver.get().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);


    }


    @Then("I click on certificateamd Completion Certificates then  enter data")
    public void i_click_on_certificateamd_completion_certificates_then_enter_data() {

        nihad.certificatesSpan.click();
        nihad.completionCertificatesLink.click();
        ReusableMethods.waitFor(3);


    }
    @When("I select {string} as the From date")
    public void i_select_as_the_from_date(String from) {

        WebElement fromDate = nihad.fromDateIconCompletionCertificates;
        ReusableMethods.waitForVisibility(fromDate, 5);
        Assertions.assertTrue(fromDate.isDisplayed(), "From date icon is not visible!");
        fromDate.click();

        JavascriptExecutor js11 = (JavascriptExecutor) DriverManager.getDriver();
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", nihad.fromDateIconCompletionCertificates);

        nihad.fromInput.click();
        ReusableMethods.waitFor(3);
        nihad.fromDateIconCompletionCertificates.sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_Nihad"));
        ReusableMethods.waitFor(3);

        WebElement toDate = nihad.toDateIconCompletionCertificates;
        ReusableMethods.waitForVisibility(toDate, 5);
        Assertions.assertTrue(toDate.isDisplayed(), "To date icon is not visible!");
        nihad.toInput.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.waitForVisibility(nihad.toDateIconCompletionCertificates, 10).sendKeys(ConfigReader.getProperty("Filtercertificatesfrom_to"));
        ReusableMethods.waitFor(3);

        WebElement courseDropdown = nihad.courseDropdownCompletionCertificates;
        ReusableMethods.waitForVisibility(courseDropdown, 5);
        Assertions.assertTrue(courseDropdown.isDisplayed(), "Course dropdown is not visible!");
        courseDropdown.click();
        ReusableMethods.waitFor(3);

        WebElement showResultsButton = nihad.showResultsButtonCompletionCertificates;
        ReusableMethods.waitForVisibility(showResultsButton, 5);
        Assertions.assertTrue(showResultsButton.isDisplayed(), "Show Results button is not visible!");
        showResultsButton.click();
        ReusableMethods.waitFor(2);


    }

    @When("I select date as the To date")
    public void i_select_date_as_the_to_date() {


    }

    @When("I select Meta Social Media Marketing as the course")
    public void i_select_meta_social_media_marketing_as_the_course() {
        Select s = new Select(nihad.courseDropdown);
        s.selectByIndex(1);
        nihad.showResultsBtn.click();
    }



}
