package testNG;

import org.testng.annotations.Test;

public class SingeltonPracticeTest {
    @Test
    public void test(){

        String str1 = Singelton.getExample();
        String str2 = Singelton.getExample();
        System.out.println(str1);
        System.out.println(str2);

        Singelton str = new Singelton();
    }

}
