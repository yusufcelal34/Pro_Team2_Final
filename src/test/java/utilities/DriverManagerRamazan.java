package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerRamazan {

        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static WebDriver getDriver(String browser) {
            if (driver.get() == null) {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver.set(new FirefoxDriver());
                        break;
                    default:
                        throw new IllegalArgumentException("Desteklenmeyen browser: " + browser);
                }

                // ✅ Ekran konumlandırma (1920x1080 için 3 pencere yan yana)
                WebDriver drv = driver.get();
                drv.manage().window().setSize(new Dimension(640, 1080));

                int threadIndex = (int) (Thread.currentThread().getId() % 3);
                switch (threadIndex) {
                    case 0:
                        drv.manage().window().setPosition(new Point(0, 0));
                        break;
                    case 1:
                        drv.manage().window().setPosition(new Point(640, 0));
                        break;
                    case 2:
                        drv.manage().window().setPosition(new Point(1280, 0));
                        break;
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



    // Mevcut driver varsa kapat ve ThreadLoc
