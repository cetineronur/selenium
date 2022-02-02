package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@title='Tüm Çerezlere İzin Ver']")
    public WebElement facebookCookies;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement uyariElemnt;
}

