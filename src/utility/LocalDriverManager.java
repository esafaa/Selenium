package utility;

import org.openqa.selenium.WebDriver;

public class LocalDriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriverDriver(WebDriver driver) {
        webDriver.set(driver);
    }


}
