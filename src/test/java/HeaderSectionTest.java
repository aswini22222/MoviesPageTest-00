import org.openqa.selenium.WebDriver;
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

public class HeaderSectionTest {
    public WebDriver driver;
    LoginPage loginpage;
    HomePage homePage;
    HeaderSection headerSection;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginpage = new LoginPage(driver);
        homePage=new HomePage(driver);
        headerSection=new HeaderSection(driver);

        loginpage.loginToApplication("rahul","rahul@2021");
        String expectedurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expectedurl));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void findapplogo(){
       Assert.assertTrue(headerSection.findAppLogo().isDisplayed(),"App logo is not Displayed");
    }
    @Test(priority = 2)
    public void testnavigationbypopular(){
        headerSection.setNavPopularLinkElement();
        String expPopularUrl="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(expPopularUrl,driver.getCurrentUrl(),"Urls do not match");
    }
    @Test(priority = 3)
    public void testHomepagelink(){
        headerSection.setNavHomeLinkElement();
        String expurl="https://qamoviesapp.ccbp.tech/";
        Assert.assertEquals(expurl,driver.getCurrentUrl(),"Urls do not match");

    }
    @Test(priority = 4)
    public void testLogoutFunctionality(){
        headerSection.clickaccountpage();
        String accountpageurl="https://qamoviesapp.ccbp.tech/account";
        Assert.assertEquals(accountpageurl,driver.getCurrentUrl(),"urls do not match");
        headerSection.logout();
        //Avatar image
        Assert.assertEquals(headerSection.findavatarimage().isDisplayed(),"Avatar image is not Displayed");
    }


}
