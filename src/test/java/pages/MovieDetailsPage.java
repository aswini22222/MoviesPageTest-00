package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MovieDetailsPage {
    public WebDriver driver;

    @FindBy(how = How.XPATH,using = "//li")
    List<WebElement> movielistelements;

    @FindBy(className = "movie-title")
     WebElement movietitle;

    @FindBy(className = "movie-overview")
    WebElement movieOverview;

    @FindBy(className = "watch-time")
    WebElement watchTime;

    @FindBy(className = "sensor-rating")
    WebElement sensorrating;

    @FindBy(className = "release-year")
    WebElement releaseyear;

    @FindBy(className = "play-button")
    WebElement playButton;

    @FindBy(css = ".movie-genre")
    WebElement movieGenre;

    @FindBy(css = ".genres-heading")
    WebElement genreHeading;

    @FindBy(css = "div[class='genres-container']>p")
    List<WebElement> genrelist;

   @FindBy(xpath = "//h1[text()='Audio Available']")
   WebElement audioAvailableTExt;

   @FindBy(css = "div[class='audio-category'] li")
   List<WebElement> audioCategoryList;

   @FindBy(className = "rating-heading")
   WebElement ratingHeadingEl;

   @FindBy(className = "rating-average-heading")
   WebElement ratingaverageHeadingEl;

   @FindBy(className = "budget-heading")
   WebElement budgetHeadingEl;

   @FindBy(className = "release-date-heading")
   WebElement releasedateHeadingEl;

   @FindBy(css = "h1.similar-movies-heading")
   WebElement MorelikethisHeadingEl;

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public WebElement clickanyMovie(int index){
        return movielistelements.get(index);
    }

    public boolean isTitleDisplayed() {
        return movietitle.isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        return movieOverview.isDisplayed();
    }

    public boolean movieWatchTime(){
        return watchTime.isDisplayed();
    }

    public boolean isReleaseYearDisplayed() {
        return releaseyear.isDisplayed();
    }

    public boolean isRatingDisplayed() {
        return sensorrating.isDisplayed();
    }
    public boolean playButton(){
        return playButton.isDisplayed();
    }
    public boolean isGenreDisplayed() {
        return movieGenre.isDisplayed();
    }
    public boolean isgenreheadingdisplayed(){
        return genreHeading.isDisplayed();
    }
    public String genrelistDisplayed(int index){
        return genrelist.get(index).getText();
    }
    public boolean AudioAvailbltext(){
        return audioAvailableTExt.isDisplayed();
    }
    public String audioCategorylist(int index){
        return audioCategoryList.get(index).getText();
    }
    public boolean ratingHeadingText(){
        return ratingHeadingEl.isDisplayed();

    }
    public boolean ratingAverageHeading(){
        return ratingaverageHeadingEl.isDisplayed();
    }

    public boolean budgetHeadingtext(){
        return budgetHeadingEl.isDisplayed();
    }
    public boolean releasedateDisplayed() {
        return releasedateHeadingEl.isDisplayed();
    }

    public boolean morelikethisDisplayed() {
        return MorelikethisHeadingEl.isDisplayed();
    }
}
