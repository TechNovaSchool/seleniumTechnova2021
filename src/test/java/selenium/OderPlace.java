package selenium;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OderPlace {
    public static void main(String[] args) {
//        TC#2: Smartbear software order placing
//        1.Open   browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2.Go to  website:    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        3.Enter username: "Tester"
//        4.Enter password: "test"
//        5.Click on Login button

        SmartbearMain.loginToSmartBear(driver);

//        6.Click on Order
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();
//        7.Select familyAlbum from product, set quantity to 2
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select select = new Select(product);
        select.selectByIndex(1);

        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
//        quantity.clear();
        quantity.sendKeys(Keys.BACK_SPACE,"2");


//        8.Click to "Calculate"button
        WebElement calculateBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateBtn.click();

//        9.Fill address Info with JavaFaker
        Faker faker = new Faker();

//      •Generate: name, street, city, state, zip code

        WebElement name = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        WebElement street = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]"));
        WebElement city = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]"));
        WebElement state = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
        WebElement zipCode = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
            name.sendKeys(faker.name().firstName());
            street.sendKeys(faker.address().streetAddress());
            city.sendKeys(faker.address().city());
            state.sendKeys(faker.address().state());
            zipCode.sendKeys(faker.address().zipCode().substring(0, 5));

//        10.Click on "visa" radio button
        WebElement creditCard = driver.findElement(By.cssSelector("label[for*=\"cardList_0\"]"));
        creditCard.click();

//        11.Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-", ""));
        //set date
        WebElement date = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        date.sendKeys("08/12");
//        12.Click on "Process"
        WebElement processBtn = driver.findElement(By.xpath("//a[.='Process']"));
        processBtn.click();
//        13. Verify success message "New order has been successfully added."
        WebElement message = driver.findElement(By.xpath("//div[@class=\"buttons_process\"]/strong"));
        if(message.isDisplayed()) {
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
        driver.close();
    }

}
