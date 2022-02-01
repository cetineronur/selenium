package tests.pracice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class P3 extends TestBase{


    @Test
    public void test(){
        //    go to url :http://demo.automationtesting.in/Alerts.html
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //    cancel Alert  (Press a Button !)
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)

        // url'ye gidin :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // "Alert with OK"yi tıklayın ve 'click the button to display a confirm box' i tıklayın:'
        driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

        // Uyarıyı kabul et(I am an alert box!) ve uyarıyı konsolda yazdır
        driver.switchTo().alert().accept();

        //  "Alert with OK & Cancel" ı tıklayın ve 'click the button to display a confirm box' i tıklayın
        // Uyarıyı iptal et (Press a Button !)
        // "Alert with Textbox" ı tıklayın ve 'click the button to demonstrate the prompt box' tıklayın'
        // ve ardından sendKeys 'TechProEducation' (Lütfen adınızı girin)
        // sonunda "Hello TechproEducation How are you today" mesajını konsola yazdır (edited)
    }
}
