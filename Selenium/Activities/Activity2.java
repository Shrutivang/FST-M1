package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		
		// Create a Driver Object
				WebDriver driver = new FirefoxDriver(); //ChromeDriver() or EdgeDriver()
				
				 //Open a new browser to https://training-support.net/webelements/login-form/
				driver.get("https://training-support.net/webelements/login-form");
				
				// Get the title of the page and print it to the console.
				System.out.println("Page title is: " + driver.getTitle());
				
		        // Find the username field using any locator and enter "admin" into it.
				driver.findElement(By.id("username")).sendKeys("admin");
				
			    // Find the password field using any locator and enter "password" into it.
				driver.findElement(By.id("password")).sendKeys("password");
				
			       // Find the "Log in" button using any locator and click it.
				driver.findElement(By.xpath("//button[text()='Submit']")).click();
			       // Close the browser.
				
				 // Print the confirmation message
		        String message = driver.findElement(By.tagName("h1")).getText();
		        System.out.println(message);

				
				
				//Close the browser
				driver.quit();

	}

}
