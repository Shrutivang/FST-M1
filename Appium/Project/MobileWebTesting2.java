package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileWebTesting2 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator"); // or physical device name
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset(); // keep Chrome signed in

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void openLoginPage() {
        // 1️⃣ Navigate to site
        driver.get("https://training-support.net/webelements");

        // 2️⃣ Scroll to find the Login Form card
        WebElement loginCard = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Login Form\"))"));
        loginCard.click();
    }

    @Test(priority = 1)
    public void testValidLogin() {
        // 3️⃣ Enter valid credentials
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

        // 4️⃣ Submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

        // 5️⃣ Verify success message
        WebElement message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]"));
        String actualMsg = message.getText();

        System.out.println("Message after valid login: " + actualMsg);
        Assert.assertEquals(actualMsg, "Welcome Back, admin", "✅ Valid login message should appear");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        // 3️⃣ Enter invalid credentials
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("wrongpassword");

        // 4️⃣ Submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

        // 5️⃣ Verify failure message
        WebElement message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]"));
        String actualMsg = message.getText();

        System.out.println("Message after invalid login: " + actualMsg);
        Assert.assertEquals(actualMsg, "Invalid credentials", "❌ Invalid login message should appear");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
