import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        String expurl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(expurl));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void testHomepageUI(){
        //Heading Text riverdale
        String actualHeadText=homePage.getheadingtext();
        String expHeadText="riverdale";
        Assert.assertEquals(actualHeadText,expHeadText,"Heading Text is not matched as expected");
        //Description TExt
        String actualDescText="This made-for-video production mixes highlights of Michael Jordan from the '80s with a fantasy storyline of a high school teen named Walt, who has been cut from his basketball team. Doubting his abilities, Walt gets some lessons from Michael Jordan himself, on the magical Playground known as Michael Jordan's Playground.";
        String expDescText=homePage.getdescriptionText();
        Assert.assertEquals(actualHeadText,actualDescText,"Description Text is not matched as expected");
        //get Movie Heading text elements
        int  movielistelements=homePage.getmovielistheadingelements();
        Assert.assertTrue(movielistelements>0,"No of Movies are displayed in the movies section");
        //get contact us head text
        String expContacthead="Contact Us";
        String actualcontactTExt=homePage.getcontactUsheadingText();
        Assert.assertEquals(expContacthead,actualcontactTExt,"Contact Us Heading Text do not Match");

    }
    @Test(priority = 2)
    public void testplaybutton(){
        homePage.clickplaybuttonEl();
        String expurl="https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
        String currenturl=driver.getCurrentUrl();
        Assert.assertEquals(currenturl,expurl,"Urls do not match");
    }

}



