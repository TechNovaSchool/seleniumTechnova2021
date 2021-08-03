package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTitle {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");

        driver.getTitle(); // is a method to get the webpage title
        // it will return a string
        System.out.println(driver.getTitle());

        driver.getCurrentUrl(); // will return URL address
        System.out.println(driver.getCurrentUrl());

    }
}
