package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MauseAction1 extends TestBase {

        @Test
    public void test(){
        //  1- Yeni bir class olusturalim: MouseActions1
        //  2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
            driver.get("https://the-internet.herokuapp.com/context_menu");

        //  3- Cizili alan uzerinde sag click yapalim
            WebElement daschElement = driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(daschElement).perform();


        //  4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
            String alertText=driver.switchTo().alert().getText();
            String expected = "You selected a context menu";
            softAssert.assertEquals(alertText,expected);


        //  5- Tamam diyerek alert’I kapatalim
            driver.switchTo().alert().accept();
            String firstPageHandle= driver.getWindowHandle();

        //  6- Elemental Selenium linkine tiklayalim
            driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //  7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
            String secondPageHandle= "";
            Set<String> handleSet=driver.getWindowHandles();
            for (String each:handleSet) {
                if(!each.equals(firstPageHandle)){
                    secondPageHandle=each;
                }
            }
            driver.switchTo().window(secondPageHandle);

            String secondPageTextElement= driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
            String expectedSeconPageText="Elemental Selenium";
            softAssert.assertEquals(secondPageTextElement,expectedSeconPageText);
        }


}
