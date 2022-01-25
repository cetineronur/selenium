package day03_WebelementsLocations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CO1_TekrarTest {
    public static void main(String[] args) {
       // 1. Yeni bir class olusturun (TekrarTesti)
       // 2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
            System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://youtube.com");
            if(driver.getTitle().equals("youtube")){
                System.out.println("Youtube title testi PASS");
            }else{
                System.out.println("Youtube title testi FAILED: "+driver.getTitle());
            }
       // 3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        if(driver.getCurrentUrl().contains("youtube")){
            System.out.println("sayfa URL 'youtube' iceriyor.");
        }else{
            System.out.println("sayfa URLsi 'youtube' icermiyor."+driver.getCurrentUrl());
        }
       // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://amazon.com");
       // 5. Youtube sayfasina geri donun
        driver.navigate().back();
       // 6. Sayfayi yenileyin
        driver.navigate().refresh();
       // 7. Amazon sayfasina donun
        driver.navigate().forward();
       // 8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
       // 9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        if(driver.getTitle().contains("Amazon")){
            System.out.println("Actual Title: Amazon iceriyor.");
        }else{
            System.out.println("Actual Title: "+driver.getTitle());
        }
       // 10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        if(driver.getCurrentUrl().equals("https://www.amazon.com/")){
            System.out.println("Amazon URL testi PASS");
        }else{
            System.out.println("Amazon URL testi FAILED\nActual Amazon Url"+driver.getCurrentUrl());
        }
       // 11.Sayfayi kapatin
        driver.close();

    }
}
