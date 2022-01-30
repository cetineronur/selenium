package tests.day13;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class AmazonTest extends TestBase {

    /*
    facebook hesap olusturma sayfasi testi
    https://www.facebook.com/ sayfasindan >>>Yeni hesap olustur sayfasina gidin
     isim girisi yapin
     soy isim girisi yapin
     cep numarasi +38669645099 girin
     en az 6 rakam bir harf ve noktalama isareti olan sifre girisi yapin
     Dogum tarihi 18 yasindan kucuk bir tarih secin
     cinsiyet secimi yapin farketmez
     kaydol a tiklayin
     beklenen sonuc 18 yas alti uyarisi vermesi
     */

    @Test
    public void warning_letter() throws InterruptedException {
       driver.get("https://www.facebook.com/");
      driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        Actions actions = new Actions(driver);
       /*driver.findElement(By.xpath("//input[@name='email']"));
       actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click();*/


       //driver.findElement(By.xpath("//a[text()='Deutsch']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
       WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
       // Actions actions1 = new Actions(driver);
       actions.sendKeys("Onur").sendKeys(Keys.TAB).sendKeys("Cetiner").
               sendKeys(Keys.TAB).sendKeys("+38669645099").sendKeys(Keys.TAB).sendKeys("123456a.").
               sendKeys(Keys.TAB).perform();

       WebElement birthday= driver.findElement(By.xpath("//select[@id='day']"));
        Select select = new Select(birthday);
        select.selectByValue("21");
        actions.sendKeys(Keys.TAB).

        sendKeys("Kas").
        sendKeys(Keys.TAB).sendKeys("2009").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(5000);

    }

}
