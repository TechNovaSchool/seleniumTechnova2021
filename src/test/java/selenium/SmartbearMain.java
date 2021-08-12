package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearMain {
    public static void main(String[] args) {
        //   1.Open  browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        loginToSmartBear(driver);


// 6. Print out count of all the links on landing page
        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        int numberOfLinks = links.size();
        if (numberOfLinks == 6){
            System.out.println("Test Pass");
        }

        else{
            System.out.println("Test Fail");
        }

// 7.Print out each link text on this page (edited)
//Loop First Method
        for (WebElement extarctLinks : links){
            System.out.println(extarctLinks.getText());
        }

////Loop Second Method


    }

    public static void loginToSmartBear( WebDriver driver ) {
        WebElement userName = driver.findElement(By.cssSelector("input[id = 'ctl00_MainContent_username']"));
        WebElement password = driver.findElement(By.cssSelector("input[id = 'ctl00_MainContent_password']"));
        WebElement signinButton = driver.findElement(By.cssSelector("input[id = 'ctl00_MainContent_login_button']"));

        userName.sendKeys("Tester");
        password.sendKeys("test");
        signinButton.click();
    }
}
