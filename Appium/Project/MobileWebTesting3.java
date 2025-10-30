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
import java.util.List;

public class MobileWebTesting3 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator"); // or actual device name
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testPopupLogin() {
        // 1️⃣ Open the target website
        driver.get("https://training-support.net/webelements");
        

     // 2️⃣ Scroll to and click on the "Popups" card
        WebElement popupCard = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Popups\"))"));
        popupCard.click();

      
        // 3️⃣ Click button to open popup login
        WebElement loginPopupButton = driver.findElement(AppiumBy.id("signIn"));
        loginPopupButton.click();

        // 4️⃣ Enter credentials in popup
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

        // 5️⃣ Click on "Log in" or "Submit" button inside popup
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // 6️⃣ Verify the success message
        WebElement message = driver.findElement(AppiumBy.id("action-confirmation"));
        String actualMessage = message.getText();

        System.out.println("Popup login message: " + actualMessage);

        // 7️⃣ Assertion
        Assert.assertEquals(actualMessage, "Welcome Back, admin", "✅ Login message should match expected text");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
