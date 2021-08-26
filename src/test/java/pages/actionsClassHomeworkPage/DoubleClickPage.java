package pages.actionsClassHomeworkPage;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoubleClickPage {

    public DoubleClickPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "iframeResult")
    public WebElement iframe;

    @FindBy (id = "demo")
    public WebElement text;


}
