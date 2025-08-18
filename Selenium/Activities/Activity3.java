package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// Initialize the Firefox driver
		WebDriver driver =  new FirefoxDriver();
		
		  // Open the page
		driver.get("https://training-support.net/webelements/login-form");
		// Print the title of the page
		System.out.println("Home page title: "+ driver.getTitle());
		
		// Close the browser
        driver.quit();
		
		
		

	}

}
