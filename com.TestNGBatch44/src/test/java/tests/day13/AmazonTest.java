package tests.day13;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class AmazonTest extends TestBase {


    @Test
    public void test() throws InterruptedException {

        driver.navigate().to("https://facebook.com");
        driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement engElementi = driver.findElement(By.xpath("//a[@href='https://en-gb.facebook.com/']"));
        engElementi.click();


        Thread.sleep(3000);

    }
}