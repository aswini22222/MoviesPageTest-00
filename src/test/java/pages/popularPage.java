package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class popularPage {
    @FindBy(className = "link-item")
    List<WebElement> movielistElements;

    WebDriver driver;
    WebDriverWait wait;
    public popularPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public int getmoviesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("link-item")));
        return movielistElements.size();
    }

}

