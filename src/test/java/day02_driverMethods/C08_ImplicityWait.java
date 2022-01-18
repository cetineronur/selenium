package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_ImplicityWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // implicitlywait testimiz boyunca sayfa acilmasi ve element bulunmasi konusunda driver'in bekleyecegi maximum sureyi belirler
        // bu sure iceriisinde gorevini bitirir bitirmez, bir sonraki adima gecer.
        //bu sure icerisinde bitiremezse o zaman hata verir.

        driver.get("https://techproeducation.com");
        driver.close();

    }
}
