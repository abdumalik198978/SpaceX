package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ERP_loginManager {
    public ERP_loginManager(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="login")
    public WebElement usernameInput;


    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "(//li[@style='display: block;'])[9]")
    public WebElement PurchasesTab;
}
