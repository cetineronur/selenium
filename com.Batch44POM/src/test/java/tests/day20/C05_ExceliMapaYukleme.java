package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapaYukleme {

    @Test
    public void test01(){
        //dosya yolu ve sayfa ismi verilen bir excel sheetin map olarak kaydeden
        //reusable bir metod olusturalim.

        String path="src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi="Sayfa1";

        Map<String,String> ulkelerMap= ReusableMethodsExcel.mapOlustur(path, sayfaAdi);

        //olusturdugunuz map'i kullanarak Turkey'in bilgilerinin yazdirin.

        System.out.println(ulkelerMap.get("Turkey"));

        //Listede NetherLands oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));
    }
}
