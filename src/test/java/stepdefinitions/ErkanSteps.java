package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.Erkan;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import static java.sql.Driver.*;

public class ErkanSteps {

    WebDriver driver = DriverManager.getDriver();
    Erkan erkan = new Erkan();
    BasePage basepage = new BasePage(driver);
    Actions actions = new Actions(driver);


    // [US015] - TC_ORG_001

            @Given("the user navigates to the homepage {string}")
            public void the_user_navigates_to_the_homepage(String string) {
                DriverManager.getDriver().get(ConfigReader.getProperty("url"));

            }
            @When("the {string} heading is displayed")
            public void the_heading_is_displayed(String string) {
                Assert.assertTrue(erkan.Organzations_EB
                        .isDisplayed());


            }
            @Then("the subtitle text {string} should be displayed")
            public void the_subtitle_text_should_be_displayed(String string) {
                Assert.assertTrue(erkan.Greatest_EB
                        .isDisplayed());

            }
            @Then("the {string} button should be displayed")
            public void the_button_should_be_displayed(String string) {
                erkan.All_Organization_Button_EB
                        .click();


            }

    // [US015] - TC_ORG_002

    @When("the horizontal slider band containing at least 4 organization cards is displayed")
    public void theHorizontalSliderBandContainingAtLeastOrganizationCardsIsDisplayed() {
        Assert.assertTrue(erkan.Sliders_EB.isDisplayed());

    }


    @And("the user verifies the navigation dots \\(or arrow buttons) below the slider")
    public void theUserVerifiesTheNavigationDotsOrArrowButtonsBelowTheSlider() {

        By firstDotLocator = By.cssSelector("#app > section:nth-child(24) > div.position-relative.mt-20 > div.d-flex.justify-content-center > div > span.swiper-pagination-bullet.swiper-pagination-bullet-active");

        WebElement firstDot = driver.findElement(firstDotLocator);

        if (firstDot.isDisplayed()) {
            firstDot.click();
            System.out.println("Slider'ın ilk noktasına doğrudan tıklandı.");
        }

    }

    @And("the user clicks on the {string} card displayed in the list")
    public void theUserClicksOnTheCardDisplayedInTheList(String arg0) {
        erkan.Affagato_Media_EB
                        .click();

    }

