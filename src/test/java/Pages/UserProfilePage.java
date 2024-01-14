package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage extends BasePage {

    public UserProfilePage(WebDriver givenDriver){
        super(givenDriver);
        }

        By profileButton = By.cssSelector("img.avatar");
        By profilePagePasswordField = By.cssSelector("[name = 'current_password']");
        By profileNameField = By.id("inputProfileName");
        By saveButton = By.cssSelector(".btn-submit");

        public void clickProfileButton() {
            findElement(profileButton);
        }

        public void enterProfileChangePassword(String password) {
            findElement(profilePagePasswordField);
        }


}
