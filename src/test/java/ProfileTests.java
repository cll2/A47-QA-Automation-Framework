import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void ChangeProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Demo@class.com", "te$t$tudent");
        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.clickProfileButton();
        profilePage.enterProfileChangePassword("te$t$tudent");
        profilePage.enterNewProfileName(generateRandomName());
    }

    /*
    @Test
     /*
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Added 1 song into 'Emo Playlist.'";
        openLoginUrl();
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();

    }

     */



    /* @Test //(dataProvider = "CorrectLoginCredentials", dataProviderClass = BaseTest.class)
    public void playSong(String email, String password) throws InterruptedException {
        //".bars"
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        playNextSong();
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bars")));
        Assert.assertTrue(soundBar.isDisplayed());
    } */


}

