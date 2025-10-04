package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sevval {
    WebDriver driver;

    public Sevval(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // ---------------- SABİT LOGIN BİLGİLERİ ----------------
    public static final String EMAIL = "sevval.student@instulearn.com";
    public static final String PASSWORD = "Learn.1406";


    // ---------------- LOGIN ELEMENTLERİ ----------------

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[1]")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement altLoginButton;


    //---------------- DASHBOARD ELEMENTLERİ ----------------
    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[1]/a/span[2]")
    public WebElement DashBoardButton;

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[8]/a/span[2]")
    public WebElement notificationsLink;

    @FindBy(xpath = "//*[@id=\"showNotificationMessage6142\"]")
    public WebElement ViewButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[1]/div[2]/a[1]/div[2]/span[2]")
    public WebElement PurchasedCoursesButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[1]/div[3]/a[1]/div[2]/span[2]")
    public WebElement SupportMessagesButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[1]/div[2]/a[2]/div[2]/span[2]")
    public WebElement MeetingsButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[1]/div[3]/a[2]/div[2]/span[2]")
    public WebElement CommentsButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div[1]/a/span")
    public WebElement MarkallButton;

    @FindBy(xpath = "//*[@id=\"swlDelete\"]")
    public WebElement OnayButonu;

    @FindBy(xpath = "//*[@id=\"swlDelete\"]")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[@id='notifications-table']//tr[contains(@class,'read')]")
    public WebElement readNotification;


    //----------------------------------------------------------//

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[4]/a/span[2]")
    public WebElement quizzesButton;

    @FindBy(xpath = "//*[@id=\"quizzesCollapse\"]/ul/li[1]/a")
    public WebElement MyResultButton;

    @FindBy(xpath = "//*[@id=\"quizzesCollapse\"]/ul/li[2]/a")
    public WebElement NotParticiPatetButton;


    @FindBy(xpath = "/html/body/div[3]/div[2]")
    public WebElement TarihAralığı1AÇılanPencere;


    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[4]")
    public WebElement Tarih1;


    @FindBy(xpath = "/html/body/div[3]/div[4]/button[2]")
    public WebElement  TarihAralığı1Apply ;


    @FindBy(xpath = "/html/body/div[4]/div[2]")
    public WebElement TarihAralığı2AÇılanPencereBox;


    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/table/tbody/tr[1]/td[4]")
    public WebElement Tarih2;



    @FindBy(xpath = "/html/body/div[4]/div[4]/button[2]")
    public WebElement TarihAralığı2Apply;


    @FindBy(xpath = "/html/body/div[3]/div[2]")
    public WebElement Trh1AçılanPencereBox;



    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[5]")
    public WebElement Trh1Trh;



    @FindBy(xpath = "/html/body/div[3]/div[4]/button[2]")
    public WebElement Trh1Aplly;



    @FindBy(xpath = "/html/body/div[4]/div[2]")
    public WebElement Trh12AçılanPencereBox;


    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/table/tbody/tr[1]/td[5]")
    public WebElement Tarih2Trh;



    @FindBy(xpath = "/html/body/div[4]/div[4]/button[2]")
    public WebElement Trh2Apply;

//--------------------------------------------------------------------------------------------//

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[7]/a/span[2]")
    public WebElement SupportsButton;


    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul")
    public WebElement SupportsAçılanPencereBox;


    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul/li[1]/a")
    public WebElement NewButton;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div/div[1]/input")
    public WebElement SubjectBox;


    @FindBy(xpath = "//*[@id=\"supportType\"]")
    public WebElement TypeBox;


    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    public WebElement DepartmentBox;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div/div[5]/textarea")
    public WebElement MessageBox;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div/div[6]/div/button")
    public WebElement SEndMessageButton;


    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul/li[2]/a")
    public WebElement CourseSupportsButton;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div/div[1]/div/div/input")
    public WebElement FormBox;

    @FindBy(xpath = "/html/body/div[3]/div[2]")
    public WebElement FormAçılırPencere;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[6]")
    public WebElement FormBoxTrh;

    @FindBy(xpath = "/html/body/div[3]/div[4]/button[2]")
    public WebElement FormApply;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div/div[2]/div/div/input")
    public WebElement ToBox;

    @FindBy(xpath = "/html/body/div[4]/div[2]")
    public WebElement ToBoxAçılırPencere;


    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/table/tbody/tr[1]/td[6]")
    public WebElement ToBoxTrh;

    @FindBy(xpath = "/html/body/div[4]/div[4]/button[2]")
    public WebElement ToApply;


    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    public WebElement InstructorsBox;


    @FindBy(xpath = "//*[@id=\"select2-webinar-b3-container\"]")
    public WebElement CoursesBox;


    @FindBy(xpath = "//*[@id=\"select2-webinar-b3-container\"]")
    public WebElement StatusBox;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div/div[6]/button")
    public WebElement ShowResultButton;


    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul/li[3]/a")
    public WebElement tickesButton;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div/div[1]/div/div[1]/div/div/input")
    public WebElement Form1Box;

    @FindBy(xpath = "/html/body/div[3]/div[2]")
    public WebElement Form1BoxAçılırPencere;


    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[7]")
    public WebElement Form1BoxTrh1;


    @FindBy(xpath = "/html/body/div[3]/div[4]/button[2]")
    public WebElement Form1BoxApply;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div/div[1]/div/div[2]/div/div/input")
    public WebElement To1Box;

    @FindBy(xpath = "/html/body/div[4]/div[2]")
    public WebElement TOBox1AçılanPencere;


    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/table/tbody/tr[1]/td[7]")
    public WebElement TOBox1ApTrh2;


    @FindBy(xpath = "/html/body/div[4]/div[4]/button[2]")
    public WebElement TOBox1Aply;


    @FindBy(xpath = "//*[@id=\"departments\"]")
    public WebElement Department2;


    @FindBy(xpath = "//*[@id=\"status\"]")
    public WebElement Status2;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div/div[3]/button")
    public WebElement TicketShowResults;


}