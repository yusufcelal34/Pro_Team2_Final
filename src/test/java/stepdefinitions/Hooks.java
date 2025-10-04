package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;
import utilities.LoggerHelper;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        LoggerHelper.info("=== Test Başlıyor: " + scenario.getName() + " ===");

        // Driver başlat
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LoggerHelper.info("Driver başlatıldı ve hazır.");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LoggerHelper.error("!!! Test Başarısız: " + scenario.getName());

            // Screenshot eklemek için açabilirsin
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception e) {
                LoggerHelper.error("Screenshot alınamadı: " + e.getMessage());
            }

        } else {
            LoggerHelper.info("+++ Test Başarıyla Tamamlandı: " + scenario.getName());
        }

        DriverManager.quitDriver();
        LoggerHelper.info("Driver kapatıldı.");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
