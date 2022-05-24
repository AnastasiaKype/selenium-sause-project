package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FinishPage extends StaticElementsOnPage{

    @FindBy(className = "complete-header")
    private WebElement labelCompleteOnPage;


    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public FinishPage checkFinishPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    public FinishPage checkLabelFinishOnPage() {
        assertThat(labelCompleteOnPage.getText(), equalTo("THANK YOU FOR YOUR ORDER"));
        return this;
    }
}
