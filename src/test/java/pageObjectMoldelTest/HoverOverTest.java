package pageObjectMoldelTest;

import Utilities.Driver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.herokuapp.HoverOverPage;

import javax.swing.*;

public class HoverOverTest {

    /*
    1. Go to https://the-internet.herokuapp.com/hovers
2. Hover over to first image
3. Assert: “name: user1” is displayed
4. Hover over to second image
5. Assert:  “name: user2” is displayed
6. Hover over to third image
7. Confirm: “name: user3” is displayed
     */

    HoverOverPage hoverOverPage = new HoverOverPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hoverOver() {
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(hoverOverPage.avatar1).perform();
        Assert.assertTrue(hoverOverPage.name1.isDisplayed());

        actions.moveToElement(hoverOverPage.avatar2).perform();
        Assert.assertTrue(hoverOverPage.name2.isDisplayed());

        actions.moveToElement(hoverOverPage.avatar3).perform();
        Assert.assertTrue(hoverOverPage.name3.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }
}
