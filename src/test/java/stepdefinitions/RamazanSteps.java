package stepdefinitions;


import LoginMethod.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Ramazan;

import javax.swing.text.Utilities;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class RamazanSteps {

    Ramazan ramazan = new Ramazan();


    @Given("user goes to {string}")
    public void user_goes_to(String string) throws InterruptedException {

        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
        Thread.sleep(5000);


    }

    @Given("user waits {int} seconds")
    public void userWaitsSeconds(int arg0) throws InterruptedException {

        Thread.sleep(2000);

    }


    @When("user scrolls the page until {string} text")
    public void user_scrolls_the_page_until_text(String string) throws InterruptedException {

        //JSUtilities.scrollToElement(DriverManager.getDriver(),ramazan.subscribeNowText);
        JSUtilities.scrollToElement(DriverManager.getDriver(), ramazan.validatinText);
        //JSUtilities.scrollToElement(DriverManager.getDriver(),ramazan.LoginButton_Under_emailandPassword);
        Thread.sleep(2000);


    }

    @Then("page should display {string}")
    public void page_should_display(String string) {

        String expectedText = "Subscribe Now!";
        String actualText = ramazan.subscribeNowText.getText();

        Assert.assertEquals(expectedText, actualText);


    }


    @Then("membership cards should display")
    public void membershipCardsShouldDisplay() {

        Assert.assertTrue(ramazan.bronzeButton.isDisplayed());
        Assert.assertTrue(ramazan.goldButton.isDisplayed());
        Assert.assertTrue(ramazan.silverButton.isDisplayed());


    }

    @Then("purchase button under membership cards should clickable")
    public void purchaseButtonUnderMembershipCardsShouldClickable() {


        Assert.assertTrue(ramazan.purchaseBronzeButton.isEnabled() && ramazan.purchaseBronzeButton.isDisplayed());
        Assert.assertTrue(ramazan.purchaseGoldButton.isEnabled() && ramazan.purchaseGoldButton.isDisplayed());
        Assert.assertTrue(ramazan.purchaseSilverButton.isEnabled() && ramazan.purchaseSilverButton.isDisplayed());

    }

    @Then("user clicks the login button in the Header")
    public void userClicksTheLoginButton() throws InterruptedException {

        Thread.sleep(2000);
        ramazan.loginButon.click();
    }

    @And("user write {string} in email textBox")
    public void userWriteInEmailTextBox(String arg0) {

        ramazan.emailTextBox.sendKeys(ConfigReader.getProperty("emailRamazan"));

    }

    @And("user write {string} in passWord texBox")
    public void userWriteInPassWordTexBox(String arg0) {

        ramazan.passWordTextBox.sendKeys(ConfigReader.getProperty("passWordRamazan"));

    }

    @Then("user clicks the login button under emailTextBox")
    public void userClicksTheLoginButtonUnderEmailTextBox() {

        JSUtilities.clickWithJS(DriverManager.getDriver(), ramazan.LoginButton_Under_emailandPassword);

    }

    @Then("page should display  dasboard Menu")
    public void pageShouldDisplayDasboardMenu() {


        Assert.assertTrue(ramazan.DashboardLink.isDisplayed() && ramazan.DashboardLink.isEnabled());


    }

    @And("user click all link under the dashBoard Menu")
    public void userClickTheDashBoardLink() throws InterruptedException {
        Assert.assertTrue(ramazan.DashboardLink.isDisplayed());
        Assert.assertTrue(ramazan.DashboardLink.isEnabled());
        ramazan.DashboardLink.click();
        JSUtilities.scrollToElement(DriverManager.getDriver(), ramazan.CourcesLinkUnderDasboardText);
        Thread.sleep(2000);
        ramazan.CourcesLinkUnderDasboardText.click();
        JSUtilities.clickWithJS(DriverManager.getDriver(), ramazan.MeetingsLinkUnderDasboardText);
        Thread.sleep(1000);
        ramazan.MeetingsLinkUnderDasboardText.click();


/*
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



 */


    }


    @Then("The user verifies that View All Events Link is visible")
    public void theUserVerifiesThatViewAllEventsLinkIsVisible() {

        Assert.assertTrue(ramazan.ViewAllLink.isDisplayed() && ramazan.ViewAllLink.isEnabled());


    }

    @Then("The user verifies that the links under View All Events Links are visible and enable.")
    public void theUserVerifiesThatTheLinksUnderViewAllEventsLinksAreVisible(io.cucumber.datatable.DataTable dataTable) {



        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Purchased Courses":
                    webElement = ramazan.PurchasedCoursesLink;
                    break;
                case "Meetings":
                    webElement = ramazan.MeetingsLinkUnderViewAllButton;
                    break;
                case "Support":
                    webElement = ramazan.SupportMessagesLink;
                    break;
                case "Comments":
                    webElement = ramazan.CommentsLinkUnderViewAllButton;
                    break;
                case "Account Balance":
                    webElement = ramazan.AccountBalanceLink;
                    break;
                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }

            Assert.assertTrue(webElement.isDisplayed() && webElement.isEnabled());
            Assert.assertTrue(ramazan.AccountBalanceLink.isDisplayed() && ramazan.AccountBalanceLink.isEnabled());
            JSUtilities.getNumberOfOpenWindows(DriverManager.getDriver());

        }

    }


    @And("user scrolls the page until LoginButton_Under_emailandPassword")
    public void userScrollsThePageUntilLoginButton_Under_emailandPassword() {

        JSUtilities.scrollToElement(DriverManager.getDriver(), ramazan.LoginButton_Under_emailandPassword);
    }

    @And("The user confirms that current job postings and detailed information")
    public void theUserConfirmsThatCurrentJobPostingsAndDetailedInformation() {

        String ilanTarihiStr = ramazan.noticeBoard.get(0).getText().trim(); // "12 Jul 2021 | 19:26"
        String[] parts = ilanTarihiStr.split("\\|");
        String datePart = parts[0].trim(); // "12 Jul 2021"
        String timePart = parts[1].trim(); // "19:26"

// İkisini birleştir
        String fullDateTime = datePart + " " + timePart; // "12 Jul 2021 19:26"

// Doğru formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime ilanTarihiSaat = LocalDateTime.parse(fullDateTime, formatter);
        LocalDate ilanTarihi = ilanTarihiSaat.toLocalDate();

// Güncel tarih kontrolü
        LocalDate bugun = LocalDate.now();
        LocalDate altSinir = bugun.minusDays(30);
        LocalDate ustSinir = bugun.plusDays(30);

//        if (ilanTarihi.isBefore(altSinir) || ilanTarihi.isAfter(ustSinir)) {
//            // Eğer tarih eskiyse test için "dinamik tarih" oluştur
//            ilanTarihi = bugun; // veya altSinir + rastgele gün
//        }

        Assert.assertTrue("İlan tarihi güncel değil! " + ilanTarihi,
                (ilanTarihi.isEqual(altSinir) || ilanTarihi.isAfter(altSinir)) &&
                        (ilanTarihi.isEqual(ustSinir) || ilanTarihi.isBefore(ustSinir))

        );




    }

    @And("User verifies that the monthly learning table is displayed")
    public void userVerifiesThatTheMonthlyLearningTableIsDisplayed() {

        Assert.assertTrue(ramazan.monthlyLearningIstatisticsBoard.isDisplayed());
    }

    @Given("user kullanıcı login olur")
    public void userKullanıcıLoginOlur(){

      LoginPage.loginAs();

    }




    @Then("User verify that links are visible under the Financial heading in the Dashboard sidebar")
    public void userVerifyThatLinksAreVisibleUnderTheFinancialHeadingInTheDashboardSidebar(io.cucumber.datatable.DataTable dataTable) {

        List<String> elementList = dataTable.asList();

        for (String element : elementList) {
            WebElement webElement = null;

            switch (element) {
                case "Financial summary":
                    webElement = ramazan.financialSummaryLinkOnTheLeftSideBar;
                    break;
                case "Payout":
                    webElement = ramazan.payOutLinkOnTheLeftSideBar;
                    break;
                case "Charge account":
                    webElement = ramazan.chargeAccountLinkOnTheLeftSideBar;
                    break;
                case "Subscribe":
                    webElement = ramazan.subscribeLinkOnTheLeftSideBar;
                    break;

                default:
                    throw new IllegalArgumentException("Tanimlanmamis header link: " + element);
            }

            Assert.assertTrue(webElement.isEnabled()&&webElement.isEnabled());

        }

    }


    @Then("user clicks on the Finacial buton")
    public void userClicksOnTheFinacialButon() {

        JSUtilities.clickWithJS(DriverManager.getDriver(),ramazan.financialLinkOnTheLeftSideBar);
    }

    @Then("user clicks Financial Summary button")
    public void userClicksFinancialSummaryButton() {

        JSUtilities.clickWithJS(DriverManager.getDriver(),ramazan.financialSummaryLinkOnTheLeftSideBar);
    }

    @Then("User Verifies that the list of financial documents is visible on the page")
    public void userVerifiesThatTheListOfFinancialDocumentsIsVisibleOnThePage() {

        Assert.assertTrue(ramazan.financialDocuments.isDisplayed());




    }
}










