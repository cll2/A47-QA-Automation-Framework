import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework20 extends BaseTest {

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

