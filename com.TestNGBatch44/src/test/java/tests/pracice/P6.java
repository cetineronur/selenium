package tests.pracice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class P6 extends TestBase {
    @Test
    public void test(){

        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Fill in capitals by country.
        WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement seul = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement roma = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));

        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
        WebElement norwey = driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement korea = driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement usa = driver.findElement(By.xpath("//div[@id='box103']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(oslo,norwey)
                .dragAndDrop(stockholm,sweden)
                .dragAndDrop(washington,usa)
                .dragAndDrop(copenhagen,denmark)
                .dragAndDrop(seul,korea)
                .dragAndDrop(roma,italy)
                .dragAndDrop(madrid,spain).perform();
    }
}
