package tests.practise;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.P2_WebTableTestPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P2_WebTableTest {

    @Test
    public void Test(){

     //  go to url : https://en.wikipedia.org/wiki/Dell
        Driver.getDriver().get(ConfigReader.getProperty("Wikiepdia"));

     //  go to table which name is 'List of companies acquired by Dell Inc.'
        P2_WebTableTestPage p2_webTableTestPage = new P2_WebTableTestPage();
        JavascriptExecutor jse = (JavascriptExecutor)  Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",p2_webTableTestPage.nameOfList);

     //  print row 4 of the table on console
        System.out.println("4.Satir: "+ p2_webTableTestPage.fourthRow.getText());

     //  also print on console the 2nd and 3rd elements (middle 2 elements) in line 5
        System.out.println("5.Satir 2.Oge: "+p2_webTableTestPage.secondElement.getText());
        System.out.println("5.Satir 3.Oge: "+p2_webTableTestPage.thirdElement.getText());
     // ( 2nd and 3rd elements : November 2, Cloud integration leader)
        Driver.closeDriver();
    }
}
