package Activities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 extends BaseTest {
    @Test
    public void verifyTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }
}
