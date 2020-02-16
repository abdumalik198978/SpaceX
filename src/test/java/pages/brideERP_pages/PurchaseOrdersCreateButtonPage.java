package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PurchaseOrdersCreateButtonPage {
    public PurchaseOrdersCreateButtonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[contains(text(), 'Create')]")
    public WebElement createButton;

    @FindBy (xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement vendorTab;

    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public List<WebElement> vendorList;

    @FindBy(xpath = "//a[.='Add an item']")
    public WebElement addAnItem;

    @FindBy(xpath = "(//div[@class='o_notebook']//tbody/tr[1]/td[@class='o_data_cell o_required_modifier'])[1]")
    public WebElement productTab;

    @FindBy(xpath = "(//a[.='Search More...'])[2]")
    public WebElement searchUnderProducts;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
    public List<WebElement> listOfResultUnderProducts;

    @FindBy(xpath = "(//tbody[@class='ui-sortable'])[2]/tr[2]")
    public WebElement searchMoreProductChose;

    @FindBy(xpath = "(//button[.='Confirm Order'])[1]")
    public WebElement confirmButton;

    @FindBy(xpath = "(//button[contains(text(), 'Save')])[1]")
    public WebElement saveResultUnderPurchaseOrders;

    @FindBy(xpath = "(//span[contains(text(), 'Purchase Order')])[1]")
    public WebElement purchaeOrderHomePage;

    @FindBy(xpath = "//h1/span")
    public WebElement purchaseOrdersConfirmation;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[1]/td[2]")
    public WebElement purchaseOrdersHomePageConfirmPurchaseText;





}
