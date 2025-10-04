package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Sevval;
import utilities.ConfigReader;
import utilities.DriverManager;


public class SevvalSteps {
WebDriver driver = DriverManager.getDriver();
    Sevval sevval = new Sevval(driver);
    private String link;
    private String button;
    private long durum;

    @Given("kullanıcı sayfaya gider")
    public void kullanıcı_sayfaya_gider() {

        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("üst login butonuna tıklar")
    public void üst_login_butonuna_tıklar() {

        sevval.loginButton.click();

    }

    @When("e mail kutusuna EmailSevval yazar")
    public void e_mail_kutusuna_yazar() {
       sevval.emailBox.sendKeys(ConfigReader.getProperty("EmailSevval"));

    }


    @When("password kutusuna PasswordSevval yazar")
    public void password_kutusuna_yazar() {
        sevval.passwordBox.sendKeys(ConfigReader.getProperty("PasswordSevval"));
    }

    @When("log in butonuna tıklar")
    public void log_in_butonuna_tıklar() {
       sevval.altLoginButton.click();

    }

    @Then("dashboard sayfasına erişir")
    public void dashboard_sayfasına_erişir() {

       Assert.assertTrue(Boolean.parseBoolean("Dashboard sayfasına girilmeli"));
       sevval.notificationsLink.isDisplayed();

    }//

    @Then("dashboard sayfasında {string} bölümü gözükür")
    public void dashboard_sayfasında_bölümü_gözükür(String string) {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
        Assert.assertTrue("Notifications bölümü görünmüyor!", sevval.notificationsLink.isDisplayed());
    }

    @When("dashboard sayfasında {string} bölümüne basar")
    public void dashboard_sayfasında_bölümüne_basar(String Notifications) {
        sevval.notificationsLink.click();
    }

    @Then("sayfaya erişim sağlanır")
    public void sayfaya_erişim_sağlanır() {
        Assert.assertTrue("Notifications sayfasına erişilemedi!", DriverManager.getDriver().getCurrentUrl().contains("notifications"));
    }

    @When("View iconuna tıklar")
    public void view_iconuna_tıklar() {
       sevval.ViewButton.click();
    }

    @Then("Onay butonu gelir ve onaylar")
    public void onay_butonu_gelir_ve_onaylar() {
        Assert.assertTrue("Onay butonu görünmüyor!", sevval.confirmButton.isDisplayed());
        sevval.confirmButton.click();
        sevval.OnayButonu.click();
    }

    @When("kullanıcı dashboard sayfasında courses butonuna tıklar ve geri dashboard’a döner")
    public void kullanıcı_dashboard_sayfasında_courses_butonuna_tıklar_ve_geri_dashboard_a_döner() {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
        sevval.PurchasedCoursesButton.click();
        DriverManager.getDriver().navigate().back();
        sevval.DashBoardButton.click();
    }

    @When("kullanıcı dashboard sayfasında support butonuna tıklar ve geri dashboard’a döner")
    public void kullanıcı_dashboard_sayfasında_support_butonuna_tıklar_ve_geri_dashboard_a_döner() {

        sevval.SupportMessagesButton.click();
        DriverManager.getDriver().navigate().back();
        sevval.DashBoardButton.click();
    }

    @When("kullanıcı dashboard sayfasında meetings butonuna tıklar ve geri dashboard’a döner")
    public void kullanıcı_dashboard_sayfasında_meetings_butonuna_tıklar_ve_geri_dashboard_a_döner() {
        sevval.MeetingsButton.click();
        DriverManager.getDriver().navigate().back();
        sevval.DashBoardButton.click();
    }

    @When("kullanıcı dashboard sayfasında comments butonuna tıklar ve geri dashboard’a döner")
    public void kullanıcı_dashboard_sayfasında_comments_butonuna_tıklar_ve_geri_dashboard_a_döner() {

        sevval.CommentsButton.click();
        DriverManager.getDriver().navigate().back();
        sevval.DashBoardButton.click();
    }

    @When("Mark all notifications iconuna tıklar")
    public void mark_all_notifications_iconuna_tıklar() {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
       sevval.MarkallButton.click();
    }


    @Then("Okundu bildirimini alır")
    public void okundu_bildirimini_alır() {

        Assert.assertTrue("Bildirim okundu olarak işaretlenmedi!", sevval.readNotification.isDisplayed());
    }

    @When("siteyi kapatır")
    public void siteyi_kapatır() {

        DriverManager.quitDriver();
    }


//US-43----------------------------------------------------------------------------------//

    @Given("kullanıcı giriş yapar ve dashboard sayfasında olur")
    public void kullanıcı_giriş_yapar_ve_dashboard_sayfasında_olur() {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));


            }

    @When("kullanıcı dashboard sidebar menüsünü açar")
    public void kullanıcı_dashboard_sidebar_menüsünü_açar() {
        sevval.DashBoardButton.click();

            }

    @Then("Quizzes başlığı altında {string} ve {string} linkleri görünür ve tıklanabilir olmalı")
    public void quizzes_başlığı_altında_ve_linkleri_görünür_ve_tıklanabilir_olmalı(String string, String string2) {
        sevval.quizzesButton.click();  // Quizzes menüsünü aç
        Assert.assertTrue(sevval.MyResultButton.isDisplayed());
        Assert.assertTrue(sevval.MyResultButton.isEnabled());
        Assert.assertTrue(sevval.NotParticiPatetButton.isDisplayed());
        Assert.assertTrue(sevval.NotParticiPatetButton.isEnabled());
            }

    @Given("kullanıcının daha önce katıldığı en az {int} quiz vardır")
    public void kullanıcının_daha_önce_katıldığı_en_az_quiz_vardır(Integer int1) {

            }

    @When("kullanıcı {string} linkine tıklar")
    public void kullanıcı_linkine_tıklar(String string) {
        if (link.equals("My Results")) {
            sevval.MyResultButton.click();
        } else if (link.equals("Not Participated")) {
            sevval.NotParticiPatetButton.click();
        }

            }

    @Then("kullanıcının quiz istatistikleri görüntülenir")
    public void kullanıcının_quiz_istatistikleri_görüntülenir() {

        Assert.assertTrue(sevval.MyResultButton.isDisplayed());
    }

    @Then("sayfa hatasız açılır")
    public void sayfa_hatasız_açılır() {

        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("results"));
            }

    @Given("kullanıcının birden fazla quiz sonucu vardır")
    public void kullanıcının_birden_fazla_quiz_sonucu_vardır() {

            }

    @When("kullanıcı {string} sayfasını açar")
    public void kullanıcı_sayfasını_açar(String string) {

        sevval.NotParticiPatetButton.click();

            }

    @When("filtre menüsünden tarih \\/ skor aralığı \\/ quiz adı seçer")
    public void filtre_menüsünden_tarih_skor_aralığı_quiz_adı_seçer() {

        sevval.TarihAralığı1AÇılanPencere.click();
        sevval.Tarih1.click();
        sevval.TarihAralığı1Apply.click();

        sevval.TarihAralığı2AÇılanPencereBox.click();
        sevval.Tarih2.click();
        sevval.TarihAralığı2Apply.click();
            }

    @Then("liste seçilen filtreye göre güncellenir")
    public void liste_seçilen_filtreye_göre_güncellenir() {

        Assert.assertTrue(sevval.TarihAralığı2AÇılanPencereBox.isDisplayed());
            }

    @Then("sadece uygun sonuçlar görüntülenir")
    public void sadece_uygun_sonuçlar_görüntülenir() {

            }

    @Given("kullanıcının quiz sonuçları mevcuttur")
    public void kullanıcının_quiz_sonuçları_mevcuttur() {

            }

    @When("kullanıcı {string} sayfasında bir sonucu seçer")
    public void kullanıcı_sayfasında_bir_sonucu_seçer(String string) {

            }

    @When("işlem butonuna \\(indir, detay, paylaş) tıklar")
    public void işlem_butonuna_indir_detay_paylaş_tıklar() {

            }

    @Then("ilgili işlem başarıyla gerçekleşir")
    public void ilgili_işlem_başarıyla_gerçekleşir() {

            }

    @Given("kullanıcının hiç katılmadığı en az {int} quiz vardır")
    public void kullanıcının_hiç_katılmadığı_en_az_quiz_vardır(Integer int1) {

            }

    @When("kullanıcı dashboard sidebar’dan {string} linkine tıklar")
    public void kullanıcı_dashboard_sidebar_dan_linkine_tıklar(String string) {

            }

    @Then("kullanıcıya girmediği sınavların listesi açılır")
    public void kullanıcıya_girmediği_sınavların_listesi_açılır() {

            }

    @Given("kullanıcının birden fazla katılmadığı quiz vardır")
    public void kullanıcının_birden_fazla_katılmadığı_quiz_vardır() {

            }

    @When("filtrelerden kategori \\/ tarih \\/ quiz tipi seçer")
    public void filtrelerden_kategori_tarih_quiz_tipi_seçer() {

            }

    @Then("liste seçilen kriterlere göre filtrelenir")
    public void liste_seçilen_kriterlere_göre_filtrelenir() {

            }

    @Then("sadece ilgili sınavlar görüntülenir")
    public void sadece_ilgili_sınavlar_görüntülenir() {

            }

    @Given("kullanıcının en az {int} katılmadığı quiz vardır")
    public void kullanıcının_en_az_katılmadığı_quiz_vardır(Integer int1) {

            }

    @When("listeden bir quiz seçer")
    public void listeden_bir_quiz_seçer() {

            }

    @When("işlem butonuna \\(sınava katıl, detayları gör) tıklar")
    public void işlem_butonuna_sınava_katıl_detayları_gör_tıklar() {

            }

    @Then("kullanıcı ilgili işlemi gerçekleştirebilir")
    public void kullanıcı_ilgili_işlemi_gerçekleştirebilir() {


            }

