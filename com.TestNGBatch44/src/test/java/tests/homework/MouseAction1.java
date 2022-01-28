package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class MouseAction1 extends TestBase {

    @Test
    public void test(){
    //   1 Yeni bir class olusturalim: MouseActions1
    //   2 https://the internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement dashedBox =driver.findElement(By.id("hot-spot"));

    //   3 Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        actions.contextClick(dashedBox).perform();


    //   4 Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String allertmessage= driver.switchTo().alert().getText();
        String expectedMessage="You selected a context menu";
        softAssert.assertEquals(allertmessage,expectedMessage,"text is not true");


    //   5 Tamam diyerek alert’I kapatalim

        driver.switchTo().alert().accept();
        String windowhandle1 = driver.getWindowHandle(); // buraya kadar olan ilk sayfanin window handle'i

        //   6 Elemental Selenium linkine tiklayalim

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleList = driver.getWindowHandles();
        String windowhandle2 =" ";
        for (String each:handleList) {
            if(!each.contains(windowhandle1)){
                windowhandle2=each;
            }

        }
        driver.switchTo().window(windowhandle2);

    //   7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim.
        String h1Tag= driver.findElement(By.tagName("h1")).getText();
        String expected = "Elemental Selenium";
        softAssert.assertEquals(h1Tag,expected);
        softAssert.assertAll();



    }

}
