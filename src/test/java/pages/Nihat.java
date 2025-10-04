
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverManager;

public class Nihat {



    public Nihat() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @FindBy(xpath = "(//div[@class='col-6'])[1]")
    public WebElement validateCertificatesCard;


    @FindBy(xpath = "//div[@class='login-card']")

    public WebElement certificateValidationPageTitle;

//    @FindBy(id = "formSubmit")
//    public WebElement formSubmitButton;

    @FindBy(xpath = "//img[@alt='Reserve a meeting - Home']")
    public WebElement reserveMeetingCard;

    @FindBy(xpath = "//h1[@class='text-white font-30 mb-15']")
    public WebElement headerTitle;

    @FindBy(xpath = "(//a[contains(@class, 'nav-link')])[4]")
    public WebElement fourthNavLink;



    @FindBy(xpath = "//*[@class='product-price-box mt-25']")
    public WebElement productPriceBox;

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    //=========================================================

//    @FindBy(xpath = "//*[contains(text(),'free')]")
//    public WebElement freeElement;
//
//    @FindBy(xpath = "//*[contains(text(),'free_shipping')]")
//    public WebElement freeShippingElement;
//
//    @FindBy(xpath = "//*[contains(text(),'discount')]")
//    public WebElement discountElement;

//    @FindBy(id = "free")
//    public WebElement freeElement;
//
//    @FindBy(id = "free_shipping")
//    public WebElement freeShippingElement;
//
//    @FindBy(id = "discount")
//    public WebElement discountElement;

    @FindBy(xpath = "(//*[@class='custom-control custom-switch'])[1]")
    public WebElement freeElement;

    @FindBy(xpath = "(//*[@class='custom-control custom-switch'])[2]")
    public WebElement freeShippingElement;

    @FindBy(xpath = "(//*[@class='custom-control custom-switch'])[3]")
    public WebElement discountElement;



//    ====================================================

    @FindBy(xpath = "(//*[@class='image-box'])[1]")
    public WebElement firstImageBox;

    @FindBy(xpath = "//*[@class='user-inline-avatar d-flex align-items-center']")
    public WebElement userInlineAvatar;

    @FindBy(xpath = "//h3[text()='Updated Product Title']")
    public WebElement updatedProductTitle;

    @FindBy(id = "description-tab")
    public WebElement descriptionTab;

//===============================================================================================

    @FindBy(xpath = "//*[@class='btn mt-20 btn-primary']")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@class='btn btn-outline-danger mt-20 ml-0 ml-md-10 js-product-direct-payment']")
    public WebElement buyNowButton;
    @FindBy(xpath = "//*[@class='stars-card d-flex align-items-center mt-0']")
    public WebElement ratingStars;
    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElement commentTextArea;
    @FindBy(xpath = "//*[@class='btn btn-sm btn-primary']")
    public WebElement postCommentButton;
    @FindBy(xpath = "//*[.='Login']")

    public WebElement loginButon;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "password")
    public WebElement passWordTextBox;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-block mt-20']")
    public WebElement Login;


//===============================================================================================
    @FindBy(xpath = "//button[contains(@class,'btn btn-sm btn-primary mt-15')]")
    public WebElement checkoutButton;

//    @FindBy(xpath = "//input[@type='radio' and @name='gateway']")
//    public WebElement gatewayRadioButton;

    @FindBy(id = "Stripe")
    public WebElement stripeFrame;

    @FindBy(id = "paymentSubmit")
    public WebElement paymentSubmitButton;

    @FindBy(xpath = "//span[contains(@class,'LinkText--bodyEmphasized')]")
    public WebElement spanlink;

//    @FindBy(id = "email")
//    public WebElement emailInput;
    @FindBy(xpath = "//span[@class='InputContainer']")
    public WebElement emailInput;
    @FindBy(xpath = "//button[@type='reset' and contains(@class,'your-class-name')]")
    public WebElement resetButton;


    @FindBy(id = "cardNumber")
    public WebElement cardNumberInput;
    @FindBy(id = "cardExpiry")
    public WebElement cardExpiryInput;

    @FindBy(id = "cardCvc")
    public WebElement cardCvcInput;
    @FindBy(id = "billingName")
    public WebElement billingNameInput;
    @FindBy(id = "billingCountry")
    public WebElement billingCountryInput;
    @FindBy(id = "enableStripePass")
    public WebElement enableStripePassCheckbox;
    @FindBy(className = "SubmitButton-IconContainer")
    public WebElement submitButtonIconContainer;
//=======================================================================
@FindBy(xpath = "//div[contains(@class, 'custom-control') and contains(@class, 'custom-switch')]")
public WebElement customSwitch;


    @FindBy(xpath = "//span[normalize-space()='Certificates']")
    public WebElement certificatesSpan;

    @FindBy(linkText = "Achievements")
    public WebElement achievementsLink;

    @FindBy(linkText = "Certificate Validation")
    public WebElement certificateValidationLink;

    @FindBy(linkText = "Completion Certificates")
    public WebElement completionCertificatesLink;
//========================================================================


    @FindBy(xpath = "(//*[contains(@class, 'd-flex') and contains(@class, 'flex-column') and contains(@class, 'align-items-center') and contains(@class, 'text-center')])[1]")
    public WebElement firstElement;
    @FindBy(xpath = "(//*[contains(@class, 'd-flex') and contains(@class, 'flex-column') and contains(@class, 'align-items-center') and contains(@class, 'text-center')])[2]")
    public WebElement secondElement;
    @FindBy(xpath = "(//*[contains(@class, 'd-flex') and contains(@class, 'flex-column') and contains(@class, 'align-items-center') and contains(@class, 'text-center')])[3]")
    public WebElement thirdElement;

//====================================================================================================================
@FindBy(xpath = "//label[text()='Certificate ID:']/following-sibling::input[@id='certificate_id']")
public WebElement idcertificate;

    @FindBy(xpath = "//input[@name='from' and contains(@class,'datefilter')]")
    public WebElement fromInput;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/table/thead/tr[1]/th[2]")
    public WebElement myElement;
    @FindBy(xpath = "//div[@class='daterangepicker']//table/thead/tr[1]/th[3]")
    public WebElement nextButton;
    @FindBy(xpath = "//div[contains(@class,'daterangepicker')]//table/tbody/tr[1]/td[5]")
    public WebElement tarih;


//    public By dayLeft(String d){
//        return By.xpath("//div[contains(@class,'daterangepicker') and contains(@class,'show-calendar')]//div[contains(@class,'calendar') and contains(@class,'left')]//td[not(contains(@class,'off')) and not(contains(@class,'disabled')) and normalize-space()='"+d+"']");
//    }
//
//
//    public By dayRight(String d){
//        return By.xpath("//div[contains(@class,'daterangepicker') and contains(@class,'show-calendar')]//div[contains(@class,'calendar') and contains(@class,'right')]//td[not(contains(@class,'off')) and not(contains(@class,'disabled')) and normalize-space()='"+d+"']");
//    }

    @FindBy(xpath = "//input[@name='to' and contains(@class,'datefilter')]")
    public WebElement toInput;
    @FindBy(xpath = "//button[@type='button' and normalize-space()='Apply']")
    public WebElement applyBtn;
    @FindBy(xpath = "//button[contains(text(),'Show Results')]")
    public WebElement showResultsBtn;

    @FindBy(name = "webinar_id")
    public WebElement courseDropdown;

    @FindBy(xpath = "//*[@id=\"certificatesCollapse\"]/ul/li[4]/a")
    public WebElement completionCertificates;

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



}