package testNG;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGPractice {

    @Test
    public void b_firstTestNG2() {
        System.out.println("My second test");
        Assert.assertEquals(12,12,"numbers are different"); //int vs int

    }

    @Test
    public void a_firstTestNG1() {
        System.out.println("My first test");

//        if(actualTitle.contains(expectedTitle)){
//            System.out.println("Pass");
//        }
//        else {
//            System.out.println("Fail");
//        if("test".equals("test")) {
//            System.out.println("test pass");
//        }
//        else {
//            System.out.println("Test Fail");!
//        }
        boolean display = true;
        Assert.assertEquals("test","test","values are different"); // string vs string
        Assert.assertEquals(12,12); //int vs int
        Assert.assertTrue("test".equals("test"));// check if the value is true

        Assert.assertFalse("test".equals("tes12t"), "message for false");// check if the value is false
        Assert.assertTrue("test".contains("test2"), "test1");

   }

    @BeforeClass
    public void myThirdTestNG3() {
        System.out.println("My before class");
    }

    @BeforeMethod
    public void my4TestNG()  {
        System.out.println("My before method");
    }
    @AfterMethod
    public void my5TestNG() {
        System.out.println("My after method");
    }

    @AfterClass
    public void my6TestNG() {
        System.out.println("My after class");
    }

}
