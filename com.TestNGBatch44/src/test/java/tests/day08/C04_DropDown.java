package tests.day08;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {


    WebDriver driver;
    WebElement dropdown;
    Select select;

    @BeforeClass
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     //  ● Bir class oluşturun: C3_DropDownAmazon
     //  ● https://www.amazon.com/ adresine gidin.

        driver.get("https://www.amazon.com/");

    }

    @Test
    public void dropdownTest1(){
        //  - Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdown);

        List<WebElement> optionList = select.getOptions();

        int actualOptionSayisi = optionList.size();
        int expectedOptionsayisi=45;

        Assert.assertEquals(actualOptionSayisi,expectedOptionsayisi);

    }

    @Test
    public void dropdownTest2(){
        //  -Test 2
        //  1. Kategori menusunden Books secenegini  secin
        select.selectByIndex(5);


        //  2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);


        //  3. Bulunan sonuc sayisini yazdirin
               WebElement Result=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
               System.out.println("Bulunan sonuc Sayısı: " + Result.getText().substring(12).replaceAll("\\D",""));


        // 4. Sonucun Java kelimesini icerdigini test edin
               String result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
               String expected="Java";
               Assert.assertTrue(result.contains("Java"),expected);
    }

    @AfterClass
    public void teardown(){

        driver.close();
    }
}
