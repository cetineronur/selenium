package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {

    @Test
    public void screenTest(){
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//div[.='Kabul ediyorum']")).click();
        // screenshot almak icin obje olusturalim ve deger olarak driver'imizi atayalim.
        // casting yapmak gerekir.
        TakesScreenshot screenshot =(TakesScreenshot) driver;

        File tumSayfaSS = new File("\\src\\tumSayfa.png");

        //olusturdugumuz file ile takesscreenshot objesini iliskilendirelim.

        tumSayfaSS = screenshot.getScreenshotAs(OutputType.FILE);

        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));



    }

}
