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

    @FindBy (xpath = "//button[@aria-label='kanban']")
    public WebElement kanbanButton;


}