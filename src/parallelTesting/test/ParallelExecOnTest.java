package parallelTesting.test;

import org.testng.annotations.*;

import javax.swing.*;

public class ParallelExecOnTest {

    long startTime;
    long endTime;

    @BeforeSuite
    public void startOfSuite() {
        startTime = System.currentTimeMillis();

    }

    @AfterSuite
    public void endOfSuite() {
        endTime = System.currentTimeMillis();
        long totalExecutionTime = endTime - startTime;
        System.out.println("The complete execution took " + totalExecutionTime + "time");
    }

    @BeforeMethod
    public void beforeEachMethod() {
        System.out.println("----------------------");
    }

    @AfterMethod
    public void afterEachMethod() {
        System.out.println(" Kill the existing driver");
    }

    @Parameters("browserName")
    @Test()
    public void methodWithChrome(String browserValue) throws InterruptedException {
        System.out.println("Create a" + browserValue + " driver");
        System.out.println("Navigate to application");
        System.out.println("login to application");
        Thread.sleep(5000);
        System.out.println("logout from application     ");
    }


}