    @Then("the user is directed to the organization details page")
    public void theUserIsDirectedToTheOrganizationDetailsPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse("Kullanıcı Affagato Media sayfasına yönlendirilemedi.", currentUrl.contains("qa.instulearn.com/users/864/profile"));
    }

    @And("the user clicks the back button to return to the homepage")
    public void theUserClicksTheBackButtonToReturnToTheHomepage() {
        driver.navigate().back();

    }


    // [US015] - TC_ORG_003
    @And("User views the Card logo and Text information located within the Slider area")
    public void userViewsTheCardLogoAndTextInformationLocatedWithinTheSliderArea(io.cucumber.datatable.DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "King Card Logo":
                    webElement = erkan.King_IMG_EB;
                    break;
                case "King Card Text":
                    webElement = erkan.King_Text_EB;
                    break;
                case "Owosso Card Logo":
                    webElement = erkan.Owosso_IMG_EB;
                    break;
                case "Owosso Card Text":
                    webElement = erkan.Owosso_Text_EB;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), webElement);

            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    // [US015] - TC_ORG_004

    @And("User views and clicks the All Organizations button")
    public void userViewsAndClicksTheAllOrganizationsButton() {
        Assert.assertTrue(erkan.All_Organizaton_Button_EB
                .isDisplayed());
        erkan.All_Organizaton_Button_EB.
                click();

    }

    @And("User should be redirected to the All Organizations page.")
    public void userShouldBeRedirectedToTheAllOrganizationsPage() {
        Assert.assertTrue(erkan.Organization_Page_EB
                .isDisplayed());
    }

    // [US024] - TC_MEET_001

    @And("The user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
        erkan.Login_Button_EB
                .click();
    }

    @And("The user enters the data {string} in the {string} field")
    public void theUserEntersTheDataInTheField(String ErkanLoginEmail,String ErkanLoginPassword) {
        erkan.Email_Text_Box_EB.sendKeys(ConfigReader.getProperty("ErkanLoginEmail"));
        erkan.Password_Text_Box_EB.sendKeys(ConfigReader.getProperty("ErkanLoginPassword"));

    }

    @When("The user clicks on the Login_BTN button")
    public void theUserClicksOnTheLogin_BTNButton() {
        erkan.Login_BTN_EB
                .click();
    }

    @Then("The user verifies that they are redirected to the {string} page")
    public void theUserVerifiesThatTheyAreRedirectedToThePage(String arg0) {
        Assert.assertTrue(erkan.Dashboard_EB
                .isDisplayed());
    }

    @And("The user clicks on the Dashboard sidebar {string} drop-down menu on the left of the screen")
    public void theUserClicksOnTheDashboardSidebarDropDownMenuOnTheLeftOfTheScreen(String arg0) {
        Assert.assertTrue(erkan.Meetings_EB
                .isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        erkan.Meetings_EB
                .click();
    }

    @And("The user verifies that My reservations, Requests, Settings are listed in the Meetings drop-down menu")
    public void theUserVerifiesThatAreListedInTheDropDownMenu(io.cucumber.datatable.DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "My reservation":
                    webElement = erkan.My_reservation_EB;
                    break;
                case "Request":
                    webElement = erkan.Requests_EB;
                    break;
                case "Settings":
                    webElement = erkan.Settings_EB;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), webElement);

            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    // [US024] - TC_MEET_002

    @Then("The user verifies that they have been redirected to the {string} page")
    public void theUserVerifiesThatTheyHaveBeenRedirectedToThePage(String arg0) {
        Assert.assertTrue(erkan.Meeting_statistics_EB
                .isDisplayed());

    }

    @And("The user verifies that the Open meetings, Total meetings, Active hours heading is visible on the Meeting statistics page")
    public void theUserVerifiesThatTheHeadingIsVisibleOnTheMeetingStatisticsPage(io.cucumber.datatable.DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Open meetings":
                    webElement = erkan.Open_Meetings_EB;
                    break;
                case "Total meetings":
                    webElement = erkan.Total_meetings_EB;
                    break;
                case "Active hours":
                    webElement = erkan.Active_hours_EB;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), webElement);

            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @And("The user clicks on the {string}")
    public void theUserClicksOnThe(String arg0) {
        erkan.My_reservation_EB
                .click();
    }

    // [US024] - TC_MEET_003

    @And("The user clicks on the Request")
    public void theUserClicksOnTheRequest() {
        erkan.Requests_EB
                .click();



    }

    @And("The user verifies that the Pending meetings, Total meetings, Sales amount, Active hours heading is visible on the Meeting statistics page")
    public void theUserVerifiesThatThePendingMeetingsTotalMeetingsSalesAmountActiveHoursHeadingIsVisibleOnTheMeetingStatisticsPage(io.cucumber.datatable.DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Pending meetings":
                    webElement = erkan.Pending_meetings_EB;
                    break;
                case "Total meetings":
                    webElement = erkan.Total_meetings_Request_EB;
                    break;
                case "Sales amount":
                    webElement = erkan.Sales_amount_EB;
                    break;
                case "Active hours":
                    webElement = erkan.Active_hours_Request_EB;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), webElement);

            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    // [US024] - TC_MEET_004

    @And("The user clicks on the Settings")
    public void theUserClicksOnTheSettings() {
        erkan.Settings_EB
                .click();
    }

    // [US024] - TC_MEET_007


    @And("The user verifies that the In-person meetings Group meeting, Save heading and button are visible on the Meeting timesheet page")
    public void theUserVerifiesThatTheInPersonMeetingsGroupMeetingSaveHeadingAndButtonAreVisibleOnTheMeetingTimesheetPage() {
        Assert.assertTrue(erkan.InPerson_meeting_EB
                .isDisplayed());
        Assert.assertTrue(erkan.Group_meeting_EB
                .isDisplayed());
        Assert.assertTrue(erkan.Save_Button_EB
                .isDisplayed());
    }

    @And("The user enters numerical value 120 data in the \"Amount\" text box field")
    public void theUserEntersNumericalValueDataInTheTextBoxField() {
        Assert.assertTrue(erkan.Amount_Title_EB
                .isDisplayed());
        String valueToSend = String.valueOf(120);
        erkan.Amount_Text_Box_EB.sendKeys(valueToSend);


    }

    @And("The user enters numerical value data in the Discount rate \\(%) text box field")
    public void theUserEntersNumericalValueDataInTheDiscountRateTextBoxField() {
        Assert.assertTrue(erkan.Discount_Rate_Title_EB
                .isDisplayed());
        String valueToSend = String.valueOf(120);
        erkan.Discount_Txt_Box_EB.sendKeys(valueToSend);

    }
    // [US024] - TC_MEET_008

    @And("The user clicks on the Settings Kategori")
    public void theUserClicksOnTheSettingsKategori() {
        erkan.Settings_Ktg_EB
                .click();
    }

    @And("The user clicks on the Available for in person meetings radio button under the in person meeting heading")
    public void theUserClicksOnTheAvailableForInPersonMeetingsRadioButtonUnderTheInPersonMeetingHeading()  {

        String durumu = erkan.Available_for_In_person_meetings_RadioButton_EB.getAttribute("aria-checked");

        if (durumu != null && durumu.equals("false")) {
            // Kapalıysa tıkla
            erkan.Available_for_In_person_meetings_RadioButton_EB.click();
        }
      //  erkan.Available_for_In_person_meetings_RadioButton_EB.click();

    }

    @Then("The user verifies that the Hourly Price text box field has been opened")
    public void theUserVerifiesThatTheHourlyPriceTextBoxFieldHasBeenOpened()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(erkan.Hourly_Price_EB));

    }

    @And("The user clicks on the Available for group meetings radio button under the group meeting heading")
    public void theUserClicksOnTheAvailableForGroupMeetingsRadioButtonUnderTheGroupMeetingHeading() {

        String durumu = erkan.Available_for_group_meetings_RadioButton_EB.getAttribute("aria-checked");

        if (durumu != null && durumu.equals("false")) {
            // Kapalıysa tıkla
            erkan.Available_for_group_meetings_RadioButton_EB.click();
        }
      //  erkan.Available_for_group_meetings_RadioButton_EB.click();
    }

    @Then("The user verifies that the Minimum Students text box field has been opened")
    public void theUserVerifiesThatTheMinimumStudentsTextBoxFieldHasBeenOpened() throws InterruptedException {
        Assert.assertTrue(erkan.Minimum_Students_EB
                .isDisplayed());
    }

    // [US032] - TC_001

    @And("The user clicks on the instulearn logo")
    public void theUserClicksOnTheInstulearnLogo() {
        erkan.InstuLearnLogo_EB
                .click();
    }

    @And("the user hovers over the username at the top of the screen")
    public void theUserHoversOverTheUsernameAtTheTopOfTheScreen() {
        erkan.profileIcon.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(erkan.hoverTargetSpan, 10);
        JSUtilities.scrollToElement(driver, erkan.hoverTargetSpan);
        try {
            new Actions(driver)
                    .moveToElement(erkan.hoverTargetSpan)
                    .pause(Duration.ofMillis(200))
                    .perform();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles:true, cancelable:true, view:window});" +
                            "arguments[0].dispatchEvent(ev);",
                    erkan.hoverTargetSpan
            );
        }
        ReusableMethods.waitFor(1);
        WebElement target = erkan.Profil_Link_EB;
        JSUtilities.scrollToElement(driver, target);
        ReusableMethods.waitForVisibility(target, 5);
        erkan.Profil_Link_EB.click();

    }


