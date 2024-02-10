package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (css = "[type = 'email']")
    WebElement emailField;
    @FindBy (css = "[type = 'password']")
    WebElement passwordField;
    @FindBy (css = "[type = 'submit']")
    WebElement submitBtn;
    @FindBy (css = "[href='registration']")
    WebElement registrationBtn;

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public LoginPage login(String email, String password) {
        provideEmail(email).providePassword(password).clickSubmit();
        return this;
    }

    public LoginPage clickRegistrationButton() {
        registrationBtn.click();
        return this;
    }




}
