package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        return this;
    }

    public void clickRegistrationButton() {
        WebElement registrationButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='registration']")));
        registrationButton.click();
    }




}
