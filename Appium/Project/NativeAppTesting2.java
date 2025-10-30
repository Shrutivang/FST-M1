package Project;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.util.Collections;

public class NativeAppTesting2 {

    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\0041LQ744\\Downloads\\ts-todo-list-v1.apk");
        options.noReset();

        URL serverUrl = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void editTaskToAddDeadline() throws InterruptedException {
        System.out.println("🟢 Starting test: Edit task to add deadline");

        // Wait for the first task in the list
        WebElement firstTask = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));
        System.out.println("🟢 Long pressing the first task...");

        // Long press the first task
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        firstTask.getLocation().x + 10, firstTask.getLocation().y + 10))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(longPress));

        System.out.println("🟢 Long pressed the first task to open edit screen.");
        Thread.sleep(2000); // wait for edit screen to load
        
        WebElement editTaskField = driver.findElement(
                AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id='android:id/content'])[1]")
        );
        editTaskField.click();
        System.out.println("🟢 Clicked on the edit task field to open task details.");
        
        
        // Wait for the due date element to appear using the correct ID
        WebElement dueDateField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")));
        dueDateField.click();
        
        WebElement NextField = driver.findElement(AppiumBy.id("android:id/next"));
        NextField.click();
        System.out.println("Next month calender displayed");
        
        
        WebElement Datepicker = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"01 November 2025\"]"));
        Datepicker.click();

        // Set deadline (select date - next Saturday)
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("bt_deadline_ok")));
        okButton.click();

        

        // Verify if the task now displays a deadline
        WebElement deadlineLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")));
        String deadlineText = deadlineLabel.getText();

        System.out.println("🟢 Deadline set to: " + deadlineText);
        assertTrue(deadlineText.contains("01.11.2025"), "Deadline was not set correctly!");
        
     // Save the edited task
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("bt_new_task_ok")));
        saveButton.click();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 App closed successfully.");
        }
    }
}
