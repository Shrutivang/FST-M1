package Activities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 extends BaseTest {
    @Test
    public void getEmergencyContacts() {
        // Login
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        // Go to My Info
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Wait and click Emergency Contacts (use XPath instead of linkText)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emergencyMenu = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Emergency Contacts']")));
        emergencyMenu.click();

        // Get table rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table hover']//tbody/tr"));

        // Print contacts
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
    }
}
