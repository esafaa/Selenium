package parallelTesting.classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void beforeEachMethod() {

        System.out.println("----------------------");
        System.out.println("Create a chrome driver");
        System.out.println("Navigate to application");
    }

    @AfterMethod
    public void afterEachMethod() {
        System.out.println(" Kill the existing driver");
    }

    @Test
    public void loginAndLogout() throws InterruptedException {
        System.out.println("Login to application");
        Thread.sleep(5000);
        System.out.println("Logout from application");
        System.out.println("Verify login page element");
    }

    @Test
    public void loginNegative() throws InterruptedException {
        System.out.println("Login to application with invalid Data");
        Thread.sleep(5000);
        System.out.println("Verify error message");
    }

}
