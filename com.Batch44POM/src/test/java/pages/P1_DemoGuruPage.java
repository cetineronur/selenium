package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P1_DemoGuruPage {

   public P1_DemoGuruPage(){
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"save\"]/span[1]/div/span")
    public WebElement firstCookie;

   @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
   public WebElement iframe;

   @FindBy(xpath = "//a[contains(text(), 'BANK')]")
    public WebElement bankButton;

   @FindBy(xpath = "//a[contains(text(), ' SALES ')]")
    public WebElement salesButton;

    @FindBy(xpath = "(//a[contains(text(), ' 5000')])[1]")
    public WebElement firstnum5000;

    @FindBy(xpath = "(//a[contains(text(), ' 5000')])[2]")
    public WebElement secondnum5000;

    @FindBy(xpath = "(//li[@class='placeholder'])[1]")
    public WebElement firstAccount;

    @FindBy(xpath = "(//li[@class='placeholder'])[3]")
    public WebElement secondAccount;

    @FindBy(xpath = "(//li[@class='placeholder'])[2]")
    public WebElement thirdAccount;

    @FindBy(xpath = "(//li[@class='placeholder'])[4]")
    public WebElement fourthAccount;

 @FindBy(linkText = "Perfect!")
 public WebElement perfectYazisi;

}
