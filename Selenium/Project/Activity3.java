package Activities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 extends BaseTest {
    @Test
    public void loginTest() {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
    }
}
