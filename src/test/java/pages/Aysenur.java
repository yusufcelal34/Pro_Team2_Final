package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class Aysenur {

    public Aysenur(){ PageFactory.initElements(DriverManager.getDriver(),this); }

    @FindBy(xpath = "//*[@class='text-secondary font-weight-bold']")
    public WebElement homePageTitle;

    @FindBy(xpath = "//input[@class='form-control border-0 mr-lg-50']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@placeholder='Search courses and instructors...']")
    public WebElement searchBoxText;

    @FindBy(xpath = "(//button[@class='btn btn-primary rounded-pill'])[1]")
    public WebElement searchButton;

    @FindBy (xpath = "//*[@id=\"app\"]/section[4]/div[1]/div/h2")
    public WebElement latestBundlesTitle;

    @FindBy (xpath = "//*[@id=\"app\"]/section[5]/div[1]/div/h2")
    public WebElement upcomingCoursesTitle;

    @FindBy (xpath = "//*[@id=\"app\"]/section[7]/h2")
    public WebElement trendingCategoriesTitle;

    @FindBy (xpath = "//*[@id=\"app\"]/section[8]/div[1]/div/h2")
    public WebElement bestsellingCoursesTitle;

    @FindBy (xpath = "//*[@id=\"app\"]/section[9]/div[1]/div/h2")
    public WebElement freeCoursesTitle;

    @FindBy (xpath = "//*[@id=\"app\"]/section[10]/div[1]/div/h2")
    public WebElement discountedCoursesTitle;

    @FindBy (xpath = "//div[@class='swiper-slide swiper-slide-active']")
    public WebElement cardElement;

    @FindBy (xpath = "//span[@class='real']")
    public WebElement price;

    @FindBy (xpath = "//span[@class='duration font-14 ml-5']")
    public WebElement duration;

    @FindBy (xpath = "//div[@class='user-inline-avatar d-flex align-items-center']")
    public WebElement instructorInformation;

    @FindBy (xpath = "//span[@class='date-published font-14 ml-5']")
    public WebElement date;

    @FindBy (xpath = "(//div[@class='trending-image d-flex align-items-center justify-content-center w-100'])[1]")
    public WebElement trendingCategoriesCards;




    @FindBy (xpath = "//*[@class='py-5 px-10 mr-10 text-dark-blue font-14']")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@class='font-20 font-weight-bold']")
    public WebElement loginTitle;

    @FindBy (xpath = "//*[@id='email']")
    public WebElement emailBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement loginLogButton;

    @FindBy (xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[1]/a/span[2]")
    public WebElement dashboardLink;

    @FindBy (xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[3]/a/span[2]")
    public WebElement courseBundlesLink;

    @FindBy (xpath = "//*[@id=\"bundlesCollapse\"]/ul/li[1]/a")
    public WebElement newCbLink;

    @FindBy (xpath = "//*[@id=\"webinarForm\"]/div[1]/div[1]/div/h4")
    public WebElement basicInformationTittle;

    @FindBy (xpath = "//*[@id=\"webinarForm\"]/div[2]/div/div[1]/input")
    public WebElement basicInfoTittleBox;

    @FindBy(css = "button.input-group-text.panel-file-manager[data-input='thumbnail']")
    public WebElement basicInfoThumbnailButton;

    @FindBy (xpath = "//*[@id='upload']")
    public WebElement plusButton;

    @FindBy (xpath = "//*[@id='upload']")
    public WebElement uploadButton;

    @FindBy (xpath = "//*[@class='btn btn-primary w-100 text-white dz-clickable']")
    public WebElement chooseFile;

    @FindBy (xpath = "//*[@id=\"uploadModal\"]/div/div/div[3]/button")
    public WebElement closeButton;

    @FindBy (xpath = "//*[@id=\"content\"]/a/div[2]/div")
    public WebElement itemClick;

    @FindBy (xpath = "//*[@id='actions']/a[3]/i")
    public WebElement confirmButton;

    @FindBy (css = "button.input-group-text.panel-file-manager[data-input='cover_image']")
    public WebElement basicInfoCoverImageButton;

    @FindBy (xpath = "//div[@class='note-editable card-block']")
    public WebElement basicInfoDescription;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div/div[1]/a")
    public WebElement previousButton;

    @FindBy (xpath = "//*[@id=\"getNextStep\"]")
    public WebElement nextButton;

    @FindBy (xpath = "//*[@id=\"sendForReview\"]")
    public WebElement sendForReviewButton;

    @FindBy (xpath = "//*[@id=\"saveAsDraft\"]")
    public WebElement saveAsDraftButton;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div/div[2]/a")
    public WebElement deleteButton;

    @FindBy (xpath = "//*[@id=\"webinarForm\"]/div[1]/div[1]/div/h4")
    public WebElement extraInformationTitle;


    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[1]/h2")
    public WebElement myBundlesTitle;

    @FindBy (id = "swlDelete")
    public WebElement deleteConfirm;

    @FindBy (xpath = "//*[@id='categories']")
    public WebElement categoryDropdown;

    @FindBy (xpath = "//*[@id=\"webinarForm\"]/div[2]/div/div[4]/input")
    public WebElement priceBox;

    @FindBy (xpath = "//*[@class='btn btn-primary btn-sm mt-15']")
    public WebElement addCourse;

    @FindBy(css = "button.applyBtn")
    public WebElement applyButton;

    @FindBy (css = "select[name='ajax[new][webinar_id]'] + span .select2-selection")
    public WebElement selectCourseDropdown;

    @FindBy (id = "webinarAddFAQ")
    public WebElement newFAQ;

    @FindBy (css = "div[id^='collapseFaq'].show textarea[name='ajax[new][answer]']")
    public WebElement faqBox;

    @FindBy (xpath = "//*[@id=\"webinarForm\"]/section/div[1]/div/div/textarea")
    public WebElement messageBox;

    @FindBy(id = "rulesSwitch")
    public WebElement rulesCheckbox;

    @FindBy(css = "label.custom-control-label[for='rulesSwitch'], label.input-label[for='rulesSwitch']")
    public WebElement rulesSwitchLabel;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]")
    public WebElement finalCourseBundles;

    @FindBy (xpath = "//*[@id=\"bundlesCollapse\"]/ul/li[2]/a")
    public WebElement myBundlesLink;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]/div[1]/div/button")
    public WebElement threeDort;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]/div[1]/div/div")
    public WebElement threeDortDropdown;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]/div[1]/div/div/a[1]")
    public WebElement edit;

    @FindBy (xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div/div/div[2]/div[1]/div/div/a[4]")
    public WebElement deleteRed;
}
