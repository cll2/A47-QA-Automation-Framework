import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPassword() {
        openLoginUrl();
        enterEmail("");
        enterPassword("");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        }

    @Test
    public void LoginValidEmailValidPassword() throws InterruptedException {
        //WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(10000);
        //Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void LoginInvalidEmailValidPassword(){
        openLoginUrl();
        enterEmail("wrong@email.com");
        enterPassword("te$t$tudent");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void LoginValidEmailInvalidPassword(){
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("wrongPassword");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


}

