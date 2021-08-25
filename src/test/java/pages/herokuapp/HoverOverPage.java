package pages.herokuapp;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverOverPage {

    public HoverOverPage() {
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy (xpath = "(//div[@class=\"figure\"])[1]")
    public WebElement avatar1;

    @FindBy (xpath = "(//div[@class=\"figure\"])[2]")
    public WebElement avatar2;

    @FindBy (xpath = "(//div[@class=\"figure\"])[3]")
    public WebElement avatar3;

    @FindBy (xpath = "(//div[@class=\"figcaption\"]/h5)[1]")
    public WebElement name1;

    @FindBy (xpath = "(//div[@class=\"figcaption\"]/h5)[2]")
    public WebElement name2;

    @FindBy (xpath = "(//div[@class=\"figcaption\"]/h5)[3]")
    public WebElement name3;
}
