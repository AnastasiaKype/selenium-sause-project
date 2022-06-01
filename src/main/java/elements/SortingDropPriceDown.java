package elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SortingDropPriceDown {

    PRICE_ASC(By.cssSelector("[data-test=product_sort_container] > [value=hilo]"), "Price (high to low)");

    @Getter
    By elementLocator;
    @Getter
    String title;
    SortingDropPriceDown( By cssSelector, String title) {
        this.elementLocator = cssSelector;
        this.title = title;
    }

    public SortingDropDownValues getByValue(String title) {
        return SortingDropDownValues.valueOf(title);
    }

}
