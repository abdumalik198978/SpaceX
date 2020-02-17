package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_loginManager;
import pages.brideERP_pages.PurchasePage_ReportingTab_VerificationManager;
import pages.brideERP_pages.PurchasesPage_ProductTab_CreateBtn_VerificationManager;
import pages.brideERP_pages.PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger;
import utilities.Config;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class SmokeTestAsAManager {

    @BeforeClass
    public void setUp(){

        ERP_loginManager login = new ERP_loginManager();

        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // User login as a manager
        login.usernameInput.sendKeys(Config.getProperties("managerUsername"));
        login.passwordInput.sendKeys(Config.getProperties("managerPassword"));
        login.loginButton.click();
        login.PurchasesTab.click();

    }

    @Test (priority = 0)
    public void PurchasesPage_ReportingTab_Verification(){

        PurchasePage_ReportingTab_VerificationManager purchases_page = new PurchasePage_ReportingTab_VerificationManager();

        // Verify Reporting tab is displayed and click Reporting tab
        purchases_page.ReportingTab.click();

        // Verify if Measure button is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.MeasuresBtn.isDisplayed());

        // Verify if Chart button  is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.ChartBtn.isDisplayed());

        // Verify if Line Chart button is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.LineChart.isDisplayed());

        // Verify if Pie Chart button is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.PieChart.isDisplayed());

        // Verify if Search  button is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.SearchBtn.isDisplayed());

        // Verify if Graph button is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.GraphBtn.isDisplayed());

        // Verify if Pivot button is displayed on Purchases Analysis page
        Assert.assertTrue(purchases_page.PivotBtn.isDisplayed());
    }

    @Test (priority = 1)
    public void PurchasesPage_ProductsTab_CreateBtn_Verification(){

        PurchasesPage_ProductTab_CreateBtn_VerificationManager products = new PurchasesPage_ProductTab_CreateBtn_VerificationManager();

        // On Products tab
        products.ProductTap.click();

        // On Create button
        products.CreateBtn.click();

        // Product name field should be empty by default
//        System.out.println(products.ProductNameField.getText());
        Assert.assertTrue(products.ProductNameField.getAttribute("value").isEmpty());

        // Can be sold check box should be selected by default
        Assert.assertTrue(products.CanBeSoldCheckBox.isSelected());

        // Can be purchased check box should be selected by default
        Assert.assertTrue(products.CanBePurchasedCheckBox.isSelected());

        // Product type drop down btn should be selected "Consumable" by default
        Select select = new Select(products.ProductTypeField);

        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("Consumable"));

        //Category field should All By default
        Assert.assertTrue(products.CategoryField.getAttribute("value").equals("All"));

        //Sales price field should be 1.00 by default
        Assert.assertTrue(products.SalesPriceField.getAttribute("value").equals("1.00"));

        // Cost field should be 0.00 by default
        Assert.assertTrue(products.CostField.getAttribute("value").equals("0.00"));

    }

    @Test (priority = 2)
    public void PurchasesPage_ProductsTab_CreateBtn_CreateNewProduct(){

        PurchasesPage_ProductTab_CreateBtn_VerificationManager productCreate = new PurchasesPage_ProductTab_CreateBtn_VerificationManager();

        PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger createNewProduct = new PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger();

        // user on Products tab
        productCreate.ProductTap.click();

        //user on Create Btn
        productCreate.CreateBtn.click();

        // User should able to write new product name
       productCreate.ProductNameField.sendKeys("apple");

       // Clear sales Price& Cost fields
        productCreate.CostField.clear();
        productCreate.SalesPriceField.clear();

       // User should able to write sales Price
        productCreate.SalesPriceField.sendKeys("1.99");

       // User should able to write Cost
        productCreate.CostField.clear();
        productCreate.CostField.clear();
        productCreate.CostField.sendKeys("3.99");

       // User should able to save new product
        createNewProduct.SaveBtn.click();

      // User should see "Product Template created" message
      Assert.assertTrue(createNewProduct.ProductTemplateCreateMessage.isDisplayed());

      // User should able to edit newly  created products
        createNewProduct.EditBtn.click();

    }

    @Test(priority = 3)
    public void PurchasesPage_ProductsTab_CreateBtn_CreateNewProduct_NegativeScenario(){

        PurchasesPage_ProductTab_CreateBtn_VerificationManager productCreate = new PurchasesPage_ProductTab_CreateBtn_VerificationManager();

        PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger createNewProduct = new PurchasesPage_ProductsTab_CreateBtn_ProductModuleManger();

        // user on Products tab
        productCreate.ProductTap.click();

        //user on Create Btn
        productCreate.CreateBtn.click();

        // User should leave empty product name field
        productCreate.ProductNameField.sendKeys("");

        // User should able to write sales Price
        productCreate.CostField.clear();
        productCreate.SalesPriceField.clear();
        productCreate.SalesPriceField.sendKeys("1.99");

        // User should able to write Cost
        productCreate.CostField.clear();
        productCreate.CostField.clear();
        productCreate.CostField.sendKeys("3.99");

        // When User click save button should see the Alert "The following field are invalid"
        createNewProduct.SaveBtn.click();

        //When user clicks to save btn user should not see the "Product Template created" message
       //System.out.println(Driver.getDriver().findElement(By.xpath("//label[.='Product Name']")).getAttribute("value"));
        //Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//label[.='Product Name']")).getAttribute("style").contains("red"));
       //Assert.assertTrue(productCreate.ProductNameField.getAttribute("style").contains("red"));


    }

}
