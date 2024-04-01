package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbases.WebTestBase;
import util.ActionsUtil;
import util.DropDownUtil;
import util.WebDriverUtil;
import util.WebElementUtil;

public class ShopPage extends WebTestBase {
    @FindBy(xpath = "//a[text()='Shop']")
    WebElement shopLink;
    @FindBy(id = "sort")
    WebElement sortDroDown;
    @FindBy(xpath = "//option[text()='Latest']")
    WebElement selectElement;
    @FindBy(xpath = "//div[text()='Campos Superior Blend']")
    WebElement sampleProduct;
    @FindBy(xpath = "//select[@class='pa_weight']")
    WebElement selectBtn;
    @FindBy(xpath = "//div[text()='Whole Beans']")
    WebElement selectGrind;
    @FindBy(xpath = "//div[text()='Once off']")
    WebElement selectFrequency;
    @FindBy(xpath = "//div[text()=' - Add to cart']")
    WebElement addToCart;
    @FindBy(xpath = "//a[text()='Checkout']")
    WebElement checkOut;
    @FindBy(xpath = "//h3[text()='Your order']")
    WebElement yourOrderPageText;
    @FindBy(xpath = "//a[contains(@class,'filter-bar__inner__section__trigger filter__')]")
    WebElement flitersBtn;
    @FindBy(xpath = "//label[text()='Cup Of Excellence®']")
    WebElement selectFilter;
    @FindBy(xpath = "//a[text()='See 3 results']")
    WebElement seeResult;
    @FindBy(xpath = "//a[text()='Coffee']")
    WebElement shopDropDown;

    public ShopPage(){
        PageFactory.initElements(driver, this);
    }
    public void clickOnFiltersBtn(){
        WebDriverUtil.waitElementUntilClickable(flitersBtn);
        WebDriverUtil.waitElementUntilClickable(selectFilter);
        WebDriverUtil.waitElementUntilClickable(seeResult);
    }
    public void clickOnShopLink(){
        WebDriverUtil.waitElementUntilClickable(shopLink);
    }
    public void sampleProductSelect(){
        WebDriverUtil.waitElementUntilClickable(sampleProduct);
    }
    public void selectWeightFromDropDown(){
        WebDriverUtil.waitElementUntilClickable(selectBtn);
        DropDownUtil.dropDownElement("500g", selectBtn);
    }
    public void ShopProducts(){
        WebDriverUtil.waitElementUntilClickable(selectGrind);
        WebDriverUtil.waitElementUntilClickable(addToCart);
        WebDriverUtil.waitElementUntilClickable(checkOut);
    }
    public String grtTextOfYourOrderPage(){
        return WebElementUtil.getTextOfElement(yourOrderPageText);
    }
    public void clickOnDropDown(){
        WebDriverUtil.waitElementUntilClickable(sortDroDown);
    }
    public void selectDropDown(){
        WebDriverUtil.waitElementUntilClickable(sortDroDown);
        DropDownUtil.dropDownElement("Latest" , sortDroDown);
    }
    public void MoveToShopElement(){
        ActionsUtil.MoveToElement(shopLink);
    }
    public void clickOnShopDropDown(){
        WebDriverUtil.waitElementUntilClickable(shopDropDown);
    }
    public String getTextOfSelectedElement(){
        return WebElementUtil.getTextOfElement(shopLink);
    }

}
