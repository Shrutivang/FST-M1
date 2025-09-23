package Activities;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Activity7 extends BaseTest {
    @Test
    public void addQualification() {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.linkText("Qualifications")).click();

        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("OpenAI");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("QA Engineer");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }
}
