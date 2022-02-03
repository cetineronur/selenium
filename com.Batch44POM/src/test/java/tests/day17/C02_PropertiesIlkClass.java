package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesIlkClass {


    @Test
    public void positiveLoginTesti(){

        //Hotel My camp sitesine positive login testini POM'a tam uygun olark yapiniz.
     //  https://www. hotelmycamp.com/ adresine git
        //Driver.getDriver().get("buraya properties dosyasina git HMCUrl'e karsilik gelen degeri getir");
    Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

     //  login butonuna bas
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();

     //  test data username: manager
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));

     //  test data password : Manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.bekle(3);
        hotelMyCampPage.userLogIn.click();

     //  Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCampPage.usernamepasswordcorrect.isDisplayed());


    }
}
