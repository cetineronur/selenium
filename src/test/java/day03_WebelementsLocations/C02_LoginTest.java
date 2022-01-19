package day03_WebelementsLocations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_LoginTest {
    public static <list> void main(String[] args) throws InterruptedException {
      System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        1. Bir class oluşturun: LoginTest
//        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
//         a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

//        b. Sign in butonuna basin
       WebElement signInLinki = driver.findElement(By.id("sign-in"));
       signInLinki.click();

//        c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox= driver.findElement(By.id("session_password"));
        WebElement signInButtonu= driver.findElement(By.name("commit"));

//        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
//        i. Username : testtechproed@gmail.com
//        ii. Password : Test1234!
       emailTextBox.sendKeys("testtechproed@gmail.com");
       passwordTextBox.sendKeys("Test1234!");
       // Thread.sleep(3000);
       signInButtonu.click();

//        e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement girisYazisiElementi = driver.findElement(By.tagName("h1"));
        System.out.println(girisYazisiElementi.getText());
        String girisYazisi= girisYazisiElementi.getText();
        String expectedGirisYazisi="Welcome to Address Book";
        if(girisYazisi.equals(expectedGirisYazisi)){
            System.out.println("sayfaya giris yazisi PASS");
        }else{
            System.out.println("sayfaya giris yazisi FAILED");
        }

//      f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adresWebElementi = driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi = driver.findElement(By.linkText("Sign out"));
        if(adresWebElementi.isDisplayed()){
            System.out.println("adres elementi goruntuleme testi PASS");
        }else{
            System.out.println("adres elementi goruntuleme testi FAILED");
        }

        if(signOutElementi.isDisplayed()){
            System.out.println("signout elementi goruntuleme testi PASS");
        }else{
            System.out.println("signout elementi goruntuleme testi FAILED");
        }

//       3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        System.out.println("sayfada "+linkler.size()+" adet link bulunmaktadir");
        driver.close();
    }
}
