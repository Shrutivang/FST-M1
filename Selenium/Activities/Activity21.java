package Activities;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {

		// Create a Driver Object
		WebDriver driver = new FirefoxDriver(); //ChromeDriver() or EdgeDriver()
		
		//create a webdriverwait object
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the page
		driver.get("https://training-support.net/webelements/tabs");
		
		//Verify using the page title
		System.out.println("Page title is: " + driver.getTitle());
		
	//find and click the button to open the new tab
		driver.findElement(By.xpath("//button[text() = 'Open A New Tab']")).click();
		
		//print the handle of the current tab
		System.out.println("Current tab handle: " + driver.getWindowHandle());
		
		//print the handle of all the open tabs
		System.out.println("All open tab handles: " + driver.getWindowHandles());
		
		//switch to the newest tab
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		
		}
		
		//print the handle of the current tab
		System.out.println("Current tab handle : " + driver.getWindowHandle());
		
		//print the title and message from the new page
		
		System.out.println("Title of the new page: " + driver.getTitle());
		
		System.out.println("Message on the new tab: " + driver.findElement(By.cssSelector("h2.text-gray-800")).getText());
				
		
		//Close the browser
		driver.quit();

	}

}
