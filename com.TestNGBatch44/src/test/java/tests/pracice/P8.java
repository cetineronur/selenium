package tests.pracice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;

public class P8 extends TestBase {

    @Test(dataProvider="aranacakKelime")
    public void gittigidiyorTest(String aranacak){
        driver.get("https://www.gittigidiyor.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(aranacak, Keys.ENTER);
    }

    @DataProvider
    public static Object[][] aranacakKelime(){
        String data[][]={{"Java"},{"Javascript"},{"Python"}};
        return data;
    }
}
