package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageIlkClass {

    @Test
    public void test01(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // arama kutusuna Nutella yazip aratalim
        AmazonPage amazonpage =new AmazonPage();
        amazonpage.amazonAramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini est edelim.
        String actualSonucStr=amazonpage.sonucYazisiElement.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));

        Driver.closeDriver();

    }

    @Test
    public void test02(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("java",Keys.ENTER);
        String sonucYazisiStr=amazonPage.sonucYazisiElement.getText();
        Assert.assertTrue(sonucYazisiStr.contains("java"));
        Driver.closeDriver();
    }
}
