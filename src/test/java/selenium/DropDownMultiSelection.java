package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownMultiSelection {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement multiListStates = driver.findElement(By.name("States"));

        Select select = new Select(multiListStates);
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.deselectAll();


         List<WebElement> listState = select.getOptions();
         System.out.println(listState.size());

         int count = 0;
         for (WebElement list : listState) {
             System.out.println(list.getText());
             if(list.getText().startsWith("N")) {
                 count++;
             }
         }

//        for (int i = 0; i < listState.size(); i++ ) {
//            if(listState.get(i).getText().startsWith("N")) {
//                count++;
//            }
//        }
        System.out.println(count);






    }
}
