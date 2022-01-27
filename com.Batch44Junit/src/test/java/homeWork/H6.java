package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H6 {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
 */


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void creatButton(){
        WebElement creatButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

        for (int i=0; i<100; i++){
            creatButton.click();
        }

    }

    @Test
    public void deleteButton() throws InterruptedException {

        Thread.sleep(3000);
        int sayac=0;
        for (int i=0; i<60; i++){
            WebElement deleteButton = driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]"));
            deleteButton.click();
            sayac++;
        }
        System.out.println("Ekranda "+(100-sayac)+" tane delete butonu kalmistir");
    }
}
