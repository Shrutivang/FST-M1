package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

		public static void main(String[] args) {
			
			WebDriver driver = new FirefoxDriver();
			
			// Open a new browser to https://training-support.net/webelements/target-practice
			driver.get("https://training-support.net/webelements/target-practice");
			
		    //Get the title of the page and print it to the console.
			System.out.println("Page title is: " + driver.getTitle());
			
		    //Using xpath:
		       // Find the 3rd header on the page and print it's text to the console.
			String thirdHeader = driver.findElement(By.xpath("//h3[contains(text(),'orange']")).getText();
			System.out.println(thirdHeader);
					
		       // Find the 5th header on the page and print it's color.
			String fifthHeader = driver.findElement(By.xpath("//h5[contains(text(),'#5')]")).getText();
			System.out.println(fifthHeader);
		    //Using any other locator:
		      //  Find the purple button and print all it's classes.
		       // Find the slate button and print it's text.
		   // Close the browser.
					driver.quit();


		}
}
