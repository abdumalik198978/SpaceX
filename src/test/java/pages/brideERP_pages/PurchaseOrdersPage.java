package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PurchaseOrdersPage {
    public PurchaseOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    public WebElement purchaseOrdersButton;


}
