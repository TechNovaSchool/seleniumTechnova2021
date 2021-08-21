package testNG;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MultipleWindowsExample {
    @Test
    public void multipleWindowsHandle() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('http://google.com', '_blank');");
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('http://etsy.com', '_blank');");
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('http://amazon.com', '_blank');");

        String mainHandle = Driver.getDriver().getWindowHandle();
        System.out.println("Current URL:" + Driver.getDriver().getCurrentUrl());


        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainHandle)) {
                Driver.getDriver().switchTo().window(handle);
                if(Driver.getDriver().getCurrentUrl().contains("etsy")){
                    break;
                }

            }
        }

        System.out.println("Final URL:" + Driver.getDriver().getCurrentUrl());
    }
}
