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

public class Activity2 {
	
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
	// Get the url of the header image.
	// Print the url to the console.
	public void homepage() {
	WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
	String imageUrl = headerImage.getAttribute("src");

	// Step d: Print the URL
	System.out.println("Header image URL is: " + imageUrl);
	}
	
	@AfterClass
	// Close the browser.
	public void closing() {
		driver.quit();
	}
}
