package pageObjectMoldelTest;

import Utilities.Config;
import Utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
    }

    /*
    1. Go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
2. Try to login with a Invalid Login
3.  Verify the message “Invalid Login or Password” is Displayed

Task — Wrong password
1. Go to SmartBear login page
2. Try to login with a wrong password
3. Verify the message “Invalid Login or Password” is Displayed

Task — NO username
1. Go to SmartBear login page
2. Try to login with no username
3. Verify the message “Invalid Login or Password” is Displayed

Task — NO password

1.  Go to SmartBear login page
2. Try to login with no password
3. Verify the message “Invalid Login or Password” is Displayed
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
    @Test (priority = 3)
    public void loginWithInvalidPassword(){
        String invalidPassword = faker.internet().password();
        loginPage.userName.sendKeys(Config.getProperty("userName"));
        loginPage.password.sendKeys(invalidPassword);
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"The error is not displayed");
    }

    @Test (priority = 4)
    public void loginWithNoUserName(){
//        loginPage.userName.sendKeys("");
        loginPage.password.sendKeys(Config.getProperty("password"));
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"The error message is not displayed");
    }

    @Test (priority = 5)
    public void loginWithNoPassword(){
        loginPage.userName.sendKeys(Config.getProperty("userName"));
        loginPage.loginButton.click();

        String errorMessage = loginPage.errorMessage.getText();
        String expectedMessage = "Invalid Login or Password.";

        Assert.assertEquals(errorMessage,expectedMessage,"The message doesn't match");
    }

    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }


}
