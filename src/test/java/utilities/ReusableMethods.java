package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    // ======== Full Page Screenshot ======== //
    public static String getScreenshot(String name) throws IOException {
        // Klasör yoksa oluştur
        String baseDir = System.getProperty("user.dir") + "/target/Screenshots";
        new File(baseDir).mkdirs();

        // Çakışmayı önlemek için zaman damgası
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Ekran görüntüsü al
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Hedef dosya
        String target = baseDir + "/" + name + "_" + date + ".png";
        File finalDestination = new File(target);

        // Kopyala
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    // ======== Window Switch ======== //
    public static void switchToWindow(String targetTitle) {
        String origin = DriverManager.getDriver().getWindowHandle();
        for (String handle : DriverManager.getDriver().getWindowHandles()) {
            DriverManager.getDriver().switchTo().window(handle);
            if (DriverManager.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        DriverManager.getDriver().switchTo().window(origin);
    }

    // ======== Hard Wait (Thread.sleep) ======== //
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // İyi pratik
        }
    }

    // ======== Explicit Wait: Visibility ======== //
    public static WebElement waitForVisibility(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ======== Explicit Wait: Clickable ======== //
    public static WebElement waitForClickability(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
