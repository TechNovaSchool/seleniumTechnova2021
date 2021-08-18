package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.SmartbearMain;

import java.util.concurrent.TimeUnit;

public class DeleteAll {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @Test
    public void deleteAllTest()  {
//        Open a chrome browser
//        Go to :http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//        Enter username : “Tester”
//        Enter password: “test”
//        Click on logon button
        SmartbearMain.loginToSmartBear(driver);
      //  Click checkAll
        WebElement checkAllBTn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllBTn.click();

        WebElement deleteAllBtn = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
//        Click “Delete Selected”
        deleteAllBtn.click();
        WebElement oderMessage = driver.findElement(By.id("ctl00_MainContent_orderMessage"));
//        Assert “List of orders is empty. In order to add new order use this link.” text is displayed
        Assert.assertTrue(oderMessage.isDisplayed(),"message is not displayed");
    }
}
