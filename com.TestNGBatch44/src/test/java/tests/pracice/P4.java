package tests.pracice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class P4 extends TestBase {

    @Test
    public void test() throws InterruptedException {

   //   go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(2000);

        WebElement securty=driver.findElement(By.className("faktor-iframe-wrapper"));
        driver.switchTo().frame(securty);
        driver.findElement(By.xpath("(//span[text()='Tümünü Kabul Et'])[1]")).click();
        driver.switchTo().defaultContent();

   //   get the first window
   //   clicking on click here button
        String guruWindowHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> setWindowHandle=driver.getWindowHandles();
        String  newWindowsHandle="";
        for (String each:setWindowHandle) {
            if(each!=guruWindowHandle){
              newWindowsHandle=each;
            }
        }
        driver.switchTo().window(newWindowsHandle);

   //   get all the window in the set
   //   switch to window


   //   input email id (somepne@gmail.com) and type something in that input
        Actions actions=new Actions(driver);
        Faker faker =new Faker();
        WebElement emailTextBox= driver.findElement(By.xpath("//input[@type='text']"));
        actions.click(emailTextBox).sendKeys(faker.internet().emailAddress()).perform();

   //   Clicking on the submit button
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

   //   verify title as expected
        String title = driver.findElement(By.xpath("//h2[text()='Access details to demo site.']")).getText();
        String expected = "Access details to demo site.";
        Assert.assertEquals(title,expected);

   //   switch to first window
        driver.switchTo().window(guruWindowHandle);
    }
}
