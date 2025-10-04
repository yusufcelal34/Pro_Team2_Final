package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Eda;
import utilities.*;

import java.util.List;

public class EdaSteps {

    Eda eda = new Eda();
//-------------------------------------------------------------------------------------------------------------------------------------------------
    @Given("the user goes to the homepage")
    public void theUserGoesToTheHomepage() {

        DriverManager.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Then("The user verifies that the links in the header section are visible.")
    public void theUserVerifiesThatTheLinksInTheHeaderSectionAreVisible(DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Categories":
                    webElement = eda.categories;
                    break;
                case "Home":
                    webElement = eda.home;
                    break;
                case "Courses":
                    webElement = eda.courses;
                    break;
                case "Instructors":
                    webElement = eda.instructors;
                    break;
                case "Store":
                    webElement = eda.store;
                    break;
                case "Blog":
                    webElement = eda.blog;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }

            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @Then("The user verifies that the links in the header section are accessible.")
    public void theUserVerifiesThatTheLinksInTheHeaderSectionAreAccessible(DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Categories":
                    webElement = eda.categories;
                    break;
                case "Home":
                    webElement = eda.home;
                    break;
                case "Courses":
                    webElement = eda.courses;
                    break;
                case "Instructors":
                    webElement = eda.instructors;
                    break;
                case "Store":
                    webElement = eda.store;
                    break;
                case "Blog":
                    webElement = eda.blog;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }

            Assert.assertTrue(webElement.isEnabled());
        }
    }

    @When("the user clicks on the Categories link")
    public void theUserClicksOnTheCategoriesLink() {

        eda.categories.click();
    }

    @When("the user selects the {string} category")
    public void the_user_selects_the_category(String category) throws InterruptedException {
        switch (category) {
            case "Development":
                eda.development.click();
                break;
            case "Business":
                eda.business.click();
                break;
            case "Marketing":
                eda.marketing.click();
                break;
            case "Lifestyle":
                eda.lifestyle.click();
                break;
            case "Health Fitness":
                eda.healthFitness.click();
                break;
            case "Web Design":
                eda.webDesign.click();
                break;
            case "Syber Security":
                eda.syberSecurity.click();
                break;
            case "Testing":
                eda.testing.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }

    @Then("the user verifies that the filtering icons are visible and active on the page")
    public void the_user_verifies_that_the_filtering_icons_are_visible_and_active_on_the_page(DataTable dataTable) {
        for (String filter : dataTable.asList()) {
            WebElement element;

            switch (filter) {
                case "Upcoming":
                    element = eda.upcoming;
                    break;
                case "Free":
                    element = eda.free;
                    break;
                case "Discount":
                    element = eda.discount;
                    break;
                case "Download":
                    element = eda.download;
                    break;
                case "Newest":
                    element = eda.newest;
                    break;
                case "Type":
                    element = eda.type;
                    break;
                case "More Actions":
                case "More options":
                    element = eda.moreOptions;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter: " + filter);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), element);

            Assert.assertTrue("Filter is not displayed: " + filter, element.isDisplayed());
            Assert.assertTrue("Filter is not enabled: " + filter, element.isEnabled());
        }
    }

    @When("the user clicks on the Courses link")
    public void the_user_clicks_on_the_courses_link() {
        eda.courses.click();
    }

    @Then("the user verifies that the filtering icons are visible and active on Courses")
    public void the_user_verifies_that_the_filtering_icons_are_visible_and_active_on_courses(DataTable dataTable) {

        List<String> elementList = dataTable.asList();

        for (String filter : dataTable.asList()) {
            WebElement element;

            switch (filter) {
                case "Upcoming":
                    element = eda.upcoming;
                    break;
                case "Free":
                    element = eda.free;
                    break;
                case "Discount":
                    element = eda.discount;
                    break;
                case "Download":
                    element = eda.download;
                    break;
                case "Newest":
                    element = eda.newest;
                    break;
                case "Type":
                    element = eda.type;
                    break;
                case "More Actions":
                case "More options":
                    element = eda.moreOptions;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter: " + filter);
            }

            JSUtilities.scrollToElement(DriverManager.getDriver(), element);

            Assert.assertTrue("Filter is not displayed: " + filter, element.isDisplayed());
            Assert.assertTrue("Filter is not enabled: " + filter, element.isEnabled());
        }
    }

    @When("the user clicks on the Instructors link")
    public void the_user_clicks_on_the_ınstructors_link() {
        eda.instructors.click();
    }

    @Then("the user verifies that the filtering icons are visible and active on Instructors")
    public void the_user_verifies_that_the_filtering_icons_are_visible_and_active_on_instructors(DataTable dataTable) {

        List<String> elementList = dataTable.asList();

        for (String filter : dataTable.asList()) {
            WebElement element;

            switch (filter) {
                case "Available for Meetings":
                    element = eda.availableForMeetings;
                    break;
                case "Free Meetings":
                    element = eda.freeMeetings;
                    break;
                case "Discount":
                    element = eda.discountInstructorsStore;
                    break;
                case "Sort by":
                    element = eda.sortByInstructorsStore;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter: " + filter);
            }

            JSUtilities.scrollToElement(DriverManager.getDriver(), element);

            Assert.assertTrue("Filter is not displayed: " + filter, element.isDisplayed());
            Assert.assertTrue("Filter is not enabled: " + filter, element.isEnabled());
        }

    }

    @When("the user clicks on the Store link")
    public void the_user_clicks_on_the_store_link() {
        eda.store.click();
    }

    @Then("the user verifies that the filtering icons are visible and active on Store")
    public void the_user_verifies_that_the_filtering_icons_are_visible_and_active_on_store(DataTable dataTable) {

        List<String> elementList = dataTable.asList();

        for (String filter : dataTable.asList()) {
            WebElement element;

            switch (filter) {
                case "Free":
                    element = eda.freeStore;
                    break;
                case "Free Shipping":
                    element = eda.freeShipping;
                    break;
                case "Discount":
                    element = eda.discountInstructorsStore;
                    break;
                case "Sort by":
                    element = eda.sortByInstructorsStore;
                    break;
                case "Type":
                    element = eda.type;
                    break;
                case "Options":
                    element = eda.optionsStore;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter: " + filter);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), element);

            Assert.assertTrue("Filter is not displayed: " + filter, element.isDisplayed());
            Assert.assertTrue("Filter is not enabled: " + filter, element.isEnabled());
        }
    }

    @Given("The user verifies that the elements is visible")
    public void the_user_verifies_that_the_elements_is_visible(DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String filter : dataTable.asList()) {
            WebElement element;

            switch (filter) {
                case "InstuLearn Logo":
                    element = eda.instuLearnLogo;
                    break;
                case "Navbar Shoping Cart":
                    element = eda.navbarShopingCartButton;
                    break;
                case "Search":
                    element = eda.homeSearchBox;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter: " + filter);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), element);
            Assert.assertTrue("Filter is not displayed: " + filter, element.isDisplayed());
        }

    }

    @Then("the user verifies that the homepage is refreshed")
    public void theUserVerifiesThatTheHomepageIsRefreshed() {

        eda.instuLearnLogo.click();
        Assert.assertEquals(ConfigReader.getProperty("url"), DriverManager.getDriver().getCurrentUrl());
    }

    @And("The user verifies that the elements is active")
    public void theUserVerifiesThatTheElementsIsActive(DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String filter : dataTable.asList()) {
            WebElement element;

            switch (filter) {
                case "InstuLearn Logo":
                    element = eda.instuLearnLogo;
                    break;
                case "Navbar Shoping Cart":
                    element = eda.navbarShopingCartButton;
                    break;
                case "Search":
                    element = eda.homeSearchBox;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter: " + filter);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), element);
            Assert.assertTrue("Filter is not enabled: " + filter, element.isEnabled());
        }


    }

    @Given("the user verifies that the Start Learning icon is visible")
    public void the_user_verifies_that_the_icon_is_visible() {
       Assert.assertTrue(eda.startLearningButton.isDisplayed());
    }

    @When("the user clicks on the Start Learning icon")
    public void the_user_clicks_on_the_icon() {
        eda.startLearningButton.click();
    }

    @Then("the user verifies that the related page is opened")
    public void the_user_verifies_that_the_related_page_is_opened() {
        Assert.assertEquals(ConfigReader.getProperty("loginPageUrl"), DriverManager.getDriver().getCurrentUrl());
    }

    @Then("the user verifies that the Login link is visible")
    public void the_user_verifies_that_the_login_link_is_visible() {
       Assert.assertTrue(eda.loginLink.isDisplayed());
    }

    @When("the user clicks on the Login link")
    public void the_user_clicks_on_the_login_link() {
       eda.loginLink.click();
    }

    @Then("the user verifies that the Login page is opened")
    public void the_user_verifies_that_the_login_page_is_opened() {
        Assert.assertEquals(ConfigReader.getProperty("loginPageUrl"), DriverManager.getDriver().getCurrentUrl());
    }

    @Then("the user verifies that the Register link is visible")
    public void the_user_verifies_that_the_link_is_visible() {
        Assert.assertTrue(eda.registerLink.isDisplayed());
    }

    @When("the user clicks on the Register link")
    public void the_user_clicks_on_the_link() {
        eda.registerLink.click();
    }

    @Then("the user verifies that the Register page is opened")
    public void the_user_verifies_that_the_register_page_is_opened() {
        Assert.assertEquals(ConfigReader.getProperty("registerPageUrl"), DriverManager.getDriver().getCurrentUrl());
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    @When("Verify that the login button is visible and enabled in the top bar of the home page.")
    public void verify_that_the_login_button_is_visible_and_enabled_in_the_top_bar_of_the_home_page() {
        Assert.assertTrue(eda.loginLink.isDisplayed());
        Assert.assertTrue(eda.loginLink.isEnabled());
    }

    @Then("Click the login link.")
    public void click_the_login_button() {
        eda.loginLink.click();
    }

    @Then("Verify that the Login page is displayed.")
    public void verify_that_the_login_page_is_displayed() {
        Assert.assertEquals(ConfigReader.getProperty("loginPageUrl"), DriverManager.getDriver().getCurrentUrl());
    }

    @Then("the related image should be visible on the left side of the page")
    public void the_related_image_should_be_visible_on_the_left_side_of_the_page() {
       Assert.assertTrue(eda.imgLoginPage.isDisplayed());
    }

    @Then("the text Log in to your account should be visible on the right side")
    public void the_text_should_be_visible_on_the_right_side() {
        Assert.assertTrue(eda.logInToYourAccountText.isDisplayed());
    }

    @Then("the email field should be visible and enabled")
    public void the_email_field_should_be_visible_and_enabled() {
        Assert.assertTrue(eda.userNameLoginTextBox.isDisplayed());
        Assert.assertTrue(eda.userNameLoginTextBox.isEnabled());
    }

    @Then("the password field should be visible and enabled")
    public void the_password_field_should_be_visible_and_enabled() {
        Assert.assertTrue(eda.passwordLoginTextBox.isDisplayed());
        Assert.assertTrue(eda.passwordLoginTextBox.isEnabled());
    }

    @When("Click the login buton.")
    public void clickTheLoginButon() {
        eda.loginButton.click();
    }

    @Then("verify that the text Forgot your password? is visible on the right side of the Login page")
    public void verify_that_the_text_forgot_your_password_is_visible_on_the_right_side_of_the_login_page() {
        Assert.assertTrue(eda.forgetPasswordLink.isDisplayed());
        Assert.assertTrue(eda.forgetPasswordLink.isEnabled());
    }

    @When("the user clicks on the Forgot your password? link")
    public void the_user_clicks_on_the_forgot_your_password_link() {
        ReusableMethods.switchToWindow(eda.forgetPasswordLink);
    }

    @Then("verify that the Forgot Password page is opened")
    public void verify_that_the_forgot_password_page_is_opened() {
       Assert.assertEquals(ConfigReader.getProperty("forgetPasswordPageUrl"), DriverManager.getDriver().getCurrentUrl());
    }

    @When("the user enters a valid email in the email field")
    public void the_user_enters_a_valid_email_in_the_email_field() {
        eda.userNameLoginTextBox.sendKeys(ConfigReader.getProperty("edaEmail"));
    }

    @When("the user enters an invalid password in the password field")
    public void the_user_enters_an_invalid_password_in_the_password_field() {
        eda.passwordLoginTextBox.sendKeys("sjsghd");
    }

    @Then("the system should not allow the user to log in")
    public void the_system_should_not_allow_the_user_to_log_in() {
        Assert.assertEquals(ConfigReader.getProperty("loginPageUrl"), DriverManager.getDriver().getCurrentUrl());
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        System.out.println(eda.invalidFeedback.getText());
        Assert.assertEquals(eda.invalidFeedback.getText(),"The password or username is incorrect.");
    }

    @When("the user enters an invalid email in the email field")
    public void theUserEntersAnInvalidEmailInTheEmailField() {
        eda.userNameLoginTextBox.sendKeys("hjshg@sagfs");
    }

    @And("the user enters a valid password in the password field")
    public void theUserEntersAValidPasswordInThePasswordField() {
        eda.passwordLoginTextBox.sendKeys(ConfigReader.getProperty("edaPassword"));
    }

    @And("an error message should be displayed for email")
    public void anErrorMessageShouldBeDisplayedForEmail() {
        Assert.assertEquals(eda.invalidFeedback.getText(), "The selected email is invalid.");
    }

    @When("the user enters a registered email in the email field")
    public void the_user_enters_a_registered_email_in_the_email_field() {
        eda.userNameLoginTextBox.sendKeys(ConfigReader.getProperty("edaEmail"));
    }

    @When("the user enters a registered password in the password field")
    public void the_user_enters_a_registered_password_in_the_password_field() {
        eda.passwordLoginTextBox.sendKeys(ConfigReader.getProperty("edaPassword"));
    }

    @Then("the Dashboard page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertEquals("Dashboard | InstuLearn", DriverManager.getDriver().getTitle());
    }

    @Then("the user should see the Password Recovery heading")
    public void theUserShouldSeeThePasswordRecoveryHeading() {
        Assert.assertTrue(eda.passwordRecoveryText.isDisplayed());
    }

    @And("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        eda.forgetEmailTextBox.sendKeys(ConfigReader.getProperty("edaEmail"));
    }

    @And("the user clicks on the Reset Password button")
    public void theUserClicksOnTheResetPasswordButton() {
        eda.resetPasswordButton.click();
    }

    @Then("the user should see a confirmation message on the Forgot Password page")
    public void theUserShouldSeeAConfirmationMessageOnTheForgotPasswordPage() {
        Assert.assertTrue(eda.resetSuccessfullyMessage.isDisplayed());
    }

    @Then("the user should see the Reset Password button")
    public void theUserShouldSeeTheResetPasswordButton() {
        Assert.assertTrue(eda.resetPasswordButton.isDisplayed());
        Assert.assertTrue(eda.resetPasswordButton.isEnabled());
    }
}