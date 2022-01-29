package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test(){

        System.out.println(System.getProperty("user.home"));

        // yani dinamik olarak masaustundeki yeni klasorunun pathini yazmak istersem.
        String path = System.getProperty("user.home")+"\\Desktop\\yeni\\Yeni Metin Belgesi.txt";
        System.out.println(path);

        // MAsaustunde yeni klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin.
        // masaustunde yeni klasoru yoksa calismaz.
        //1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim.
        String dosyayolu =System.getProperty("user.home")+"\\Desktop\\Yeni\\Yeni Metin Belgesi.txt";
        System.out.println(Files.exists(Paths.get(dosyayolu)));

        // projemizde pom.xml oldugunu test edin.
        System.out.println(System.getProperty("user.dir")); // projemin yolunu verir
        String pomPath=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));

    }
}
