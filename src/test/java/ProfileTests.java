import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test
    public void ChangeProfileName() throws InterruptedException {
        String randomName = generateRandomName();
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        clickProfileButton();
        //enterProfileChangePassword("te$t$tudent");
        changeProfileName(randomName);
        //Assert.assertTrue(profileButton.isDisplayed());

    }



}

