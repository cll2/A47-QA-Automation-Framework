import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        //added comment here to fork
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(email, password);
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    /*commenting out as data provider accomplishes all invalid login scenarios
    @Test
    public void LoginInvalidEmailValidPassword(){
        openLoginUrl();
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("wrong@email.com");
        enterPassword("te$t$tudent");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    commenting out as data provider accomplishes all invalid login scenarios
    @Test
    public void LoginValidEmailInvalidPassword(){
        openLoginUrl();
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