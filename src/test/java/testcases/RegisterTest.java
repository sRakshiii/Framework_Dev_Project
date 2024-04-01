package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import testbases.WebTestBase;

public class RegisterTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    RegisterPage registerPage;
    RegisterTest(){
        super();
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        myAccountPage=new MyAccountPage();
        registerPage=new RegisterPage();
    }

    @Test(description = "Verify register here link with valid username and  valid password")
    public void verifyRegisterHereLinkWithValidUsernameAndValidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        registerPage.clickOnRegisterLink();
        registerPage.setRegisterData(prop.getProperty("registerUsername"), prop.getProperty("registerPassword"));
        softAssert.assertEquals(registerPage.getTextOfRegisterPage(),"REGISTER", "user landed to register Page");
        softAssert.assertAll();
    }

    @Test(description = "Verify register here link with Existing username and password")
    public void verifyRegisterHereLinkWithExistingInputData(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        registerPage.clickOnRegisterLink();
        registerPage.setRegisterData(prop.getProperty("userName"), prop.getProperty("password"));
        softAssert.assertEquals(registerPage.getTextOfAccountAlreadyExistError(),"Error:", "Account Already Exist");
        softAssert.assertAll();
    }

    @Test(description = "Verify register here link with valid username and  Invalid password")
    public void verifyRegisterHereLinkWithValidUsernameAndInValidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        registerPage.clickOnRegisterLink();
        registerPage.setRegisterData(prop.getProperty("userName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(registerPage.getTextOfRegisterPage(),"REGISTER","user Landed to resgister page");
        softAssert.assertAll();
    }

    @Test(description = "Verify register here link with Invalid username and  valid password")
    public void verifyRegisterHereLinkWithInvalidUsernameAndValidPassword(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        registerPage.clickOnRegisterLink();
        registerPage.setRegisterData(prop.getProperty("invalidUsername"), prop.getProperty("password"));
        softAssert.assertEquals(registerPage.getTextOfRegisterPage(),"ERROR:");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
