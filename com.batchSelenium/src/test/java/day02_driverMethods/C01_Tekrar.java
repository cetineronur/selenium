package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {
    // intellijde yeni bir proje actigimizda oncelikle selenium kutuphanelerini projeye eklemek gerekir.
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        //setProperty methodu 2 parametre ister.
        // ilki kullanacagimiz browser'a ait driver
        // ikinci parametre ise selenium idesinden
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);// 5000 ms kodlarin calismasini durdurur.
        driver.close(); // classin sonuna yazilir. cunku  kod calisinca driver kapanir.
    }
}
