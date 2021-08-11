package selenium;

import com.google.common.base.Verify;
import com.sun.tools.javac.comp.Check;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomeWorkSeleniumEasyWebsite {
    public static void main(String[] args) {
//        Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

//        Verify “Check All” button text is “Check All”
       WebElement checkAllBtn = driver.findElement(By.id("check1"));

        String textCheckAll = checkAllBtn.getAttribute("value");
        String expectedButtonText = "Check All";

        if (textCheckAll.equals(expectedButtonText)) {
            System.out.println("Test Pass");
        }

        else {
            System.out.println("Test Fail");
        }


//        Click to “Check All” button
        checkAllBtn.click();

//        Verify all check-boxes are checked
         WebElement option1 = driver.findElement(By.xpath("(//input[@class=\"cb1-element\"])[1]"));
         WebElement option2 = driver.findElement(By.xpath("(//input[@class=\"cb1-element\"])[2]"));
         WebElement option3 = driver.findElement(By.xpath("(//input[@class=\"cb1-element\"])[3]"));
         WebElement option4 = driver.findElement(By.xpath("(//input[@class=\"cb1-element\"])[4]"));

         if (option1.isSelected() && option2.isSelected() && option3.isSelected() && option4.isSelected()) {
             System.out.println("Test Pass");
         }
         else {
             System.out.println("Test failed");
         }


//        Verify button text changed to “Uncheck All”
        String textUnCheckAll = checkAllBtn.getAttribute("value");
         String textUnCheckAllText = "Uncheck All";

        if (textUnCheckAll.equals(textUnCheckAllText)) {
            System.out.println("Test Pass");
        }

        else {
            System.out.println("Test Fail");
        }


    }
}
