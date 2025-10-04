package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"}, // GEREKİRSE: {"stepdefinitions","hooks"} yap
        plugin = {
                "pretty",
                "html:reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true,
        tags = "@yusuf38"

)
public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    @BeforeClass
    public static void setup() {
        logger.info("Cucumber Test Runner başlatılıyor...");

        // Önce Chrome, sonra Firefox için çalıştırma
        String[] browsers = {"chrome", "firefox"};
        for (String browser : browsers) {
            logger.info(">> Tarayıcı başlatılıyor: " + browser);
            System.setProperty("BROWSER", browser);
            // Burada DriverManager.getDriver() browser değerini System property'den okuyacak
        }
    }
}
