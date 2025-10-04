package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Erkan {

    public Erkan (){
        PageFactory.initElements(utilities.DriverManager.getDriver(),this);}

    //   ORGANIZATIONS    **********************************************************************************************


    @FindBy(xpath = "//*[@id=\"app\"]/section[16]/div[1]/div/h2")
    public WebElement Organzations_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/section[16]/div[1]/div/p")
    public WebElement Greatest_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/section[16]/div[1]/a")
    public WebElement All_Organization_Button_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/section[16]/div[2]/div[1]")
    public WebElement Sliders_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/section[16]/div[2]/div[2]/div/span[1]")
    public WebElement Radio_Button_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/section[16]/div[2]/div[1]/div/div[5]/div")
    public WebElement Affagato_Media_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/section[2]/div/div[1]/div[1]/div[2]/h1")
    public WebElement Affagato_Media_Sayfa_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[16]/div[2]/div[1]/div/div[3]/div/div/img")
    public WebElement King_IMG_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[16]/div[2]/div[1]/div/div[3]/div/a")
    public WebElement King_Text_EB ;

    @FindBy(xpath ="//*[@id=\"app\"]/section[16]/div[2]/div[1]/div/div[4]/div/div/img")
    public WebElement Owosso_IMG_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[16]/div[2]/div[1]/div/div[4]/div/a")
    public WebElement Owosso_Text_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[16]/div[1]/a")
    public WebElement All_Organizaton_Button_EB;


    @FindBy(xpath ="//*[@id=\"app\"]/section/div/div/div/div/h1")
    public WebElement Organization_Page_EB;



    //  Erkan_Org Logın ************************************************************************************************

    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/a[1]")
    public WebElement Login_Button_EB;

    @FindBy(xpath ="//*[@id=\"email\"]")
    public WebElement Email_Text_Box_EB;

    @FindBy(xpath ="//*[@id=\"password\"]")
    public WebElement Password_Text_Box_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/div[3]/div/div[2]/div/form/button")
    public WebElement Login_BTN_EB;



    //  Erkan_Org [US_32]***********************************************************************************************

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[1]/div/div[2]/h3")
    public WebElement Erkan_Org;

    @FindBy(xpath ="//*[@id=\"navbar\"]/div/div/a/img")
    public WebElement instulearn_Logo_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[1]")
    public WebElement Erkan_Org_Kullanici_Adi;

    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[2]/ul/li[5]/a")
    public WebElement Profile_EB;



    //  Erkan_Org [US_24] [TC_001] *************************************************************************************

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div[1]/h1")
    public WebElement Dashboard_EB;

    @FindBy(xpath ="//*[@id=\"panel-sidebar-scroll\"]/div[1]/div[2]/div/div/div/li[6]/a/span[2]")
    public WebElement Meetings_EB;

    @FindBy(xpath ="//*[@id=\"meetingCollapse\"]/ul")
    public WebElement Meetings_Collapse_EB;

    @FindBy(xpath ="//*[@id=\"meetingCollapse\"]/ul/li[1]/a")
    public WebElement My_reservation_EB;

    @FindBy(xpath ="//*[@id=\"meetingCollapse\"]/ul/li[2]/a")
    public WebElement Requests_EB;

    @FindBy(xpath ="//*[@id=\"meetingCollapse\"]/ul/li[3]/a")
    public WebElement Settings_EB;



    //  Erkan_Org [US_24] [TC_002]  ************************************************************************************

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/h2")
    public WebElement Meeting_statistics_EB;


    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[1]/div/span")
    public WebElement Open_Meetings_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[2]/div/span")
    public WebElement Total_meetings_EB ;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[3]/div/span")
    public WebElement Active_hours_EB;



    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div")
    public WebElement MyReservation_OTA_EB;



    //  Erkan_Org [US_24] [TC_003]  ************************************************************************************


    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[1]/div/span")
    public WebElement Pending_meetings_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[2]/div/span")
    public WebElement Total_meetings_Request_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[3]/div/span")
    public WebElement Sales_amount_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/section[1]/div/div/div[4]/div/span")
    public WebElement Active_hours_Request_EB;



    //  Erkan_Org [US_24] [TC_004]  ************************************************************************************


    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/section/div[1]/h2")
    public WebElement My_timesheet_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[2]/h2")
    public WebElement InPerson_meeting_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[3]/h2")
    public WebElement Group_meeting_EB;

    @FindBy(xpath ="//*[@id=\"meetingSettingFormSubmit\"]")
    public WebElement Save_Button_EB;



    //  Erkan_Org [US_24] [TC_007]  ************************************************************************************

    @FindBy(xpath ="//*[@id=\"meetingCollapse\"]/ul/li[3]/a")
    public WebElement Settings_Ktg_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[1]/div/div[1]/label")
    public WebElement Amount_Title_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[1]/div/div[1]/div/input")
    public WebElement Amount_Text_Box_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[1]/div/div[2]/label")
    public WebElement Discount_Rate_Title_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[1]/div/div[2]/div/input")
    public WebElement Discount_Txt_Box_EB;



    //  Erkan_Org [US_24] [TC_008]  ************************************************************************************


    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[2]/div/div[1]/div")
    public WebElement Available_for_In_person_meetings_RadioButton_EB;

    @FindBy(xpath ="//*[@id=\"panel_app\"]/div[2]/div[3]/form/div[3]/div/div[1]/div/label")
    public WebElement Available_for_group_meetings_RadioButton_EB;

    @FindBy(xpath ="//label[text()='Hourly Price']\n")
    public WebElement Hourly_Price_EB;

    @FindBy(xpath ="//*[@id=\"onlineGroupMeetingOptions\"]/div/div[1]/label")
    public WebElement Minimum_Students_EB;



//  Erkan_Org [US_32] [TC_001]  ****************************************************************************************

    @FindBy(xpath ="//*[@id=\"navbar\"]/div/div/a/img")
    public WebElement InstuLearnLogo_EB;

    @FindBy(xpath = "//span[contains(text(), 'Erkan_Org')]")
    public WebElement ErkanOrg_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[2]/ul/li[5]/a/span")
    public WebElement ProfileLink_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[2]/div/div[3]/div[1]/span[2]")
    public WebElement Student_EB;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[1]/span")
    public WebElement profileIcon;

    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[2]/div[2]/div[1]/span")
    public WebElement hoverTargetSpan;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/div[2]/ul/li[5]/a")
    public WebElement Profil_Link_EB;



//  Erkan_Org [US_32] [TC_002]  ****************************************************************************************

    @FindBy(xpath ="//*[text()='My Profile']")
    public WebElement My_Profile_EB;

    @FindBy(xpath ="//*[@id=\"followToggle\"]")
    public WebElement Follow_BTN_EB;



//  Erkan_Org [US_32] [TC_003]  ****************************************************************************************

    @FindBy(xpath ="//*[@id=\"app\"]/section[2]/div/div[3]/div[1]")
    public WebElement Student_List_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[2]/div/div[3]/div[2]")
    public WebElement Courses_List_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[2]/div/div[3]/div[3]")
    public WebElement Reviews_List_EB;

    @FindBy(xpath ="//*[@id=\"app\"]/section[2]/div/div[3]/div[4]")
    public WebElement Meetings_List_EB;



//  Erkan_Org [US_32] [TC_004]  ****************************************************************************************

    @FindBy(xpath ="//*[@id=\"about-tab\"]")
    public WebElement About_List_EB;

    @FindBy(xpath ="//*[@id=\"webinars-tab\"]")
    public WebElement Courses_List_2_EB;

    @FindBy(xpath ="//*[@id=\"instructors-tab\"]")
    public WebElement Instructors_List_EB;

    @FindBy(xpath ="//*[@id=\"webinars-tab\"]")
    public WebElement Articles_List_EB;

    @FindBy(xpath ="//*[@id=\"badges-tab\"]")
    public WebElement Badges_List_EB;

    @FindBy(xpath ="//*[@id=\"appointments-tab\"]")
    public WebElement Reserve_a_meeting_List_EB;




//  Erkan_Org [US_24] [TC_005]  ****************************************************************************************

    @FindBy(xpath ="//*[@id=\"mondayTimeSheet\"]/td[3]/div")
    public WebElement Uc_Nokta_EB;

    @FindBy(xpath ="//*[@id=\"mondayTimeSheet\"]/td[3]/div/div")
    public WebElement Add_Time_Button_EB;

    @FindBy(xpath ="/html/body/div[4]/div[3]/div/div[2]")
    public WebElement Clock_Picker_EB;

    @FindBy(xpath ="/html/body/div[4]/div[3]/div/div[2]/div[3]")
    public WebElement Clock_Uc_EB;

    @FindBy(xpath ="/html/body/div[4]/div[3]/div/div[3]/div[4]")
    public WebElement Clock_OnBes_EB ;

    @FindBy(xpath ="/html/body/div[4]/div[3]/div/div[2]/div[4]")
    public WebElement Clock_Dort_EB;

    @FindBy(xpath ="/html/body/div[4]/div[3]/div/div[3]/div[5]")
    public WebElement Clock_Yirmi_EB;

    @FindBy(xpath ="//*[@id=\"swal2-content\"]/div/div[1]/div[2]/div/div[2]")
    public WebElement Saat_Gosterge_Erkan;

    @FindBy(xpath ="//*[@id=\"swal2-content\"]/div/div[3]/textarea")
    public WebElement Description_Text_Box_EB;

    @FindBy(xpath ="//*[@id=\"saveTime\"]")
    public WebElement Save_Button_Saat_EB;


    @FindBy(xpath ="//*[@id=\"mondayTimeSheet\"]/td[2]/div/span[1]/text()")
    public WebElement Duzenlenen_Saat_EB;

//  Erkan_Org [US_24] [TC_006]  ****************************************************************************************

    @FindBy(xpath ="//*[@id=\"swal2-content\"]/div/div[1]/div[2]/div/div[1]")
    public WebElement AM_PM_Radio_BTN_EB;

//  Erkan_Org [US_32] [TC_003]  ****************************************************************************************

    @FindBy(xpath ="//*[@id=\"app\"]/section[2]/div/div[1]/div[1]/div[1]/img")
    public WebElement Erkan_IMG_EB;



































}











