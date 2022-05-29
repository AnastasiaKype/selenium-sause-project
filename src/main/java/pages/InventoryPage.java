package pages;

import elements.SortingDropDownValues;
import elements.SortingDropPriceDown;
import elements.SortingDropPriceUp;
import elements.SortingDropUpValues;
import lombok.Getter;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BaseAuthorizedPage {

    @Getter
    @FindBy(id = "shopping_cart_container")
    WebElement cartContainer;
    @Getter
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;

    @Getter
    @FindBy(css = "[data-test=product_sort_container]")
    WebElement sortingDropdown;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkCartOnThePage() {
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo(0)));
        return this;
    }

    public InventoryPage chooseSortingOption(String value) {
        sortingDropdown.click();
        By locator = SortingDropDownValues.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }

    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }
    public InventoryPage chooseSortingOptionUp(String value) {
        sortingDropdown.click();
        By locator = SortingDropUpValues.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }
    public InventoryPage chooseSortingOptionUp(SortingDropDownValues value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }
    public InventoryPage chooseSortingOptionPriceUp(String value) {
        sortingDropdown.click();
        By locator = SortingDropPriceUp.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }
    public InventoryPage chooseSortingOptionPriceUp(SortingDropPriceUp value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }
    public InventoryPage chooseSortingOptionPriceDown(String value) {
        sortingDropdown.click();
        By locator = SortingDropPriceDown.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }
    public InventoryPage chooseSortingOptionPriceDown(SortingDropPriceDown value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }

    @Override
    public LoginPage logOut() {
        return null;
    }
}
