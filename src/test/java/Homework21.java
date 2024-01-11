import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        doubleClickAPlaylist();
        enterNewPlayListName(newPlayListName);
        Assert.assertTrue(doesPlayListExist());
    }


}

