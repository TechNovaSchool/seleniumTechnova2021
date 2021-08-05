package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class HerokuAppUrl {
    public static void main(String[] args) {
//        Task #8 HerokuApp Url verification
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        2. Go to https://the-internet.herokuapp.com/forgot_password
        driver.get("https://the-internet.herokuapp.com/forgot_password");

//        3. Enter any email into input box
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
//        4. Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();
//        5. Verify URL contains Expected : -->  "email_sent"

        String actualHeader = driver.findElement(By.tagName("h1")).getText();
        String expectedHeader = "Internal Server Error";

        if(actualHeader.equals(expectedHeader)){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
}
