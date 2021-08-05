package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByID {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      driver.get("https://www.etsy.com");
//        driver.get("https://www.google.com");

//     driver.findElement(By.id("global-enhancements-search-query"))
//               .sendKeys("lighters");
//     driver.findElement(By.className("spch-dlg")).click();

       String header = driver.findElement(By.tagName("h1")).getText();
        System.out.println(header);

        driver.findElement(By.className("wt-flex-shrink-xs-0")).click();



    }
}
