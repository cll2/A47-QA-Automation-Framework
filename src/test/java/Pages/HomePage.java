package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "img.avatar")
    WebElement avatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy(css = "[name = 'name']")
    WebElement playlistNameField;
    @FindBy(css = "div.success.show")
    WebElement popUpNotification;

    public String getPlaylistName () {
        return firstPlaylist.getText();
    }

    public boolean isAvatartDisplayed() {
        return avatarIcon.isDisplayed();
    }

}
