package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void informationAlert()  {

        WebElement infoBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoBtn.click();

        Alert alert  = driver.switchTo().alert();
        alert.accept();

        WebElement message = driver.findElement(By.id("result"));

        String expectedText = "You successfully clicked an alert";
        String actualText = message.getText();

        Assert.assertEquals(actualText,expectedText, "Test failed");
//        Assert.assertTrue(message.isDisplayed(),"Text is not displayed");
//        Assert.assertTrue(actualText.equals(expectedText),"Test failed");
        }
        @Test
        public void confirmAlert() {
            WebElement confirmBTn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
            confirmBTn.click();

            Alert alert  = driver.switchTo().alert();
            alert.accept();

            WebElement message = driver.findElement(By.id("result"));

            String text = "You clicked: Ok";
            String textReal = message.getText();

//            Assert.assertTrue(actualText.equals(expectedText), "Test fail");
//            Assert.assertTrue(message.isDisplayed(),"Test fail");
             Assert.assertEquals(textReal,text,"Test fail");
        }
    @Test
    public void promptAlert() {
        WebElement promptBTn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptBTn.click();
        String alertMsg = "Hello World";

        Alert alert  = driver.switchTo().alert();
        alert.sendKeys(alertMsg);
        alert.accept();

        WebElement message = driver.findElement(By.id("result"));

        String expected = "You entered: " + alertMsg;
        String actual = message.getText();

          Assert.assertTrue(actual.equals(expected), "Test fail");
//
    }
}
