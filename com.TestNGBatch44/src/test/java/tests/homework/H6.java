package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class H6 extends TestBase {

    @Test
    public void test1(){
     //   https://www.chanel.com/us/
     //   1st test:
     //   1- Accessing the site --> OK if the site is displayed
        driver.get("https://www.chanel.com/us/");

     //   2- Click on the search bar (on the top menu)
        driver.findElement(By.xpath("(//button[@title='Search'])[2]")).click();

     //   3- Search for "ROUGE ALLURE"
        WebElement searchbox= driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchbox.sendKeys("ROUGE ALLURE", Keys.ENTER);

     //   3- Check if the items of the displayed list contain the searched word
        List<WebElement> searchList=driver.findElements(By.xpath("//span[text()='ROUGE ALLURE']"));

        for (WebElement each:searchList) {
            System.out.println(each.getText());
            Assert.assertTrue(each.getText().contains("rouge allure"));
        }

     //   4- Select the second item of the list
        driver.findElement(By.xpath("(//a[@class='product-list-inline__link'])[2]")).click();

     //   5- Make sure that the displayed product name is the same as the previously selected name.
        WebElement secondElement= driver.findElement(By.xpath("//span[text()='ROUGE ALLURE VELVET LE LION DE CHANEL']"));
        Assert.assertTrue(secondElement.getText().contains("ROUGE ALLURE"));

    }

    @Test
    public void test2(){
        driver.get("https://www.chanel.com/us/");
        driver.findElement(By.xpath("(//span[text()='Makeup'])[1]")).click();
        driver.findElement(By.xpath("//a[@data-event-label='lipstick']")).click();
        driver.findElement(By.xpath("(//a[@data-test='product_link'])[1]")).click();
        String price = driver.findElement(By.tagName("p")).getText();

        driver.findElement(By.xpath("(//form[@class='js-addToBag'])[1]")).click();


        driver.findElement(By.xpath("//a[@class='button is-primary is-block js-reviewBag-cta']")).click();

        WebElement addcartProduct= driver.findElement(By.xpath("//span[@data-test='lblProductTitle_151138']"));
        String price2 = driver.findElement(By.tagName("p")).getText();
       // driver.switchTo().frame(addcartProduct);
        System.out.println(addcartProduct.getText());
        Assert.assertTrue(addcartProduct.getText().equalsIgnoreCase("ROUGE ALLURE VELVET LA COMÈTE"));
        Assert.assertEquals(price,price2);
    }

}