// [US032] - TC_002

    @And("the user sees the {string} button in the Dashboard sidebar on the left of the screen and clicks on it")
    public void theUserSeesTheButtonInTheDashboardSidebarOnTheLeftOfTheScreenAndClicksOnIt(String arg0) {
        WebElement myProfileLink = erkan.My_Profile_EB;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", myProfileLink);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickableProfileLink = wait.until(
                ExpectedConditions.elementToBeClickable(myProfileLink));
        clickableProfileLink.click();

        // js.executeScript("arguments[0].click();", clickableProfileLink);





    }

    @And("the user confirms that they have been redirected to the Follow button")
    public void theUserConfirmsThatTheyHaveBeenRedirectedToTheFollowTitle() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 400)");

        Assert.assertTrue(erkan.Follow_BTN_EB
                .isDisplayed());



    }

    // [US032] - TC_003
    @And("the Students Courses Reviews Meetings heading are visible")
    public void theStudentsCoursesReviewsMeetingsHeadingAreVisible(io.cucumber.datatable.DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Students":
                    webElement = erkan.Student_List_EB;
                    break;
                case "Courses":
                    webElement = erkan.Courses_List_EB;
                    break;
                case "Reviews":
                    webElement = erkan.Reviews_List_EB;
                    break;
                case "Meetings":
                    webElement = erkan.Meetings_List_EB;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), webElement);

            Assert.assertTrue(webElement.isDisplayed());
        }

    }

    // [US032] - TC_004
    @And("the user confirms that the About Courses Instructors Articles Badges Reserve a meeting heading are visible")
    public void theUserConfirmsThatTheAboutCoursesInstructorsArticlesBadgesReserveAMeetingHeadingAreVisible(io.cucumber.datatable.DataTable dataTable) {
        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "About":
                    webElement = erkan.About_List_EB;
                    break;
                case "Courses":
                    webElement = erkan.Courses_List_2_EB;
                    break;
                case "Instructors":
                    webElement = erkan.Instructors_List_EB;
                    break;
                case "Articles":
                    webElement = erkan.Articles_List_EB;
                    break;
                case "Badges":
                    webElement = erkan.Badges_List_EB;
                    break;
                case "Reserve a meeting":
                    webElement = erkan.Reserve_a_meeting_List_EB;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }
            JSUtilities.scrollToElement(DriverManager.getDriver(), webElement);

            Assert.assertTrue(webElement.isDisplayed());
        }
}


    // [US024] - TC_005

    @And("the user clicks on the three dots under the Actions column of the Monday row")
    public void theUserClicksOnTheThreeDotsUnderTheActionsColumnOfTheMondayRow() {
        erkan.Uc_Nokta_EB
                .click();
    }

    @And("the user clicks the Add Time button")
    public void theUserClicksTheButton() {
                erkan.Add_Time_Button_EB
                        .click();

    }

    @And("the user selects the Modal Window field time picker to be uc")
    public void theUserSelectsTheModalWindowFieldTimePickerToBe() throws InterruptedException {
        erkan.Clock_Uc_EB
                .click();
        Thread.sleep(2000);
        erkan.Clock_OnBes_EB
                .click();
        Thread.sleep(2000);
        erkan.Clock_Dort_EB
                .click();
        Thread.sleep(2000);
        erkan.Clock_Yirmi_EB
                .click();
        Thread.sleep(2000);
    }


    @And("the user enters alphabetical data in the Description text box field")
    public void theUserEntersAlphabeticalDataInTheTextBoxField() throws InterruptedException {
        Assert.assertTrue(erkan.Description_Text_Box_EB
                .isDisplayed());
        erkan.Description_Text_Box_EB
                .click();
        Thread.sleep(2000);
        erkan.Description_Text_Box_EB.sendKeys("Indirimli Kurs");

    }

    @And("The user clicks the Save button")
    public void theUserClicksTheSaveButton() throws InterruptedException {
        Assert.assertTrue(erkan.Save_Button_Saat_EB
                             .isDisplayed());
        Thread.sleep(2000);
        erkan.Save_Button_Saat_EB
                           .click();

    }


    @And("The user confirms that they have been redirected to the Follow buton")
    public void theUserConfirmsThatTheyHaveBeenRedirectedToTheFollowButon() {
        Assert.assertTrue(erkan.Follow_BTN_EB
                .isDisplayed());
    }

    @And("the user clicks on the AM PM radio button")
    public void theUserClicksOnTheAMPMRadioButton() {
        erkan.AM_PM_Radio_BTN_EB
                .click();

    }

    @And("the user confirms that they have been redirected to the ERKAN IMG")
    public void theUserConfirmsThatTheyHaveBeenRedirectedToTheERKANIMG() {
        Assert.assertTrue(erkan.Erkan_IMG_EB
                .isDisplayed());
    }
}






