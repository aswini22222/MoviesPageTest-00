package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    By websiteLogoLocator = By.className("login-website-logo");
    By HeadingTextLocator = By.className("sign-in-heading");
    By usernamelabelLocator = By.xpath("//label[text()='USERNAME']");
    By PasswordlableLocator = By.xpath("//label[text()='PASSWORD']");
    By loginButtonLocator = By.className("login-button");
    By usernamelocator=By.id("usernameInput");
    By passwordlocator=By.id("passwordInput");
    By errorMessageLocator=By.className("error-message");
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findWebsiteLogo() {
        return driver.findElement(websiteLogoLocator);
    }
    public String getheadingText() {
        return driver.findElement(HeadingTextLocator).getText();

    }
    public String usernamelabellocator(){
        return driver.findElement(usernamelabelLocator).getText();
    }
    public String getpasswordlabelText(){
        return driver.findElement(PasswordlableLocator).getText();
    }
    public void enterusername(String username){
        driver.findElement(usernamelocator).sendKeys(username);
    }
    public void enterpassword(String password){
        driver.findElement(passwordlocator).sendKeys(password);
    }
    public void ClickLoginButton() {
        driver.findElement(loginButtonLocator).click();

    }
    public void loginToApplication(String username,String password){
        enterusername(username);
        enterpassword(password);
        ClickLoginButton();
    }
    public String geterrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        WebElement errorMsgElement=driver.findElement(errorMessageLocator);
        return errorMsgElement.getText();
    }








            }