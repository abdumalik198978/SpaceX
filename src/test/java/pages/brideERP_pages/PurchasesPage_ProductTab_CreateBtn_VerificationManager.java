package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchasesPage_ProductTab_CreateBtn_VerificationManager {
    public PurchasesPage_ProductTab_CreateBtn_VerificationManager(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@data-menu='516']")
    public WebElement ProductTap;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public WebElement CreateBtn;

    @FindBy(xpath ="//input[@placeholder ='Product Name']")
    public WebElement ProductNameField;

    @FindBy(xpath = "//label[.='Can be Sold']//../div/input")
    public WebElement CanBeSoldCheckBox;

    @FindBy(xpath = "//label[.='Can be Purchased']//../div/input")
    public WebElement CanBePurchasedCheckBox;

    @FindBy(xpath = "(//option[.='Consumable']//..)[1]")
    public WebElement ProductTypeField;

    @FindBy(xpath = "//div[@name='categ_id']/div/input")
    public WebElement CategoryField;

    @FindBy(xpath = "//div[@name='list_price']/input")
    public WebElement SalesPriceField;

    @FindBy(xpath = "//div[@name='standard_price']/input")
    public WebElement CostField;

}
