package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkloginLinki;
    @FindBy(xpath = "//input[@class='form-control required']")
    public WebElement userNameBox;
    @FindBy(xpath = "//input[@class='form-control required password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginButonu;
    @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")
    public WebElement adduser;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement addUserUserName;//add user sayfasi username
    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement addUserPassword;//add user sayfasi username



    public void hotelMyCampLogin() {
        Driver.getDriver().navigate().to("https://www.hotelmycamp.com");
        ilkloginLinki.click();
        userNameBox.sendKeys("manager");
        passwordBox.sendKeys("Manager1!");
        loginButonu.click();
        adduser.click();
    }


}