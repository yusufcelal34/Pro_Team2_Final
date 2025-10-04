package stepdefinitions;

import io.cucumber.java.bs.A;
import utilities.ConfigReader;
import utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Enes;
import utilities.JSUtilities;
import utilities.WaitHelper;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class EnesSteps {
    Enes enes = new Enes();
    WebDriver driver = Hooks.getDriver();
    WebElement firstCard;
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

    @Given("The user on the homepage {string}")
    public void the_user_on_the_homepage(String url) throws InterruptedException {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
        Thread.sleep(5000);
    }

    @When("I scroll to the body store section")
    public void i_scroll_to_the_body_store_section() {
        JSUtilities.scrollToElement(driver, enes.storeProductsYazisi);
        wait.until(ExpectedConditions.visibilityOf(enes.storeProductsYazisi));
        Assert.assertTrue("Store Products heading is not visible!", enes.storeProductsYazisi.isDisplayed());

    }
    @Then("the Store Products heading should be visible")
    public void the_store_products_heading_should_be_visible() {
        enes.storeProductsYazisi.isDisplayed();

    }
    @Then("a product slider should be visible with at least one product card")
    public void a_product_slider_should_be_visible_with_at_least_one_product_card() {
        List<WebElement> productCards = enes.productCards;
        if (productCards == null || productCards.isEmpty()) {
            productCards = driver.findElements(By.cssSelector(".product-card, .products .product-card, .product-slider .product-card, .products .swiper-slide, .product-slider .swiper-slide"));
        }


        Assert.assertTrue("No product cards found in the slider!", productCards.size() >= 1);
    }


    @When("I inspect the first product card")
    public void i_inspect_the_first_product_card() {
        WebElement firstCard1 = enes.firstProductPrice;
        JSUtilities.scrollToElement(driver, firstCard1);
        wait.until(ExpectedConditions.visibilityOf(firstCard1));
    }

    @Then("the card should display a price")
    public void the_card_should_display_a_price() {
        WebElement price = enes.firstProductPrice;
        wait.until(ExpectedConditions.visibilityOf(price));
        Assert.assertTrue("Price is not visible", price.isDisplayed());
        Assert.assertFalse("Price text is empty", price.getText().trim().isEmpty());
    }

    @Then("the card should display a rating")
    public void the_card_should_display_a_rating() {
        WebElement rating = enes.ratingBox;
        wait.until(ExpectedConditions.visibilityOf(rating));
        Assert.assertTrue("Rating is not visible", rating.isDisplayed());



    }

    @Then("the card should display an add to cart icon")
    public void the_card_should_display_an_add_to_cart_icon() throws InterruptedException {
        JSUtilities.scrollToElement(driver, enes.storeProductsYazisi);
        JSUtilities.waitForPageLoadWithJS(driver, Duration.ofSeconds(10));
        enes.firstProductCard.click();
        Thread.sleep(3000);
        Assert.assertTrue(enes.addCartButton.isDisplayed());

    }
    @When("I click the first product card")
    public void i_click_the_first_product_card() {
        enes.storeHeader.click();

    }
    @Then("the product detail page should open")
    public void the_product_detail_page_should_open() {
        enes.productLink.click();
        Assert.assertTrue("description part is not visible",enes.descriptionYazisi.isDisplayed());
    }
    @Then("the product title should be visible")
    public void the_product_title_should_be_visible() {
        Assert.assertTrue(enes.urunBaslikYazisi.isDisplayed());

    }

    @When("I click the All product button")
    public void i_click_the_button() {
        enes.allProductsLinki.click();


    }
    @Then("the product listing page should open")
    public void the_product_listing_page_should_open() {
        Assert.assertTrue(enes.productsYazisi.isDisplayed());

    }
    @Then("all products should be listed")
    public void all_products_should_be_listed() {
        List<WebElement> allProducts = driver.findElements(
                By.xpath("//*[@id='filtersForm']//figure/div/a/img")
        );

        int productCount = allProducts.size();
        System.out.println("Bulunan ürün sayısı = " + productCount);

        Assert.assertTrue( productCount >= 1);

    }

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() throws InterruptedException {
        enes.loginButton.click();


    }
    @Given("the user enters valid credentials and logs in")
    public void the_user_enters_valid_credentials_and_logs_in() throws InterruptedException {
        enes.emailTextBox.sendKeys(ConfigReader.getProperty("emailEnes"));
        enes.passwordTextBox.sendKeys(ConfigReader.getProperty("passwordEnes"));

        enes.loginButtonInLoginPage.click();


    }
    @Given("the user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {

        Assert.assertTrue(enes.dashboardYazisi.isDisplayed());
    }
    @When("the user looks at the Sidebar under the Quizzes section")
    public void the_user_looks_at_the_sidebar_under_the_quizzes_section() throws InterruptedException {
        enes.quizzesLinki.click();
        Thread.sleep(2000);


    }
    @Then("the user should see links {string}, {string}, {string}, {string}, {string}")
    public void the_user_should_see_links(String string, String string2, String string3, String string4, String string5) {
        Assert.assertTrue(
                "Some links are not visible",
                enes.getQuizLinks().stream().allMatch(WebElement::isDisplayed)
        );

    }
    @Then("each link should be clickable")
    public void each_link_should_be_clickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(
                enes.getQuizLinks().stream().allMatch(
                        link -> wait.until(ExpectedConditions.elementToBeClickable(link)).isEnabled()
                )
        );

    }

    @When("User clicks the New Quiz link")
    public void user_clicks_the_new_quiz_link() {
        enes.quizzesLinki.click();
        WaitHelper.bekle(2);
        enes.newQuizLinki.click();

    }
    @When("User enters Quiz Title and Pass Mark")
    public void user_enters_quiz_title_and_pass_mark() {
        Random random = new Random();
        String quizTitle = "Quiz_" + random.nextInt(1000);
        int passMark = 70;

        enes.quizTitleAlani.sendKeys(quizTitle);
        enes.passMarkAlani.sendKeys(String.valueOf(passMark));
        WaitHelper.bekle(3);
        Enes.ScenarioContext.put("quizTitle", quizTitle);

    }
    @When("User saves the quiz")
    public void user_saves_the_quiz() {
        enes.quizCreateButton.click();
        WaitHelper.bekle(4);

    }

    @Then("the new quiz should be visible in the quiz list")
    public void the_new_quiz_should_be_visible_in_the_quiz_list() {
        enes.listLinki.click();
        WaitHelper.bekle(2);
        String actualText = enes.lastCreatedQuiz.getText().trim();

        String expectedText = Enes.ScenarioContext.get("quizTitle");
        WaitHelper.bekle(2);


        Assert.assertEquals(expectedText,actualText);

    }
    @Given("The user clicks the New Quiz page")
    public void the_user_clicks_the_new_quiz_page() {
        enes.quizzesLinki.click();
        enes.listLinki.click();
        WaitHelper.bekle(2);
    }

    @When("The user clicks {string}")
    public void the_user_clicks(String string) {
        enes.ucNoktaMenu.click();
        WaitHelper.bekle(1);

        enes.editLinki.click();
        WaitHelper.bekle(2);
        enes.addMultipleChoiceButton.click();

    }

    @When("The user enters {string}, {string}, {string} and  {string}")
    public void the_user_enters_and(String string, String string2, String string3, String string4) {
        Random random = new Random();
        String question = "Question :" + random.nextInt(1000);
        String grade = "70";
        String answerTitle ="Answer";
        enes.questionTitle.sendKeys(question);
        enes.gradeTitle.sendKeys(grade);
        enes.answerTitleInput.sendKeys(answerTitle);
        enes.correctAnswerYazisi.click();


    }

    @When("The user saves the question")
    public void the_user_saves_the_question() {
        enes.quizEditSaveButton.click();

    }

    @Then("The question should be visible in the questions list")
    public void the_question_should_be_visible_in_the_questions_list() {
        Assert.assertTrue(enes.questionYazisi.isDisplayed());

    }
    @Given("The user clicks the List page")
    public void the_user_clicks_the_list_page() {
        enes.quizzesLinki.click();
        enes.listLinki.click();

    }

    @When("The user clicks Add a Descriptive")
    public void the_user_clicks_add_a_descriptive() {
        enes.ucNoktaMenu.click();
        enes.editLinki.click();
        enes.addDescriptiveLinki.click();

    }

    @When("The user enters {string}, {string}, {string}")
    public void the_user_enters(String string, String string2, String string3) {
       String questionTitle= "Question 1";
       String gradeTitle ="65";
       String descriptionAnswer= "Answer";

       enes.questionTitle.sendKeys(questionTitle);
       enes.gradeTitle.sendKeys(gradeTitle);
       enes.descriptionCorrectAnswerInput.sendKeys(descriptionAnswer);


    }
    @When("The user saves the descriptive")
    public void the_user_saves_the_descriptive() {
        enes.descriptonSaveButtonu.click();


    }
    @Then("The question should be visible in the descriptive list")
    public void the_question_should_be_visible_in_the_descriptive_list() {
        WebElement questionTitle = driver.findElement(By.xpath("//h4[@class='question-title' and contains(text(),'Question 1')]"));
        String actualText = questionTitle.getText();
        String questionTitle1= "Question 1";

        Assert.assertEquals(questionTitle1, actualText);

    }

    @Given("The user clicks the Quizzes List page")
    public void the_user_clicks_the_quizzes_list_page() {
        enes.quizzesLinki.click();
        enes.listLinki.click();
    }
    @When("The user views the statistics widgets")
    public void the_user_views_the_statistics_widgets() {
        Assert.assertTrue(enes.statisticsPart.isDisplayed());
    }
    @When("The user applies a filter")
    public void the_user_applies_a_filter() {
        enes.totalMarkFilter.sendKeys("0");
    }
    @When("The user edits a quiz")
    public void the_user_edits_a_quiz() {
        enes.ucNoktaMenu.click();
    }
    @When("The user deletes a quiz with confirmation")
    public void the_user_deletes_a_quiz_with_confirmation() {
        enes.quizDeleteLinki.click();
        enes.deleteButonu.click();
    }
    @Then("The statistics should be visible")
    public void the_statistics_should_be_visible() {
        Assert.assertTrue(enes.statisticsPart.isDisplayed());
    }

    @Given("The user clicks the Results page")
    public void the_user_clicks_the_results_page() {
        enes.quizzesLinki.click();
        enes.resultLinki.click();
    }
    @When("The user views the statistics")
    public void the_user_views_the_statistics() {
        Assert.assertTrue(enes.statisticsPart.isDisplayed());
    }
    @When("The user applies a filter on results")
    public void the_user_applies_a_filter_on_results() {
        enes.statusOptions.click();
        enes.passedOption.click();
        enes.showResultLinki.click();

        WaitHelper.bekle(1);

    }
    @Then("The user should see a message {string} or an empty list")
    public void the_user_should_see_a_message_or_an_empty_list(String string) {
        Assert.assertTrue(enes.noResultYazisi.isDisplayed());
    }
    @Then("The user should still see the statistics and filters displayed")
    public void the_user_should_still_see_the_statistics_and_filters_displayed() {
        Assert.assertTrue(enes.statisticsPart.isDisplayed());
    }

    @Given("The user clicks the My Results page")
    public void the_user_clicks_the_my_results_page() {
        enes.quizzesLinki.click();
        enes.myResultsLinki.click();

    }

    @When("The user views the results statistics")
    public void the_user_views_the_results_statistics() {
        Assert.assertTrue(enes.resultStatisticPart.isDisplayed());


    }

    @When("The user applies a result filter")
    public void the_user_applies_a_result_filter() {
        enes.instructorInput.sendKeys("teacher");
        enes.showMyResultLinki.click();

    }

    @Then("The user should see a message {string} or an empty list in my result page")
    public void the_user_should_see_a_message_or_an_empty_list_in_my_result_page(String string) {
        Assert.assertTrue(enes.noResultYazisi.isDisplayed());
    }

    @Then("The user should still see the statistics and filters displayed in my result page")
    public void the_user_should_still_see_the_statistics_and_filters_displayed_in_my_result_page() {
        Assert.assertTrue(enes.resultStatisticPart.isDisplayed());

    }


    @Given("the user clicks the Not Participated page")
    public void the_user_clicks_the_not_participated_page() {
        enes.quizzesLinki.click();
        enes.notParticipatedLinki.click();

    }

    @When("the user applies a filter in the Not Participated page")
    public void the_user_applies_a_filter_in_the_not_participated_page() {
        enes.courseInput.sendKeys("course");
        WaitHelper.bekle(2);
        enes.showResultNotParticipate.click();

    }

    @Then("the user should see a message No quizzes found or an empty list")
    public void the_user_should_see_a_message_No_quizzes_found_or_an_empty_list() {
        Assert.assertTrue(enes.noResultInNotParticipated.isDisplayed());

    }

    @When("the user opens the Marketing section in the Sidebar")
    public void the_user_opens_the_marketing_section_in_the_sidebar() {
        enes.marketingLinki.click();

    }

    @Then("the user should see the links {string} and {string}")
    public void the_user_should_see_the_links_and(String string, String string2) {
        WaitHelper.bekle(2);

        Assert.assertTrue(enes.discountLinki.isDisplayed()|enes.promotionsLinki.isDisplayed());

    }

    @Then("each link should be clickable on the page")
    public void each_link_should_be_clickable_on_the_page() {


        enes.discountLinki.click();
        WaitHelper.bekle(2);

        Assert.assertTrue(enes.newCourseDiscountYazisi.isDisplayed());




        enes.promotionsLinki.click();
        WaitHelper.bekle(2);
        Assert.assertTrue(enes.selectAPromotionYazisi.isDisplayed());


    }

    @When("The user navigates to {string} → {string}")
    public void the_user_navigates_to(String string, String string2) {
        enes.marketingLinki.click();
        enes.discountLinki.click();
    }

    @When("The user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        enes.createDiscountButonu.click();
    }

    @Then("The user should not see any courses in the course selection field")
    public void the_user_should_not_see_any_courses_in_the_course_selection_field() {
        Assert.assertTrue(enes.courseOptions.isDisplayed());

    }

    @Then("The user should see a message {string}")
    public void the_user_should_see_a_message(String string) {
        Assert.assertTrue(enes.noDiscountIsAvailableYazisi.isDisplayed());
    }



    @Then("No discount record should be created")
    public void no_discount_record_should_be_created() {

    }


    @Then("promotion plans should be displayed as cards or list with name and price and conditions")
    public void promotion_plans_should_be_displayed_as_cards_or_list_with_name_and_price_and_conditions() {
        Assert.assertTrue(enes.promotionPrice.isDisplayed()|enes.promotionTime.isDisplayed()|enes.promotionName.isDisplayed());
    }


    @When("the user navigates to {string} → Promotions")
    public void the_user_navigates_to_promotions(String string) {
        enes.marketingLinki.click();
        enes.promotionsLinki.click();
    }

    @Then("the user should be able to select a plan \\(via select, radio button, checkbox)")
    public void the_user_should_be_able_to_select_a_plan_via_select_radio_button_checkbox() {
        Assert.assertTrue(enes.purchaseButton.isDisplayed());
        enes.purchaseButton.click();
        Assert.assertTrue(enes.promoteACourseYazisi.isDisplayed());
    }

    @Given("The user clicks the Promotions page")
    public void the_user_clicks_the_promotions_page() {
        enes.marketingLinki.click();
        enes.promotionsLinki.click();
    }

    @When("The user selects a promotion plan")
    public void the_user_selects_a_promotion_plan() {
        enes.purchaseButton.click();
    }

    @When("The user clicks {string} or {string} or {string}")
    public void the_user_clicks_or_or(String string, String string2, String string3) {
        enes.payButton.click();
    }

    @Then("The user should see a warning message {string}")
    public void the_user_should_see_a_warning_message(String string) {
        Assert.assertTrue(enes.warningCourseYazisi.isDisplayed());
    }


    @Then("The plan should not be saved or appear under My Subscriptions")
    public void the_plan_should_not_be_saved_or_appear_under_my_subscriptions() {

        enes.closeButton.click();
        Assert.assertTrue(enes.noPromotionYazisi.isDisplayed());
    }









}
