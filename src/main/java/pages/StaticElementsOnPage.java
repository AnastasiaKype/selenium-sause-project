package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.UtilsTab.switchToTheNextTab;

public class StaticElementsOnPage extends BasePage{

    @FindBy(css = ".social_twitter a")
    WebElement twitterButton = null;
    @FindBy(css = ".social_facebook a")
    WebElement facebookButton = null;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton = null;


    public StaticElementsOnPage(final WebDriver driver) {
        super(driver);

    }

    public void goToLinkedIn() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));

    }

    public void goToTwitter() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));

    }

    public void goToFacebook() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));

    }



}
