package Activities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	
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
	public void login(){
	// Find and select the username and password fields
	
	WebElement username = driver.findElement(By.id("txtUsername"));
	WebElement password = driver.findElement(By.id("txtPassword"));
	
	// Enter credentials
	username.sendKeys("orange");
	password.sendKeys("orangepassword123");
	
	// Click login
	WebElement loginbutton = driver.findElement(By.id("btnLogin"));
	loginbutton.click();
			
	//Find the PIM option in the menu and click it
	WebElement PIMbutton1 = driver.findElement(By.id("menu_pim_viewPimModule"));
	PIMbutton1.click();
	
//	//Click the Add button to add a new Employee.
	WebElement Addbutton = driver.findElement(By.id("btnAdd"));
	Addbutton.click();
//	
//	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	
//	//Fill in the required fields and click Save.
	WebElement firstname = driver.findElement(By.id("firstName"));
	WebElement lastname = driver.findElement(By.id("lastName"));
	firstname.sendKeys("Shruti");
	lastname.sendKeys("Angarkar");
	WebElement Savebutton = driver.findElement(By.id("btnSave"));
	Savebutton.click();
//	
//	// Navigate back to the PIM page (Employee List tab) and verify the creation of your employee.
//	
	WebElement PIMbutton2 = driver.findElement(By.id("menu_pim_viewPimModule"));
	PIMbutton2.click();
	
	WebElement Empname = driver.findElement(By.id("empsearch_employee_name_empName"));
	Empname.sendKeys("Shruti Angarkar");
	WebElement Search = driver.findElement(By.id("searchBtn"));
	Search.click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@AfterClass
	// Close the browser.
	public void closing() {
		driver.quit();
	}
}
