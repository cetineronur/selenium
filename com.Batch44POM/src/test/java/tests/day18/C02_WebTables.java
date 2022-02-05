package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;

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

        hmcWebTablePage = new HMCWebTablePage();
        List<WebElement> headerDAtaList = hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("Tablodaki sutun sayisi : "+headerDAtaList.size());
        System.out.println(hmcWebTablePage.tumBodyWebElement.getText());
        List<WebElement> bodyTumDataList=hmcWebTablePage.tumBodyDatalariList;
        System.out.println("Body'deki data sayisi : "+bodyTumDataList.size());

    }


    @Test(dependsOnMethods = "loginT")
    public void printRows(){
        //       ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //   ● printRows( ) metodu oluşturun //tr
        //       ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        hmcWebTablePage = new HMCWebTablePage();
        System.out.println(hmcWebTablePage.satirlarListesi.size());

        //       ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement> satirlarWebelementListesi=hmcWebTablePage.satirlarListesi;

        for (WebElement each:satirlarWebelementListesi) {
            System.out.println(each.getText());

        }
        //       ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println();
        System.out.println("4. satir : "+satirlarWebelementListesi.get(3).getText());

    }
}
