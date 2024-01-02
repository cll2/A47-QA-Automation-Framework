import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void RegistrationNavigation() {
        openLoginUrl();
        clickRegistrationButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");

    }
}
