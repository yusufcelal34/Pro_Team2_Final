package pages;

import utilities.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cennet extends BasePage {
    public WebElement requiredFieldWarning;

    public Cennet(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='py-5 px-10 text-dark-blue font-14']")
    public WebElement registerButton;

    @FindBy(xpath = "(//*[@class='img-cover'])[2]")
    public WebElement registerImage;

    @FindBy(className = "login-card")
    public WebElement signupForm;

    @FindBy(xpath = "(//*[@class='form-control '])[1]")
    public WebElement emailtexbox;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-block mt-20']")
    public WebElement signupButton;

    @FindBy(xpath = ("//label[text()='Full Name:']/following-sibling::input"))
    public WebElement fullNameTexbox;

    @FindBy(xpath = "(//*[@class='wizard-custom-radio-item flex-grow-1'])[1]")
    public WebElement studentButton;

    @FindBy(xpath = "//label[text()='Password:']/following-sibling::input")
    public WebElement passwordTexbox;

    @FindBy(xpath = "//label[text()='Retype Password:']/following-sibling::input")
    public WebElement rtypePasswordTexbox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[6]/select")
    //*** /html/body/div[2]/div[3]/div/div[2]/div/form/div[6]//span[@class='select2-selection__rendered']
    public WebElement timeZoneDropDown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[6]/select/option[155]")
    //*[@id="select2-timezone-v7-container"]   //li[text()='America/Nome']
    public WebElement optionAmericaNome;


    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/form/div[8]/input")
    public WebElement termsRulesCheckbox;

    @FindBy(xpath = "//*[@class='custom-dropdown-toggle d-flex align-items-center navbar-user cursor-pointer']")
    public WebElement profilName;


    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[1]/div")
    public WebElement TheEmailMustBeAValidEmailAddressMesaji;  //*[@id="app"]/div[3]/div/div[2]/div/form/div[2]/div

    @FindBy(xpath = "//*[@class='invalid-feedback']")
    public WebElement thePasswordConfirmationDoesNotMatchMesaji;


    @FindBy(xpath = "//*[@class='ml-4 text-lg text-gray-500 uppercase tracking-wider']")
    public WebElement pageExpiredHataKodu;

    @FindBy(className = "invalid-feedback")
    //invalid-feedback //*[@class='ml-4 text-lg text-gray-500 uppercase tracking-wider']
    public WebElement TheEmailFieldIsRequiredMesaji;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[2]/div")
    public WebElement TheFullNameFieldIsRequiredMesaji;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[4]/div")
    public WebElement ThePasswordFieldIsRequiredMesaji;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[4]/div")
    public WebElement ThePasswordConfirmationFieldIsRequiredMesaji;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/div[8]/div")
    public WebElement TheTermFieldIsRequiredMesaji;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[1]")
    public WebElement loginLink;

    @FindBy(xpath = "//*[@id=\"email\"]") //*[@id="userSettingForm"]/section/div/div/div[1]/input
    public WebElement insEmailTexbox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement insPasswordTexbox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div[1]/h1")
    public WebElement deshboardPanel;

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[13]/a/span[2]")
    public WebElement settingsLink;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[1]/div/h4")
    public WebElement basicInformationTitle;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[1]/input")
    public WebElement basicInfEmailTexbox;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[2]/input")
    public WebElement basicInfNameTexbox;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[3]/input")
    public WebElement basicInfPasswordTexbox;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[4]/input")
    public WebElement basicInfRetypePasswordTexbox;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[5]/input")
    public WebElement phoneTexbox;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[6]/select")
    public WebElement languageDDown;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[6]/select/option[2]")
    public WebElement languageEnglish;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[6]/select")
    public WebElement languageTexbox;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[7]/span/span[1]/span")
    public WebElement basicInfTimeZoneDDown;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div/div/div[7]/span/span[1]/span/span[1]")
    public WebElement americaNewYork;

    @FindBy(xpath = "//*[@id=\"getNextStep\"]")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[2]/div/h4")
    public WebElement imagesTitle;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[1]/div")
    public WebElement theEmailMustBeAValidEmailAddressMessaji;

    @FindBy(xpath = "/html/body/div[3]/div")
    public WebElement thePasswordMustBeAValidEmailAddressMessaji;

    @FindBy(xpath = "/html/body/div[3]/div")
    public WebElement cikanUyari;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/div/div/div/div[2]/div/div[3]/button[2]")
    public WebElement selectButton;

    @FindBy(xpath = "//*[@id=\"selectAvatarBtn\"]")
    public WebElement selectAnImageButton;

    // Cennet.java (Page sınıfın)
   /* @FindBy(xpath = "//*[@id=\"userSettingForm\"]/input[1]")
    public WebElement selectAnImageButton;*/


    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div[2]/div/div/div/div/button")
    public WebElement yukariOkIkonu;

    @FindBy(xpath = "//*[@id=\"cover_img\"]")
    public WebElement resimYuklemeTextBox;

    @FindBy(xpath = "//*[@id=\"content\"]/a[3]")
    public WebElement ekranresmi;


    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[3]/div/h4")
    public WebElement aboutLink;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[1]/textarea")
    public WebElement biographyTexbox;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[2]/textarea")
    public WebElement jobTitleTexbox;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[4]/div/h4")
    public WebElement educationLink;

    @FindBy(xpath = "//*[@id=\"userAddEducations\"]")
    public WebElement addEducationButton;

    @FindBy(xpath = "(//*[@id='new_education_val'])[2]")
    public WebElement addEducationTexbox;

    @FindBy(xpath = "(//*[@id='saveEducation'])[2]")
    public WebElement addEducationSaveButton;

    @FindBy(xpath = "//*[@id=\"newEducationSwlModal\"]/div[1]/div/div")
    public WebElement theValueFieldIsRequiredMesji;

    @FindBy(id = "getNextStep")
    public WebElement educationNextButton;

    @FindBy(xpath = "//*[@class='btn-group dropdown table-actions show']")
    public WebElement ucNokta;

    @FindBy(xpath = "//*[@id=\"userListEducations\"]/div[1]/div/div/div[2]/div/div/button")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id=\"userListEducations\"]/div[1]/div/div/div[2]/div/div/a")
    public WebElement deleteText;

    @FindBy(xpath = "//*[@id=\"swlDelete\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[5]/a/img")
    public WebElement experiencesLink;

    @FindBy(xpath = "//*[@id=\"userAddExperiences\"]")
    public WebElement addExperiencesButton;

    @FindBy(xpath = "//*[@id=\"new_experience_val\"]")
    public WebElement addExperiencesTexbox;

    @FindBy(xpath = "//*[@id=\"actions\"]/a[3]")
    public WebElement confirimButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[6]")
    public WebElement skillsLink;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div[1]/div[14]/label")
    public WebElement sdetButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[7]/a/img")
    public WebElement identyLink;


    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div[2]/div/div[2]/div[1]/input")
    public WebElement accountHolderTexbox;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div[2]/div/div[2]/div[2]/input")
    public WebElement accountId;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[8]/a/img")
    public WebElement zoomApiLink;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[1]/textarea")
    public WebElement zoomClientId;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[2]/textarea")
    public WebElement zoomClientSecret;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div/div/div[3]/textarea")
    public WebElement zoomAccountId;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[9]/a/img")
    public WebElement extraInformationLink;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div[1]/div/div[1]/div/div[2]/label")
    public WebElement femaleChecbox;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/form/section/div[1]/div/div[2]/input")
    public WebElement ageTexbox;

    @FindBy(xpath = "//*[@id=\"userSettingForm\"]/section/div[1]/div/div[3]/div/div[2]/label")
    public WebElement onlineTexbox;


    @FindBy(xpath = "//*[@id=\"saveData\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[2]/div[2]/a")
    public WebElement deleteAccountButton;

//*[@id="saveData"]
}