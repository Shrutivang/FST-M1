package Project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class NativeAppTesting1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\0041LQ744\\Downloads\\ts-todo-list-v1.apk");
        options.noReset();

        // ✅ Appium 3.x uses base endpoint (no /wd/hub)
        URL serverUrl = new URI("http://localhost:4723").toURL();

        driver = new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addThreeTasks() {
        addTask("Complete Activity 1", "High");
        addTask("Complete Activity 2", "Medium");
        addTask("Complete Activity 3", "Low");

        // ✅ Verify that all three tasks were added
        List<WebElement> tasks = driver.findElements(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name"));
        assertEquals(tasks.size(), 3, "Expected 3 tasks in the list");

        assertEquals(tasks.get(0).getText(), "Complete Activity 1");
        assertEquals(tasks.get(1).getText(), "Complete Activity 2");
        assertEquals(tasks.get(2).getText(), "Complete Activity 3");

        System.out.println("✅ All three tasks added successfully!");
    }

    // 🔧 Helper method to add task
    public void addTask(String taskName, String priority) {
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys(taskName);

        driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='" + priority + "']"))).click();

        driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
        System.out.println("📝 Added task: " + taskName + " with priority " + priority);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
