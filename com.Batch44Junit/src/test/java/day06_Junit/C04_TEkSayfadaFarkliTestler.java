package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public  class C04_TEkSayfadaFarkliTestler {

    static WebDriver driver;
    static WebElement aramaKutusu;
    static WebElement sonucYazisiElement;

    @Test
    public void test01(){
        // amazon sayfasinda nutella icin arama yazip sonuc yazisini nutella icerdigini tets edelim
        aramaKutusu.sendKeys("nutella", Keys.ENTER);
        sonucYazisiElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucuYazisi=sonucYazisiElement.getText();
        String arananKelime="nutella";

        if(actualSonucuYazisi.contains(arananKelime)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
        }

    }
    @Test
    public void test02(){
        // amazon sayfasinda java icin arama yazip sonuc yazisini java icerdigini tets edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.clear();
        aramaKutusu.sendKeys("java", Keys.ENTER);
        sonucYazisiElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucuYazisi=sonucYazisiElement.getText();
        String arananKelime="java";

        if(actualSonucuYazisi.contains(arananKelime)){
            System.out.println("java testi PASSED");
        }else {
            System.out.println("java testi FAILED");
        }


    }
    @Test
    public void test03(){
        // amazon sayfasinda ali icin arama yazip sonuc yazisini ali icerdigini tets edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.clear();
        aramaKutusu.sendKeys("ali", Keys.ENTER);
        sonucYazisiElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucuYazisi=sonucYazisiElement.getText();
        String arananKelime="ali";

        if(actualSonucuYazisi.contains(arananKelime)){
            System.out.println("ali testi PASSED");
        }else {
            System.out.println("ali testi FAILED");
        }


    }

    @BeforeClass
    public static void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    }

    @AfterClass
    public static void ortaligiTopla(){
        driver.close();


    }
}
