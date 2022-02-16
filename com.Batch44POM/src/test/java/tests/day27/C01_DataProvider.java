package tests.day27;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {


    @DataProvider
    public static Object[][] aranacakKelimeListesi() {

        return new String[][]{{"Nutella"},{"Java"},{"Cucumber"}};
    }

    @Test(dataProvider = "aranacakKelimeListesi")
    public void amazonsearch(String aranacaklar){

        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacaklar, Keys.ENTER);
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains(aranacaklar));
    }
}
