import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginpage;
    HomePage homePage;
    HeaderSection headerSection;
    popularPage Popularpage;
    SearchPage searchPage;

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
        searchPage = new SearchPage(driver);


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
    public void testSearchFunctionality() {
        searchPage.enterSearchText("riverdale");

        searchPage.clickSearchButton();
        int numberofmovies=searchPage.getMoviesCount();
        Assert.assertTrue(numberofmovies>0,"No of movies are displayed");
        driver.close();

    }
    @Test(priority = 2)
    public void testSearchWithMovieNamesAndCount() {

        searchPage.enterSearchText("Narnia");

        // Validate search results
        int numberOfMovies = searchPage.getMoviesCount();
        Assert.assertTrue(numberOfMovies > 0, "No movies are displayed in the search results for Narnia.");

        // Close the browser window
        driver.close();
    }

}