import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPassword() {
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("");
        enterPassword("");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        }

    @Test(dataProvider="CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPassword(String email, String password) throws InterruptedException {
        //WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        Thread.sleep(10000);
        //Assert.assertTrue(avatar.isDisplayed());
    }
    /*commenting out as data provider accomplishes all invalid login scenarios
    @Test
    public void LoginInvalidEmailValidPassword(){
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("wrong@email.com");
        enterPassword("te$t$tudent");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    commenting out as data provider accomplishes all invalid login scenarios
    @Test
    public void LoginValidEmailInvalidPassword(){
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("demo@class.com");
        enterPassword("wrongPassword");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    } */

    @Test(dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void LoginInvalidEmailInvalidPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


}

