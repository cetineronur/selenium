package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeybboardActions extends TestBase {

  //  1- Bir Class olusturalim KeyboardActions1
  //  2- https://www.amazon.com sayfasina gidelim
  //  3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
  //  4- aramanin gerceklestigini test edin

    @Test
    public void test(){
        //  2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //  3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramakutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions = new Actions(driver);
        actions.click(aramakutusu).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).sendKeys("ansung ").
                keyDown(Keys.SHIFT).sendKeys("a").
                keyUp(Keys.SHIFT).sendKeys("71").
                sendKeys(Keys.ENTER).perform();
    }
}
