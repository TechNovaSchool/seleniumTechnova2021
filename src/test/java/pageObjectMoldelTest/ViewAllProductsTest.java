package pageObjectMoldelTest;

import Utilities.Config;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.smartBearPages.LoginPage;
import pages.smartBearPages.ViewAllOrdersPage;

public class ViewAllProductsTest {

    /*
    Login to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
Navigate to "View all products"
Locate the : header and first row elements in a WebElements page
Create a test page
Add the test to assert the text of header is displayed
Add another test to assert the first row elements have correct text
     */

    LoginPage loginPage = new LoginPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();


    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("smartBearUrl"));
    }

    @Test
    public void checkProducts(){
        loginPage.userName.sendKeys(Config.getProperty("userName"));
        loginPage.password.sendKeys(Config.getProperty("password"));
        loginPage.loginButton.click();

        viewAllOrdersPage.viewProducts.click();

        Assert.assertTrue(viewAllOrdersPage.header.isDisplayed(),"The header is not displayed");
        Assert.assertEquals(viewAllOrdersPage.productMoney.getText(), "MyMoney", "The product name is different");

        String price = viewAllOrdersPage.price.getText().replace("$","");
        String discount = viewAllOrdersPage.discount.getText().substring(0,1);

        int priceNumber = Integer.parseInt(price);
        int procentNumber = Integer.parseInt(discount);

        int totalDiscountAmount = procentNumber * priceNumber/100;

        System.out.println(procentNumber);
        System.out.println(priceNumber);

        Assert.assertEquals(totalDiscountAmount, 8,"The discount amount is not wrong");
    }

    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }

}
