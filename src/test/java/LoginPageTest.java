import io.cucumber.java.Before;
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

import pages.LoginPage;
import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginpage;


    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"rahul", "rahul@2021"}
        };
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Test(priority = 1)
    public void testwithemptyinputFields() {
        loginpage.ClickLoginButton();
        String Experrormessage = loginpage.geterrorMessage();
        String actualMessage = "*Username or password is invalid";
        Assert.assertEquals(actualMessage, Experrormessage, "Error Message didn't Match as Expected");
    }

   @Test(priority = 2)
   public void testwithpassword(){
        loginpage.loginToApplication("rahul","");
        String experrorMsg="*Username or password is invalid";
       String actualMessage="*Username or password is invalid";
       Assert.assertEquals(actualMessage,experrorMsg,"Error Message didn't Match as Expected");
   }
   @Test(priority = 3)
   public void testemptyusername(){
       loginpage.loginToApplication("","rahul@2021");
       String experrorMsg="*Username or password is invalid";
       String actualMessage="*Username or password is invalid";
       Assert.assertEquals(actualMessage,experrorMsg,"Error Message didn't Match as Expected");

   }

   @Test(priority = 4)
    public void testloginpageUI(){
       Assert.assertTrue(loginpage.findWebsiteLogo().isDisplayed(),"App Image is Displayed");
       String ExpheadingText="Login";
       Assert.assertEquals(ExpheadingText,loginpage.getheadingText(),"Expected Heading Text is not Displayed");
       String ExpusernamelabelText="USERNAME";
       Assert.assertEquals(ExpusernamelabelText,loginpage.usernamelabellocator(),"Username label text is not Displayed");
       String ExppasswordlabelText="PASSWORD";
       Assert.assertEquals(ExppasswordlabelText,loginpage.getpasswordlabelText(),"Password label text is not Displayed");

   }
   @Test(priority = 5, dataProvider = "loginData")

       public void validLoginCredentials(String username,String password){
           loginpage.loginToApplication(username,password);
           String expurl="https://qamoviesapp.ccbp.tech/";
           WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.urlToBe(expurl));
           String actualurl=driver.getCurrentUrl();
           Assert.assertEquals(actualurl,expurl,"Urls do not Match");
       }

   @Test(priority = 6)
    public void testInvalidLoginCredentials(){
       loginpage.loginToApplication("rahul","rahill@2022");
       String Experrormessage=loginpage.geterrorMessage();
       String actualMessage="*username and password didn't match";
       Assert.assertEquals(actualMessage,Experrormessage,"Error Message didn't Mactch as Expected");
   }



}
