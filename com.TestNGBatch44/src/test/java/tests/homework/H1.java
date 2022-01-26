package tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class H1 {
    //1. “https://www.hepsiburada.com/” Adresine gidin
    //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3. search kutusuna araba yazip arattirin
    //4. bulunan sonuc sayisini yazdirin
    //5. sonuc yazisinin "araba" icerdigini dogrulayin
    //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
    }


    @Test
    public void test1() {
        String acaualTitle = driver.getTitle();
        String expectedTitle="Turkiye’nin En Buyuk Alisveris Sitesi";
        Assert.assertEquals(acaualTitle,expectedTitle);

    }

    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("araba", Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='moria-search-results-count']"));
        System.out.println("sonuc = " + sonuc.getText());
        String expectedResult="araba";
        Assert.assertTrue(sonuc.getText().contains(expectedResult),"sonuc araba icermiyor");
        Assert.assertTrue(sonuc.getText().contains("oto"),"sonuc oto iceremiyor");

    }

    @AfterClass
    public void teardown() {

    }
}
