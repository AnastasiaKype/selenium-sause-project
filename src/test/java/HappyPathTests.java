import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.InventoryPage;
import pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class HappyPathTests extends BaseTest {
@Test
void happyPathTestRefactor() {
    new LoginPage(driver)
            .loginEnter(username)
            .passwordEnter(password)
            .clickLoginButton();
    assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
    assertThat(driver.findElements(By.cssSelector("#item_0_title_link")).size(), not(equalTo("0")));
    assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
    assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo("0")));

    new InventoryPage(driver)
            .checkCartOnThePage()
            .checkInventoryPageUrl();


}


    @Test
    void happyPathTest() {
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        assertThat(driver.findElements(By.cssSelector("#item_0_title_link")).size(), not(equalTo("0")));

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        assertThat(driver.findElement(By.cssSelector("#item_0_title_link")).getAccessibleName(), equalTo("Sauce Labs Bike Light"));

        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));

        driver.findElement(By.id("first-name")).sendKeys("Anastasia");
        driver.findElement(By.id("last-name")).sendKeys("Kype");
        driver.findElement(By.id("postal-code")).sendKeys("132456");
        driver.findElement(By.id("continue")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        assertThat(driver.findElement(By.cssSelector("#item_0_title_link")).getAccessibleName(), equalTo("Sauce Labs Bike Light"));

        driver.findElement(By.id("finish")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        assertThat(driver.findElements(By.cssSelector("#add-to-cart-sauce-labs-backpack")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.className("complete-header")).getAccessibleName(), equalTo("THANK YOU FOR YOUR ORDER"));

    }





}
