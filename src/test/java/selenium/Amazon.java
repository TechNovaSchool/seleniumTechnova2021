package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Amazon {
    public static void main(String[] args) {
        //Task 10
        //1. Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to amazon.com
        driver.get("https://www.amazon.com/");

        //3. Enter any search term
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Lighter");

        //4. Click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();

        //5. Verify "All" option is displayed();
        WebElement allDropDown = driver.findElement(
                By.partialLinkText("All"));

        boolean displayed = allDropDown.isDisplayed();

        if (displayed) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }
        driver.close();

    }
}
