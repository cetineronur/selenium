package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test(){
    //   https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

    //   chooseFile butonuna basalim

        WebElement filesecbutonu = driver.findElement(By.id("file-upload"));
        //2-yukleyecegimiz dosyanin dinamik pah'ini hazirlayalim.

        String dosyayolu=System.getProperty("user.home")+"\\Desktop\\yeni\\Yeni Metin Belgesi.txt";

        //3-sendKeys() metodu ile dinamik path'i dosya sec butonuna yollayalim.
        filesecbutonu.sendKeys(dosyayolu);

    //   Yuklemek istediginiz dosyayi secelim.
    //   Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

    //   “File Uploaded!” textinin goruntulendigini test edelim
        WebElement sonuctextyazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonuctextyazisi.isDisplayed());

    }
}
