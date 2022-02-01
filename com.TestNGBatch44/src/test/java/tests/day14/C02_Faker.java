package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import javax.swing.*;
import java.security.Key;

public class C02_Faker extends TestBase {

    @Test
    public void facebookkayitTest() throws InterruptedException {

   //     "https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[text()='Tüm Çerezlere İzin Ver']")).click();

   //     “create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

   //     “firstName” giris kutusuna bir isim yazin
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();
        actions.click(firstName).sendKeys(faker.name().firstName()).

   // “surname” giris kutusuna bir soyisim yazin
        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).

   // “email” giris kutusuna bir email yazin
           sendKeys(Keys.TAB).sendKeys(email).

   // “email” onay kutusuna emaili tekrar yazin
           sendKeys(Keys.TAB).sendKeys(email).

   //     Bir sifre girin
        sendKeys(Keys.TAB).sendKeys(faker.internet().password()).

   //     Tarih icin gun secin
        sendKeys(Keys.TAB).sendKeys(faker.date().birthday().toString()).

   //     Tarih icin ay secin
        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Jan").

   //     Tarih icin yil secin
        sendKeys(Keys.TAB).sendKeys("1978").

   //     Cinsiyeti secin
           sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();

   //     Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement man = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement weiblich = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        Assert.assertTrue(man.isSelected());
        Assert.assertFalse(weiblich.isSelected());
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();


    }
}
