package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage {

   public HMCWebTablePage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(xpath = "//tbody//tr[1]//td")
   public List<WebElement> allTableColumnNumber;

   @FindBy(xpath = "//tbody//tr")
   public List<WebElement> allTableRowNumber;

   @FindBy(xpath = "//tbody//tr[4]//td")
   public List<WebElement> line4Elements;



    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> headerBirinciSatirDatalar;

    @FindBy(xpath = "//tbody")
    public WebElement tumBodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> tumBodyDatalariList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;



    public WebElement rowGet(int row) {
        WebElement rowGet=Driver.getDriver().findElement(By.xpath("//tbody/tr["+row+"]"));

        return rowGet;
    }

    public WebElement cellGet(int row, int column) {

        WebElement cellGet=Driver.getDriver().findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        return cellGet;

    }

    public void columnGet(int column) {

        int totalRowNumber=allTableRowNumber.size();

        for (int i=1;i<=totalRowNumber;i++){
            System.out.println(cellGet(i, column).getText());
        }
    }
}