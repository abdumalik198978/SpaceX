package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import pages.brideERP_pages.products_page.ProductsPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;
import org.testng.annotations.AfterClass;
import pages.brideERP_pages.*;

import java.util.List;
import java.util.Random;

public class SmokeTest {
    ProductsPage productsPage = new ProductsPage();

    @BeforeClass
    public void setUp() {
        ERP_login login = new ERP_login();
        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperties("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperties("britePassword"));
        login.loginButton.click();
    }

    @Test(priority = 10)
    public void purchaseHomePageVerification() {

        PurchaseOrdersVerificationPage pg = new PurchaseOrdersVerificationPage();
        pg.purchaseButton.click();
        Assert.assertTrue(pg.purchaseButton.isDisplayed(), "Purchase module not displayed");
    }

    @Test(priority = 11)
    public void purchaseOrdersButtonVerification() {
        PurchaseOrdersPage pf = new PurchaseOrdersPage();
        SeleniumUtil.pause(3);
        Assert.assertTrue(pf.purchaseOrdersButton.isDisplayed(), "Purchase Orders page not displayed");
        pf.purchaseOrdersButton.click();
    }

    @Test(priority = 12)
    public void importButtonUnderPurchaseOrders() {
        PurchaseOrdersImportButtonPage io = new PurchaseOrdersImportButtonPage();
        SeleniumUtil.pause(3);
        io.importButton.click();

        SeleniumUtil.pause(3);
        Assert.assertTrue(io.loadFile.isDisplayed(), "Import button not displayed");
        io.cancelButton.click();
    }

    @Test(priority = 13)
    public void searchTabUnderPurchaseOrders() {
        PurchaseOrdersSearchTabPage pf = new PurchaseOrdersSearchTabPage();
        List<WebElement> list = pf.referenceList;
        int random = new Random().nextInt(list.size());
        String randomSearch = list.get(random).getText();
        pf.searchTab.sendKeys(randomSearch + Keys.ENTER);

        Assert.assertTrue(pf.searchResult.isDisplayed(), "Search result fail to pass");
        Assert.assertTrue(pf.searchQuickResult.isDisplayed(), "Search result on search tab fail");

        pf.searchQuickResultCancelButton.click();
    }

    @Test(priority = 14)
    public void createButtonUnderPurchaseOrders() {
        PurchaseOrdersCreateButtonPage pb = new PurchaseOrdersCreateButtonPage();
        pb.createButton.click();
        pb.vendorTab.click();
        List<WebElement> listOfVendors = pb.vendorList;
        int randomNum = new Random().nextInt(listOfVendors.size());
        SeleniumUtil.pause(3);
        Driver.getDriver().findElement(By.xpath("//li[@class='ui-menu-item'][" + 2 + "]")).click();
        pb.addAnItem.click();
        SeleniumUtil.pause(2);
        pb.productTab.click();
        SeleniumUtil.pause(3);

        pb.searchUnderProducts.click();
        SeleniumUtil.pause(3);

        pb.searchMoreProductChose.click();

        pb.confirmButton.click();
        SeleniumUtil.pause(5);


        String expectedPurchaseOrderConfirmText = pb.purchaseOrdersConfirmation.getText();
        pb.saveResultUnderPurchaseOrders.click();


        pb.purchaeOrderHomePage.click();
        SeleniumUtil.pause(2);
        String actual = pb.purchaseOrdersHomePageConfirmPurchaseText.getText();

        Assert.assertTrue(expectedPurchaseOrderConfirmText.equals(actual), "Confirmation number does't match");
    }

    @Test(priority = 40)
    public void verifyClickOnProducts() {
        productsPage.purchasesButton.click();
        productsPage.productsButton.click();
        SeleniumUtil.pause(5);
        String actualTitleProductPage = Driver.getDriver().getTitle();
        String expectedTitleProductPage = "Products - Odoo";
        Assert.assertEquals(actualTitleProductPage, expectedTitleProductPage, "Titles of the PRODUCTS page do NOT match");
    }

    @Test(priority = 41)
    public void verifySearchFunctionalityOfProducts() {
        productsPage.purchasesButton.click();
        productsPage.productsButton.click();
        SeleniumUtil.pause(5);
        productsPage.productsSearchBox.sendKeys(Config.getProperties("productSearchLowerCase"));
        productsPage.searchProductFor.click();
        productsPage.productsSearchBox.sendKeys(Config.getProperties("productSearchUpperCase"));
        productsPage.searchProductFor.click();
        List<WebElement> crosses = Driver.getDriver().findElements(By.xpath("//span[@class = 'o_searchview_facet_label']/following-sibling::div/following-sibling::div"));
        for (WebElement cross : crosses) {
            cross.click();
        }
        productsPage.productsSearchBox.sendKeys(Config.getProperties("productSearchWrongItem"));
        productsPage.productsSearchBox.sendKeys(Keys.ENTER);
        try {
            Assert.assertTrue(productsPage.wrongSearchMessage.isDisplayed());
        } catch (Exception e) {
            System.out.println("The message of the search box is NOT displayed!");
        }
        productsPage.productCrossButton.click();
    }

    @Test(priority = 42)
    public void verifyProductsDetailsAvailable() {
        productsPage.purchasesButton.click();
        productsPage.productsButton.click();
        SeleniumUtil.pause(5);

        //selecting random product from the list
        Random random = new Random();
        List<WebElement> productAll = Driver.getDriver().findElements(By.xpath("//div[@class = 'oe_kanban_global_click o_kanban_record']"));
        int productOne = random.nextInt(productAll.size());
        productAll.get(productOne).click();

        //on Product's details page, verify title
        SeleniumUtil.pause(5);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = productsPage.getRandomProductTitle.getText() + " - Odoo";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Product's details' page title does NOT match");

        //checking each tab
        SeleniumUtil.pause(2);
        List<WebElement> tabs = Driver.getDriver().findElements(By.xpath("//a[@data-toggle='tab']"));
        for (WebElement tab : tabs) {
            if (!tab.getText().isEmpty()) {
                tab.click();
                SeleniumUtil.pause(2);
            }
        }
    }


    @AfterClass
    public void closePage() {
        Driver.closeDriver();
    }
}

