package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbases.WebTestBase;

public class LoginTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginTest(){
        super();
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "verify login with valid username and valid password")
    public void verifyLoginWithValidUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getMyAccountElement(), "MY ACCOUNT", "MY ACCOUNT text should be match");
        softAssert.assertAll();
    }

    @Test(description = "verify login with invalid username and valid password")
    public void verifyLoginWithInValidUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("invalidUsername"), prop.getProperty("password"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR" , "error message should be matched");
        softAssert.assertAll();
    }

    @Test(description = "verify login with valid username and invalid password")
    public void verifyLoginWithValidUserNameAndInValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR" , "error message should be matched");
        softAssert.assertAll();
    }

    @Test(description = "verify login with invalid username and invalid password")
    public void verifyLoginWithInValidUserNameAndInValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("invalidUserName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR" , "error message should be matched");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
