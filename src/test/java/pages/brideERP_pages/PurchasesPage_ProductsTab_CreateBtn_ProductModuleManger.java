package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger {

    public PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement SaveBtn;

    @FindBy(xpath = "//p[.='Product Template created']")
    public WebElement ProductTemplateCreateMessage;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement EditBtn;


}
