package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H4 {
// ...Exercise4...

// Under the  ORIGINAL CONTENTS
// click on Alerts
// print the URL
// navigate back
// print the URL
// Click on Basic Ajax
// print the URL
// enter value-> 20 and Enter
// and then verify Submitted Values is displayed open page
// close driver

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//a[@id='alerts']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        driver.getCurrentUrl();
        driver.findElement(By.id("lteq30")).sendKeys("20", Keys.ENTER);
        WebElement display = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        String actual =display.getText();
        String expected="Submitted Values";
        Assert.assertEquals(actual,expected);
        System.out.println("Submitted Values text is displayed");
    }


    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
