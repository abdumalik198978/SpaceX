package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchaseOrders {
    public PurchaseOrders(){
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

    @FindBy(xpath = "//input[@ id='o_field_input_994']")
    public WebElement addVenderReference;

    @FindBy()
   public WebElement saveButton;





}
