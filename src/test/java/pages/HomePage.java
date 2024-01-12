package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.List;

public class HomePage {
    @FindBy(xpath = "//h1[contains(@class,'home-movie-heading') and contains(text(),'riverdale')]")
    WebElement headingTextEle;
    @FindBy(className = "home-movie-description")
    WebElement DescriptionTextEle;
    @FindBy(className = "movies-list-heading")
    List<WebElement> movielistheadingtextElements;
    @FindBy(how = How.CLASS_NAME,using = "home-movie-play-button")
    WebElement playbuttonEle;
    @FindBy(how = How.CLASS_NAME,using = "contact-us-paragraph")
    WebElement contactusTextEle;
    @FindBy(xpath = "//img[@class='poster']")
    List<WebElement> movielistElements;
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getheadingtext(){
        return headingTextEle.getText();
    }
    public String getdescriptionText(){
        return DescriptionTextEle.getText();
    }
    public int  getmovielistheadingelements() {
        return movielistElements.size();
    }
    public void clickplaybuttonEl(){
         playbuttonEle.click();
    }
    public String getcontactUsheadingText(){
        return contactusTextEle.getText();
    }






}


