package selenium;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FakerTask {
    public static void main(String[] args) {
        Faker faker=new Faker();

        String lastNameText = faker.name().lastName();
        String phoneText = faker.phoneNumber().cellPhone();
        String emailAddressText = faker.internet().emailAddress();
        String  addressText=faker.address().state();
        String  cityText= faker.address().city();
        String  stateText=faker.address().state();
        String  zipCodeText=faker.address().zipCode();
        String  usernameText=faker.name().username();
        String  passwordText =faker.internet().password();

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/register.php");


        WebElement name = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement userName = driver.findElement(By.name("userName"));
        WebElement address1 = driver.findElement(By.name("address1"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        WebElement country = driver.findElement(By.name("country"));
        name.sendKeys(faker.name().firstName());
        lastName.sendKeys(lastNameText);
        phone.sendKeys(phoneText);
        userName.sendKeys(usernameText);
        address1.sendKeys(addressText);
        city.sendKeys(cityText);
        state.sendKeys(stateText);
        postalCode.sendKeys(zipCodeText);

        Select select = new Select(country);
        select.selectByVisibleText("ARMENIA");

        email.sendKeys(emailAddressText);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(passwordText);

    }
}
