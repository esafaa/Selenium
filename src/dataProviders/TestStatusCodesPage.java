package dataProviders;

import dataProviders.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestStatusCodesPage {


    WebDriver driver;

    @BeforeMethod
    public void beforeEachMethode() {
        System.out.println("-------------------");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

    }


    @AfterMethod
    public void afterEachMethod() {
        driver.quit();
    }

    /**
     * Validation of status code and respectve message
     * 200, This page returned a 200 status code
     * 300, This page returned a 300 status code
     * 400, This page returned a 400 status code
     * 500, This page returned a 500 status code
     */

    @Test(dataProvider = "statusCodes", dataProviderClass = TestData.class)
    public void statusCodeValidation(String statusCode, String expectedMessage) throws InterruptedException {
       // String statusCode = "200";
        //String expectedMessage = "This page returned a 200 status code.";
        String xpath = "//*[text()='" + statusCode + "']";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
        String messageInUI = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
        Assert.assertTrue(messageInUI.contains(expectedMessage), "Wrong message for status code " + statusCode);

    }


}
