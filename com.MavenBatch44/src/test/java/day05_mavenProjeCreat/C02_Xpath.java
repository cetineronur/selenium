package day05_mavenProjeCreat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

      // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

      // 3. Login alanine  “username” yazdirin
        WebElement userNAme=driver.findElement(By.xpath("//input[@id='user_login']"));
        userNAme.sendKeys("username");

      // 4. Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

      // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

      // 6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='pay_bills_tab']")).click();

      // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("5000");

      // 8. tarih kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");

      // 9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

      // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        if(driver.findElement(By.xpath("//div[@id='alert_content']")).getText().contains("The payment was successfully submitted.")){
            System.out.println("cikti kontrol PASSED");
        }else{
            System.out.println("cikti kontrol FAILED");
        }
    }
}
