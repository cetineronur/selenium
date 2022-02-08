package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.util.List;

public class C02_WebTables {

    HotelMyCampPage hotelMyCampPage;
    HMCWebTablePage hmcWebTablePage;

    @Test
    public void loginT(){
     //   ● Bir class oluşturun : C02_WebTables
     //   ● login( ) metodun oluşturun ve oturum açın.
     //   ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
     //       ○ Username : manager
     //       ○ Password : Manager1!
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();

    }

    @Test
    public void table(){
        //   ● table( ) metodu oluşturun
        //       ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //     //thead//tr[1]//td
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
       HMCWebTablePage hmcWebTablePage=new HMCWebTablePage();
        System.out.println(hmcWebTablePage.allTableColumnNumber.size());

    }


    @Test(dependsOnMethods = "loginT")
    public void printRows(){
        //       ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //   ● printRows( ) metodu oluşturun //tr
        //       ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
       HMCWebTablePage hmcWebTablePage=new HMCWebTablePage();
        System.out.println();
        System.out.println(hmcWebTablePage.allTableRowNumber.size());


        //       ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println();
        for (WebElement each: hmcWebTablePage.allTableRowNumber) {
            System.out.println(each.getText());
        }


        //       ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println();
        for (WebElement each:hmcWebTablePage.line4Elements) {
            System.out.println(each.getText());
        }

    }
}
