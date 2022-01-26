package tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class H2 {

    //Yeni bir Class Olusturun : D11_SoftAssert1
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1.“https://www.hepsiburada.com/” Adresine gidin
        driver.navigate().to("https://www.hepsiburada.com/");
    }
    @Test (priority = 1)
    public void titletest() {
        //2.Basliginin “ Turkiye’nin En Buyuk Alisveris Sitesi " icerdigini dogrulayin
        String title = driver.getTitle();
        String istenenTitle = "Turkiye’nin En Buyuk Alisveris Sitesi";
        softAssert = new SoftAssert();
        softAssert.assertTrue(title.contains(istenenTitle), "Title 'Turkiye’nin En Buyuk Alisveris Sitesi' içermiyor!");
    }
    @Test(dependsOnMethods ="titletest" )
    public void searchTest(){
        //3.search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba", Keys.ENTER);
    }
    @Test(dependsOnMethods ="searchTest")
    public void bulunanSonuçSayısı(){
        //bulunan sonuç sayısını yazdırın
        WebElement sonuçSayısıElementi=driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']"));
        System.out.println("Sonuç sayısı : "+sonuçSayısıElementi.getText());
    }
    @Test
    public void sonuçYazısı(){
        //5.sonuc yazisinin "araba" icerdigini dogrulayin
        WebElement sonuçYazısıElementi= driver.findElement(By.xpath("//div[@class='moria-search-results-count']"));
        String sonuçYazısıString=sonuçYazısıElementi.getText();
        softAssert.assertTrue(sonuçYazısıString.contains("araba"),"Sonu yazısı 'araba' içermiyor.");
        //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin   (AssertFalse)
        softAssert.assertFalse(sonuçYazısıString.contains("oto"),"Sonuç yazısı 'oto' içermiyor.");
    }
    @AfterClass
    public void teardown(){
        softAssert.assertAll();
        driver.close();
    }
}
