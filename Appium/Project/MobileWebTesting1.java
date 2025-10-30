package Project;

import static org.testng.Assert.assertTrue;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;



import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileWebTesting1 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://training-support.net/webelements");
	}
	

	    @Test
	    public void scrollIntoViewTest() {
		
	        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		
	        // Wait for the page to load
		
	        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
		
	 
		
	        // Just scroll
		
	        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
		
	        // Locate element
		
	        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List Elements get added at runtime!\"]")).click();
	        
	     // 3️⃣ Add 3 tasks
	        WebElement taskInput = driver.findElement(AppiumBy.id("todo-input"));
	        
	        String[] tasks = {"Add tasks to list", "Get number of tasks", "Clear the list"};
	        for (String task : tasks) {
	            taskInput.sendKeys(task);
	            driver.findElement(AppiumBy.id("todo-add")).click();
	        }

	        // 4️⃣ Verify number of tasks in list (2 existing + 3 added = 5)
	        List<WebElement> allTasks = driver.findElements(AppiumBy.xpath("//li"));
	        Assert.assertEquals(allTasks.size(), 5, "Task count should be 5 after adding 3 new tasks.");
	        
	     // 5️⃣ Click on each added task to strike out
	        for (String task : tasks) {
	            driver.findElement(AppiumBy.xpath("//li[contains(text(),'" + task + "')]")).click();}
	        
	     // 6️⃣ Delete only the newly added (struck-out) tasks
	        // Assuming struck-out tasks have class 'completed' after clicking
	        List<WebElement> completedTasks = driver.findElements(AppiumBy.xpath("//li[contains(@class, 'completed')]"));
	        for (WebElement task : completedTasks) {
	            task.findElement(AppiumBy.xpath(".//button[contains(text(),'×')]")).click(); // click the delete (×) button
	        }
	        // 7️⃣ Verify only 2 tasks remain (original ones)
	        List<WebElement> remainingTasks = driver.findElements(AppiumBy.xpath("//li"));
	        Assert.assertEquals(remainingTasks.size(), 2, "Only the original 2 tasks should remain after clearing new ones.");
	    }
	    
	@AfterClass
	
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}