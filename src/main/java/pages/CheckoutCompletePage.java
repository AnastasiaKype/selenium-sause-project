package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckoutCompletePage extends BaseAuthorizedPage{

    @FindBy(id = "back-to-products")
    private WebElement backToProductButton;

    @FindBy(className = "complete-header")
    private WebElement completeMessage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage checkCheckoutCompletePageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    public CheckoutCompletePage checkCompleteMessage(){
        assertThat(completeMessage.getAccessibleName(), equalTo("THANK YOU FOR YOUR ORDER"));
        return this;
    }

    public InventoryPage clickBackToProductButton(){
        backToProductButton.click();
        return new InventoryPage(driver);
    }
}
