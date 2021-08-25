package WaitsExample;

import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.herokuapp.DynamicLoading1;

public class ImplicitWait {

    @Test
    public void implicitWaitTest()  {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/2");
        DynamicLoading1 dynamicLoading1 = new DynamicLoading1();
        dynamicLoading1.startButton.click();

        String str = dynamicLoading1.helloText.getText();
        Assert.assertEquals(str, "Hello World!");

    }
}
