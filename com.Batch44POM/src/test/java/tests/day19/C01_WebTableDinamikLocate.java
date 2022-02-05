package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebTableDinamikLocate {
    //3 test metodu olusturalim.


    HMCWebTablePage hmcWebTablePage;
    HotelMyCampPage hotelMyCampPage;

    @Test
    public void satirYazdirTesti() {
        //1. method satir numarasi verdigimde bana o satirrdaki datalari yazdirsin
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hmcWebTablePage = new HMCWebTablePage();

        WebElement ucuncusatirElementi = hmcWebTablePage.satirGetir(4);

        System.out.println(ucuncusatirElementi.getText());
        Driver.closeDriver();

    }

    @Test
    public void hucreGetirTesti() {
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hmcWebTablePage = new HMCWebTablePage();
        //2.mehhod satir no ve data numarasi gidigimde verdigim datayi yazdirsin
        //2.satirin 4.datatsi //tbody//tr[2]//td[4]
        //4.satirin 5.datasi  //tbody//tr[4]//td[5]

        System.out.println("Girdiginiz hucredeki element: " + hmcWebTablePage.hucreWebelementGetir(5, 3));
    }

    @Test
    public void sutunYazdir() {

        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hmcWebTablePage = new HMCWebTablePage();
        //3.method sutun numarasi verdigimde bana tum sutunu yazdirsin
        hmcWebTablePage.sutunYazdir(4);

    }

}
