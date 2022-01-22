package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H1 {
    static  WebDriver driver;

    @Test
    public void testSignInUser() {
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
        WebElement userName=driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement userPassword=driver.findElement(By.id("user_password"));
        userPassword.sendKeys("password");
        driver.findElement(By.xpath("//label[@for='user_remember_me']")).click();
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

    }

    @Test
    public void onlineBanking() {
        driver.findElement(By.id("onlineBankingMenu")).click();


    }
    @Test
    public void testC() {
        System.out.println("C");

    }

    @BeforeClass
    public static void settingsSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get("http://zero.webappsecurity.com/");

    }
    @AfterClass
    public static void endingTest(){
    driver.close();
    }
}
