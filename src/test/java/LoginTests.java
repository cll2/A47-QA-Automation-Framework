import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test (dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void InvalidLoginsTest (String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void ValidLoginTests (String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(email, password);
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void RegistrationNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");

    }

}