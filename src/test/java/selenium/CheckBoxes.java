package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement genderOther = driver.findElement(By.xpath("//input[@value='other']"));
        boolean selected = genderOther.isSelected(); //will return false

        if (!selected) {
            System.out.println("Test 1 Pass");
        }
        else {
            System.out.println("Test 1 Fails");
        }

        genderOther.click();
        Thread.sleep(2000);

        boolean selectedYes = genderOther.isSelected();

        if (selectedYes) {
            System.out.println("Test 2 Pass");
        }
        else {
            System.out.println("Test 2 Fails");
        }

//        String xpath = "//input[@value='" + "Bike" +"']";

        WebElement bike = driver.findElement(By.xpath("//input[@value=\"Bike\"]"));
        WebElement car = driver.findElement(By.xpath("//input[@value=\"Car\"]"));

        if(bike.isEnabled() && car.isEnabled()) {
            System.out.println("Test 3 Pass");
        } else{
            System.out.println("Test 3 Fail");
        }

        bike.click();
        car.click();

        if(bike.isEnabled() && car.isEnabled()) {
            System.out.println("Test 4 Pass");
        } else{
            System.out.println("Test 4 Fail");
        }


    }
}
