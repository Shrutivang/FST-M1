package Project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Test3 {

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
    public void completeAndFilterTasks() throws InterruptedException {
        System.out.println("🟢 Starting test: Mark tasks complete and filter completed list");

        // Wait for the task list to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));
        List<WebElement> tasks = driver.findElements(
                AppiumBy.id("com.app.todolist:id/tv_exlv_task_name"));
        System.out.println("🟢 Found total tasks: " + tasks.size());

        if (tasks.size() < 3) {
            throw new IllegalStateException("❌ Not enough tasks to run this test. Please add at least 3 tasks.");
        }

        // ✅ Mark first two tasks as complete
        List<WebElement> checkboxes = driver.findElements(
                AppiumBy.id("com.app.todolist:id/cb_task_done"));
        for (int i = 0; i < 2 && i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
            System.out.println("✅ Marked Task " + (i + 1) + " as complete.");
        }

        // ✅ Long press the third task to edit it
        WebElement thirdTask = tasks.get(2);
        System.out.println("🟢 Long pressing third task for editing...");

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        thirdTask.getLocation().getX() + 10, thirdTask.getLocation().getY() + 10))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(longPress));

        Thread.sleep(2000);
        
        WebElement editTaskField = driver.findElement(
                AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id='android:id/content'])[1]")
        );
        editTaskField.click();
        System.out.println("🟢 Clicked on the edit task field to open task details.");

        // ✅ Move progress slider to 50%
        System.out.println("🟢 Editing progress to 50%...");
        WebElement progressSlider = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.app.todolist:id/sb_new_task_progress")));

        int startX = progressSlider.getLocation().getX();
        int width = progressSlider.getSize().getWidth();
        int yAxis = progressSlider.getLocation().getY();

        PointerInput slideFinger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence slide = new Sequence(slideFinger, 1)
                .addAction(slideFinger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        startX + 10, yAxis + 10))
                .addAction(slideFinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new org.openqa.selenium.interactions.Pause(slideFinger, Duration.ofMillis(500)))
                .addAction(slideFinger.createPointerMove(Duration.ofMillis(800),
                        PointerInput.Origin.viewport(), startX + (width / 2), yAxis + 10))
                .addAction(slideFinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(slide));

        // ✅ Save changes
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.app.todolist:id/bt_new_task_ok")));
        saveButton.click();
        System.out.println("💾 Saved task with 50% progress.");

        // ✅ Open menu and go to Completed Tasks
        WebElement optionButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc='More options']")));
        optionButton.click();

        WebElement completedOption = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[@text='Completed tasks']")));
        completedOption.click();

        System.out.println("🟢 Switched to Completed Tasks view.");
        Thread.sleep(2000);

        // ✅ Verify that only 2 completed tasks are shown
        List<WebElement> completedTasks = driver.findElements(
                AppiumBy.id("com.app.todolist:id/tv_exlv_task_name"));
        System.out.println("🧩 Completed tasks visible: " + completedTasks.size());
        assertEquals(completedTasks.size(), 2, "❌ Expected 2 completed tasks!");

        System.out.println("✅ Test passed: Exactly 2 completed tasks displayed.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 App closed successfully.");
        }
    }
}
