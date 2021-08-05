package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeader {

// Task #9 -- Zero Bank header verification
//1. Open Chrome browser
//2. Go to http://zero.webappsecurity.com/login.html
//3. Get attribute value of href from the "Forgot your password" link
//4. Verify attribute value contains Expcted --> "forgot-password"
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        String actualAttributeValue =driver.findElement(By.partialLinkText("Forgot")).getAttribute("href");
        String expectedValue = "forgot-password";
        if(actualAttributeValue.contains(expectedValue)){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
        driver.close();
    }
}
