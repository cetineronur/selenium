package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class h4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        WebElement signIdAmazon = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        signIdAmazon.click();
       WebElement benutzerNameTExtBox= driver.findElement(By.cssSelector("input[type='email']"));
        benutzerNameTExtBox.sendKeys("gurutechproeducation@gmail.com", Keys.ENTER);
        WebElement geheimzahlBox= driver.findElement(By.cssSelector("input[type='password']"));
        geheimzahlBox.sendKeys("guru2022", Keys.ENTER);
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();//hello guruya girdik
        driver.findElement(By.xpath("//a[@href='https://www.amazon.com/a/addresses?ref_=ya_d_l_addr']")).click();//adresse girdik.
        driver.findElement(By.xpath("//div[@class='a-box-inner a-padding-extra-large']")).click();//adress ekleye giriyoruz


    }
}
