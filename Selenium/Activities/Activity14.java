package Activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		//Open a new browser to https://training-support.net/webelements/tables
		driver.get("https://training-support.net/webelements/tables");
		
	       // Get the title of the page and print it to the console.
		System.out.println("Page Title is: " + driver.getTitle());
		
	        //Using xpaths on the table:
	            //Find the number of rows and columns in the table and print them.
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thread/tr/th"));
		System.out.println("No of columns: " + cols.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thread/tr/td"));
		System.out.println("No of rows: " + rows.size());
		
	            //Find and print the Book Name in the 5th row.
		WebElement cellValue;
	           // Click the header of the Price column to sort it in ascending order.
	           // Find and print the Book Name in the 5th row again.
	       // Close the browser.


	}

}
