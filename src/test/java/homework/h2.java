package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class h2 {
    public static void main(String[] args) throws InterruptedException {






          //7. Continue click ediniz
          //8. Password u texbox ini locate ediniz.
          //9. Password key gonderiniz
          //10. Sign in locate ediniz
          //11. Sign in click ediniz.


          //14. Arama search imlecini locate ediniz
          //15. Imlece click ediniz.

            //1. https://www.amazon.co.uk/ adresine gidiniz.
            System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");

            //2. Sign in butonuna gidip locate ediniz.
            WebElement signButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

            //3. Sign in yani giris yapiniz
            signButton.click();

            //4. E-mail textbox locate ediniz.
            WebElement emailTextBox = driver.findElement(By.id("ap_email"));

            //5. Email icin key gonderiniz
            emailTextBox.sendKeys("mhmetaliszgn@gmail.com");

            //6. Continue butonunu locate ediniz
            WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
            continueButton.click();

            WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
            passwordTextBox.sendKeys("ervanaz2012");

            WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
            signInButton.click();

            //12. Text arama butonu nu locate ediniz.
            WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));

            //13. Textbox a key olarak Nutella yi assign ediniz
            searchTextBox.sendKeys("nutella", Keys.ENTER);
        Thread.sleep(2000);
        WebElement allButton = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/span"));
        allButton.click();
            WebElement signOutButton = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[25]/a"));
            signOutButton.click();

            driver.close();





    }
}
