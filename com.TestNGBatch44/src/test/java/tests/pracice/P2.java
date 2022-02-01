package tests.pracice;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class P2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //soru :ingilizce
        // //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        // //maximize the window
        ////click on action dialog button
        // //if need use explicitly wait
        ////click on the ok button
        ////accept the iframe message

        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");

        driver.findElement(By.xpath("//button[@id='action']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
}
