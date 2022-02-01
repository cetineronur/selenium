package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //amazon.com anasayfasina gidip
        driver.get("https://www.amazon.com");

        JavascriptExecutor jss = (JavascriptExecutor) driver;
        //sell linkine JsExecuter ile tiklayalim
        WebElement selllinki = driver.findElement(By.xpath("//a[text()='Sell']"));
        jss.executeScript("arguments[0].click();",selllinki);
        Thread.sleep(2000);
        //ilgili sayfaya gittiginizi test edelim.

    }
}
