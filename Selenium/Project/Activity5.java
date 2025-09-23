package Activities ;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.time.Duration;

public class Activity5 extends BaseTest {
    @Test
    public void editUserInfo() throws InterruptedException {
        // Login
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        // Navigate to My Info
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Wait for Edit button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));

        // Use JS click instead of normal click
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);

        // Update fields
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Michael");
        driver.findElement(By.id("personal_optGender_1")).click(); // Male
        driver.findElement(By.id("personal_cmbNation")).sendKeys("Indian");

        WebElement dob = driver.findElement(By.id("personal_DOB"));
        dob.clear();
        dob.sendKeys("1990-05-10");

        // Save (again force JS click to avoid Firefox bug)
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);

        Thread.sleep(1000); // let UI update
    }
}
