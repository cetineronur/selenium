package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebelement extends TestBase {

    @Test
    public void test01() throws InterruptedException, IOException {

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // nutella icin arama yapalim.
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim.
        WebElement sonucyazisielementi= driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucsayisiStr=sonucyazisielementi.getText();
        Assert.assertTrue(sonucsayisiStr.contains("Nutella"));

        //testin calistigini ispat icin sonuc sayisi webelmentinin screenshot edelim.
        File webelementsSS=new File("target/screenShot/webelement.jpeg");
        File geciciResim=sonucyazisielementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,webelementsSS);
    }
}
