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
	//Declare class objects
	WebDriver driver;
	WebDriverWait wait;	
	
	@BeforeClass
	public void setup() {
		//Initialize driver and wait
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//open the page
		driver.get("https://training-support.net");
		
	}
	
	@Test(priority = 1)
	public void homepageTest() {
		//Assertions
		Assert.assertEquals(driver.getTitle(), "Training Support");
	}
	
	@Test(priority = 2)
	public void aboutPageTest()  {
		//find and click the About Us link
		driver.findElement(By.linkText("About Us")).click();
		//Assertion for the page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");
		
	}
	
	//Browser clean up function
	
	@AfterClass
	public void tearDown()  {
		driver.quit();
	}

}
