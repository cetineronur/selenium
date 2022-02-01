package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecuterScroll extends TestBase {

    @Test
    public void scroolaction() throws InterruptedException {

        //  1- Yeni bir class olusturun : ScroolInto
        //  2- hotelmycamp anasayfasina gidin
            driver.get("https://www.hotelmycamp.com");

        //  3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
        Thread.sleep(1000);

        //  4- istediginiz oda inceleme sayfasi acildigini test edin
        String url= driver.getCurrentUrl();
        String expected = "https://www.hotelmycamp.com/RoomDetail/147";
        Assert.assertEquals(url,expected);

    }

    @Test
    public void scroolJsExecuter(){

        driver.get("https://www.hotelmycamp.com");
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        WebElement odainceleLinki = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",odainceleLinki);
        jse.executeScript("arguments[0].click();",odainceleLinki);
    }
}
