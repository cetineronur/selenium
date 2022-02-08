package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Set;

public class C01_WindowHandleReusableMehod {

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/windows adresine gidelim
        // new tab butonuna basalim
        // new taba'a gecip titlen "New Window" oldugunu test edin

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandele=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> handleSeti = Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each:handleSeti) {
            if(!each.equals(ilkSayfaWindowHandele)){
                ikinciSayfaHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandle);
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }

    @Test
    public void windowsHandleReusableTest() throws IOException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();
        ReusableMethods.switchToWindow("New Window");
        ReusableMethods.getScreenshot("WindowsSwitch");
    }
}
