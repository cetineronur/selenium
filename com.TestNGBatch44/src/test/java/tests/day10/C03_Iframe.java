package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {



    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void IframeTest(){
        //  ● Bir class olusturun: IframeTest
        //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //  ● Bir metod olusturun: iframeTest
        //     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement istenenYazi = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(istenenYazi.isEnabled(),"An IFrame containing…. yazisi gorunmuyor");
        System.out.println(istenenYazi.getText());

        //     ○ Text Box’a “Merhaba Dunya!” yazin.

        // yazi yazmak istedigimiz ttext kutusu iframe'in icinde oldugundan direk ulasamiyoruz.
        //once iframe locate edip onun icine switch yapmaliyiz.
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement textbox=driver.findElement(By.tagName("p"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dunya!");

        //     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini tiklayin.
        // yukarida iframe'in icine switch yaptigimizdan yeniden disari cikmaliyiz.
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        //     textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        // sponsored yazisi yeni sayfada oldugundan ve driver eski sayfada kaldigindan yaz<iyi locate edemedik.

        WebElement sponsortYazisi = driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
        softAssert.assertTrue(sponsortYazisi.isDisplayed(),"Yazi gorunmuyor.");
        softAssert.assertAll();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
