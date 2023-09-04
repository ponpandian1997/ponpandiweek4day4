package week4.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) {
		
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//get inside to frame
		driver.switchTo().frame("iframeResult");
		//find the element
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	
		//verification
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		
		
		}

}
