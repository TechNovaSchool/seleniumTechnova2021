package WaitsExample;

import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.herokuapp.DynamicLoading1;

public class UsingThreadToSleep {

    @Test
    public void threadSleep() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicLoading1 dynamicLoading1 = new DynamicLoading1();
        dynamicLoading1.startButton.click();
        Thread.sleep(10000);
        String str =  dynamicLoading1.helloText.getText();
        Assert.assertTrue(str.equals("Hello World!"));

    }

}
