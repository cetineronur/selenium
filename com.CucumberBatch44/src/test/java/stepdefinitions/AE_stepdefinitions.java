package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AEPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AE_stepdefinitions {

AEPage aePage = new AEPage();

    @Given("Kullanici {string} ye gider")
    public void kullanici_ye_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));
    }
    @Given("Siteye giris yapildigini gorur")
    public void siteye_giris_yapildigini_gorur() {
        String expectedUrl = ConfigReader.getProperty("automationExerciseUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl().toString();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Given("Kullanici Ana Sayfadaki Product linkine tiklar")
    public void kullanici_ana_sayfadaki_product_linkine_tiklar() {
        aePage.products.click();
    }

    @Given("Kullanici {string} yazisini gorur")
    public void kullanici_yazisini_gorur(String aranansonuc) {
        String sonucYazisi=aePage.allproducts.getText();
       Assert.assertTrue(sonucYazisi.contains(aranansonuc));
    }
    @Given("Kullanici SearchBox kutusunun gorunur oldugunu dogrular.")
    public void kullanici_search_box_kutusunun_gorunur_oldugunu_dogrular() {
        Assert.assertTrue(aePage.searchBox.isDisplayed());
    }
    @Then("Kullanici Arama girişine ürün adını girer ve arama düğmesine tıklar")
    public void kullanici_arama_girişine_ürün_adını_girer_ve_arama_düğmesine_tıklar() {
        aePage.searchBox.sendKeys("jeans");
        aePage.searchBoxTik.click();
    }
    @Given("Kullanici {string} yazisinin görünür olduğunu doğrular")
    public void kullanici_yazisinin_görünür_olduğunu_doğrular(String aranansonuc) {
        String sonucYazisi=aePage.searchedProduct.getText();
        Assert.assertTrue(sonucYazisi.contains(aranansonuc));
    }

    @Given("Aramayla ilgili tüm ürünlerin görünür olduğunu doğrular")
    public void aramayla_ilgili_tüm_ürünlerin_görünür_olduğunu_doğrular() {
        for (WebElement each:aePage.searchedProductsList) {
            ReusableMethods.hover(each);
            Assert.assertTrue(each.getText().contains("Jeans"));
        }
    }
    @Then("Kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.closeDriver();
    }

}
