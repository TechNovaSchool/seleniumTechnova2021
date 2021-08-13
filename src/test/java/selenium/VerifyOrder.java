package selenium;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VerifyOrder {
    public static void main(String[] args) {

//
//        1. Open browser and login to smartbear software
//        2. Click on view all orders
//        Verify Susan McLaren has order on date “01/05/2010”
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
        SmartbearMain.loginToSmartBear(driver);

        WebElement date = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));

        String expectedDate = "01/05/2010";
        String actualDate = date.getText();

        if (expectedDate.equals(actualDate)) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

    }
}
