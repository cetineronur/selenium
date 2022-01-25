package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class h3 {
    public static void main(String[] args) {
       // Bir Class olusturun AmazonSearchTest
       // 2. Main method olsuturun ve asagidaki gorevi tamamlayin.
       // a. Amazon web sayfasina gidin. https://www.amazon.com
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

       // b. Search “city bike”
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("city bike");
        search.submit();// istersek Keys.ENTER de yapabiliriz.

       // c. Amazonda goruntulenen ilgili sonuc sayisini yazdirin
      WebElement fear_gear_bikes = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[6]"));
       // System.out.println("iligili sinuc sayisi: "+ilgiliSonucSayisi.size());
        ///fear_gear_bikes.click();

       // d. Sonra karsinizia cikan ilk sonucun resmine tiklayin…
    driver.findElement(By.xpath("//img[@alt='Sponsored Ad - KESPOR K7 Folding Bike for Adults, Women, Men, Rear Carry Rack, Front and Rear Fenders, Shimano 7 Speed Alu...']")).click();


    }
}
