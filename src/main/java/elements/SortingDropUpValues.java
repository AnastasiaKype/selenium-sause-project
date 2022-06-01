package elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SortingDropUpValues {

   NAME_DESC(By.cssSelector("[data-test=product_sort_container] > [value=za]"), "Name (Z to A)");

    @Getter
    By elementLocator;
    @Getter
    String title;
    SortingDropUpValues( By cssSelector, String title) {
        this.elementLocator = cssSelector;
        this.title = title;
    }

    public SortingDropUpValues getByValueTwo (String title) {
        return SortingDropUpValues.valueOf(title);
    }
}
