package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity8 extends BaseTest {
    @Test
    public void applyLeave() {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.id("menu_leave_applyLeave")).click();

        driver.findElement(By.id("applyleave_txtLeaveType")).sendKeys("Annual Leave");
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2025-10-01");
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2025-10-02");
        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        WebElement status = driver.findElement(By.xpath("//table[@id='resultTable']//td[6]"));
        Assert.assertTrue(status.getText().contains("Pending"));
    }
}
