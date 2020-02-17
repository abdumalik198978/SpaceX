package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MondayProjectPages {
    public MondayProjectPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "login")
    public WebElement loginField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement LoginButton;

    @FindBy (xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_root']")
    public WebElement purchaseTab;

    @FindBy (xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_rfq']")
    public WebElement requestForQuotationLink;

    @FindBy (xpath = "//button[@accesskey = 'c']")
    public WebElement createButton;

    @FindBy (xpath = "(//input[starts-with(@id, 'o_field_input_')])[1]")
    public WebElement vendorField;

    @FindBy (xpath = "(//span[@class = 'o_dropdown_button'])[1]")
    public WebElement vendorDropDownButton;

    @FindBy (xpath = "//ul[@id = 'ui-id-1']")
    public WebElement vendorOptions;

    @FindBy (xpath = "(//li[@class = 'ui-menu-item'])[3]")
    public WebElement elementVendor;

    @FindBy (xpath = "(//input[@class = 'o_datepicker_input o_input'])[1]")
    public WebElement calendarValue;


    @FindBy (xpath = "//a[.='Deliveries & Invoices']")
    public WebElement deliveriesAndInvoices;

    @FindBy (xpath = "(//input[@class = 'o_datepicker_input o_input'])[2]")
    public WebElement scheduleDate;

    @FindBy (xpath = "(//span[@class = 'o_datepicker_button'])[2]")
    public WebElement dropDownScheduleButton;

    @FindBy (xpath = "//button[@class = 'btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class = 'o_notification_title']")
    public WebElement errorMessage;

    @FindBy (xpath = "(//button[.='Confirm Order'])[1]")
    public WebElement confirmOrderButton;


    @FindBy(xpath = "//div[@class = 'o_notification undefined o_error']")
    public WebElement errorMessageForSchedule;
    @FindBy (xpath = "//input[@class = 'o_searchview_input']")
    public WebElement searchField;

    @FindBy (xpath = "//ul[@class = 'dropdown-menu o_searchview_autocomplete']")
    public WebElement optionsForSearch;

    @FindBy(xpath = "//em[.='Vendor']")
    public WebElement findByVendor;

    @FindBy (xpath = "//tbody[@class = 'ui-sortable']")
    public WebElement relatedResultForVendor;

    @FindBy (xpath = "//a[@href='/web#menu_id=518&action=695']")
    public WebElement requestForQuotation;
}


