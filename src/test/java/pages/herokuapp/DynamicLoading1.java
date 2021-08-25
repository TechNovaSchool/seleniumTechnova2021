package pages.herokuapp;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoading1 {

    public DynamicLoading1() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath ="//button")
    public WebElement startButton;

    @FindBy (xpath = "(//h4)[2]")
    public WebElement helloText;
}
