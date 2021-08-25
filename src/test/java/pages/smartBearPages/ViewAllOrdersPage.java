package pages.smartBearPages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOrdersPage {

    public ViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (linkText = "View all products")
    public WebElement viewProducts;

    @FindBy (xpath = "//h2")
    public WebElement header;

    @FindBy (xpath = "//table[@class=\"ProductsTable\"]/tbody/tr[2]/td[1]")
    public WebElement productMoney;

    @FindBy (xpath = "//table[@class=\"ProductsTable\"]/tbody/tr[2]/td[2]")
    public WebElement price;

    @FindBy (xpath = "//table[@class=\"ProductsTable\"]/tbody/tr[2]/td[3]")
    public WebElement discount;

}
