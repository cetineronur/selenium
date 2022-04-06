package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AEPage {

public AEPage(){

    PageFactory.initElements(Driver.getDriver(),this);

}

//---------------Cem--------------------------------------------------------->
//---------------Emin--------------------------------------------------------->
//---------------Guenter--------------------------------------------------------->
//---------------Kubra--------------------------------------------------------->
//---------------Mali--------------------------------------------------------->
//---------------Mustafa--------------------------------------------------------->
//---------------Onur--------------------------------------------------------->
    //MainPage--->Products Linki
@FindBy (xpath = "//a[@href='/products']")
public WebElement products;

    //MainPage--->products Linki----->All Products text
@FindBy(xpath = "//h2[@class='title text-center']")
public WebElement allproducts;

    //MainPage--->products Linki----->SearchBox
@FindBy(xpath = "//input[@id='search_product']")
public WebElement searchBox;

    //MainPage--->products Linki----->SearchBox arama tusu
@FindBy(xpath = "//button[@id='submit_search']")
public WebElement searchBoxTik;

    //MainPage--->products Linki----->Searached Product yazisi
@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    public WebElement searchedProduct;

@FindBy(xpath = "//div[@class='product-image-wrapper']")
    public List<WebElement> searchedProductsList;

//---------------Salih--------------------------------------------------------->
//---------------Sezen--------------------------------------------------------->
//---------------Zeynep--------------------------------------------------------->






}
