import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
//      Added ChromeOptions argument below to fix websocket error
        //dont need this here now, with the pick browser method
        // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*"); //allows redirection from http to https
        //options.addArguments("start-maximized");
        //or driver.manage().window().maximize();
        //**basic** driver = new ChromeDriver(options); selenium grid will use dynamic input values for browser

        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        //implicit wait is not the best. use explicit wait instead
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(url);
    }
    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }
    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getIncorrectDataFromDataProviders() {
        return new Object[][] {
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL="https:hub.lambdatest.com/wd/hub";  //found on github

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "cll2");
        ltOptions.put("accessKey", "FHu3fpjupo2UlV2o5dZZE2r29ufWTkPpIwtFTfFe3CIiS5z47x");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
    @DataProvider(name="CorrectLoginProviders")
    public static Object[][] getCorrectDataFromDataProviders() {
        return new Object[][] {
                {"demo@class.com", "te$t$tudent"},
                /*{"chelsea.laurenson@testpro.io", "te$t$tudent"}  this is not logging me in? */
        };
    }

    //Searching songs helper methods
    protected void searchForASong(String songName) {
        //class example that worked was "div#searchForm input[type=search]"
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'search']")));
        searchField.click();
        searchField.sendKeys(songName);
    }
    protected void clickViewAllButton() throws InterruptedException{
        //failed selectors "button[data-test = 'view-all-songs-btn']"
        //.song>button
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button")));
        viewAllButton.click();
        //Thread.sleep(20000);
    }
    protected void selectFirstSongResult() {
        //failed "[.song-title>td.title]"
        //"#songResultsWrapper > div > div > div.resize-observer"
        //"#songResultsWrapper > div > div > div.item-container > table > tr"
        //"#songResultsWrapper > div > div > div.item-container > table > tr.song-item")
        //"#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"
        //"#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title")
        WebElement firstSongInList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > ul > article:nth-child(1) > span.main > span.details")));
        firstSongInList.click();
        //Thread.sleep(20000);

        }
        protected void clickAddToButton() throws InterruptedException {
        //failed ".btn-add-to")
            // HW feedback but still fail "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"
            //#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to
            WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
            addToButton.click();
            //Thread.sleep(20000);
    }

    protected void choosePlayList() throws InterruptedException {
        //failed ".playlist>li")
        //HW feedback to try "//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"
        WebElement playListFromDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")));
        //Thread.sleep(20000);
        playListFromDropDown.click();
    }
    protected String getSongAddedToPlaylistNotificationText() {
        // "div.success.show"
        WebElement addedToPlaylistNotification = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return addedToPlaylistNotification.getText();
    }

    //playing songs helper methods
     protected void playNextSong() throws InterruptedException {
        WebElement nextSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.next.fa.fa-step-forward.control")));

        action.moveToElement(nextSongButton).perform();
        nextSongButton.click();
        nextSongButton.click();
        //Thread.sleep(20000);
        }

        //playlist actions helper methods
        protected void selectAPlaylist() {
        WebElement playListFromSideBar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(5)")));
        playListFromSideBar.click();
    }

    protected void doubleClickAPlaylist() {
        action = new Actions(getDriver());
        WebElement playListFromSideBar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(5)")));
        action.doubleClick(playListFromSideBar);
    }


    protected void deleteSelectedPlayList() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deleteButton.click();
    }

    protected void managePopUpWindow() {

        try {
            WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
            confirm.click();
        } catch(Exception e) {

        }
    }
    protected String getSongDeletedFromPlaylistNotification() {
        WebElement deletedFromPlaylistNotification = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return deletedFromPlaylistNotification.getText();
    }

    //count songs helper methods
    protected void choosePlaylistByName(String playlistName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size() ;
    }

    protected String getPlaylistDetails() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.meta.text-secondary span.meta"))).getText();
    }

    protected void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs Found:" + countSongs());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

    //rename playlist helper methods
    String newPlayListName = "re-named";
    protected void enterNewPlayListName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']]")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    protected String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");

    }

    public boolean doesPlayListExist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + newPlayListName + "']")));
        return playListElement.isDisplayed();
    }






}





