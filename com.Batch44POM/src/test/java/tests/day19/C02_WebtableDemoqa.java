package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebtableDemoqa {

    @Test(groups = {"smoke","regression"})
    public void demoqaTest(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));

        DemoqaPage demoqaPage=new DemoqaPage();

        //  2. Headers da bulunan department isimlerini yazdirin
        //  normlde //thead//th olurdu ancak bu tablo class isimleri ile organize edilmis
        //1.Yol:
        System.out.println("baslik satiri elementi : "+demoqaPage.baslikSatiriElementi.getText());
        System.out.println();

        //2.Yol
        for (WebElement each: demoqaPage.depertmentNames) {
            System.out.print(each.getText()+" ");
        }

        //  3. 3.sutunun basligini yazdirin

        //1.Yol
        System.out.println();
        System.out.println("3.sutun basligi : "+demoqaPage.basliklarWebelementiListesi.get(2).getText());
        //2.Yol
        System.out.println();
        System.out.println("3.Sutunun basligi: "+demoqaPage.depertmentNames.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("===========Tum body==========");
        System.out.println(demoqaPage.bodyTekWebelement.getText());
        System.out.println();
        for (WebElement each: demoqaPage.allData) {
            System.out.print(each.getText()+" ");
        }
        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println();
        System.out.println("Tablodaki data sayisi : "+demoqaPage.allData.size());
        System.out.println();
        System.out.println("Tablodaki data sayisi : "+demoqaPage.tumDataWebelementList.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println();
        System.out.println("tablodaki satir sayisi: "+demoqaPage.rowNumber.size());
        System.out.println();
        System.out.println("Tum satir sayisi : "+demoqaPage.tumSatirlarWebelementList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     farkli yollardan hesaplanabilir ama biz hucre sayisi / satir sayisi yapalim
        System.out.println();
        System.out.println("tablodaki sutun sayisi: "+demoqaPage.allData.size()/demoqaPage.rowNumber.size());
        System.out.println();
        System.out.println("tablodaki sutun sayisi : " +
                (demoqaPage.tumDataWebelementList.size()/demoqaPage.tumSatirlarWebelementList.size()));

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println();
        int rowNumber=demoqaPage.rowNumber.size();

        for (int i=1;i<=rowNumber;i++) {
            System.out.println(Driver.getDriver().findElement(By.xpath("(//div [@class='rt-tr-group'])[" + i + "]//div[@class='rt-td'][3]")).getText());
        }
        System.out.println();
        demoqaPage.sutunYazdir(2);


        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println();
        for (int i=0;i<70;i+=7){
            if(demoqaPage.allData.get(i).getText().equals("Kierra")){
                System.out.println("Kierra'nin maasi: "+demoqaPage.allData.get(i + 4).getText());
            }
        }
        System.out.println();

        demoqaPage.ismeGoreMaasYazdir("Alden");

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println();
        demoqaPage.cellGet(3,2);
        System.out.println();
        demoqaPage.hucreYazdir(3,2);

        Driver.closeDriver();
    }
}
