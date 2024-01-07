import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test
    public void ChangeProfileName() throws InterruptedException {
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(20000);
        //WebElement profileButton = driver.findElement(By.cssSelector("img.avatar"));
        clickProfileButton();
        enterProfileChangePassword("te$t$tudent");
        generateRandomName();
        String randomName = generateRandomName();
        enterNewProfileName(randomName);
        clickSaveButton();
        Thread.sleep(20000);
        //Assert.assertTrue(profileButton.isDisplayed());

    }
    @Test
    public void RegistrationNavigation() {
        openLoginUrl();
        clickRegistrationButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");

    }

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

