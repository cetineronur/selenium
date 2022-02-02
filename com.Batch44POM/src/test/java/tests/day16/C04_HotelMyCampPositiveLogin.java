package tests.day16;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {

    @Test
    public void pozitifLoginTest(){
     //  1 ) Bir Class olustur : PositiveTest
     //  2) Bir test method olustur positiveLoginTest()
     //  https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

     //  login butonuna bas
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.firstLogin.click();

     //  test data username: manager,
        hotelMyCampPage.usernameBox.sendKeys("manager");

     //  test data password : Manager1!
        hotelMyCampPage.password.sendKeys("Manager1!");
        hotelMyCampPage.login.click();

     //  Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    }
}
