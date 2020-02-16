package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VendorsPageSaime {

    public VendorsPageSaime(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="login")
    public WebElement usernameInput;


    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginButton;


    @FindBy(xpath = "//span[contains(text(),'Purchases')]")
    public WebElement purchasesButton;


    @FindBy(linkText = "Vendors")
    public WebElement vendorsButton;

    @FindBy(xpath = "//div[@class='o_main_content']/div//ol/li")
    public WebElement vendorPageTitle;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement vendorCreateButton;

    @FindBy(xpath = "(//input[@class='o_radio_input'])[1]")
    public WebElement vendorIndividualCheckBox;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement vendorNameField;

    @FindBy (xpath = "//button[@accesskey='s']")
    public WebElement vendorSaveButton;

    @FindBy (xpath = "//h1/span[@class='o_field_char o_field_widget o_required_modifier']")
    public WebElement vendorCreatedNameField;

    @FindBy(xpath = "(//span[contains(text(),'Saime')])[1]")
    public WebElement vendorSearchResultName;

    @FindBy(xpath ="//input[@class=\'o_searchview_input\']")
    public WebElement vendorSearchField;

}
