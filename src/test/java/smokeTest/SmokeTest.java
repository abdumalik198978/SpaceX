package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import pages.brideERP_pages.Icoming_Products_Create_Import_page;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SmokeTest {
    @BeforeClass
    public void setUp(){
        ERP_login login = new ERP_login();
        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperties("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperties("britePassword"));
        login.loginButton.click();


    }

    @Test (priority = 51)
    public void Incoming_Products_Validation_Bycreating() throws InterruptedException{
        Icoming_Products_Create_Import_page pagesIncoming = new Icoming_Products_Create_Import_page();
        pagesIncoming.purchaseTab.click();
        pagesIncoming.incomingProductsField.click();
        Thread.sleep(3000);
        // I was not able to click on create button unless put some Thread.sleep; other waits both did not work
        pagesIncoming.createButtonIncomingProducts.click();
        pagesIncoming.referenceSourceLocationInput.click();
        Thread.sleep(1000);
        pagesIncoming.searchMore_ReferenceSourceLocationInput.click();
        //Here to make it dynamic I am using random generator to select random fromlist
//====================================
        // I select search more button from dropdown and it displays a table of location lists
        List<WebElement> elementsOfReference = Driver.getDriver().findElements(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr"));
       // System.out.println(elementsOfReference);
        int boundary1 = elementsOfReference.size();
        Random randomNum = new Random();
        int index1 = randomNum.nextInt(boundary1);
       // System.out.println(randomNum.nextInt(boundary));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+ index1+ "]"))));
       Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+ index1+ "]")).click();
//=====================================
        pagesIncoming.destinationLocationInput.click();
        pagesIncoming.seacrMore_DestinationLocation.click();
        List<WebElement> elementsOfDestination = Driver.getDriver().findElements(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr"));
        int boundry2 = elementsOfDestination.size();
        //System.out.println(elementsOfDestination);
        int index2 = randomNum.nextInt(boundry2);
       // System.out.println(index2);
        Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+index2+"]")).click();
//======================================
        pagesIncoming.productInput.click();
        pagesIncoming.searchMore_Product.click();
        List<WebElement> elementsOfProduct = Driver.getDriver().findElements(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr"));
        int boundry3 = elementsOfProduct.size();
      //  System.out.println(elementsOfProduct);
        int index3 = randomNum.nextInt(boundry3);
        // System.out.println(index3);
        Driver.getDriver().findElement(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr["+ index3+"]")).click();
//========================================
        pagesIncoming.initialDemandInput.clear();
        pagesIncoming.initialDemandInput.sendKeys("100");

        pagesIncoming.sourceDocumentInput.sendKeys("From Abdumalik");
//==========================================
        pagesIncoming.procurementDocInput.click();
        pagesIncoming.searchMore_Procurement.click();
        List<WebElement> elementsOfProcurement = Driver.getDriver().findElements(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr"));
        int boundry4 = elementsOfProcurement.size();
      //  System.out.println(elementsOfProcurement);
        int index4 = randomNum.nextInt(boundry4);
        //System.out.println(index4);
        Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive']//tbody)[3]/tr["+index4+"]")).click();
//===============================================
        pagesIncoming.saveButtonForCreateIncomingProducts.click();

         wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(pagesIncoming.actionBtnAfterCreate));

        Assert.assertTrue(pagesIncoming.actionBtnAfterCreate.isDisplayed(),"Action Btn is not displayed, Verification failed");

        pagesIncoming.purchaseTab.click();

    }

    @Test (priority = 52)
    public void Incoming_Products_Validation_Bycreating_Negative() throws InterruptedException{
        Icoming_Products_Create_Import_page pagesIncoming = new Icoming_Products_Create_Import_page();

        pagesIncoming.purchaseTab.click();
        pagesIncoming.incomingProductsField.click();
        Thread.sleep(3000);
        // I was not able to click on create button unless put some Thread.sleep; other waits both did not work
        pagesIncoming.createButtonIncomingProducts.click();
        pagesIncoming.saveButtonForCreateIncomingProducts.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(pagesIncoming.popUpWarning));
        Assert.assertTrue(pagesIncoming.popUpWarning.isDisplayed());
        pagesIncoming.purchaseTab.click();

    }
    @Test (priority = 53)
    public void Incoming_Products_Validation_ByImporting() throws InterruptedException{
        Icoming_Products_Create_Import_page pagesIncoming = new Icoming_Products_Create_Import_page();

        pagesIncoming.purchaseTab.click();
        pagesIncoming.incomingProductsField.click();
        Thread.sleep(3000);

        pagesIncoming.importButton.click();
        Assert.assertTrue(pagesIncoming.importInput.isDisplayed(), "Imort input button is not displayed");
        pagesIncoming.purchaseTab.click();
    }

}
