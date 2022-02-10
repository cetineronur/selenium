package tests.practise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P1_DemoGuruPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.lang.reflect.AccessibleObject;

public class P1_DemoGuruTest {

    @Test
    public void test() throws InterruptedException {

      // http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("DemoGuru"));
        P1_DemoGuruPage p1_demoGuruPage = new P1_DemoGuruPage();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(p1_demoGuruPage.iframe);
       p1_demoGuruPage.firstCookie.click();
       Driver.getDriver().switchTo().defaultContent();

      // DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(p1_demoGuruPage.bankButton, p1_demoGuruPage.firstAccount);

      // CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(p1_demoGuruPage.salesButton, p1_demoGuruPage.secondAccount);

      // DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(p1_demoGuruPage.firstnum5000, p1_demoGuruPage.thirdAccount);

      // CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(p1_demoGuruPage.secondnum5000, p1_demoGuruPage.fourthAccount);

      // Perfect butonun goruntulendigini dogrulayin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(p1_demoGuruPage.perfectYazisi.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.closeDriver();

    }
}
