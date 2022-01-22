package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertion {
	//1) Bir class oluşturun: BestBuyAssertions

	WebDriver driver;

	@Before
	public void setup(){

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@After
	public void teardown(){

		//driver.close();
	}


	@Test
	public void test01(){


		//2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
		driver.get("https://www.bestbuy.com/");

		//○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
		String actualUrl= driver.getCurrentUrl();
		String expectedUrl="https://www.bestbuy.com/";

		Assert.assertEquals("Lutfen test degerlerini gozden gecirin",expectedUrl,actualUrl);

		//○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
		String actualTitle= driver.getTitle();
		String istenmeyenKelime="Rest";

		Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

		//○ logoTest => BestBuy logosunun görüntülendigini test edin
		WebElement logoElement = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
		Assert.assertFalse("Logo gorunmuyor",!logoElement.isDisplayed());

		//○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
		WebElement francais = driver.findElement(By.xpath("//button[text()='Français']"));
		Assert.assertTrue(francais.isDisplayed());


	}

}
