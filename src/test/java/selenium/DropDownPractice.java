package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        WebElement dropDown = driver.findElement(By.xpath("//select"));

        Select select = new Select(dropDown);

 Select select1 = new Select(driver.findElement(By.xpath("//select")));
        select.selectByVisibleText("Audi");
        select.selectByIndex(2);
        select.selectByValue("saab");
        select.getFirstSelectedOption();
        select.getOptions();
        select1.getAllSelectedOptions();
        select.deselectAll();



    }
}
