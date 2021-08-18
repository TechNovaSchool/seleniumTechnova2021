package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.error.Mark;
import selenium.SmartbearMain;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EditOrders {
//    Task 1 —Delete Order
//1. Open browser and Login to smartBear

//2. Delete”
//    Mark Smith” from the list
//3. Assert it is deleted from the list
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartbearMain.loginToSmartBear(driver);
    }

    @Test
    public void deleteOrder(){

        String givenName = "Steve Johns";

        WebElement markSmith = driver.findElement(By.
                xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[.='" + givenName+ "']/../td[1]"));
        markSmith.click();

        WebElement deleteSelectedOrder = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_btnDelete\"]"));
        deleteSelectedOrder.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for(WebElement name : allNames) {
            Assert.assertFalse(name.getText().equals(givenName),"The test failed");
        }
    }
//    Task 2 — Edit order
//1. Open browser and login to SmartBear
//2. Click too edit button from the right for “Steve Johns”
//            3. Change the name to “ your favorite actor/ sport star”
//            4. Click Update
//5. Assert “your actor name” is in the list
    @Test
    public void editOrder(){
        String xpath = "//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[.='Steve Johns']/../td[13]";


        WebElement editBtn = driver.findElement(By.xpath(xpath));
        editBtn.click();

        WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        name.clear();
        name.sendKeys("Michael Jordan");

        WebElement updateBtn = driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]"));
        updateBtn.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for (WebElement names : allNames ) {
            if (names.getText().equals("Michael Jordan")) {
                Assert.assertEquals(names.getText(), "Michael Jordan", "The test fails for edit");

           }
        }

    }

//    Task 3 — Create a method called removeName()
//1. Accept two parameters: Webdriver, String name
//2. Method will remove the given name from the list of SmartBear
//3. Create a new TestNG test, and call your method
//4. Assert that your method removed the given name


    public static void removeName(WebDriver driver, String name) {
        WebElement nameBtn = driver.findElement(By.
                xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[.='" + name+ "']/../td[1]"));
        nameBtn.click();

        WebElement deleteSelectedOrder = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_btnDelete\"]"));
        deleteSelectedOrder.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for (WebElement names : allNames ) {
            System.out.println(names.getText());
            Assert.assertNotEquals(name, names.getText(), "The test fails for edit");

            }
    }

    @Test
    public void deleteName() {
        removeName(driver, "Bob Feather");

    }


}
