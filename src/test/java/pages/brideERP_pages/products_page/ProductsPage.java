package pages.brideERP_pages.products_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductsPage {
    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_root']")
    public WebElement purchasesButton;
    @FindBy (xpath = "//a[@data-action-id='691']")
    public WebElement productsButton;
    @FindBy (xpath = "//input[@class = 'o_searchview_input']")
    public WebElement productsSearchBox;
    @FindBy (xpath = "//a[@href='#']/em[.='Product']")
    public WebElement searchProductFor;
    @FindBy (xpath = "//span[@class = 'o_searchview_facet_label']/following-sibling::div/following-sibling::div")
    public WebElement productCrossButton;
    @FindBy (css = "div.oe_view_nocontent")
    public WebElement wrongSearchMessage;
    @FindBy (xpath = "//div[@class = 'oe_kanban_global_click o_kanban_record']")
    public WebElement randomProduct;
    @FindBy (xpath = "//span[@name='name']")
    public WebElement getRandomProductTitle;
    @FindBy (linkText = "General Information")
    public WebElement genInfoTab;
    @FindBy(linkText = "Sales")
    public WebElement salesTab;
    @FindBy(linkText = "Purchase")
    public WebElement purchaseTab;
    @FindBy(linkText = "Inventory")
    public WebElement inventoryTab;
    @FindBy(linkText = "Invoicing")
    public WebElement invoicingTab;
    @FindBy(linkText = "Notes")
    public WebElement notesTab;

}
