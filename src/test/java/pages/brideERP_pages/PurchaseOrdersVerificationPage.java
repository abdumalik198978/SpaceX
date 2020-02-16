package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchaseOrdersVerificationPage {
    public PurchaseOrdersVerificationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//*[contains(text(),'Purchases')]")
    public WebElement purchaseButton;
}
