package WaitsExample;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.herokuapp.DynamicLoading1;

public class ExplicitWaitTest {
    @Test
    public void explicitWaitTest()  {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/2");
        DynamicLoading1 dynamicLoading1 = new DynamicLoading1();
        dynamicLoading1.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),8);

        wait.until(ExpectedConditions.visibilityOf(dynamicLoading1.helloText));



        String str = dynamicLoading1.helloText.getText();
        Assert.assertEquals(str, "Hello World!");

    }
}
