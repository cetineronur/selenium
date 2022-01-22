package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {

  // 1) Bir class oluşturun: YoutubeAssertions
  // 2) https://www.youtube.com adresine gidin
  // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
  // ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
  // ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
  // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
  // ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){

        String actualTiitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals("Test girdilerini kontrol ediniz",expectedTitle,actualTiitle);
    }

    @Test
    public void imageTest(){
        driver.findElement(By.xpath("//yt-formatted-string[text()='Kabul ediyorum']")).click();
        WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
    WebElement searchBox = driver.findElement(By.xpath("(//input[@id='search'])"));
    Assert.assertTrue(searchBox.isDisplayed());

    }

    @Test
    public void wrongTitleTest(){
        String actualTiitle= driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse(actualTiitle.contains(expectedTitle));

    }

    @AfterClass
    public static void teardown(){
       driver.close();
    }

}
