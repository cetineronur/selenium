package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathText {
    public static void main(String[] args) {
        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- Add Element butonuna basin
        WebElement addButton= driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();

        // 3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deletButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        if(deletButton.isDisplayed()){
            System.out.println("Delete buttonu gorunuyor test: PASS");
        }else{
            System.out.println("Delete buttonu gorunuyor testi: FAILED");
        }
        // 4- Delete tusuna basin
        deletButton.click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addYazisiElementi = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));

        if(addYazisiElementi.isDisplayed()){
            System.out.println("add yazisi gorunuyor test: PASS");
        }else{
            System.out.println("add yazisi gorunuyor testi: FAILED");
        }
        driver.close();
    }

}
