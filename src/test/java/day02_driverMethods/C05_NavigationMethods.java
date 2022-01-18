package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigationMethods {
    public static void main(String[] args) {
      // 1. Yeni bir Class olusturalim.C02_NavigationMethods
       System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
      // 2. Youtube ana sayf,asina gidelim . https://www.youtube.com/
     driver.navigate().to("https://youtube.com");
      // 3. Amazon soyfasina gidelim. https://www.amazon.com/
       driver.navigate().to("https://amazon.com");
      // 4. Tekrar YouTube’sayfasina donelim
       driver.navigate().back();
      // 5. Yeniden Amazon sayfasina gidelim
       driver.navigate().forward();
      // 6. Sayfayi Refresh(yenile) yapalim
       driver.navigate().refresh();
      // 8. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close(); // varsa acik olan tum sayfalari kapatir.
        // close ise son bulundugu sayfayi kapatir.

    }
}
