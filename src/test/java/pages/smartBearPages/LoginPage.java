package pages.smartBearPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class LoginPage {
    //when we are creating a POM page
    //1- to create constructor and call Pagefactory method

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //2- @findBy annotation to locate webElement
    //@findBy annotation locates the WebElement
    // Then we store that webElement on the next line
    @FindBy(id="ctl00_MainContent_username")
    public WebElement usernameInput;


    @FindBy(id="ctl00_MainContent_password")
    public WebElement passwordInput;

    @FindBy(id="ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorMessage;


}
