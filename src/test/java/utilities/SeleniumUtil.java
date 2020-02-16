package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.TreeMap;

public class SeleniumUtil {
    public static void pause(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void explicitWait(int second, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), second);

        wait.until(ExpectedConditions.visibilityOf(webElement));
    }



}
