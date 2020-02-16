package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchaseOrdersImportButtonPage {
    public PurchaseOrdersImportButtonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[contains(text(), 'Import')]")
    public WebElement importButton;

    @FindBy(xpath = "//label[@class='btn btn-primary']")
    public WebElement loadFile;

    @FindBy(xpath = "//button[.='Cancel']")
    public WebElement cancelButton;

}
