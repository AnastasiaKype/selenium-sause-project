package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CartPage extends BaseAuthorizedPage{

    @FindBy(id = "checkout")
    private WebElement buttonCheckout;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement buttonRemoveBackpack;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement buttonRemoveBikeLight;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement buttonRemoveBoltTShirt;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    private WebElement buttonRemoveFleeceJacket;

    @FindBy(id = "remove-sauce-labs-onesie")
    private WebElement buttonRemoveOnesie;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    private WebElement buttonRemoveRedTShirt;

    @FindBy(id = "continue-shopping")
    private WebElement buttonContinueShopping;

    @FindBy(css = "#item_4_title_link")
    private WebElement backPackOnTheCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkCartPageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }

    public CartPage checkBackpackOnTheCart(){
        assertThat(backPackOnTheCart.getAccessibleName(), equalTo("Sauce Labs Backpack"));
        return this;
    }

    public CartPage clickRemoveBackpackButton(){
        buttonRemoveBackpack.click();
        return this;
    }

    public CartPage clickRemoveBikeLightButton(){
        buttonRemoveBikeLight.click();
        return this;
    }

    public CartPage clickRemoveBoltTShirtButton(){
        buttonRemoveBoltTShirt.click();
        return this;
    }

    public CartPage clickRemoveFleeceJacketButton(){
        buttonRemoveFleeceJacket.click();
        return this;
    }

    public CartPage clickRemoveOnesieButton(){
        buttonRemoveOnesie.click();
        return this;
    }

    public CartPage clickRemoveRedTShirtButton(){
        buttonRemoveRedTShirt.click();
        return this;
    }

    public CheckoutStepOnePage clickCheckoutButton(){
        buttonCheckout.click();
        return new CheckoutStepOnePage(driver) {
            @Override
            public LoginPage logOut() {
                return null;
            }
        };
    }
    public InventoryPage clickContinueShoppingButton(){
        buttonContinueShopping.click();
        return new InventoryPage(driver);
        }
}
