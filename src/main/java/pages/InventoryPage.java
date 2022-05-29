package pages;

import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;

public class InventoryPage extends BaseAuthorizedPage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buttonAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement buttonAddBoltTShirt;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement buttonAddBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement buttonAddFleeceJacket;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement buttonAddOnesie;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement buttonAddRedTShirt;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    public InventoryPage(WebDriver driver) {

        super(driver);
    }

    public InventoryPage checkInventoryPageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkCartOnThePage(){
        assertThat(cartButton.getSize(), not(IsEqual.equalTo("0")));
        return this;
    }

    public InventoryPage clickButtonAddBackPack(){
        buttonAddBackpack.click();
        return this;
    }

    public InventoryPage clickButtonAddBoltTShirt(){
        buttonAddBoltTShirt.click();
        return this;
    }

    public InventoryPage clickButtonAddBikeLight(){
        buttonAddBikeLight.click();
        return this;
    }

    public InventoryPage clickButtonAddFleeceJacket(){
        buttonAddFleeceJacket.click();
        return this;
    }

    public InventoryPage clickButtonAddOnesie(){
        buttonAddOnesie.click();
        return this;
    }

    public InventoryPage clickButtonAddRedTShirt(){
        buttonAddRedTShirt.click();
        return this;
    }

    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(driver);
    }
}
