package testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority {
//    @Test (priority = 0)
//    public void thirdTest() {
//        System.out.println("My third test");
//    }


    @Test (priority = 0, dependsOnMethods = "secondTest")
    public void firstTest() {
        System.out.println("My first test");
    }

    @Test (priority = 1)
    public void secondTest() {
        System.out.println("My second test");
    }



}
