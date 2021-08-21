package pageObjectMoldelTest;

import Utilities.Config;
import Utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.smartBearPages.LoginPage;

public class SmartBearLoginTest {

    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void openBrowser(){
        Driver.getDriver().get(Config.getProperty("smartBearUrl"));
    }

    @Test (priority = 1)
    public void loginTest(){
        loginPage.userName.sendKeys(Config.getProperty("userName"));
        loginPage.password.sendKeys(Config.getProperty("password"));
        loginPage.loginButton.click();
        Assert.assertFalse(loginPage.errorMessage.isDisplayed(),"The error is not displayed");
    }

    /*
    1. Go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
2. Try to login with a Invalid Login
3.  Verify the message “Invalid Login or Password” is Displayed
     */
    @Test (priority = 2)
    public void loginWithInvalidUsername(){
        String invalidUsername = faker.name().username();
//        System.out.println(invalidUsername);
        loginPage.userName.sendKeys(invalidUsername);
        loginPage.password.sendKeys(Config.getProperty("password"));
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"The error is not displayed");
    }

}
