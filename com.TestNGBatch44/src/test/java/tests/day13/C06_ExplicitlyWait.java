package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C06_ExplicitlyWait extends TestBase {

    @Test
    public void test() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedCondition)
    }
}
