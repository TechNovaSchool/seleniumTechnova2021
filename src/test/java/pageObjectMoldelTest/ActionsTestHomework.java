package pageObjectMoldelTest;

import Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actionsClassHomeworkPage.DoubleClickPage;
import pages.actionsClassHomeworkPage.TelerikPage;

public class ActionsTestHomework {

    /*
    1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”
     */

    DoubleClickPage doubleClickPage = new DoubleClickPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 8);
    TelerikPage telerikPage = new TelerikPage();


    @Test
    public void doubleClick(){
        //DoubleClickTest
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        //2. Switch to iframe.
        //3. Double click on the text "Double-click me to change my text color."
        //4. Assert: Text's "style" attribute value contains "red".
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame(doubleClickPage.iframe);
        actions.doubleClick(doubleClickPage.text).perform();
        Assert.assertTrue(doubleClickPage.text.getAttribute("style").contains("red"));
    }
/*
Drag And Drop
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */
    @Test
    public void dragAndDrop() {
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        wait.until(ExpectedConditions.elementToBeClickable(telerikPage.cookies));
        telerikPage.cookies.click();
        actions.dragAndDrop(telerikPage.smallCircle, telerikPage.bigCircle).perform();
        Assert.assertEquals(telerikPage.bigCircle.getText(), "You did great!");
    }

    /*
    Context Click – HOMEWORK (right click)
1. Go to https://the-internet.herokuapp.com/context_menu
2. Right click to the box.
3. Alert will open.
4. Accept alert
No assertion needed for this practice.
     */

    @Test
    public void contextClick() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(element).perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }



}
