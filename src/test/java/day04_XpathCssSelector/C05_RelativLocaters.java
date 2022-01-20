package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativLocaters {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");


        //once uzerinden tarif edecegimiz web elemnetlerini locate etmeliyiz

        WebElement sailor= driver.findElement(By.id("pid11_thumb"));
        WebElement baston = driver.findElement(By.id("pid6_thumb"));
        WebElement  bay_area = driver.findElement(By.id("pid8_thumb"));
        WebElement nyc= driver.findElement(By.id("pid3_thumb"));

        //2 ) Berlin’i  3 farkli relative locator ile locate edin
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(baston));
        System.out.println(berlin1.getAttribute("id"));

        //3 ) Relative locator’larin dogru calistigini test edin
    }
}
