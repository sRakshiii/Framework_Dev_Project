package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbases.WebTestBase;

import java.time.Duration;

public class ActionsUtil extends WebTestBase {
    public static Actions actions;

    public static  void MoveToElement(WebElement element){
        actions=new Actions(driver);
        actions.moveToElement(element)
                .pause(Duration.ofSeconds(4))
                .perform();
    }
}
