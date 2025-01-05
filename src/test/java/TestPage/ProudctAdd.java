package TestPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProudctAdd {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "/GREENKART/Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		String[] iteamsNeed = { "Brocolli", "Beetroot", "Cucumber" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		AddProduct(driver, iteamsNeed);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();
		driver.findElement(By.cssSelector("span.promoInfo")).getText();
		driver.findElement(By.linkText("Place Order")).click();
		
		
}

public static void AddProduct(WebDriver driver,String[] iteamsNeed) {
	
	int j = 0;
	List<WebElement> Products = driver.findElements(By.cssSelector("h4.product-name"));
	// System.out.println(Products);

	for (int i = 0; i < Products.size(); i++) {

		String[] Name = Products.get(i).getText().split("-");
		String formattedName = Name[0].trim();

		List<String> iteamsNeedList = Arrays.asList(iteamsNeed);

		if (iteamsNeedList.contains(formattedName)) {
			j++;

			driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

			if (j == iteamsNeed.length) {
				break;
			}

		}

	}

}
}
