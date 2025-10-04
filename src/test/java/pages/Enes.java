package pages;

import org.openqa.selenium.By;
import utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enes {

    public Enes(){
        //Page classı
        PageFactory.initElements(DriverManager.getDriver(),this);


    }
    @FindBy(xpath = "//h2[@class='section-title']")
    public WebElement storeProductsYazisi;

    @FindBy(css = ".product-card, .products .product-card, .product-slider .product-card, .products .swiper-slide, .product-slider .swiper-slide")
    public List<WebElement> productCards;


    @FindBy (xpath = "(//div[contains(@class,'product-card')]//div[contains(@class,'product-price-box') and contains(@class,'mt-25')])[1]")
    public WebElement firstProductPrice;

    @FindBy(css = ".stars-card")
    public WebElement ratingBox;

    @FindBy(xpath = "(//div[contains(@class,'product-card')])[1]")
    public WebElement firstProductCard;

    @FindBy(xpath = "(//div[contains(@class,'product-card')])[1]//button[descendant::svg[contains(@class, 'feather-shopping-cart')]]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    public WebElement addCartButton;

    @FindBy(xpath = "//*[@id=\"navbarContent\"]/ul/li[5]/a")
    public WebElement storeHeader;

    @FindBy(xpath = "//*[@id=\"filtersForm\"]/div[2]/div[1]/div/div/div/figure/div/a/img")
    public WebElement productLink;

    @FindBy(xpath = "//*[@id=\"description-tab\"]")
    public WebElement descriptionYazisi;

    @FindBy(xpath = "//*[@id=\"productAddToCartForm\"]/div/h1")
    public WebElement urunBaslikYazisi;
    @FindBy(xpath = "//*[@id=\"app\"]/section[11]/div[1]/a")
    public WebElement allProductsLinki;

    @FindBy(xpath = "//*[@id=\"app\"]/section/div/div/div/div/h1")
    public WebElement productsYazisi;

    @FindBy(xpath = "//*[.='Login']")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-block mt-20']")
    public WebElement loginButtonInLoginPage;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div[1]/h1")
    public WebElement dashboardYazisi;

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[5]/a/span[2]")
    public WebElement quizzesLinki;
    @FindBy(xpath ="//*[@id=\"quizzesCollapse\"]/ul/li[1]/a" )
    public WebElement newQuizLinki;
    @FindBy(xpath ="//*[@id=\"quizzesCollapse\"]/ul/li[2]/a" )
    public WebElement listLinki;
    @FindBy(xpath ="//*[@id=\"quizzesCollapse\"]/ul/li[3]/a" )
    public WebElement resultLinki;
    @FindBy(xpath ="//*[@id=\"quizzesCollapse\"]/ul/li[4]/a" )
    public WebElement myResultsLinki;
    @FindBy(xpath ="//*[@id=\"quizzesCollapse\"]/ul/li[5]/a" )
    public WebElement notParticipatedLinki;
    public List<WebElement> getQuizLinks() {
        return Arrays.asList(newQuizLinki, listLinki, resultLinki, myResultsLinki, notParticipatedLinki);
    }
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div/section/div/div/div[2]/input")
    public WebElement quizTitleAlani;
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div/section/div/div/div[5]/input")
    public WebElement passMarkAlani;
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div/div/button")
    public WebElement quizCreateButton;

    public By listTitleSpan(String exactTitle) {
        return By.xpath("//tbody//span[contains(@class,'d-block') and normalize-space()='" + exactTitle + "']");
    }

    public static class ScenarioContext {
        private static final Map<String, Object> data = new HashMap<>();
        public static void put(String key, Object value){ data.put(key, value); }
        @SuppressWarnings("unchecked")
        public static <T> T get(String key){ return (T) data.get(key); }
    }

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[3]/div[2]/div/div/div/table/tbody/tr[1]/td[1]/span[1]")
    public WebElement lastCreatedQuiz;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[3]/div[2]/div/div/div/table/tbody/tr[1]/td[9]/div/div/a[1]")
    public WebElement editLinki;

    @FindBy(xpath = "//*[@id=\"add_multiple_question\"]")
    public WebElement addMultipleChoiceButton;


    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[1]/div[1]/div/input")
    public WebElement questionTitle;

    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[1]/div[2]/div/input")
    public WebElement gradeTitle;

    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[3]/div/div[2]/div[2]/div/label")
    public WebElement correctAnswerYazisi;

    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[3]/div/div[1]/div/div/input")
    public WebElement answerTitleInput;

    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[4]/button[1]")
    public WebElement quizEditSaveButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div[1]/section[2]/ul/li/div[1]/h4")
    public WebElement questionYazisi;

    @FindBy(xpath = "//button[@class='btn-transparent dropdown-toggle']")
    public WebElement ucNoktaMenu;

    @FindBy(xpath = "//*[@id=\"add_descriptive_question\"]")
    public WebElement addDescriptiveLinki;

    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[2]/div/div/textarea")
    public WebElement descriptionCorrectAnswerInput;

    @FindBy(xpath = "//*[@id=\"swal2-content\"]/div/div/div[3]/button[1]")
    public WebElement descriptonSaveButtonu;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/h2")
    public WebElement statisticsPart;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[2]/div/div[2]/div/div[1]/div/input")
    public WebElement totalMarkFilter;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[3]/button")
    public WebElement showResultFilter;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[3]/div[2]/div/div/div/table/tbody/tr[1]/td[9]/div/div/a[2]")
    public WebElement quizDeleteLinki;

    @FindBy(xpath = "//*[@id=\"swlDelete\"]")
    public WebElement deleteButonu;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[3]/div[2]/div[2]/h2")
    public WebElement noResultYazisi;

    @FindBy(xpath = "//*[@id=\"status\"]")
    public WebElement statusOptions;

    @FindBy(xpath = "//select[@id='status']/option[@value='passed']")
    public WebElement passedOption;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[3]/button")
    public WebElement showResultLinki;
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/h2")
    public WebElement resultStatisticPart;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[2]/div/div[2]/div/div[1]/div/input")
    public WebElement instructorInput;
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[2]/div/div[2]/div/input")
    public WebElement notParticipatedInstructorInput;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div/form/div[3]/button")
    public WebElement showMyResultLinki;
    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[3]/button")
    public WebElement showResultNotParticipate;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[2]/div[2]/div[2]/h2")
    public WebElement noResultInNotParticipated;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/form/div[2]/div/div[1]/div/input")
    public WebElement courseInput;

    @FindBy(xpath = "//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[9]/a/span[2]")
    public WebElement marketingLinki;

    @FindBy(xpath = "//*[@id=\"marketingCollapse\"]/ul/li[1]/a")
    public WebElement discountLinki;

    @FindBy(xpath = "//*[@id=\"marketingCollapse\"]/ul/li[2]/a")
    public WebElement promotionsLinki;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/h2")
    public WebElement newCourseDiscountYazisi;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/h2")
    public WebElement selectAPromotionYazisi;

    @FindBy(xpath = "//*[@id=\"formSubmit\"]")
    public WebElement createDiscountButonu;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div/form/div[1]/div/div[2]/div/div")
    public WebElement courseOptions;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div/div[2]/h2")
    public WebElement noDiscountIsAvailableYazisi;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div/div[1]/div/div[2]/span")
    public WebElement promotionPrice;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div/div[1]/div/h3")
    public WebElement promotionName;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div/div[1]/div/p[1]")
    public WebElement promotionTime;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/section/div/div[1]/div/button")
    public WebElement purchaseButton;
    @FindBy(xpath = "//*[@id=\"payPromotionModal\"]/form/h3")
    public WebElement promoteACourseYazisi;


    @FindBy(xpath = "//*[@id=\"payPromotionModal\"]/form/div[2]/button[1]")
    public WebElement payButton;
    @FindBy(xpath = "//*[@id=\"payPromotionModal\"]/form/div[1]/div/div[3]/div")
    public WebElement warningCourseYazisi;

    @FindBy(xpath = "//*[@id=\"payPromotionModal\"]/form/div[2]/button[2]")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"panel_app\"]/div[2]/div[3]/div[1]/div[2]/h2")
    public WebElement noPromotionYazisi;














}
