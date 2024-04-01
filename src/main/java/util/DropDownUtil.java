package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbases.WebTestBase;

public class DropDownUtil extends WebTestBase {
    public static Select select;
    public static void dropDownElement(int index, WebElement element){
        select = new Select(element);
        select.selectByIndex(index);
    }

    public static void dropDownElement(String visibleText, WebElement element){
        select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
    public static void dropDownByValue(String value , WebElement element){
        select = new Select(element);
        select.selectByValue(value);
    }
    public static void dropDownElementVisibleText(String visibleWithText, WebElement element){
        select = new Select(element);
        select.deselectByVisibleText(visibleWithText);
    }
}
