package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PurchaseOrdersSearchTabPage {
    public PurchaseOrdersSearchTabPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> referenceList;

    @FindBy(xpath = "//*[@class='o_searchview_input']")
    public WebElement searchTab;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public WebElement searchResult;

    @FindBy(xpath = "//*[@class='o_facet_values']/span")
    public WebElement searchQuickResult;

    @FindBy(xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement searchQuickResultCancelButton;
}
