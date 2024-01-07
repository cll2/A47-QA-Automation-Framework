import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        //".bars"
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        playNextSong();
        WebElement soundBar = driver.findElement(By.cssSelector(".bars"));
        Thread.sleep(20000);
        Assert.assertTrue(soundBar.isDisplayed());

    }

}

