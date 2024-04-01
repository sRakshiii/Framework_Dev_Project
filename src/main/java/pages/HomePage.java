package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbases.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class HomePage extends WebTestBase {
    @FindBy(xpath = "//a[@class = 'newsletter__close newsletter__trigger']")
    WebElement closedAd;

    @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
    WebElement loginAndRegister;
    @FindBy(id = "searchsubmit")
    WebElement searchBtn;
    @FindBy(id = "s")
    WebElement searchTextBox;
    @FindBy(xpath = "//a[text()='Shop']")
    WebElement shopElementLink;

    @FindBy(xpath = "//a[text()='Terms & Conditions']")
    WebElement termsAndConditionsLink;
    @FindBy(xpath = "//h2[text()='Terms and Conditions']")
    WebElement textOfTAndCPage;
    @FindBy(xpath = "//a[text()='Contact']")
    WebElement contactLink;
    @FindBy(xpath = "//h2[text()='Contact Us']")
    WebElement contactUsTextLink;
    @FindBy(linkText = "http://www.w3.org/1999/xlink")
    WebElement addToCartLnk;
    @FindBy(xpath = "//div[text()='Sort by']")
    WebElement shopPageTextElement;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }


    public void clickOnAddToCartLink(){
        WebDriverUtil.waitElementUntilClickable(addToCartLnk);
    }
    public String getTextOfShopPageElement(){
        return WebElementUtil.getTextOfElement(shopPageTextElement);
    }

    public void clickOnContactLink(){
        WebDriverUtil.waitElementUntilClickable(contactLink);
    }
    public String getTextOfContactUsPage(){
        return   WebElementUtil.getTextOfElement(contactUsTextLink);
    }
    public void scrollByPixels(){
        WebDriverUtil.scrollByPixels();
    }
    public void clickOnTermsLink(){
        WebDriverUtil.waitElementUntilClickable(termsAndConditionsLink);
    }
    public String getTextOfTAndCPage(){
        return WebElementUtil.getTextOfElement(textOfTAndCPage);
    }
    public void closeFirstAd(){
        WebDriverUtil.waitElementUntilClickable(closedAd);
    }

    public void clickOnLoginAndRegister(){
        WebDriverUtil.waitElementUntilClickable(loginAndRegister);
    }
    public void clickOnSearchBtn(){
        WebDriverUtil.waitElementUntilClickable(searchBtn);
    }

    public void clickOnShopLink(){
        WebDriverUtil.waitElementUntilClickable(shopElementLink);
    }
}
