package tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class H3 {

    //..Exercise2...
//  http://www.bestbuy.com 'a gidin,

//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
//      mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    //...Exercise2...
    //   http://www.bestbuy.com 'a gidin,
    @Before
    public void testtenOnce () {
        driver.navigate().to("http://www.bestbuy.com");
    }
    //   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    @Test
    public void titleTesti () {
        String actualTitle=driver.getTitle();
        String expectedTitle="Best";
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title Best kelimesi icermiyor");
    }
    @Test
    public void test () {
        //   Ayrica Relative Locator kullanarak;
        //       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        WebElement helloLogo=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement bestBuylogo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloLogo));
        Assert.assertTrue(bestBuylogo.isDisplayed());
    }
    //       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    @Test
    public void mexicoLinkTest () {
        WebElement yaziElement = driver.findElement(By.xpath("//h1[1]"));
        WebElement usaElement = driver.findElement(By.xpath("(//h4[.='United States'])[1]"));
        WebElement mexicoElement = driver.findElement(RelativeLocator.with(By.tagName("h4")).below(yaziElement).toRightOf(usaElement));
        Assert.assertTrue(mexicoElement.isDisplayed());
    }
    @AfterClass
    public static void tearDown () {
        //driver.close();
    }
}
