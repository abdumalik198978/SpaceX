package pages.brideERP_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchasePage_ReportingTab_VerificationManager {

    public PurchasePage_ReportingTab_VerificationManager() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu='521']")
    public WebElement ReportingTab;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement MeasuresBtn;

    @FindBy(xpath = "//button[@class='btn btn-default fa fa-bar-chart-o o_graph_button active']")
    public WebElement ChartBtn;

    @FindBy(xpath = "//button[@class='btn btn-default fa fa-line-chart o_graph_button']")
    public WebElement LineChart;

    @FindBy(xpath = "//button[@class='btn btn-default fa fa-pie-chart o_graph_button']")
    public WebElement PieChart;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement SearchBtn;

    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-bar-chart o_cp_switch_graph active']")
    public WebElement GraphBtn;

    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")
    public WebElement PivotBtn;
}


