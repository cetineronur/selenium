package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class P3_TutorialTestPage {

    public P3_TutorialTestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Phones & PDAs")
    public WebElement PhonesPDAs;

    @FindBy(tagName = "h4")
    public List<WebElement> productList;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> phoneList;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[2]")
    public WebElement SepetButton;

    @FindBy(linkText = "a']")
    public List<WebElement> sepetList;

    @FindBy(xpath = "//td[text()='$583.19']")
    public WebElement totalPrice;

    public void sepet(){
        Driver.getDriver().findElement("")
    }

}
