import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(email, password);
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}

