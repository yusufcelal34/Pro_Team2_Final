package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class Eda {

    public Eda(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }
// Header-----------------------------------------------------------------------------------------------------------------------------------------------------
        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li")
        public WebElement categories;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[2]/a")
        public WebElement home;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[3]/a")
        public WebElement courses;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[4]/a")
        public WebElement instructors;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[5]/a")
        public WebElement store;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[6]/a")
        public WebElement blog;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

//Header>Categories-------------------------------------------------------------------------------------------------------
        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[1]/a/div")
        public WebElement development;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[2]/a/div")
        public WebElement business;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[3]/a/div")
        public WebElement marketing;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[4]/a/div")
        public WebElement lifestyle;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[5]/a/div")
        public WebElement healthFitness;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[6]/a/div")
        public WebElement webDesign;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[7]/a/div")
        public WebElement syberSecurity;

        @FindBy (xpath = "//*[@id=\"navbarContent\"]/ul/li[1]/div/ul/li/ul/li[8]/a")
        public WebElement testing;
//--------------------------------------------------------------------------------------------------------------------------

//filtering icons > Catagories and Courses------------------------------------------------------------------------------------------------------------------------
        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[2]/div[1]/label")
        public WebElement upcoming;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[2]/div[2]/label")
        public WebElement free;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[2]/div[3]/label")
        public WebElement discount;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[2]/div[4]/label")
        public WebElement download;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[3]/select")
        public WebElement newest;

        @FindBy (xpath = "//*[text()='Type']")
        public WebElement type;

        @FindBy (xpath = "//*[text()='More options']")
        public WebElement moreOptions;
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

//filtering icons > Instructors------------------------------------------------------------------------------------------------
        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[1]/div[1]/label")
        public WebElement availableForMeetings;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[1]/div[2]/label")
        public WebElement freeMeetings;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[1]/div[3]/label")
        public WebElement discountInstructorsStore;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[2]/select")
        public WebElement sortByInstructorsStore;
//-----------------------------------------------------------------------------------------------------------------------------

//filtering icons > Store-------------------------------------------------------------------------------------------------------------------------------------------
        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[1]/div[1]/label")
        public WebElement freeStore;

        @FindBy (xpath = "//*[@id=\"topFilters\"]/div/div[1]/div[2]/label")
        public WebElement freeShipping;

        @FindBy (xpath = "//*[text()='Options']")
        public WebElement optionsStore;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

       @FindBy (xpath = "//*[@id=\"navbar\"]/div/div/a/img")
       public WebElement instuLearnLogo;

        @FindBy (xpath = "//*[@id=\"navbarShopingCart\"]")
        public WebElement navbarShopingCartButton;

        @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/form/input")
        public WebElement homeSearchBox;

        @FindBy (xpath = "//*[@id=\"navbar\"]/div/div/div[2]/a[1]")
        public WebElement startLearningButton;

        @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[1]")
        public WebElement loginLink;

        @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[2]")
        public WebElement registerLink;


//Login Page------------------------------------------------------------------------------------------------------------

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[1]/img")
    public WebElement imgLoginPage;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/h1")
    public WebElement logInToYourAccountText;

    @FindBy (xpath = "//*[@id=\"email\"]")
    public WebElement userNameLoginTextBox;

    @FindBy (xpath = "//*[@id=\"password\"]")
    public WebElement passwordLoginTextBox;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/div[2]/a")
    public WebElement forgetPasswordLink;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[1]/div")
    public WebElement invalidFeedback;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/h1")
    public WebElement passwordRecoveryText;

    @FindBy (xpath = "//*[@id=\"email\"]")
    public WebElement forgetEmailTextBox;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement resetPasswordButton;

    @FindBy (xpath = "/html/body/div[3]/div")
    public WebElement resetSuccessfullyMessage;
/*
    @FindBy (xpath = "")
    public WebElement;

    @FindBy (xpath = "")
    public WebElement;

    @FindBy (xpath = "")
    public WebElement;

    @FindBy (xpath = "")
    public WebElement;



 */


}

