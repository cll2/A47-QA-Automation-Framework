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
    }
    @Test
    public void playSong() throws InterruptedException {
        //".bars"
        //openLoginUrl();  This function is now captured in launch browser before method
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        playNextSong();
        WebElement soundBar = driver.findElement(By.cssSelector(".bars"));
        Thread.sleep(20000);
        Assert.assertTrue(soundBar.isDisplayed());
    } */



    }

