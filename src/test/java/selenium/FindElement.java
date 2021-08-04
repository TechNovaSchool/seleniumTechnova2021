package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //this line set up a driver for a specified browser

        WebDriver driver = new ChromeDriver(); // instantiating new web-driver
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");  // navigate to the webpage

//        driver.findElement(By.linkText("Store")).click();
        driver.findElement(By.name("test")). click();

//        driver.close();


    }
}
