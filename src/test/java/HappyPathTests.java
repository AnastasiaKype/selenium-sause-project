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
void happyPathTestRefactor() {
    new LoginPage(driver)
            .loginEnter(username)
            .passwordEnter(password)
            .clickLoginButton();

    new ByerInformationPage(driver)
            .enterFirstName()
            .checkFirstNamePlaceholder()
            .enterLastName()
            .checkLastNamePlaceholder()
            .enterPostalCode()
            .clickToContinueButton()
            .checkStepOnePageUrl();

    new PaymentPage(driver)
            .checkPageUrl()
            .checkLabelInformation()
            .clickToFinishButton();



    new FinishPage(driver)
            .checkFinishPageUrl()
            .checkLabelFinishOnPage();

}





}
