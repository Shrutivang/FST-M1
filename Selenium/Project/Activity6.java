package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6 extends BaseTest {
    @Test
    public void verifyDirectoryMenu() {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        WebElement directory = driver.findElement(By.id("menu_directory_viewDirectory"));
        Assert.assertTrue(directory.isDisplayed() && directory.isEnabled());
        directory.click();

        String header = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(header, "Search Directory");
    }
}
