package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	
	 @BeforeClass
	public void beforeClass() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		
		// Open the browser
		driver.get("https://training-support.net/webelements/login-form");
		
	}	
	
	@Test
	public void LoginTest() {
		//   // Find the username and password fields
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		
		// Enter credentials
		username.sendKeys("admin");
		password.sendKeys("password");
		
		// Click login
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		// Read login message
		String loginmessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assert.assertEquals("Welcome Back, Admin!", loginmessage);
		
		}
	
	@AfterClass
	public void afterclass() {
		// Close browser
		driver.close();
	}

}
