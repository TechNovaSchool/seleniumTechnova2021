package pages.actionsClassHomeworkPage;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelerikPage {

    public TelerikPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "draggable")
    public WebElement smallCircle;

    @FindBy (id = "droptarget")
    public WebElement bigCircle;

    @FindBy (id = "onetrust-accept-btn-handler")
    public WebElement cookies;
}
