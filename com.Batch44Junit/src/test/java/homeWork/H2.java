package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H2 {


    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tierdown(){
        //driver.close();
    }

    @Test
    public void test01(){
      // n11 sayfasına git,
        driver.get("https://www.n11.com");

      // JBL kulaklık arat,
        WebElement search =driver.findElement(By.id("searchData"));
        search.sendKeys("JBL");
        driver.findElement(By.xpath("//a[@class='searchBtn']")).click();

      // gelen ilk ürünü tıkla
        driver.findElement(By.xpath("(//h3[@class='productName'])[1]")).click();

      // ürünü sepete ekle
        driver.findElement(By.xpath("//a[@data-uniskuid='127049690953']")).click();
    }

    @Test
    public void test02(){

       // JBL Blutoth hoparlör arat,
        WebElement search =driver.findElement(By.id("searchData"));
        search.sendKeys("JBL Blutoth hoparlör");
        driver.findElement(By.xpath("//a[@class='searchBtn']")).click();

       // gelen ilk ürüne tıkla
        driver.findElement(By.xpath("//a[@data-id='523517729']")).click();

       // ürünü sepete ekle
        driver.findElement(By.xpath("//a[@data-uniskuid='127069099535']")).click();
    }

    @Test
    public void test03(){
       // sepete git,
        driver.findElement(By.xpath("(//a[@rel='nofollow'])[5]")).click();
       driver.findElement(By.xpath("//span[text()='Tamam']")).click();

       // kaç tane ürün olduğuna bak,
        WebElement text = driver.findElement(By.xpath("//b[text()='Toplam 2 ürün']"));
        String actualText=text.getText();
        String expectedText="Toplam 2 ürün";
        Assert.assertEquals(actualText,expectedText);

       // ürünlerin seçilen ürün olup olmadığını doğrula
        WebElement ersteProduct= driver.findElement(By.xpath("(//a[@class='prodDescription'])[1]"));
        String actual1=ersteProduct.getText();
        String expected1="JBL Flip Essential Taşınabilir Bluetooth Hoparlör";
        Assert.assertEquals(actual1,expected1);

        WebElement zweiProduct= driver.findElement(By.xpath("(//a[@class='prodDescription'])[2]"));
        String actual2=zweiProduct.getText();
        String expected2="JBL Tune 225 TWS Bluetooth Kulak İçi Kulaklık";
        Assert.assertEquals(actual2,expected2);
    }

}
