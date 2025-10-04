package pages;

import utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Melih {

    public Melih(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"app\"]/section[13]/div/div[1]/div/h2")
    public WebElement becomeAnInstructorIsimElementi;

    @FindBy(xpath = "//*[@id=\"app\"]/section[13]/div/div[1]/div/div/a")
    public WebElement becomeAnInstructorButonElementi;


    @FindBy(xpath = "//*[@class='font-20 font-weight-bold']")
    public WebElement logInToYourAccountYaziElementi;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[1]")
    public WebElement loginButon;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement girisIcinLoginButonu;

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[10]/a/span[2]")
    public WebElement supportButonu;

    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul/li[1]/a")
    public WebElement supportNewButonu;

    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul/li[2]/a")
    public WebElement supportCoursesSupoortButonu;

    @FindBy(xpath = "//*[@id=\"supportCollapse\"]/ul/li[3]/a")
    public WebElement supportTicketsButonu;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/h2")
    public WebElement supportSummaryYaziElementi;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div/div[1]/input")
    public WebElement newSubject;

    @FindBy(xpath = "//*[@id=\"supportType\"]")
    public WebElement typeDd;

    @FindBy(xpath = "//*[@id=\"departmentInput\"]/span/span[1]/span")
    public WebElement departmentDd;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div/div[5]/textarea")
    public WebElement newSendMessage;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div/div[6]/div/button")
    public WebElement SendMessageButonu;

    @FindBy(xpath = "//*[@id=\"conversationsList\"]/div/table/tbody[2]/tr[1]/td[1]/a/div/div[2]/span[1]")
    public WebElement coursesSupportMesajlari;











}
