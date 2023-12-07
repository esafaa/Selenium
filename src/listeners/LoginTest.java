package listeners;

import org.testng.Assert;
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
    public void loginByEmail(){
        String emailExpected= "safaa@gmail.com";
        System.out.println("Login by Email");
        Assert.assertEquals("safaa@gmail.com",emailExpected); // true
    }
    @Test
    public void loginByFacebook(){
        String usernameExpected= "Safaa";
        System.out.println("Login by Email");
        Assert.assertEquals("safa",usernameExpected); // true
    }
}
