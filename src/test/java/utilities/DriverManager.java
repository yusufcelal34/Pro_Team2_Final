package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.getProperty("browser");
            if (browser == null) browser = "chrome";
            browser = browser.toLowerCase().trim();

            switch (browser) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--start-maximized");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                }
                case "edge": {
                    System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver.set(new EdgeDriver(edgeOptions));
                    break;
                }
                case "opera": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions operaOptions = new ChromeOptions();
                    operaOptions.setBinary("C:\\Program Files\\Opera\\launcher.exe");
                    operaOptions.addArguments("--remote-allow-origins=*");
                    operaOptions.addArguments("--start-maximized");
                    driver.set(new ChromeDriver(operaOptions));
                    break;
                }
                case "brave": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions braveOptions = new ChromeOptions();
                    braveOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
                    braveOptions.addArguments("--remote-allow-origins=*");
                    braveOptions.addArguments("--start-maximized");
                    driver.set(new ChromeDriver(braveOptions));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Desteklenmeyen tarayıcı: " + browser);
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
