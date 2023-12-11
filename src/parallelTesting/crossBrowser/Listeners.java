package parallelTesting.crossBrowser;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility.LocalBrowserManager;
import utility.LocalDriverManager;

public class Listeners implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        Reporter.log("beforeInvocation: "+ testResult.getTestClass().getName() + " => "
        +method.getTestMethod().getMethodName());

        if (method.isTestMethod()){
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = LocalBrowserManager.createBrowser(browserName);
            LocalDriverManager.setWebDriverDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult){

        Reporter.log("afterInvocation: "+ testResult.getTestClass().getName()+ " => "
        +method.getTestMethod().getMethodName());

        if (method.isTestMethod()){
            WebDriver driver =LocalDriverManager.getDriver();
            if (driver != null){
                driver.quit();
            }
        }
    }

}
