import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Added 1 song into 'Emo Playlist.'";

        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        searchForASong("holzinacc0");
        selectFirstSongResult();
        clickViewAllButton();
        clickAddToButton();
        choosePlayList();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));
    }

}

