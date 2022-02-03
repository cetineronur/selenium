package tests.pracice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P5 extends TestBase {

    @Test
    public void test(){

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // web sitesini maximize yapin
        // ikinci emojiye tıklayın

        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
       WebElement secondEmoji= driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement each:list) {
            each.click();
        }

        // parent iframe e geri donun
        driver.switchTo().defaultContent();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> formList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> metinler=new ArrayList<>(Arrays.asList("Bir","iframe","sorusu","bu","kadar","egleneceli",
                                                                "olabilir","sizce de","oyle degil mi?","",""));

        for (int i=0;i< formList.size();i++){
            formList.get(i).sendKeys(metinler.get(i));
        }
        //  apply button a basin
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
