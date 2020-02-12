package smokeTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

public class SmokeTest {
    @BeforeClass
    public void setUp(){
        ERP_login login = new ERP_login();
        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperties("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperties("britePassword"));
        login.loginButton.click();

    }

    @Test
    public void purchaseVerificatio(){

    }
}
