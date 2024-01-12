package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection {
    @FindBy(css = "div[class$=home-container] img.website-logo")
    WebElement websitelogoElement;
    @FindBy(css = "div[class$=home-container] a")
    WebElement applogoLinkElement;
    @FindBy(linkText = "Home")
    WebElement navHomeLinkElement;
    @FindBy(linkText = "Popular")
    WebElement navPopularLinkElement;
    @FindBy(how = How.CLASS_NAME,using = "logout-button")
    WebElement accountpagebuttonEl;
    @FindBy(how = How.CLASS_NAME,using = "avatar-img")
    WebElement avatarimageEle;

    WebDriver driver;
    public HeaderSection(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement findAppLogo() {
        return websitelogoElement;
    }
    public void clickonApplogo(){
        applogoLinkElement.click();
    }
    public void setNavHomeLinkElement(){
        navHomeLinkElement.click();
    }
    public void setNavPopularLinkElement(){
        navPopularLinkElement.click();
    }
    public void clickaccountpage(){
        accountpagebuttonEl.click();
    }
    public void logout(){
        clickonApplogo();
        driver.switchTo().alert().accept();
    }
    public WebElement findavatarimage(){
        return avatarimageEle;
    }
    }

