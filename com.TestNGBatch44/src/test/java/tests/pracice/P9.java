package tests.pracice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class P9 extends TestBase {

    // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
    // login yapiniz Email: batch44@gmail.com   password : 123456789
    // Search fonksiyonunu kullanarak
    // Mac,ipod ve samsung icin Dataprovider ile yapınız.

    @DataProvider
    public Object[][] getData(){
        String data[][]={{"Mac"},{"ipad"},{"Samsung"}};
        return data;
    }

    @Test(dataProvider = "getData")
    public void loginTest(String search){
    driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("batch44@gmail.com");
    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456789");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.xpath("//input[@name='search']")).sendKeys(search,Keys.ENTER);



    }
}
