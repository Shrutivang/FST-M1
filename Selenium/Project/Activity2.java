package Activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2 extends BaseTest {
    @Test
    public void getHeaderImageUrl() {
        WebElement img = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        String imgUrl = img.getAttribute("src");
        System.out.println("Header Image URL: " + imgUrl);
        Assert.assertTrue(imgUrl.contains("logo.png"));
    }
}
