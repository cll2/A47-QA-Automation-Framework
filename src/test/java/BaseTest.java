import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;

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
        options.addArguments("start-maximized");
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


    protected void clickProfileButton() {
        //failed selectors
        // "a.view-profile>span"
        //".view-profile
        //"img.avatar"
        WebElement profileButton = driver.findElement(By.cssSelector("img.avatar"));
        profileButton.click();

    }

    protected void enterProfileChangePassword(String password) {
        WebElement profilePagePasswordField = driver.findElement(By.cssSelector("[name = 'current_password']"));
        profilePagePasswordField.click();
        profilePagePasswordField.clear();
        profilePagePasswordField.sendKeys(password);
    }

    protected String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");

    }

    protected void enterNewProfileName(String name) {
        WebElement profileNameFiled = driver.findElement(By.id("inputProfileName"));
        profileNameFiled.click();
        profileNameFiled.clear();
        profileNameFiled.sendKeys(name);

    }

    protected void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
    }

    //Searching songs helper methods
    protected void searchForASong(String songName) {

        //class example that worked was "div#searchForm input[type=search]"
        WebElement searchField = driver.findElement(By.cssSelector("[type = 'search']"));
        searchField.click();
        searchField.sendKeys(songName);
    }


        protected void clickViewAllButton() throws InterruptedException{
            //failed selectors "button[data-test = 'view-all-songs-btn']"
            //.song>button
            WebElement viewAllButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
            viewAllButton.click();
            Thread.sleep(20000);
        }

        protected void selectFirstSongResult() throws InterruptedException {
        //failed "[.song-title>td.title]"
            //"#songResultsWrapper > div > div > div.resize-observer"
            //"#songResultsWrapper > div > div > div.item-container > table > tr"
            //"#songResultsWrapper > div > div > div.item-container > table > tr.song-item")
            //"#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"
            //"#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title")

            WebElement firstSongInList = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > ul > article:nth-child(1) > span.main > span.details"));
            Thread.sleep(20000);
            firstSongInList.click();

        }

         protected void clickAddToButton() throws InterruptedException {
        //failed ".btn-add-to")
             //#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to
            WebElement addToButton = driver.findElement(By.xpath("songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
            Thread.sleep(20000);
            addToButton.click();

    }

        protected void choosePlayList() throws InterruptedException {
        //failed ".playlist>li")
            WebElement playList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
            playList.click();
            Thread.sleep(20000);
        }

        protected String getNotificationText() {
        // "div.success.show"
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();
        }



}



