package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbases.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class RegisterPage extends WebTestBase {
    @FindBy(xpath = "//a[text()='Click here']")
    WebElement registerLink;
    @FindBy(xpath = "//h2[text()='Register']")
    WebElement registerPageText;
    @FindBy(id = "reg_email")
    WebElement emailUserNameTextBox;
    @FindBy(id = "reg_password")
    WebElement passwordTextBox;
    @FindBy(name = "register")
    WebElement registerBtn;
    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement accountAlreadyExistError;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }
    public void setRegisterData(String userName , String password) {
        WebElementUtil.sendKeyOnElement(emailUserNameTextBox , userName);
        WebElementUtil.sendKeyOnElement(passwordTextBox , password);
        WebDriverUtil.waitElementUntilClickable(registerBtn);
    }

    public void clickOnRegisterLink(){
        WebElementUtil.clickOnElement(registerLink);
    }
    public String getTextOfRegisterPage(){
        return WebElementUtil.getTextOfElement(registerPageText);
    }
    public String getTextOfAccountAlreadyExistError(){
        return  WebElementUtil.getTextOfElement(accountAlreadyExistError);
    }
}
