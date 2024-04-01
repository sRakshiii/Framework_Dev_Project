package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbases.WebTestBase;

import java.time.Duration;

public class WebDriverUtil extends WebTestBase {
    public static final long IMPLICIT_WAIT = 20;
    public static final long PAGE_LOAD_TIMEOUT = 30;
    public static final long EXPLICIT_WAIT = 30;

    public static WebDriverWait webDriverWait;
    static JavascriptExecutor javascriptExecutor;
    public static void scrollByPixels() {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,500)");
    }
    public static void waitElementUntilClickable(WebElement element){
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
