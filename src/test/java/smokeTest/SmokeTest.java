package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.*;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class SmokeTest {

    MondayProjectPages mondayProjectPages = new MondayProjectPages();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @BeforeClass
    public void setUp() {
        ERP_login login = new ERP_login();
        //Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        Driver.getDriver().get((String) Config.getProperties("UrlBriteERP"));
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


    @Test(priority = 1)
    public void Create_request_for_quotation(){
        String expectedTitle = "Requests for Quotation - Odoo";
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
        Assert.assertTrue(mondayProjectPages.createButton.isDisplayed(),"Create button is not displayed");
        mondayProjectPages.createButton.click();


        String expcetedCreatePageTitle = "New - Odoo";
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
        Assert.assertTrue(mondayProjectPages.vendorField.isDisplayed());


        Assert.assertTrue(mondayProjectPages.vendorField.getAttribute("value").isEmpty(),"Vendor is not empty");
        mondayProjectPages.vendorField.click();
        mondayProjectPages.elementVendor.click();


        String expectDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalTime expectTime = LocalTime.now().minusSeconds(1);
        String changeTime = expectTime.format(DateTimeFormatter.ISO_TIME).substring(0,8);
        String expectedDateTime = expectDate + " " + changeTime;
        System.out.println(expectedDateTime);
        //       Assert.assertEquals(mondayProjectPages.calendarValue.getAttribute("value"),expectedDateTime);
        System.out.println(mondayProjectPages.calendarValue.getText());
        Assert.assertFalse(mondayProjectPages.calendarValue.getText().isEmpty(),"Time is empty");
        mondayProjectPages.deliveriesAndInvoices.click();


        Assert.assertTrue(mondayProjectPages.scheduleDate.getAttribute("value").isEmpty(),"Schedule date is not empty");
        mondayProjectPages.scheduleDate.sendKeys(expectedDateTime);
        System.out.println(expectedDateTime);

        mondayProjectPages.saveButton.click();
        mondayProjectPages.confirmOrderButton.click();
        //  Assert.assertTrue(mondayProjectPages.errorMessageForSchedule.isDisplayed(),"Schedule error message displayed.You didn't save order");

    }

    @Test (priority = 2)
    public void User_not_able_to_save_request_for_quotation_with_empty_fields(){
        mondayProjectPages.requestForQuotationLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(mondayProjectPages.createButton));
        // Assert.assertTrue(mondayProjectPages.createButton.isDisplayed(),"Create button for with empty fields is not there");
        mondayProjectPages.createButton.click();


        String expcetedCreatePageTitle = "New - Odoo";
        wait.until(ExpectedConditions.titleIs(expcetedCreatePageTitle));
        Assert.assertEquals(Driver.getDriver().getTitle(),expcetedCreatePageTitle);


        mondayProjectPages.saveButton.click();
        Assert.assertTrue(mondayProjectPages.errorMessage.isDisplayed(),"Error message didn't displayed");
    }


    @Test (priority = 3)
    public void Use_search_button(){
        mondayProjectPages.requestForQuotationLink.click();
        wait.until(ExpectedConditions.visibilityOf(mondayProjectPages.searchField));
        Assert.assertTrue(mondayProjectPages.searchField.isDisplayed());
        mondayProjectPages.searchField.click();
        mondayProjectPages.searchField.sendKeys("ACD");
        Assert.assertTrue(mondayProjectPages.optionsForSearch.isDisplayed());
        mondayProjectPages.findByVendor.click();
        Assert.assertTrue(mondayProjectPages.relatedResultForVendor.isDisplayed(),"Related result is not there");

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
    @AfterClass
    public void closePage(){
        Driver.closeDriver();
    }
}

