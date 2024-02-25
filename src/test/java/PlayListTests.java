import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {
    @Test//(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void countSongsInPlaylist(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("demo@class.com", "te$t$tudent");
        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }



    @Test //(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        String playListDeletedNotification = "Deleted playlist";
        loginPage.login("demo@class.com", "te$t$tudent");
        selectAPlaylist();
        deleteSelectedPlayList();
        managePopUpWindow();
        Assert.assertTrue(getSongDeletedFromPlaylistNotification().contains(playListDeletedNotification));
    }
}
