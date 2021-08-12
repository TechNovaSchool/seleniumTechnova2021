package selenium;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

public class FakerPractice {
    public static void main(String[] args) {
        Faker faker = new Faker();

        String name =  faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String city = faker.address().city();
        String state = faker.address().state();
        String phone = faker.phoneNumber().cellPhone();
        String ssn = faker.idNumber().ssnValid();
        faker.internet().emailAddress();
        faker.internet().password(5,10);
        faker.name().username();
        faker.address().zipCode();


        System.out.println(name);
        System.out.println(firstName + " " + lastName);
        System.out.println(city + ", " +state);

    }
}
