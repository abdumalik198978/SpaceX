package smokeTest;

import org.testng.annotations.BeforeClass;
import pages.brideERP_pages.ERP_login;
import utilities.Config;
import utilities.Driver;

public class SmokeTest {
    @BeforeClass
    public void setUp() {
        ERP_login login = new ERP_login();

        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperties("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperties("britePassword"));
        login.loginButton.click();

    }



    }


