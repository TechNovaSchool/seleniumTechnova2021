package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UltimateQATask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().refresh();

        driver.get("https://ultimateqa.com/complicated-page");

        WebElement name = driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']"));
        name.sendKeys("Andrew");

        WebElement email = driver.findElement(By.cssSelector("#et_pb_contact_email_0"));
        email.sendKeys("test@gmail.com");

        WebElement text = driver.findElement(By.id("et_pb_contact_message_0"));

        text.sendKeys("Text to fill the box");

        WebElement twoNumbers = driver.findElement(By.xpath("(//p[@class='clearfix']/span)[1]"));
        WebElement sumOfTwoNumbers = driver.findElement(By.xpath("(//input[@class='input et_pb_contact_captcha'])[1]"));
        WebElement submitButton = driver.findElement(By.xpath("(//button[. = 'Submit'])[1]"));

        String myNumbers = twoNumbers.getText();

        int firstSpace = myNumbers.indexOf(" ");
        int plusSign = myNumbers.indexOf("+");
        String firstNumber = myNumbers.substring(0, firstSpace);
        String secondNumber = myNumbers.substring(plusSign+2);


        int num1 = Integer.valueOf(firstNumber);
        int num2 = Integer.valueOf(secondNumber);
        int sum = num1 + num2;

        String sumInText = String.valueOf(sum);
        sumOfTwoNumbers.sendKeys(sumInText);
        submitButton.click();
        driver.close();
    }
}
