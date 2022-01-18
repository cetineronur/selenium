package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        //sayfa basliginin amazon icerdigini test edin.
        String actualTitle= driver.getTitle();
        String arananKelime="Amazon";
        if(actualTitle.contains(arananKelime)){
            System.out.println("title testi PASS");
        }else{
            System.out.println("Title testi FAILED");
        }
        //SAYFA ADRESINI YAZDIRIN
        System.out.println(driver.getCurrentUrl());

        //sayfa url'nin "amazon" icerdigini test edin.
        String url = driver.getCurrentUrl();
        if(url.contains("amazon")){
            System.out.println("URL Test PASS");
        }else{
            System.out.println("URL Test FAILED");
        }

        //sayfanin handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //html kodlarinda alisveris kelimesinin gectigini test edin.
       String PageSource=driver.getPageSource();
       if(PageSource.contains("alisveris")){
           System.out.println("alisveris kelimesi geciyor");
       }else{
           System.out.println("alisveris kelimesi gecmiyor");
       }
        driver.close();

    }
}
