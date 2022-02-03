package tests.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class TwitterKayit extends TestBase {

    @Test
    public void test(){

        driver.get("https://www.twitter.com");
        driver.findElement(By.xpath("(//div[@dir='auto'])[7]")).click();

        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-18u37iz r-16y2uox r-1wbh5a2 r-1wzrnnt r-1udh08x r-xd6kpl r-1pn2ns4 r-ttdzmv'])[1]")).click();
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        actions.sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).sendKeys("+4915752419683").perform();
        WebElement month = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
        Select select = new Select(month);
        select.selectByIndex(11);
        actions.sendKeys(Keys.TAB).sendKeys("21").sendKeys(Keys.TAB).sendKeys("1978").perform();
       // WebElement day = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-1m3jxhj r-sdzlij r-1phboty r-rs99b7 r-peo1c r-1ps3wis r-1ny4l3l r-1guathk r-o7ynqc r-6416eg r-lrvibr']")).click();
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-lrvibr'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-lrvibr'])[2]")).click();
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-1m3jxhj r-sdzlij r-1phboty r-rs99b7 r-peo1c r-1ps3wis r-1ny4l3l r-1guathk r-o7ynqc r-6416eg r-lrvibr']")).click();
        driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();
        driver.findElement(By.xpath("(//div[@role='button'])[5]")).click();
        WebElement onayKodu= driver.findElement(By.xpath("//input[@dir='auto']"));
        onayKodu.click();
        actions.sendKeys(faker.internet().password());
    }
}
