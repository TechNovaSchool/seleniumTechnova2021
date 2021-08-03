package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstAutomation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //this line set up a driver for a specified browser

        WebDriver driver = new ChromeDriver(); // instantiatng new web-driver

        driver.get("https://www.google.com/");  // navigate to the webpage
        //adding more navigations

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().to("https://www.carmax.com/cars");


    }
}
