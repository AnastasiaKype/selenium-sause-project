import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindElementsTest {

    static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

   @Test
    void AuthorisationFormTest(){
       assertThat(driver.findElement(By.id("first-name")).getAccessibleName(), equalTo("First Name"));
       assertThat(driver.findElement(By.id("last-name")).getAccessibleName(), equalTo("Last Name"));
       assertThat(driver.findElement(By.id("postal-code")).getAccessibleName(), equalTo("Zip/Postal Code"));
   }

   @Test
    void ClickElementsNegativeTest() {
       assertThat(driver.findElements(By.cssSelector("#react-burger-menu-btn")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.cssSelector("#inventory_sidebar_link")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.cssSelector("#inventory_sidebar_link")).size(), not(equalTo("0")));
       assertThat(driver.findElement(By.cssSelector("#inventory_sidebar_link")).getAccessibleName(), equalTo(""));
       assertThat(driver.findElement(By.cssSelector("#about_sidebar_link")).getAccessibleName(), equalTo(""));
       assertThat(driver.findElements(By.cssSelector("#logout_sidebar_link")).size(), not(equalTo("0")));
       assertThat(driver.findElement(By.cssSelector("#logout_sidebar_link")).getAccessibleName(), equalTo(""));
       assertThat(driver.findElements(By.cssSelector("#reset_sidebar_link")).size(), not(equalTo("0")));
       assertThat(driver.findElement(By.cssSelector("#reset_sidebar_link")).getAccessibleName(), equalTo(""));


   }

   @Test
   void FloorTest() {
       assertThat(driver.findElements(By.className(".social_twitter")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.className(".social_facebook")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.className(".social_linkedin")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.className(".footer_robot")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.className(".footer")).size(), not(equalTo("0")));
       assertThat(driver.findElements(By.className(".footer_copy")).size(), not(equalTo("0")));

       assertThat(driver.findElement(By.className("footer_copy")).getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
       assertThat(driver.findElement(By.className("social_facebook")).getText(), equalTo("Facebook"));
       assertThat(driver.findElement(By.className("social_linkedin")).getText(), equalTo("LinkedIn"));

   }
   @Test
    void OthersElementsTest() {

       assertThat(driver.findElements(By.id("cancel")).size(), not(equalTo("0")));
       assertThat(driver.findElement(By.id("cancel")).getAccessibleName(), equalTo("Go back CANCEL"));
       assertThat(driver.findElements(By.id("continue")).size(), not(equalTo("0")));
       assertThat(driver.findElement(By.id("continue")).getAccessibleName(), equalTo("Continue"));
   }



}
