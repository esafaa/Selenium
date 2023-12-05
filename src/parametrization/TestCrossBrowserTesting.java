package parametrization;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utility.LocalBrowserManager;

public class TestCrossBrowserTesting {
    WebDriver driver;


    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserValue) {
        driver = LocalBrowserManager.createBrowser(browserValue);
    }


    @Test
    public void printTitleForBestBuy() {
        driver.get("https://bestbuy.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void printTitleForAmazon() {
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void printTitleForFacebook() {
        driver.get("https://facebook.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
