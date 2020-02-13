package smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import pages.brideERP_pages.products_page.ProductsPage;
import src.test.java.utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

public class SmokeTest {
    ProductsPage productsPage = new ProductsPage();
    @BeforeClass
    public void setUp(){
        ERP_login login = new ERP_login();
        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperties("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperties("britePassword"));
        login.loginButton.click();

    }

    @Test
    public void verifyClickOnProducts (){
     productsPage.purchasesButton.click();
     productsPage.productsButton.click();
        SeleniumUtil.pause(5);
     String actualTitleProductPage = Driver.getDriver().getTitle();
     String expectedTitleProductPage = "Products - Odoo";
     Assert.assertEquals(actualTitleProductPage,expectedTitleProductPage,"Titles of the PRODUCTS page do NOT match");
    }

    @Test
    public void verifySearchFunctionalityOfProducts(){

    }
}
