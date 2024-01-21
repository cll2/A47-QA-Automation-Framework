package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy (css = "img.avatar)")
    WebElement profileButton;

    @FindBy (css = "[name = 'current_password']")
    WebElement profilePagePasswordField;

    @FindBy (id = "inputProfileName")
    WebElement profileNameField;

    @FindBy (css = ".btn-submit")
    WebElement saveBtn;

    public void clickProfileButton() {
        profileButton.click();
    }

    public void enterProfileChangePassword(String password) {
        profilePagePasswordField.sendKeys(password);
    }

    public void enterNewProfileName(String name) {
        WebElement profileNameFiled = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputProfileName")));
        profileNameFiled.click();
        profileNameFiled.clear();
        profileNameFiled.sendKeys(name);
    }
    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-submit")));
        saveButton.click();
    }


}
