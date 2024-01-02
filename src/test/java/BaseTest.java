import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    //login helper methods
    protected void openLoginUrl() {
        driver.get(url);
    }

    protected void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void enterPassword(String password) {
        WebElement passwordFiled = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordFiled.click();
        passwordFiled.clear();
        passwordFiled.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
    }

    //registration helper methods
    protected void clickRegistrationButton() {
        WebElement registrationButton = driver.findElement(By.cssSelector("[href='registration']"));
        registrationButton.click();
    }

    //profile helper methods

    protected String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");

    }
    protected void clickProfileButton() {
        //failed selectors
        // "a.view-profile>span"
        //".view-profile
        //"img.avatar"
        WebElement profileButton = driver.findElement(By.cssSelector("img.avatar"));
        profileButton.click();

    }

    protected void enterProfileChangePassword(String password) {
        WebElement profilePagePasswordField = driver.findElement(By.cssSelector("name = 'current_password'"));
        profilePagePasswordField.click();
        profilePagePasswordField.clear();
        profilePagePasswordField.sendKeys();
    }

    protected void changeProfileName(String randomName) {
        WebElement profileNameFiled = driver.findElement(By.id("inputProfileName"));
        profileNameFiled.click();
        profileNameFiled.clear();

    }
}



