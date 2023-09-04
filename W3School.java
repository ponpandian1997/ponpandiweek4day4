package week4.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

public class W3School {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //handle the frame
        driver.switchTo().frame("iframeResult");
       //click Try it
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        //Handle the Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //print the
          String text = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
        System.out.println(text);
        driver.close();
        

        
        
        
        
	}

}
