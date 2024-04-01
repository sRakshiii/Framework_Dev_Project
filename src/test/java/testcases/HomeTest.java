package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ShopPage;
import testbases.WebTestBase;

public class HomeTest extends WebTestBase {
    HomePage homePage;
    ShopPage shopPage;
    HomeTest(){
        super();
    }
    @BeforeMethod()
    public void preRequisite(){
        initialization();
        homePage=new HomePage();
        shopPage=new ShopPage();
    }
    @Test(description = "verify add to cart link on Home page")
    public  void verifyAddToCartLink(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnAddToCartLink();
        softAssert.assertEquals(homePage.getTextOfShopPageElement(),"SORT BY");
        softAssert.assertAll();
    }

    @Test(description = "verify User is able to click on shop link")
    public void  verifyShopLink(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnShopLink();
        softAssert.assertEquals(shopPage.getTextOfSelectedElement(),"SHOP");
        softAssert.assertAll();
    }

    @Test(description = "verify Terms And Conditions Link")
    public void verifyTermsAndConditionsLink(){
        SoftAssert softAssert= new SoftAssert();
        // homePage.closeFirstAd();
        homePage.clickOnTermsLink();
        softAssert.assertEquals(homePage.getTextOfTAndCPage(),"");
        softAssert.assertAll();
    }
    @Test(description = "verify contact link on homepage")
    public void verifyContactLink(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnContactLink();
        softAssert.assertEquals(homePage.getTextOfContactUsPage(),"CONTACT US");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
