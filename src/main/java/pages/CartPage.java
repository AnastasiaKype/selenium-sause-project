package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends StaticElementsOnPage{

    @FindBy(id = "item_0_title_link")
    private WebElement linkItemSauceLabsBikeLight;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkCartPageUrl() {

        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }


    public ByerInformationPage clickToCheckoutButton() {
        checkoutButton.click();
        return new ByerInformationPage(driver);
    }
}
