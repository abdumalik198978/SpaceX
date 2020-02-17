package smokeTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PurchaseOrdersEdit;
import pages.brideERP_pages.*;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class SmokeTest {
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


    @Test(priority = 16)
    public void VerifyEditButtonFromPurchaseOrder(){
        PurchaseOrdersEdit purchaseOrdersEdit=new PurchaseOrdersEdit();
        purchaseOrdersEdit.purchaseButton.click();

        purchaseOrdersEdit.purchaseOrders.click();
        SeleniumUtil.pause(3);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle="Purchase Orders - Odoo";
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Purchase orders title verification is failed");

        purchaseOrdersEdit.orderFromPurchaseList.click();
        SeleniumUtil.pause(2);
        String expectedTitleName=purchaseOrdersEdit.nameOfOrder.getText();
        String actualTitleName = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitleName.contains(expectedTitleName),"Title doesn't contain the order name");

        purchaseOrdersEdit.editButton.click();
        SeleniumUtil.pause(3);
        purchaseOrdersEdit.addVenderReference.click();
        purchaseOrdersEdit.addVenderReference.sendKeys("Orders");
        SeleniumUtil.pause(3);
        purchaseOrdersEdit.saveButton.click();

    }
    @Test(priority = 17)
    public  void VerifyPrintButtonFromPurchaseOrder(){
        PurchaseOrdersEdit purchaseOrdersEdit=new PurchaseOrdersEdit();
        purchaseOrdersEdit.purchaseButton.click();

        purchaseOrdersEdit.purchaseOrders.click();
        SeleniumUtil.pause(3);

        purchaseOrdersEdit.orderFromPurchaseList.click();
        SeleniumUtil.pause(2);

       purchaseOrdersEdit.printButton.click();

       SeleniumUtil.pause(2);

       purchaseOrdersEdit.purchaseOrderOptionFromPrintButton.click();
        SeleniumUtil.pause(5);

    }



    @AfterClass
    public void closePage(){
        Driver.closeDriver();
    }
}

