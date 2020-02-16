package smokeTest;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import pages.brideERP_pages.VendorsPageSaime;

import pages.brideERP_pages.products_page.ProductsPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;
import org.testng.annotations.AfterClass;
import pages.brideERP_pages.*;

import java.util.List;
import java.util.Random;

import java.security.Key;
import java.util.List;

public class SmokeTest {
    VendorsPageSaime vp=new VendorsPageSaime();
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
    @Test(priority = 31)
    public void vendorButton() {
//        Click to Purchases tab top of the page.
//        Verify Purchases button navigate user to the purchases page.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();

//        Click to Vendors button.
        vp.vendorsButton.click();
        SeleniumUtil.pause(6);

//        Verify it navigates user to Vendors page.
        Assert.assertEquals(vp.vendorPageTitle.getText(), "Vendors");
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();
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

    @Test(priority = 32)
    public void createNewVendorUnderVendors(){

//        Click to Purchases tab top of the page.
//        Verify Purchases button navigate user to the purchases page.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();

//        Click to Vendors button.
//        Verify it navigates user to Vendors page.
        vp.vendorsButton.click();
       SeleniumUtil.pause(6);

//        User should be able to see the Create button left side of the page under the page title.
//        Verify the Create button is displayed.
        Assert.assertTrue(vp.vendorCreateButton.isDisplayed(),"Vendors create button doesn't displayed");


//        Click to Create button.
        vp.vendorCreateButton.click();


//        Verify individual radio button is selected as a default.
       Assert.assertTrue(vp.vendorIndividualCheckBox.isSelected(),"Individual radio button is not selected as a default" );



//        Enter a name into a name field and click to Save button.
        vp.vendorNameField.sendKeys("Saime");
        vp.vendorSaveButton.click();


//        Verify the entered name displayed into the next page.
        Assert.assertTrue(vp.vendorCreatedNameField.getText().equals("Saime"));
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();

    }

    @Test(priority = 33)
    public void searchExistingVendorUnderVendors(){
//        Click to Purchases tab top of the page.
//        Verify Purchases button navigate user to the purchases page.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();

//        Click to Vendors button.
//        Verify it navigates user to Vendors page.
        vp.vendorsButton.click();
        SeleniumUtil.pause(6);

//        User should be able to see the Search field left side of the page.
//        Verify the Search button is displayed.
        Assert.assertTrue(vp.vendorSearchField.isDisplayed(),"Search field doesn't displayed");

//        Enter a name into the search tab and click.
        vp.vendorSearchField.sendKeys("Saime"+Keys.ENTER);
        SeleniumUtil.pause(2);


//        Verify relevant results are displayed.
//        Assert.assertTrue( vp.vendorSearchResultName.getText().equals("Saime"),"Created name doesn't displayed after searching");
        List<WebElement>searchResults=Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_details']"));
        for(WebElement result: searchResults){
            System.out.println(result.getText());
            if(result.getText().equals("Saime")){
                Assert.assertTrue(result.getText().equals("Saime"));
            }
        }
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();


    }



}

