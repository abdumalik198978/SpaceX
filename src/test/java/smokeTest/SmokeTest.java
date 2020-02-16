package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.brideERP_pages.ERP_login;
import pages.brideERP_pages.products_page.ProductsPage;
import src.test.java.utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtil;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

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
        productsPage.purchasesButton.click();
        productsPage.productsButton.click();
        SeleniumUtil.pause(5);
        productsPage.productsSearchBox.sendKeys(Config.getProperties("productSearchLowerCase"));
        productsPage.searchProductFor.click();
        productsPage.productsSearchBox.sendKeys(Config.getProperties("productSearchUpperCase"));
        productsPage.searchProductFor.click();
        List<WebElement> crosses = Driver.getDriver().findElements(By.xpath("//span[@class = 'o_searchview_facet_label']/following-sibling::div/following-sibling::div"));
        for(WebElement cross: crosses){
            cross.click();
        }
        productsPage.productsSearchBox.sendKeys(Config.getProperties("productSearchWrongItem"));
        productsPage.productsSearchBox.sendKeys(Keys.ENTER);
        try {
            Assert.assertTrue(productsPage.wrongSearchMessage.isDisplayed());
        }catch (NoSuchElementException e){
            System.out.println("The message of the search box is NOT displayed!");
        }
       productsPage.productCrossButton.click();
    }

    @Test
    public void verifyProductsDetailsAvailable(){
        productsPage.purchasesButton.click();
        productsPage.productsButton.click();
        SeleniumUtil.pause(5);
        //selecting random product from the list
        Random random = new Random();
        List<WebElement> productAll = Driver.getDriver().findElements(By.xpath("//div[@class = 'oe_kanban_global_click o_kanban_record']"));
        int productOne = random.nextInt(productAll.size());
        productAll.get(productOne).click();

        //on Product's details page
        SeleniumUtil.pause(5);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = productsPage.getRandomProductTitle.getText()+" - Odoo";
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Product's details' page title does NOT match");

        //checking each tab ---not finished
        SeleniumUtil.pause(2);
        List<WebElement> tabs = Driver.getDriver().findElements(By.xpath("//a[@data-toggle='tab']"));
        for(WebElement tab : tabs){
            if(!tab.getText().equals("Variants") && !tab.getText().equals("Images")){
                tab.click();
                SeleniumUtil.pause(2);
            }
        }






    }
}
