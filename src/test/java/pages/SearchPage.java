package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    @FindBy(how = How.CLASS_NAME,using = "search-empty-button")
    WebElement searchbuttonEl;
    @FindBy(how = How.ID,using = "search")
    WebElement  searchInput;
    @FindBy(className = "link-item")
    List<WebElement> movieListElements;

    WebDriver driver;
    WebDriverWait wait;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public int getMoviesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("link-item")));
        return movieListElements.size();
    }

    public void enterSearchText(String searchtext) {
        searchInput.sendKeys(searchtext);
    }

    public void clickSearchButton() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        searchbuttonEl.click();
    }

    public void search(String searchText) {
        enterSearchText(searchText);
        clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("results-text")));
    }


}
