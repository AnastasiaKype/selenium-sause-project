import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BaseAuthorizedPage;
import pages.LoginPage;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindElementsTest extends BaseTest {

    static WebDriver driver;


    @Test
    void AuthorisationFormTest() {
        assertThat(driver.findElement(By.id("first-name")).getAccessibleName(), equalTo("First Name"));
        assertThat(driver.findElement(By.id("last-name")).getAccessibleName(), equalTo("Last Name"));
        assertThat(driver.findElement(By.id("postal-code")).getAccessibleName(), equalTo("Zip/Postal Code"));
    }


    //@Test
  //  void StaticElementsPageTest() {
      //  new BaseAuthorizedPage(driver)
               // .goToTwitter()
              //  .checkContinueButton()
              //  .checkCancel()
               // .checkAboutButton()
               // .checkExitSideButton()
              //  .checkLogoutButton()
               // .checkResetAppStateButton()
               // .checkSideLabelAllItemsButton()
               // .goToFacebook()
               // .goToLinkedIn();

    }

