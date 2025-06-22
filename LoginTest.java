package LoginProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//Wait for 5 second for elements to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		//Case 1 - Valid Username and Password 
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		driver.findElement(By.linkText("Log out")).click();	
		
		
		// Case 2 - Invalid Username and valid Password
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("invalid");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		// Printing error message
		System.out.println(driver.findElement(By.id("error")).getText());
		
		// Case 3 - Valid Username and invalid Password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("invalid pass");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		// Printing error message
		System.out.println(driver.findElement(By.id("error")).getText());
		
		
		// Case 4 - No data
				
		driver.findElement(By.xpath("//button[@id='submit']")).click();
				
		driver.findElement(By.linkText("Log out")).click();
		
		driver.close();
		
		
	}

}
