package tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class H4 {
    // 1) "https://www.facebook.com/" SAYFASINA GiDiN
    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

    protected WebDriver driver;
    protected Select select;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
    @Test
    public void test(){
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']")).click();

        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement birthDay= driver.findElement(By.xpath("//select[@id='day']"));
        select =new Select(birthDay);
        List<WebElement> birthdayList = select.getOptions();

        for (WebElement each:birthdayList) {
            System.out.print(each.getText()+" ");
        }
        System.out.println();
        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement birthdayMonth = driver.findElement(By.xpath("//select[@id='month']"));
        select = new Select(birthdayMonth);
        List<WebElement> birtdayMonth=select.getOptions();

        for (WebElement each:birtdayMonth) {
            System.out.print(each.getText()+" ");
        }
        System.out.println();
        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
        select = new Select(year);
        List<WebElement> yearList = select.getOptions();

        for (WebElement each:yearList) {
            System.out.print(each.getText()+" ");
        }
    }
}
