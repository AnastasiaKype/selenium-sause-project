import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;
import java.util.stream.Collectors;

import static elements.SortingDropDownValues.NAME_ASC;
import static elements.SortingDropPriceDown.PRICE_ASC;
import static elements.SortingDropPriceUp.PRICE_DESC;
import static elements.SortingDropUpValues.NAME_DESC;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@Slf4j
@Epic("Технические тесты")
@Story("Тесты на удаление/добавление cookie")

public class CookiesTests extends BaseTest {

    @Test
    void setCookiesTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("session-username", "locked_out_user", "/"));

        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
    }

    @Test
    void name() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .chooseSortingOption(NAME_ASC);

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        // сделать проверку на сортировку, используя компараторы


    }

    @Test
    void nameTwo() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .chooseSortingOptionUp(String.valueOf(NAME_DESC));

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

    }
    @Test
    void priceDesc() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .chooseSortingOptionPriceUp(PRICE_DESC);

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

    }

    @Test
    void priceAsc() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .chooseSortingOptionPriceUp(String.valueOf(PRICE_ASC));

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

    }


}
