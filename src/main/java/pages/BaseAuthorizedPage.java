package pages;

import elements.FooterPageElement;
import elements.SideElement;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import static utils.UtilsTab.switchToTheNextTab;

public class BaseAuthorizedPage extends BasePage implements FooterPageElement, SideElement {

    @FindBy(css = ".social_twitter a")
    WebElement twitterButton;

    @FindBy(css = ".social_facebook a")
    WebElement facebookButton;

    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement reactMenuOpenButton;

    @FindBy(id = "react-burger-cross-btn")
    WebElement reactMenuCloseButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(css = "#inventory_sidebar_link")
    WebElement allItemTitle;

    @FindBy(css = "#about_sidebar_link")
    WebElement aboutTitle;

    @FindBy(css = "#logout_sidebar_link")
    WebElement logoutTitle;

    @FindBy(css = "#reset_sidebar_link")
    WebElement resetTitle;

    public BaseAuthorizedPage(WebDriver driver) {

        super(driver);
    }
    @Override
    public void goToTwitter(){
        twitterButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
    }
    @Override
    public void goToFacebook(){
        facebookButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
    }

    @Override
    public void goToLinkedIn(){
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
    }
    public BaseAuthorizedPage clickOpenReactMenuButton(){
        reactMenuOpenButton.click();
        return this;
    }

    public BaseAuthorizedPage checkAllItemsInReactMenu(){
        assertThat(allItemTitle.getAccessibleName(), IsEqual.equalTo("ALL ITEMS"));
        return this;
    }

    public BaseAuthorizedPage checkAboutInReactMenu(){
        assertThat(aboutTitle.getAccessibleName(), IsEqual.equalTo("ABOUT"));
        return this;
    }

    public BaseAuthorizedPage checkLogoutInReactMenu(){
        assertThat(logoutTitle.getAccessibleName(), IsEqual.equalTo("LOGOUT"));
        return this;
    }

    public BaseAuthorizedPage checkResetInReactMenu(){
        assertThat(resetTitle.getAccessibleName(), IsEqual.equalTo("RESET APP STATE"));
        return this;
    }

    public BaseAuthorizedPage clickCloseReactMenuButton(){
        reactMenuCloseButton.click();
        return this;
    }

    @Override
    public LoginPage goLogout(){
        reactMenuOpenButton.click();
        logout.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        return new LoginPage(driver);
    }

    @Override
    public LoginPage logOut() {
        return null;
    }

}