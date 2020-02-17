package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ERP_login {
    public ERP_login() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="login")
    public WebElement usernameInput;


    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginButton;

}
