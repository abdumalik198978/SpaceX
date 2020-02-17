package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Icoming_Products_Create_Import_page {
    public Icoming_Products_Create_Import_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class = 'oe_menu_text'])[9]")
    public WebElement purchaseTab;

    @FindBy(xpath = "//a[@href = '/web#menu_id=514&action=519']/span[@class='oe_menu_text']")
    public WebElement incomingProductsField;

    @FindBy(xpath = "//div[@class = 'o_list_buttons']/button[1]")
    public WebElement createButtonIncomingProducts;

    @FindBy(xpath = "//div[@class = 'o_form_buttons_edit']/button[1]")
    public WebElement saveButtonForCreateIncomingProducts;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement referenceSourceLocationInput;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li[8]")
    public WebElement searchMore_ReferenceSourceLocationInput;

    @FindBy(xpath = "//tr[@class ='o_data_row']/td[.='Virtual Locations/Procurements']")
    public WebElement oneReferenceRandomLocationFromSerchmoreTable;
    // dynamic for element "(//div[@class='table-responsive'])[3]//tbody/tr[3]"

   @FindBy(xpath = "(//span[@class='o_pager_limit'])[4]")
   public WebElement numberOfReferenceLocationTable;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[2]")
    public WebElement destinationLocationInput;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[8]")
    public WebElement seacrMore_DestinationLocation;

    @FindBy(xpath = "//tr[@class = 'o_data_row']/td[.='Physical Locations/YourCompany: Transit Location']")
    public WebElement oneRandomDestinationLocationFromSearchMoreTable;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[3]")
    public WebElement productInput;

    @FindBy(xpath = "//ul[@id='ui-id-3']/li[8]")
    public WebElement searchMore_Product;

    @FindBy(xpath = "//tr[@class ='o_data_row text-info']/td[.='iPad Mini2']")
    public WebElement oneRandomProductFromProductList;

    @FindBy(xpath = "//input[@name='product_uom_qty']")
    public WebElement initialDemandInput;

    @FindBy(xpath = "//input[@name='origin']")
    public WebElement sourceDocumentInput;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[5]")
    public WebElement procurementDocInput;

    @FindBy(xpath = "(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'])[5]/li[8]")
    public WebElement searchMore_Procurement;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionBtnAfterCreate;

    @FindBy(xpath = "//div[@class='o_notification_title']/span")
    public WebElement popUpWarning;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public  WebElement importButton;

    @FindBy(xpath = "//input[@class='oe_import_file_show form-control']")
    public WebElement importInput;

}
