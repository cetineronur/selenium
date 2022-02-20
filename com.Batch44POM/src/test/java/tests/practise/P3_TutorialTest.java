package tests.practise;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P3_TutorialTestPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P3_TutorialTest {
    @Test
    public void test(){
        //~ url'ye gidin: "http://tutorialsninja.com/demo/index.php?route=common/home"
        Driver.getDriver().get(ConfigReader.getProperty("tutorial"));

        //~ Phones & PDAs e tıklayın
        P3_TutorialTestPage p3_tutorialTestPage = new P3_TutorialTestPage();
        p3_tutorialTestPage.PhonesPDAs.click();

        //~ telefonların marka adını al
        for (WebElement each:p3_tutorialTestPage.productList) {
            System.out.println(each.getText());
        }

        //~ tüm elemanlar için ekle düğmesine tıklayın
        p3_tutorialTestPage.phoneList.stream().forEach(x->x.click());

//~ siyah toplam eklenen sepet düğmesine tıklayın
        p3_tutorialTestPage.SepetButton.click();

//~ listenin isimlerini sepetten al


        for (WebElement each:p3_tutorialTestPage.sepetList) {
            System.out.println(each.getText());
        }

//~ görüntülenen listeden ve sepet listesinden isimleri karşılaştırın


        //Assert.assertEquals(p3_tutorialTestPage.productList,p3_tutorialTestPage.phoneList);

//~ goruntulenen listede toplam fiyatin $583.19 oldugunu test edin
        Assert.assertEquals(p3_tutorialTestPage.totalPrice.getText(),"$583.19");

    }
}
