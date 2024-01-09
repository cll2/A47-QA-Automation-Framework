import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String playListDeletedNotification = "Deleted playlist";
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        selectAPlaylist();
        deleteSelectedPlayList();
        Thread.sleep(2000);
        managePopUpWindow();
        Thread.sleep(2000);
        Assert.assertTrue(getSongDeletedFromPlaylistNotification().contains(playListDeletedNotification));
    }


}

