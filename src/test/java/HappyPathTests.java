import org.junit.jupiter.api.Test;
import pages.*;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class HappyPathTests extends BaseTest {
    @Test
    void authorisationPositiveTest() {
        new LoginPage(driver)
                .loginEnter(username)
                .passwordEnter(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }





}
