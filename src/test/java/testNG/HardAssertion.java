package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertion {
    SoftAssert softAssert;

    @Test
    public void hardAssertion(){
        System.out.println("This is a HARD assertion");
        Assert.assertEquals(1,1,"This hard assertion failed");
        System.out.println("Test one is running");
    }

    @Test
    public void softAssertions() {
        System.out.println("Test for soft assert is running");
        softAssert = new SoftAssert();
        softAssert.assertEquals(3,5,"This soft assert failed");
        System.out.println("Test one is running");
        softAssert.assertTrue(false);
        System.out.println("Test for assert true");
    }

    @AfterMethod
    public void tearDown(){
        softAssert.assertAll();
    }

}
