package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

      // 3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();

      // 4-Sayfa basliginin “Google” ifadesi icerdigini test edin.
        String actualSeiteTitlr=driver.getTitle();
        String findenWort = "Google";

        if(actualSeiteTitlr.contains(findenWort)){
            System.out.println("Title Test PASSED");

        }else{
            System.out.println("Title testi FAILED");
        }
      // 5- Arama cubuguna “Nutella” yazip aratin
        WebElement findBox= driver.findElement(By.xpath("//input[@name='q']"));
        findBox.sendKeys("Nutella", Keys.ENTER);


      // 6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());


        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisiString=sonucSayisi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
        String sonucNutellaSayisiString=sonucKelimeleri[1]; // 73.900.000
        sonucNutellaSayisiString=sonucNutellaSayisiString.replace(".","");
        int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisiString);
        if (nutellaAramaSonucu>10000000){
            System.out.println("Nutella arama testi PASSED");
        } else {
            System.out.println("Nutella arama testi FAILED");
        }

      // 8-Sayfayi kapatin
        driver.close();

    }
}