//US-46---------------------------------------------------------------------------------//

    @Given("kullanıcı giriş yapmış")
    public void kullanıcı_giriş_yapmış() {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Given("kullanıcı dashboard sayfasında")
    public void kullanıcı_dashboard_sayfasında() {
        sevval.DashBoardButton.click();
        Assert.assertTrue(sevval.SupportsButton.isDisplayed());
    }

    @When("kullanıcı support menüsünü açar")
    public void kullanıcı_sidebar_menüsünü_açar() {

        sevval.SupportsButton.click();
        Assert.assertTrue(sevval.SupportsAçılanPencereBox.isDisplayed());


    }

    @Then("{string} linki görünür ve aktif olmalı")
    public void linki_görünür_ve_aktif_olmalı(String string) {

        if (link.equals("New")) {
            Assert.assertTrue(sevval.NewButton.isDisplayed());
            Assert.assertTrue(sevval.NewButton.isEnabled());
        } else if (link.equals("Courses Support")) {
            Assert.assertTrue(sevval.CourseSupportsButton.isDisplayed());
            Assert.assertTrue(sevval.CourseSupportsButton.isEnabled());
        } else if (link.equals("Tickets")) {
            Assert.assertTrue(sevval.tickesButton.isDisplayed());
            Assert.assertTrue(sevval.tickesButton.isEnabled());
        }

    }

    @When("kullanıcı konu ve tip bilgilerini girer")
    public void kullanıcı_konu_ve_tip_bilgilerini_girer() {
        sevval.SubjectBox.sendKeys("Test Konusu");
        sevval.TypeBox.sendKeys("Test Tipi");
        sevval.DepartmentBox.sendKeys("IT Departmanı");
        sevval.MessageBox.sendKeys("Bu bir test destek mesajıdır.");

    }

    @When("kullanıcı {string} butonuna tıklar")
    public void kullanıcı_butonuna_tıklar(String string) {
        if (button.equals("Gönder")) {
            sevval.SEndMessageButton.click();
        } else if (button.equals("Düzenle")) {
            // Düzenle locatorin yok, eklersen buraya koyabilirsin
        } else if (button.equals("Kapat")) {
            // Kapat locatorin yok, eklersen buraya koyabilirsin
        }

    }

    @Then("yeni destek isteği başarıyla gönderilmeli")
    public void yeni_destek_isteği_başarıyla_gönderilmeli() {

    }

    @Then("destek özet boardları başlık, tarih ve durum bilgileriyle görünmeli")
    public void destek_özet_boardları_başlık_tarih_ve_durum_bilgileriyle_görünmeli() {
        Assert.assertTrue(sevval.FormBox.isDisplayed());
        Assert.assertTrue(sevval.ToBox.isDisplayed());
        Assert.assertTrue(sevval.ShowResultButton.isDisplayed());
    }

    @When("kullanıcı mesaj geçmişi listesini açar")
    public void kullanıcı_mesaj_geçmişi_listesini_açar() {
        sevval.CourseSupportsButton.click();
        Assert.assertTrue(sevval.FormBox.isDisplayed());

    }

    @When("kullanıcı tarih, durum veya konu kriteriyle filtreleme yapar")
    public void kullanıcı_tarih_durum_veya_konu_kriteriyle_filtreleme_yapar() {
        sevval.FormBox.click();
        sevval.FormBoxTrh.click();
        sevval.FormApply.click();
        sevval.ToBox.click();
        sevval.ToBoxTrh.click();
        sevval.ToApply.click();
        sevval.StatusBox.click();
    }

    @Then("mesaj listesi filtreye uygun olarak güncellenmeli")
    public void mesaj_listesi_filtreye_uygun_olarak_güncellenmeli() {

        Assert.assertTrue(sevval.ShowResultButton.isDisplayed());
    }

    @When("kullanıcı mesaj geçmişinden bir mesaj seçer")
    public void kullanıcı_mesaj_geçmişinden_bir_mesaj_seçer() {
        sevval.FormBox.click();

    }

    @When("kullanıcı mesajı günceller ve kaydeder")
    public void kullanıcı_mesajı_günceller_ve_kaydeder() {
        sevval.MessageBox.clear();
        sevval.MessageBox.sendKeys("Güncellenmiş mesaj");
        sevval.SEndMessageButton.click();

    }

    @Then("mesaj güncellenmeli ve listede yeni hali görünmeli")
    public void mesaj_güncellenmeli_ve_listede_yeni_hali_görünmeli() {
        Assert.assertTrue(sevval.MessageBox.getText().contains("Güncellenmiş mesaj"));
    }

    @When("kullanıcı ticket listesinden açık bir ticket seçer")
    public void kullanıcı_ticket_listesinden_açık_bir_ticket_seçer() {

        sevval.tickesButton.click();
        Assert.assertTrue(sevval.Form1Box.isDisplayed());
    }

    @When("kullanıcı yeni mesaj yazar ve gönderir")
    public void kullanıcı_yeni_mesaj_yazar_ve_gönderir() {

        sevval.MessageBox.sendKeys("Ticket için yeni mesaj");
        sevval.SEndMessageButton.click();
    }

    @Then("mesaj ilgili ticket altında görünmeli")
    public void mesaj_ilgili_ticket_altında_görünmeli() {
        Assert.assertTrue(sevval.MessageBox.getText().contains("Ticket için yeni mesaj"));

    }

    @When("kullanıcı açık ticket detaylarını görüntüler")
    public void kullanıcı_açık_ticket_detaylarını_görüntüler() {
        sevval.tickesButton.click();
        Assert.assertTrue(sevval.Form1Box.isDisplayed());
    }

    @Then("ticket kapanmalı ve durumu {string} olarak güncellenmeli")
    public void ticket_kapanmalı_ve_durumu_olarak_güncellenmeli(String string) {

        Assert.assertEquals(durum, sevval.Status2.getText());

    }

    @Then("ticket listesi görünmeli ve her ticket için Başlık, Güncellenme Tarihi, Departman ve Durum bilgileri yer almalı")
    public void ticket_listesi_görünmeli_ve_her_ticket_için_başlık_güncellenme_tarihi_departman_ve_durum_bilgileri_yer_almalı() {
        Assert.assertTrue(sevval.Form1Box.isDisplayed());
        Assert.assertTrue(sevval.To1Box.isDisplayed());
        Assert.assertTrue(sevval.Status2.isDisplayed());
        Assert.assertTrue(sevval.Department2.isDisplayed());
    }
}
