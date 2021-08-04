package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskGmail {
    public static void main(String[] args) {


// 1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//2. Go to https://google.com
        driver.get("https://google.com");
//3. Click Gmail from top right
        driver.findElement(By.linkText("Gmail")).click();
//4. Verify element contains Expected <Gmail> Skipped

//5. Go back to Google by using back() command
        driver.navigate().back();

//6. Verify title contains "Google"
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
//7. Go back to Gmail using forward button
        driver.navigate().forward();
//8. Verify title contains Expected Gmail
        String expectedTitleEMail = "Gmail";
        String actualTitleEMail = driver.getTitle();
        if(actualTitleEMail.contains(expectedTitleEMail)){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
        driver.close();
    }
}
