package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class h1 {
    public static void main(String[] args) throws InterruptedException {
        //1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        if(driver.getTitle().contains("facebook")){
            System.out.println("title facebook yazisini iceriyor");
        }else{
            System.out.println("title facebook yazisini icermiyor");
        }
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’iyazdirin.
       if( driver.getCurrentUrl().contains("facebook")){
           System.out.println("URL facebook kelimesini iceriyor");
       }else{
           System.out.println(driver.getCurrentUrl());
       }
        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");
        //5.Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        if(driver.getTitle().contains("Walmart.com")){
            System.out.println("sayfa basligi Walmart.com iceriyor");
        }else{
            System.out.println("Walmart.com icermiyor.");
        }
        //6.Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7.Sayfayi yenileyin
        driver.navigate().refresh();
        //8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //9.Browser’i kapatin
        driver.close();
    }
}
