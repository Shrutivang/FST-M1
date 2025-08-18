package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// Create a Driver Object
				WebDriver driver = new FirefoxDriver(); //ChromeDriver() or EdgeDriver()
				
				//Open the page
				driver.get("https://training-support.net/");
				
				//Verify using the page title
				System.out.println("Page title is: " + driver.getTitle());
				
				//find and click the about us link
					
				driver.findElement(By.linkText("About Us")).click();
				
				//Print title of the new page
				System.out.println("New Page title is: " + driver.getTitle());
				
				//Close the browser
				driver.quit();

	}

}
