package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
 Create a new class called : WindowHandlePractice
Create new test and create setUps
Go to https://the-internet.herokuapp.com/windows
Assert title is “The Internet”
Click on “Click Here” text
Switch to the new Window
Assert:Title is “New Window”
 */

public class WindowHandles {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void windowHandleTest() throws InterruptedException {
        String mainHandle = driver.getWindowHandle();
        String expectedTile = "The Internet";
        String actualTile = driver.getTitle();

        Assert.assertEquals(actualTile, expectedTile,"The title is incorrect");

        WebElement clickHereText = driver.findElement(By.linkText("Click Here"));
        clickHereText.click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainHandle)) {
                driver.switchTo().window(handle);
            }
        }

        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());





    }

}
