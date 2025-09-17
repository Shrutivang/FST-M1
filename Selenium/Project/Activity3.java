package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
	driver = new FirefoxDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	// Open a browser.
	// Navigate to ‘http://alchemy.hguy.co/orangehrm’
	driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@Test
	public void login(){
	// Find and select the username and password fields
	
	WebElement username = driver.findElement(By.id("txtUsername"));
	WebElement password = driver.findElement(By.id("txtPassword"));
	
	// Enter credentials
	username.sendKeys("orange");
	password.sendKeys("orangepassword123");
	
	// Click login
	WebElement loginbutton = driver.findElement(By.id("btnLogin"));
	loginbutton.click();
			
	// Read login message	
	//Verify that the homepage has opened
			
	 String loginMessage = driver.findElement(By.className("firstLevelMenu")).getText();
     Assert.assertEquals("Admin", loginMessage);
			
	}
	
	@AfterClass
	// Close the browser.
	public void closing() {
		driver.quit();
	}
}
