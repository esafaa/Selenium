package alertsPopupsPractice;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert1= driver.switchTo().alert();
        Thread.sleep(5000);
        alert1.accept();
        Thread.sleep(5000);
        driver.quit();
    }
}
