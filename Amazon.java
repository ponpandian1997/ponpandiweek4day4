package week4.day4;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//Enter OnePlus9 into SearchBox and Enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro" , 
				Keys.ENTER);
		Thread.sleep(2000);
		//Enter Product Price
		String firstProductPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();	
		System.out.println(firstProductPrice);
		Thread.sleep(7000);
		//Enter Product Rating
		String firstCustomerRating = driver.findElement(By.xpath("(//span[@class='a-size-base puis-bold-weight-text'])[1]")).getText();
		System.out.println(firstCustomerRating);	
		Thread.sleep(3000);
		//Click The First Text Link
		driver.findElement(By.xpath("//div[@id='ivLargeImage']")).click();
		Thread.sleep(7000);
		//Click 'Add to Cart' button
		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		Thread.sleep(2000);
		//Get the cart sub total and verify if it is correct.
		String cartSubTotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		if(cartSubTotal.equals(firstProductPrice)) {
			System.out.println("Cart Subtotal is verified.");
		}
		driver.close();
		
	}

}
