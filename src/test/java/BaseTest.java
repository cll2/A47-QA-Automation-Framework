import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url ="https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); //allows redirection from http to https
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getIncorrectDataFromDataProviders() {
        return new Object[][] {
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""}
        };

    }

    @DataProvider(name="CorrectLoginProviders")
    public static Object[][] getCorrectDataFromDataProviders() {
        return new Object[][] {
                {"demo@class.com", "te$t$tudent"},
                {"chelsea.laurenson@testpro.io", "te$t$tudent"}
        };
    }
    //login helper methods
    /*protected void openLoginUrl() {
        //not used as this is captured in the launch browser before method
        driver.get(url);
    } */

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
             //HW feedback but still fail "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"
             //#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to
            WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
            Thread.sleep(20000);
            addToButton.click();

    }

        protected void choosePlayList() throws InterruptedException {
        //failed ".playlist>li")
            //HW feedback to try "//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"
            WebElement playList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
            playList.click();
            Thread.sleep(20000);
        }

        protected String getSongAddedToPlaylistNotificationText() {
        // "div.success.show"
            WebElement addedToPlaylistNotification = driver.findElement(By.cssSelector("div.success.show"));
            return addedToPlaylistNotification.getText();
        }

        //playing songs helper methods
        protected void playNextSong() throws InterruptedException {
            WebElement nextSongButton = driver.findElement(By.cssSelector("i.next.fa.fa-step-forward.control"));
            Actions action = new Actions(driver);
            action.moveToElement(nextSongButton).perform();
            nextSongButton.click();
            nextSongButton.click();
            Thread.sleep(20000);
        }

        //playlist actions helper methods
        protected void selectAPlaylist() {
        WebElement playList = driver.findElement(By.cssSelector(".playlist:nth-child(5)"));
        playList.click();
        }

        protected void deleteSelectedPlayList() {
            WebElement deleteButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
            deleteButton.click();
        }

        protected void managePopUpWindow() {
        WebElement confirm = driver.findElement(By.cssSelector("button.ok"));
        confirm.click();
        }
        protected String getSongDeletedFromPlaylistNotification() {
        WebElement deletedFromPlaylistNotification = driver.findElement(By.cssSelector("div.success.show"));
        return deletedFromPlaylistNotification.getText();
        }




}



