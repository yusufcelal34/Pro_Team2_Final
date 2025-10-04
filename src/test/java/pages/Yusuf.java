package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Yusuf {
    WebDriver driver;

    public Yusuf(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//-----------------26-START-----------------

    //---2---
    @FindBy(id = "email")
    public WebElement emailBox;

    //---2.1---
    @FindBy(id = "password")
    public WebElement passwordBox;

    //---2.2---
    public WebElement buttonByText(String text) {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button"));
    }

    //---3---
    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[6]/a/span[2]")
    public WebElement myCertificatesLink;

    //---4---
    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[6]/a/span[2]")
    public WebElement certificatesButton;

    //---5---
    @FindBy(xpath = "//*[@id=\"certificatesCollapse\"]/ul/li[1]/a")
    public WebElement listButton;

    //---6---
    @FindBy(xpath = "//*[@id=\"certificatesCollapse\"]/ul/li[2]/a")
    public WebElement achievements;

    //---7---
    @FindBy(xpath = "//*[@id=\"certificatesCollapse\"]/ul/li[3]/a")
    public WebElement certificateValidation;

    //---8---
    @FindBy(xpath = "//*[@id=\"certificatesCollapse\"]/ul/li[4]/a")
    public WebElement completionCertificates;

    //---9---
    @FindBy(xpath = "//*[@id='panel-sidebar-scroll']/div[1]/div[2]/div/div/div/li[15]/a/span[2]")
    public WebElement logoutLink;

    //---10---
    @FindBy(xpath = "//*[@id='panel-sidebar-scroll']/div[1]/div[2]/div/div/div/li[15]/a/span[2]")
    public WebElement logoutexit;

    //---12---
    @FindBy(xpath = "//*[@id=\"certificatesCollapse\"]/ul/li[1]/a")
    public WebElement certificateStatisticsLink;

    //---13---
    // From date picker
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[1]/div/div[1]/div/div/input")
    public WebElement fromDateIcon;

    // To date picker
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[1]/div/div[2]/div/div/input")
    public WebElement toDateIcon;

    // Course dropdown
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[2]/div/div[1]/div/select")
    public WebElement courseDropdown;

    // Quiz dropdown
    @FindBy(xpath = "//*[@id=\"quizFilter\"]")
    public WebElement quizDropdown;

    // Grade input
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[2]/div/div[2]/div/div[2]/div/input")
    public WebElement gradeInput;

    // Show Results button
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[3]/button")
    public WebElement showResultsButton;

    //---18---
    // From date picker
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[1]/div/div[1]/div/div/input")
    public WebElement fromDateIconachievements;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[1]/div/div[2]/div/div/input")
    public WebElement toDateIconachievements;
    // To date picker

    // Course dropdown
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[2]/div/div[1]/div/select")
    public WebElement courseDropdownachievements;

    // Quiz dropdown
    @FindBy(xpath = "//*[@id=\"quizFilter\"]")
    public WebElement quizDropdownachievements;

    // Grade input
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[2]/div/div[2]/div/div[2]/div/input")
    public WebElement gradeInputachievements;

    // Show Results button
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[3]/button")
    public WebElement showResultsButtonachievements;

    //---23---
    @FindBy(xpath = "//*[@id=\"certificate_id\"]")
    public WebElement certificate_id;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[2]/div/div[1]/input")
    public WebElement Captcha_yusuf;

    @FindBy(xpath = "//*[@id=\"formSubmit\"]")
    public WebElement submit;

    //---29---
    // From date picker
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[1]/div/div[1]/div/div/input")
    public WebElement fromDateIconCompletionCertificates;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[1]/div/div[2]/div/div/input")
    public WebElement toDateIconCompletionCertificates;
    // To date picker

    // Course dropdown
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[2]/div/select")
    public WebElement courseDropdownCompletionCertificates;

    // Show Results button
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[3]/button")
    public WebElement showResultsButtonCompletionCertificates;

//-----------------26-THE-END-----------------

// ****************************************@@@@@@@@@@@****************************************

//-----------------38-START-----------------


    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[2]/div[2]/div[1]/span")
    public WebElement hoverTargetSpan;

    @FindBy(xpath = "//*[@id=\"navbar\"]/div/div/a/img")
    public WebElement instulearn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[2]/ul/li[7]/a/span")
    public WebElement dropdownLogoutLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[1]")
    public WebElement headerLoginButton;

    @FindBy(xpath = "//*[@id='navbar']/div/div/a/img")
    public WebElement navbarLogoImage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[1]/span")
    public WebElement profileIcon;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[1]/img")
    public WebElement profileIconshow;

    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[2]/div[2]/a[1]")
    public WebElement loginLink;

//-----------------38-THE-END-----------------

// ****************************************@@@@@@@@@@@****************************************

//-----------------41-START-----------------


    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[2]/a/span[2]\n")
    public WebElement myCoursesLink;

    @FindBy(xpath = "//*[@id=\"webinarCollapse\"]/ul/li[4]/a")
    public WebElement Mypurchases;

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[15]/a/span[2]")
    public WebElement logoutLinkInSidebar;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/h2\n")
    public WebElement myActivityLink;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[1]/h2")
    public WebElement myPurchasesLink;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]/div[1]/div/button")
    public WebElement Mypurchasesvisible;

    @FindBy(xpath = "//*[normalize-space(.)='Invoice' or normalize-space(.)='Invoices' or normalize-space(.)='Fatura']")
    public final By invoiceSubmenuBy = By.xpath("//*[normalize-space(.)='Invoice' or normalize-space(.)='Invoices' or normalize-space(.)='Fatura']");

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]/div[1]/a/h3")
    public WebElement learnPage;

    @FindBy(xpath = "//*[@id=\"webinarCollapse\"]/ul/li[7]/a\n")
    public WebElement myFavoritesLink;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div[1]/h2")
    public WebElement favoriteCoursesText;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div[2]/div/div/div[2]/div[1]/div/button")
    public WebElement removeVisible;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div[2]/div/div/div[2]/div[1]/div/div/a")
    public WebElement remove;


}
//-----------------41-THE-END-----------------