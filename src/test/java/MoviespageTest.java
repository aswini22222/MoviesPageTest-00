import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class MoviespageTest {
    public WebDriver driver;
    LoginPage loginpage;
    HomePage homePage;
    HeaderSection headerSection;
    popularPage Popularpage;
    MovieDetailsPage movieDetailsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginpage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection = new HeaderSection(driver);
        Popularpage = new popularPage(driver);
        movieDetailsPage=new MovieDetailsPage(driver);

        loginpage.loginToApplication("rahul", "rahul@2021");
        String expectedurl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expectedurl));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void testMovieDetailsOnHomePage() {
        // Click on any movie on the Home Page
        movieDetailsPage.clickanyMovie(2);
    }
    @Test(priority = 2)
    public void testUIELements(){
        movieDetailsPage.isTitleDisplayed();
        movieDetailsPage.isDescriptionDisplayed();
        movieDetailsPage.movieWatchTime();
        movieDetailsPage.isReleaseYearDisplayed();
        movieDetailsPage.isRatingDisplayed();
        movieDetailsPage.playButton();
        movieDetailsPage.isGenreDisplayed();
        movieDetailsPage.isgenreheadingdisplayed();
        movieDetailsPage.genrelistDisplayed(2);
        movieDetailsPage.audioCategorylist(2);
        movieDetailsPage.ratingHeadingText();
        movieDetailsPage.ratingAverageHeading();
        movieDetailsPage.budgetHeadingtext();
        movieDetailsPage.releasedateDisplayed();
        movieDetailsPage.morelikethisDisplayed();
    }

}
