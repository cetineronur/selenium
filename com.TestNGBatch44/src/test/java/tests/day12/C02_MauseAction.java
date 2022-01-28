package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_MauseAction extends TestBase {
    // amazon anasayfaya gidin. sag ustte hello sign in elementinin uzerinde maus bekletin. acilan
    // menude new list linkine tiklayin.
    //ve new list sayfasinin acildigini test edin.

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // amazon anasayfaya gidin. sag ustte hello sign in elementinin uzerinde maus bekletin
        Actions actions = new Actions(driver);
        WebElement signIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(signIn).perform();

        // menude new list linkine tiklayin.
        WebElement creatAList=driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(creatAList).perform();

        //ve new list sayfasinin acildigini test edin.
        String actualTitle= driver.getTitle();
        String expected = "Your List";
        Assert.assertTrue(actualTitle.contains(expected));

    }
}
