package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class MaauseAction2 extends TestBase {
  //  1-- https://demoqa.com/droppable adresine gidelim
  //  2--“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
  //  3--“Drop here” yazisi yerine “Dropped!” oldugunu test edin.

    @Test
    public void test(){
        //  1-- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //  2--“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        String dropHereYazisi = driver.findElement(By.xpath("(//p[text()='Drop here'])[1]")).getText();

        WebElement sourceLocator = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destinationLacator = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceLocator,destinationLacator).build().perform();

        //  3--“Drop here” yazisi yerine “Dropped!” oldugunu test edin.
        String droppedText = driver.findElement(By.tagName("p")).getText();
        softAssert.assertNotEquals(dropHereYazisi,droppedText,"draganddrop isleminden Dropped gorunmuyor.");
        softAssert.assertAll();
    }

}
