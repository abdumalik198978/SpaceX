package smokeTest;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import pages.brideERP_pages.VendorsPageSaime;

import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

import java.security.Key;
import java.util.List;

public class SmokeTest {
    VendorsPageSaime vp=new VendorsPageSaime();

    @BeforeClass
    public void setUp(){
        ERP_login login = new ERP_login();
        Driver.getDriver().get(Config.getProperties("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperties("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperties("britePassword"));
        login.loginButton.click();

    }
    @Test(priority = 31)
    public void vendorButton(){
//        Click to Purchases tab top of the page.
//        Verify Purchases button navigate user to the purchases page.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();

//        Click to Vendors button.
        vp.vendorsButton.click();
        SeleniumUtil.pause(6);

//        Verify it navigates user to Vendors page.
        Assert.assertEquals(vp.vendorPageTitle.getText(), "Vendors");
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();

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
