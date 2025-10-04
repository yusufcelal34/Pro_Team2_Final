package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pages.Melih;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class MelihSteps {

    Melih melih = new Melih();



    @Given("kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        DriverManager.getDriver().get(ConfigReader.getProperty("instuLearnUrl"));

    }

    @Then("kullanici anasayfadaki yaziya kadar iner")
    public void kullaniciAnasayfadakiYaziyaKadarIner() throws InterruptedException {


        // Elementi scroll et
        JSUtilities.scrollToElement(DriverManager.getDriver(), melih.becomeAnInstructorIsimElementi);


    }

    @When("Become an Instructor basliginin gorundugunu test eder")
    public void becomeAnInstructorBasligininGorundugunuTestEder() {

        Assert.assertTrue(melih.becomeAnInstructorIsimElementi.isDisplayed());
    }
  


    @When("Become an Instructor butonunun kullanılabilirligini test eder")
    public void becomeAnInstructorButonununKullanılabilirliginiTestEder() {

        Assertions.assertTrue(melih.becomeAnInstructorButonElementi.isDisplayed());
    }


    @Then("kullanici Become An Instructor butonuna kadar iner")
    public void kullaniciBecomeAnInstructorButonunaKadarIner() throws InterruptedException {

        // Elementi scroll et
        JSUtilities.scrollToElement(DriverManager.getDriver(), melih.becomeAnInstructorButonElementi);

    }


    @And("senkronizasyon icin {int} saniye bekler")
    public void senkronizasyonIcinSaniyeBekler(int saniye) {
        ReusableMethods.waitFor(saniye);
    }

    @When("Become an Instructor butonuna tıklar")
    public void kullanici_butona_js_ile_tiklar() {
        JSUtilities.clickWithJS(DriverManager.getDriver(), melih.becomeAnInstructorButonElementi);
    }

    @And("login sayfasına ulaşabildiğini test eder")
    public void loginSayfasınaUlaşabildiğiniTestEder() {

        Assertions.assertTrue(melih.logInToYourAccountYaziElementi.isDisplayed());
    }

    @And("login butonuna basar")
    public void loginButonunaBasar() {
        melih.loginButon.click();
    }

    @Then("email kutusuna {string} yazar")
    public void email_kutusuna_yazar(String email) {
        melih.emailBox.sendKeys(email);
    }

    @And("password kutusuna {string} yazar")
    public void password_kutusuna_yazar(String password) {
        melih.passwordBox.sendKeys(password);
    }

    @Then("login butonuna basarak giris yapar")
    public void loginButonunaBasarakGirisYapar() {
        melih.girisIcinLoginButonu.click();
    }

    @When("support butonunu gorene kadar asagi iner")
    public void supportButonunuGoreneKadarAsagiIner() {
        // Elementi scroll et
        JSUtilities.scrollToElement(DriverManager.getDriver(), melih.supportButonu );
    }

    @Then("support butonuna tiklar")
    public void supportButonunaTiklar() {
        JSUtilities.clickWithJS(DriverManager.getDriver(), melih.supportButonu);
    }

    @And("New linkinin gorunebildigini test eder")
    public void newLinkininGorunebildiginiTestEder() {
        Assertions.assertTrue(melih.supportNewButonu.isDisplayed());
    }

    @And("Courses support linkinin gorunebildigini test eder")
    public void coursesSupportLinkininGorunebildiginiTestEder() {
        Assertions.assertTrue(melih.supportCoursesSupoortButonu.isDisplayed());
    }

    @And("Tickets linkinin gorunebildigini test eder")
    public void ticketsLinkininGorunebildiginiTestEder() {
        Assertions.assertTrue(melih.supportTicketsButonu.isDisplayed());
    }

    @And("kullanıcı New linkine tıklar")
    public void kullanıcıNewLinkineTıklar() {
        melih.supportNewButonu.click();
    }

    @When("kullanıcı Courses Support linkine tıklar")
    public void kullanıcıCoursesSupportLinkineTıklar() {
        melih.supportCoursesSupoortButonu.click();
    }

    @Then("Acılan sayfada Support summary göründüğünü test eder")
    public void acılanSayfadaSupportSummaryGöründüğünüTestEder() {
        Assertions.assertTrue(melih.supportSummaryYaziElementi.isDisplayed());
    }

    @Then("kullanıcı subject kısmına {string} yazar")
    public void kullanıcıSubjectKısmınaYazar(String girilenMesaj) {
        melih.newSubject.sendKeys(girilenMesaj);
    }

    @And("kullanıcı type dropdown menusune tıklar")
    public void kullanıcıTypeDropdownMenusuneTıklar() {
        melih.typeDd.click();
    }

    @Then("kullanıcı platform support a tıklar")
    public void kullanıcıPlatformSupoortATıklar() {
        WebElement dropdown = DriverManager.getDriver().findElement(By.xpath("//*[@id='supportType']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Platform support");
        dropdown.click();
    }

    @Then("kullanıcı department dropdown menusune tıklar")
    public void kullanıcıDepartmentDropdownMenusuneTıklar() {
        melih.departmentDd.click();
    }

    @And("kullanıcı content e tıklar")
    public void kullanıcıContentETıklar() {
        // 1️⃣ Dropdown menüsüne tıkla (menüyü açar)
        WebElement dropdown = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"departmentInput\"]/span/span[1]/span"));
        dropdown.click();

        // 2️⃣ Açılan menüden 'content' yazan seçeneği bul ve tıkla
        WebElement contentOption = DriverManager.getDriver().findElement(By.xpath("//*[text()='Content']"));
        contentOption.click();

    }

    @Then("kullanıcı mesaj kısmına {string} yazar")
    public void kullanıcıMesajKısmınaYazar(String newSendMessage) {
        melih.newSendMessage.sendKeys(newSendMessage);
    }

    @And("kullanıcı Send Message butonuna tıklar")
    public void kullanıcıSendMessageButonunaTıklar() {
        melih.SendMessageButonu.click();
    }

    @Then("open conservation {int} olarak güncellenir")
    public void openConservationOlarakGüncellenir(int arg0) {
        // Sayıyı gösteren elementi bul
        WebElement openConversationCount = DriverManager.getDriver()
                .findElement(By.xpath("//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[1]/div/strong"));

        // Text olarak sayıyı al
        String countText = openConversationCount.getText().trim();
        System.out.println("Open Conversation sayisi: " + countText);

        // Beklenen değer "1" mi kontrol et
        Assert.assertEquals("Open conversation sayisi 1 degil!", "1", countText);
    }

    @And("kullanıcı message history altındaki mesajları görebildiğini test eder")
    public void kullanıcıMessageHistoryAltındakiMesajlarıGörebildiğiniTestEder() {
        Assertions.assertTrue(melih.coursesSupportMesajlari.isDisplayed());
    }
}
