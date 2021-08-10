package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCss {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        1. Open a chrome browser
        //        2. Go to amazon.com

        driver.get("https://www.amazon.com");

        String [] array = {"alexa","iphone"};
//        3. Enter any search term
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        searchBox.sendKeys(array[1]);
//        4. Click on search button
         WebElement searchBtn = driver.findElement(By.cssSelector("input[value='Go']"));
         searchBtn.click();



        String actualTitle = driver.getTitle();

        String expectedTitle = "alexa";


        if(actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");

        }
        driver.close();

//        5. Verify title

    }
}
