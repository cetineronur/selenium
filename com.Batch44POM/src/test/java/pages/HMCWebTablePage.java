package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage {

    public HMCWebTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> headerBirinciSatirDatalar;

    @FindBy(xpath = "//tbody")
    public WebElement tumBodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> tumBodyDatalariList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;


    public WebElement satirGetir(int satirNo) {

        //2.satiri yazdir  //tbody//tr[2]
        //7.satiri yazdir //tbody//tr[7]

        String satirDinamikXpath = "//tbody//tr[" + satirNo + "]";
        WebElement satirElementi = Driver.getDriver().findElement(By.xpath(satirDinamikXpath));

        return satirElementi;
    }

    public String hucreWebelementGetir(int satir, int sutun) {
        String dinamikHucreXpath = "//tbody//tr[" + 2 + "]//td[" + sutun + "]";
        WebElement istenenHucrelementi = Driver.getDriver().findElement(By.xpath(dinamikHucreXpath));
        String hucredatasi = istenenHucrelementi.getText();

        return hucredatasi;

    }

    public void sutunYazdir(int sutun) {
        // her bir satirdaki istenen sutun elementini yazdirabilmek icin
        // once satir sayisini bilmeye ihtiyacim var
        int satirsayisi=satirlarListesi.size();
        for (int i=1 ; i<=satirsayisi ; i++ ){
            System.out.println(hucreWebelementGetir(i, sutun));
        }
    }
}