package LoginMethod;

import org.apache.hc.core5.http.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Ramazan;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.JSUtilities;
import utilities.WaitHelper;

public class LoginPage {

    // Login methodu
    public static void loginAs() {
        DriverManager.getDriver().get(ConfigReader.getProperty("instuLearnUrl"));     // sayfaya git
        WaitHelper.bekle(1);// 1 saniye bekle
        Ramazan ramazan=new Ramazan();
        ramazan.loginButon.click();                      // Header'daki login button
        WaitHelper.bekle(1);
        String email1=ConfigReader.getProperty("emailRamazan");
        String password1=ConfigReader.getProperty("passWordRamazan");
        //passWordRamazan



        ramazan.emailTextBox.sendKeys(email1);                   // email yaz
        ramazan.passWordTextBox.sendKeys( password1);// password yaz
        WaitHelper.bekle(3);
        JSUtilities.scrollToElement(DriverManager.getDriver(),ramazan.LoginButton_Under_emailandPassword);    // login button altına scroll
        WaitHelper.bekle(2);
        JSUtilities.clickWithJS(DriverManager.getDriver(),ramazan.LoginButton_Under_emailandPassword);     // login button'a tıkla
    }
}
