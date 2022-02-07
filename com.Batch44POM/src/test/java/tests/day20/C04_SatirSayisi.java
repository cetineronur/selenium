package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatirSayisi {

    @Test
    public void test01() throws IOException {
        //ulkeler excelindeki Sayfa1 ve Sayfa2'deki satir sayilarini
        //ve kullanilan satir sayilarinin bulun.

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis =new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        int Sayfa1SatirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        int sayfa1FizikiKullanilanSatirSayisi=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("1.sayfa satiri sayisi: "+Sayfa1SatirSayisi);
        System.out.println("Fiziki kullanilan satir sayisi: "+sayfa1FizikiKullanilanSatirSayisi);

        // fiziki kullanilan satir sayisi index ile degil sayma sayilari ile calisir
        System.out.println();
        int Sayfa2SatirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        int sayfa2FizikiKullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("2.sayfa satiri sayisi: "+Sayfa2SatirSayisi);
        System.out.println("2.sayfa Fiziki kullanilan satir sayisi: "+sayfa2FizikiKullanilanSatirSayisi);
    }
}
