package testNG;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestDriver {

    @Test
    public void testMyDriver(){

        Driver.getDriver().get("https://www.amazon.com/");
        Driver.quitDriver();
    }
}
