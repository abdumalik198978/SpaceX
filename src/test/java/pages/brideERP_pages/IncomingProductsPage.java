package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class IncomingProductsPage {
    public IncomingProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@href='/web#menu_id=504&action=']")
    public WebElement purchases;

    @FindBy(xpath = "//a[@href='/web#menu_id=514&action=519']")
    public WebElement incomingProductsField;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//table/tbody//td[@class='o_data_cell o_required_modifier']")
    public List<WebElement> listOfSearchedItems;

    @FindBy (xpath = "(//td[.='[PROD_DEL] Switch, 24 ports'])[1]")
    public WebElement incomingProductsProduct;

    @FindBy(xpath = "//a[.='[PROD_DEL] Switch, 24 ports']")
    public WebElement incomingProductsProductDetail;

    @FindBy(xpath = "//span[.='Switch, 24 ports']")
    public WebElement incomingProductsProductDetailTitle;
}
