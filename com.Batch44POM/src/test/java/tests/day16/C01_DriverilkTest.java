package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverilkTest {

    @Test
    public void test01(){
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //amazona gittigimizi test edelim.
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));
        Driver.closeDriver();
    }

    @Test
    public void test02(){
        //bestbuy anasayfaya gidelim
        Driver.getDriver().get("https://www.bestbuy.com");

        // bestbuya gittigimizi test edelim
        String url=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("bestbuy"));
        Driver.closeDriver();
    }
}
