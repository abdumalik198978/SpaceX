package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchaseOrdersEdit {
    public PurchaseOrdersEdit(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_root']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_form_action']")
    public WebElement purchaseOrders;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr[1]/td[2]")
     public  WebElement orderFromPurchaseList;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editButton;

    @FindBy(name="partner_ref")
    public WebElement addVenderReference;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
   public WebElement saveButton;

    @FindBy(xpath = "//span[@name='name']")
    public  WebElement nameOfOrder;

    @FindBy(xpath = "//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle']")
    public  WebElement printButton;

    @FindBy(xpath = "(//a[@data-index='0'])[1]")
    public WebElement purchaseOrderOptionFromPrintButton;










}
