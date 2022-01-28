package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {

  //  1- https://demoqa.com/droppable adresine gidelim
    //  2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
  //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void test(){
        //  1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //  2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElament = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drophereElament = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElament,drophereElament).perform();

        //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDropText=dragMeElament.getText();
        String expectedDropText="Dropped!";
        softAssert.assertEquals(actualDropText,expectedDropText);
        softAssert.assertAll();

    }
}
