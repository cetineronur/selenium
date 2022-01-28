package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookAnmeldung extends TestBase {

    @Test
    public  void test(){

      //  1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

      //  2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

      //  3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement name= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.click(name).keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).
                sendKeys("nur").sendKeys(Keys.TAB).
                keyDown(Keys.SHIFT).sendKeys("c").
                keyUp(Keys.SHIFT).sendKeys("etiner").sendKeys(Keys.TAB).
                sendKeys("cetineronur44@gmail.com").sendKeys(Keys.TAB).
                sendKeys("cetineronur44@gmail.com").sendKeys(Keys.TAB).
                sendKeys("Aa11s2345-").perform();

        WebElement birtday= driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select = new Select(birtday);
        select.selectByIndex(18);
        driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();

      //  4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }
}
