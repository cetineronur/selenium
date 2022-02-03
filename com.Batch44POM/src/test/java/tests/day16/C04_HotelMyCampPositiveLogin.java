package tests.day16;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {
    @Test
    public void positiveLoginTest() {
        //https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().navigate().to("https://www.hotelmycamp.com");
        //      login butonuna bas
        //  test data username: manager,
        //  test data password : Manager1!
        //  Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        HotelMyCampPage hotelmycampPage = new HotelMyCampPage();
        hotelmycampPage.mainPageLogin.click();
        hotelmycampPage.userNameBox.sendKeys("manager");
        hotelmycampPage.passwordBox.sendKeys("Manager1!");
        hotelmycampPage.userLogIn.click();
    }

    @Test
    public void methodTest() {
        HotelMyCampPage hotelmycampPage = new HotelMyCampPage();
        hotelmycampPage.hotelMyCampLogin();
    }


}
