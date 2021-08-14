package testNG;

import org.testng.annotations.*;


public class TestNGPractice {

    @Test
    public void b_firstTestNG2() {
        System.out.println("My second test");
    }

    @Test
    public void a_firstTestNG1() {
        System.out.println("My first test");
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
