package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;

import java.time.Duration;

public class LogoutFunctionalitySteps {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("the user navigates to the login page")
    public void theusernavigatestotheloginpage(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }
    @When("the user enters valid username and password")
    public void enterusernameandpassword(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }
    @When("clicks on the login button")
    public void clickLoginButton(){
        driver.findElement(By.className("login-button")).click();
    }
    @Then("the user should be successfully logged in")
    public void userloggedin(){
        String expurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expurl));
        String currenturl=driver.getCurrentUrl();
        Assert.assertEquals(currenturl,expurl,"Urls do not matched as Expected");
    }
    //Scenario 2
    @Given("the user is logged in")
    public void userloggedinSuccessfully(){
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("ccbp.tech"));
    }
    @When("the user navigates to the membership details page")
    public void  usernavigatesthemembershipdetailspage(){
        driver.findElement(By.className("avatar-button")).click();
    }
    @Then("the user should see the membership details")
    public void userseemembershipdetails(){
        WebElement MembershipHead=driver.findElement(By.className("membership-heading"));
        WebElement membershipUsername=driver.findElement(By.className("membership-username"));
        WebElement memebrshipPassword=driver.findElement(By.className("membership-password"));
        WebElement plandetailsheadText=driver.findElement(By.xpath("//p[contains(text(),'Plan details')]"));
        Assert.assertTrue(MembershipHead.isDisplayed(),"Membership Heading is Displayed");
        Assert.assertTrue(membershipUsername.isDisplayed(),"Username is Displayed");
        Assert.assertTrue(memebrshipPassword.isDisplayed(),"Password is Displayed");
        Assert.assertTrue(plandetailsheadText.isDisplayed(),"Plan Details TExt is Displayed ");
    }
    @And("the membership plan should be Premium Ultra HD")
    public void membershippaln(){
        WebElement PremiumHEad=driver.findElement(By.xpath("//p[contains(text(),'Premium')]"));
        WebElement UltraHDtext=driver.findElement(By.xpath("p[contains(text(),'Ultra HD')]"));
        Assert.assertTrue(PremiumHEad.isDisplayed(),"Premium Head text is  Displayed");
        Assert.assertTrue(UltraHDtext.isDisplayed(),"Ultra HD TExt is dispalyed");

    }
    //Scenario 3
    @Given("The user is logged in")
    public void userLoggedIn(){
        String expAccountURl="https://qamoviesapp.ccbp.tech/account";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(actualurl,expAccountURl,"Urls do not match");
    }
    @When("the user clicks on the logout button")
    public void clicklogoutbutton(){
        driver.findElement(By.className("logout-button")).click();
    }
    @Then("the user should be successfully logged out")
    public void usersuccessfullyloggedout(){
        String expHomeUrl="https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expHomeUrl));
        String currrentURL=driver.getCurrentUrl();
        Assert.assertEquals(expHomeUrl,currrentURL,"Urls do not match");
    }
    @And("redirected to the login page")
    public void redirectedtologinpage(){
        String expurl="https://qamoviesapp.ccbp.tech/login";
        Assert.assertEquals(expurl,driver.getCurrentUrl(),"Redirected to Home Page");

    }

  @After
    public void tearDown(){
        driver.quit();
  }



    }

