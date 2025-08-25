package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity1 {
		//declare the class objects
	WebDriver driver;
	WebDriverWait wait;
		
	@BeforeClass
	public void setup() {
		//Initialize driver and wait
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open a browser.
		//Navigate to ‘http://alchemy.hguy.co/orangehrm’.
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	
	@Test
	//Get the title of the website.
	//Make sure it matches “OrangeHRM” exactly.
	public void homepage() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	//If it matches, close the browser
	public void closing() {
		driver.quit();
	}
	
	
	
		
		
		
		

	}


