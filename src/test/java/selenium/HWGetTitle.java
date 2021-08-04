package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class HWGetTitle {
    /////   Home Work
//               Task # 1
        public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
//            driver.manage().window().fullscreen();
            driver.get("https://www.google.com");

            String acutalTitle = driver.getTitle();
            String expectedTitle = "Google";

            if (acutalTitle.equals(expectedTitle)){
                System.out.println("Test Pass");
            }else{
                System.out.println("Test Fail");
            }
            //////   Task # 2
            driver.get(" https://www.technovaschool.com/");
            String technova = driver.getCurrentUrl().toLowerCase();
            String expectedUrl = "technovaschool";


                if (technova.contains(expectedUrl)){
                    System.out.println(true + " The URL of the web  has technova school");
                }
                else {
                    System.out.println("Test Failed different url");
            }

            String tech = driver.getTitle();
            if (tech.equals("IT School Online | Tech Nova School")){
                System.out.println(true + " The title name is correct for Tech Nova School");
            }else{
                System.out.println(false);
            }

            driver.close();
        }
    }
