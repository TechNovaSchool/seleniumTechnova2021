package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.ThemeReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TechNovaLinks {
    public static void main(String[] args) throws InterruptedException {
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        2. Go to https://www.technovaschool.com/
        driver.get("https://www.technovaschool.com/");
        Thread.sleep(8000);


//        3. Count the number of the links on the web-page (expected 41)
        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        int numLinks = links.size();
        System.out.println(numLinks);
        if (numLinks == 41) {
            System.out.println("Test Pass");
        }
        else    {
            System.out.println("Test Fails");
        }
//        4. Print out all the texts of the links on the page
        for(WebElement link :links) {
//            System.out.println(link.getText());
        }

//        5. Count the number of the links that doesn't have text (expected 19)
        int counter = 0;

        for(WebElement link :links) {
            if (link.getText().isEmpty()) {
                counter++;
            }
        }
        if (counter == 19) {
            System.out.println("Test Pass");
        }
        else    {
            System.out.println("Test Fails");
        }
    }
}
