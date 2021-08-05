package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayed {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement gmail = driver.findElement(By.partialLinkText("Gmail"));

        if(gmail.isDisplayed()){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }

        gmail.click();


    }
}
