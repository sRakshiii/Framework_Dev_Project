package testbases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.WebDriverUtil;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public Properties prop;
    public static WebDriver driver;

    public WebTestBase(){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        } catch (Exception e){
            e.printStackTrace();

        }
        prop = new Properties();
        try{
            prop.load(fileInputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/browsers/chromedriver.exe/");
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/browsers/msedgedriver.exe/");
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Please select the correct browser name");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverUtil.IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();
    }

}
