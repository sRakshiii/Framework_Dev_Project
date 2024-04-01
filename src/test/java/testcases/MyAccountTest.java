package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbases.WebTestBase;

public class MyAccountTest extends WebTestBase {
    HomePage homePage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;

    MyAccountTest(){
        super();
    }
    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        loginPage=new LoginPage();
    }

    @Test(description = "Verify user is able to see user's Orders")
    public void verifyOrdersOnTooltip(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getTextOrderLink(),"ORDERS","user landed to the orders page");
        softAssert.assertAll();
    }
    @Test(description = "Verify user is able to see click browse product link")
    public void verifyBrowseOrdersLinkOnTooltip(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("password"));
        myAccountPage.clickOnOrdersInToolTip();
        softAssert.assertEquals(myAccountPage.getTextBrowseProductLink(), "BROWSE PRODUCTS", "user able to browse product");
        softAssert.assertAll();
    }
    @Test(description = "verify remember me checkbox is enable")
    public void verifyCheckboxIsEnabled(){
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        SoftAssert softAssert=new SoftAssert();
        myAccountPage.rememberMeBoxIsEnabled();
        softAssert.assertEquals(myAccountPage.getTextOfLoginPage(),"LOG IN");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
