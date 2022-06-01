import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Feature("Тесты на авторизацию в системе")
public class AuthorisationTests extends BaseTest{
    @Test
    void authorisationWithLoginPagePositiveTest() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Test
    void authorisationWithLoginPageFailedTest() {
        new LoginPage(driver)
                .loginEnter(username + "1111")
                .passwordEnter(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Test
    void authorisationWithLoginPageFailedPasswordTest() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password + "1111")
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Test
    void authorisationWithLoginPagePerformanceUserTest() {
        new LoginPage(driver)
                .loginEnterPerfomance(usernameTwo)
                .passwordEnter(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }
    @AfterAll
    static void afterAll() {
        driver.quit();
    }

}
