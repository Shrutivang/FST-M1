package Activities;

 	import static org.testng.Assert.assertEquals;

import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class Activity7 {

	public class FirstTest {
		//Declare class objects
		WebDriver driver;
		WebDriverWait wait;	
		
		@BeforeClass
		public void setup() {
			//Initialize driver and wait
			driver = new FirefoxDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//open the page
			driver.get(" https://training-support.net/webelements/login-form");
			
		}
		
		@Test(priority = 1)
		public void homepageTest() {
			//Assertions
			Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
		}
		
		@DataProvider(name="Invalidcredentials")
		public Object[][] creds() {
			return new Object[][] {
				{"admin", "Wrongpassword"},
				{"Wrondadmin", "password"},
				{"$@!$#$%", "DELETE TABLE users"}
			};
		}
		
		
		@Test(priority = 2, dataProvider = "Invalidcredentials")
		public void invalidLoginTest(String username, String password) {
			//Find the username , password and submit elements
			WebElement usernameField = driver.findElement(By.id("username"));
			WebElement passwordField = driver.findElement(By.id("password"));
			WebElement submitButton = driver.findElement(By.xpath("//button[text()= 'Submit']"));
			
			//clear fields
			usernameField.clear();
			passwordField.clear();
			
			//Enter the credentials
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			//click the submit button
			submitButton.click();
			
			//Assertion
			String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
			assertEquals(message, "Invalid credentials");
			
		}
		
		//Browser clean up function
		
		@AfterClass
		public void tearDown()  {
			driver.quit();
		}

	}


}
