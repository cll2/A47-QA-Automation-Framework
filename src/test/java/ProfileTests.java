import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void ChangeProfileName() throws InterruptedException {
        //openLoginUrl();
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }

    @Test
    public void RegistrationNavigation() {
        //openLoginUrl();
        //openLoginUrl();  This function is now captured in launch browser before method
        clickRegistrationButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");

    }


    /* @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Added 1 song into 'Emo Playlist.'";
        openLoginUrl();
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    public void addSongToPlaylist() throws InterruptedException {
        clickViewAllButton();
        clickAddToButton();
        choosePlayList();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));
        Assert.assertTrue(getSongAddedToPlaylistNotificationText().contains(newSongAddedNotification));
    } */


    /* @Test (dataProvider = "CorrectLoginCredentials", dataProviderClass = BaseTest.class)
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

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void countSongsInPlaylist(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }



    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist(String email, String password) throws InterruptedException {
        String playListDeletedNotification = "Deleted playlist";
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        //Thread.sleep(2000);
        selectAPlaylist();
        deleteSelectedPlayList();
        //Thread.sleep(2000);
        managePopUpWindow();
        //Thread.sleep(2000);
        Assert.assertTrue(getSongDeletedFromPlaylistNotification().contains(playListDeletedNotification));
    }
}

