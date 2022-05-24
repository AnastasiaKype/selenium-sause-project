package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;
import static utils.UtilsTab.switchToTheNextTab;

public class StaticElementsOnPage extends BasePage {

    public StaticElementsOnPage(final WebDriver driver) {
        super(driver);
        initElements(this.driver, this);

    }


    @FindBy(css = ".social_twitter a")
    WebElement twitterButton = null;
    @FindBy(css = ".social_facebook a")
    WebElement facebookButton = null;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton = null;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsButton;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutButton;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateButton;
    @FindBy(id = "react-burger-cross-btn")
    WebElement exitSideButton;

    @FindBy(id = "cancel")
    WebElement cancel;

    public StaticElementsOnPage checkCancel() {
        assertThat(cancel.getAccessibleName(), equalTo("Go back CANCEL"));
        return this;
    }

    @FindBy(id = "continue")
    WebElement continueButton;

    public StaticElementsOnPage checkContinueButton() {
        assertThat(continueButton.getAccessibleName(), equalTo("Continue"));
        return this;
    }



    public StaticElementsOnPage goToLinkedIn() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
        return this;

    }

    public StaticElementsOnPage goToTwitter() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
        return this;

    }

    public StaticElementsOnPage goToFacebook() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
        return this;
    }

    public StaticElementsOnPage checkSideLabelAllItemsButton() {
        assertThat(allItemsButton.getAccessibleName(), equalTo("ALL ITEMS"));
        return this;
    }

    public StaticElementsOnPage checkLogoutButton() {
        assertThat(logoutButton.getAccessibleName(), equalTo("LOGOUT"));
        return this;
    }

    public StaticElementsOnPage checkAboutButton() {
        assertThat(aboutButton.getAccessibleName(), equalTo("ABOUT"));
        return this;
    }

    public StaticElementsOnPage checkResetAppStateButton() {
        assertThat(resetAppStateButton.getAccessibleName(), equalTo("ABOUT"));
        return this;
    }

    public StaticElementsOnPage checkExitSideButton() {
        assertThat(exitSideButton.getAccessibleName(), equalTo(true));
        return this;
    }


}
