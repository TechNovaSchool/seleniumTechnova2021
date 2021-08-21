package testNG;

import Utilities.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PropertiesPractice {

    @Test
    public void practice() throws IOException {

        // 1. Create a path for connection to out file
        String path = "Configuration.properties";

        //2. We will create Properties object

        Properties properties = new Properties();

        //3. Open the file using FileInputStream

        FileInputStream file = new FileInputStream(path);

        //4. Load the properties to file into the properties object
        properties.load(file);

        //5. Read the values from the file using a method getProperty()

        System.out.println(properties.getProperty("login"));
        System.out.println(properties.getProperty("mybaseURl"));

    }

    @Test
    public void testBear() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getProperty("smartBearUrl"));

        WebElement userName = driver.findElement(By.cssSelector("input[id = 'ctl00_MainContent_username']"));
        WebElement password = driver.findElement(By.cssSelector("input[id = 'ctl00_MainContent_password']"));
        WebElement signinButton = driver.findElement(By.cssSelector("input[id = 'ctl00_MainContent_login_button']"));

        userName.sendKeys(Config.getProperty("userName"));
        password.sendKeys(Config.getProperty("password"));
        signinButton.click();

    }


}
