package util;

import org.openqa.selenium.WebElement;
import testbases.WebTestBase;

public class WebElementUtil extends WebTestBase {
    public static void clickOnElement(WebElement element){
        element.click();
    }
    public static void sendKeyOnElement(WebElement element, String text){
        element.sendKeys(text);
    }
    public static void elementIsEnabled(WebElement element){
        element.isEnabled();
    }
    public static void elementIsSelected(WebElement element){
        element.isSelected();
    }
    public static String getTextOfElement(WebElement webElement){
        return webElement.getText();

    }
}
