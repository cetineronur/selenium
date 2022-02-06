package tests.pracice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P7 extends TestBase {

    @Test

    public void test(){

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        List<WebElement> allListItem = driver.findElements(By.xpath("//div[@class='shelf-item']"));


        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        int sayac=1;
        for (WebElement each:allListItem) {
            System.out.println(sayac+".Urun: "+each.getText());
            System.out.println();
            sayac++;
        }

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> productItemList = new ArrayList<>();
        List<WebElement> productItemListWebelemet=driver.findElements(By.xpath("//p[@class='shelf-item__title']"));

        for (WebElement each:productItemListWebelemet) {
            productItemList.add(each.getText());
        }
        System.out.println();
        System.out.println(productItemList);


        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın

        Random random = new Random();
        List<WebElement> addtocart=driver.findElements(By.xpath("//div[@class='shelf-item__buy-btn']"));
        for (int i=0; i<5;i++){
            WebElement product =addtocart.get(random.nextInt(addtocart.size()));
            product.click();

                driver.findElement(By.xpath("//div[@class='float-cart__close-btn']"));

                driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();
                addtocart.remove(product);

        }
        driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']")).click();

        List<WebElement> addcartList=driver.findElements(By.xpath("//div[@class='shelf-item__details']"));
        sayac=1;
        for (WebElement each:addcartList) {
            System.out.println();
            System.out.println(each.getText()+" sepete eklendi.");
            sayac++;
        }

        // (Her ürün 1 defadan fazla eklenemez!)
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
            List<WebElement> addcartPrice=driver.findElements(By.xpath("//div[@class='shelf-item__price']"));
        System.out.println();

        List<Double> doublePriceList=new ArrayList<>();
        for (int i=16;i<21;i++) {

            doublePriceList.add(Double.parseDouble(addcartPrice.get(i).getText().substring(2,7)));
        }
        Double subtotal=0.0;
        for (int i=0;i<5;i++){
            subtotal+=doublePriceList.get(i);
        }
        Double actual=Double.parseDouble(driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText().replaceAll("[$'\"+-]",""));
        Double expected =subtotal;
        Assert.assertEquals(actual,expected);

        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        System.out.println("Test PASS");

        // 7.Checkout'a tıklayın
        driver.findElement(By.xpath("//div[@class='buy-btn']")).click();
    }
}
