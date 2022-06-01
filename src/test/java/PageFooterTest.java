import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


@Feature("Тесты на подвал страницы")


public class PageFooterTest extends BaseTest{

    @Test
    void goToFacebook(){
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .goToFacebook();
    }
    @Test
    void goToLinkedIn(){
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .goToLinkedIn();
    }
    @Test
    void goToTwitter(){
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .goToTwitter();
    }



}
