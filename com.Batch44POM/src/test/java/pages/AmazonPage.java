package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // Bir page classi actigimizda ilk yapmamiz gereken sey
    // parametresiz constructor olusturup
    // bu constructor icinde PageFActory ile drivere ilk deger atamasi yapamak

   public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement amazonAramaKutusu;

    @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small'")
    public WebElement sonucYazisiElement;

}
