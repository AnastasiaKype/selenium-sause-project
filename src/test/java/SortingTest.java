import elements.SideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
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
@Story("Тесты на сортировку")
public class SortingTest extends BaseTest {

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


