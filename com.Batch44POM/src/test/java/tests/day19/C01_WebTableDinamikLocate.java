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
   public void rowGet(){
       //1. method satir numarasi verdigimde bana o satirrdaki datalari yazdirsin

        hmcWebTablePage = new HMCWebTablePage();
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
       System.out.println(hmcWebTablePage.rowGet(4));

   }
    @Test
    public void cellGet(){
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hmcWebTablePage = new HMCWebTablePage();
        //2.mehhod satir no ve data numarasi gidigimde verdigim datayi yazdirsin
        System.out.println(hmcWebTablePage.cellGet(2, 4).getText());
    }
    @Test
    public void columnGet(){
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        hmcWebTablePage = new HMCWebTablePage();
        //3.method sutun numarasi verdigimde bana tum sutunu yazdirsin.
        hmcWebTablePage.columnGet(5);

    }


}
