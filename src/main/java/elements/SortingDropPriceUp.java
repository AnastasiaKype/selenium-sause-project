package elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SortingDropPriceUp {
    PRICE_DESC(By.cssSelector("[data-test=product_sort_container] > [value=lohi]"), "Price (high to low)");

    @Getter
    By elementLocator;
    @Getter
    String title;
    SortingDropPriceUp( By cssSelector, String title) {
        this.elementLocator = cssSelector;
        this.title = title;
    }

    public SortingDropDownValues getByValue(String title) {
        return SortingDropDownValues.valueOf(title);
    }

}
