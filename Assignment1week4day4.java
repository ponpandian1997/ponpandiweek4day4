package week4.day4;

import java.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Assignment1week4day4 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       //click on mens fashions
        driver.findElement(By.xpath("(//span[@class='catText'])[1]")).click();
        //click on Sports Shoes
        driver.findElement(By.xpath("(//span[@class='linkTest'])[1]")).click();
        //Print the Count of Sports Shoes 
        String text1 = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
        System.out.println("shoes Count :" + text1);
        //click on training shoes
		driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded'])[3]")).click();
		Thread.sleep(2000);
		//click on Price low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		List<Integer> sortPrice=new ArrayList<Integer>();
		//Print The Shoes  price in Order
	    List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		//print list size
	    System.out.println(price.size());
	    for (int i = 0; i < price.size(); i++) {
	    	//get all element from list as a String
	    	String text = price.get(i).getText();//" 10,999"
	    	//replace the , by empty
	    	String replaceAll = text.replaceAll("[^0-9]", "");//10999
	    	//convert string into integer
	    	int parseInt = Integer.parseInt(replaceAll);
	    	//add the converted data to new list
	    	sortPrice.add(parseInt);//element add into list
	    	}
	    //Arrange the price
	    Collections.sort(sortPrice);
	    //print the list
	    System.out.println("items displayed are sorted correctly" + sortPrice);
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("500");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		WebElement firstshoe = driver.findElement(By.xpath("//p[@class='product-title']"));
		 Actions action =new Actions(driver);
		 action.moveToElement(firstshoe).perform();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		 Thread.sleep(5000);
		 //get price
		 String price2 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	     Thread.sleep(2000);
	     //get discount
	     String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
	     System.out.println("Price: Rs." +price2+ "  Discount: "+ discount);

	}

}
