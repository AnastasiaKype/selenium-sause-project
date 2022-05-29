import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class HappyPathTests extends BaseTest {
    @Test
    void authorisationPositiveTest() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .goLogout();
    }

    @Test
    void happyPathTest() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .clickButtonAddBackPack()
                .clickCartButton()
                .checkCartPageURL()
                .checkBackpackOnTheCart()
                .clickCheckoutButton()
                .checkCheckoutStepOnePageURL()
                .enterFirstname(firstname)
                .enterLastname(lastname)
                .enterPostalCode(postalcode)
                .clickContinueButton()
                .checkCheckOutStepTwoRageURL()
                .checkBackpackOnOrder()
                .clickFinishButton()
                .checkCheckoutCompletePageURL()
                .checkCompleteMessage()
                .clickBackToProductButton()
                .checkInventoryPageURL()
                .goLogout();
    }






}
