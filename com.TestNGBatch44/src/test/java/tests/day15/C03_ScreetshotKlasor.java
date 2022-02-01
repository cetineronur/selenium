package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreetshotKlasor extends TestBase {

    //amazona gidin
    //uc farkli test metodu ile java, nutella ve elma aratip
    //sonuc sayfasinin screenshotini kaydedin.

    WebElement searchBox;

    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
         searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);
        tumSayfaScreenshot();
    }

    @Test
    public void test02() throws IOException {

        searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Nutella", Keys.ENTER);
        tumSayfaScreenshot();
    }

    @Test
    public void test03() throws IOException {

        searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("elma", Keys.ENTER);
        tumSayfaScreenshot();
    }
}
