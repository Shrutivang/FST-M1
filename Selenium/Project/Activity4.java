package Activities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 extends BaseTest {
    @Test
    public void addEmployee() {
        // Login
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        // Add employee
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("btnSave")).click();

        // Verify
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("John Doe");
        driver.findElement(By.id("searchBtn")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'John')]")).isDisplayed());
    }
}
