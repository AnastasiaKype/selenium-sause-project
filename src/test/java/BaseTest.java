import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    public static WebDriver driver;
    public static String baseUrl;
    public static String username;
    public static String password;
    static String firstname;
    static String lastname;
    static String postalcode;

    @BeforeAll
    static void beforeAllTests() throws IOException {
        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("problem.username");
        password = properties.getProperty("standard.password");
        firstname = properties.getProperty("firstname");
        lastname = properties.getProperty("lastname");
        postalcode = properties.getProperty("postalcode");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        driver.get(baseUrl);
    }

    @AfterEach
    void afterEach() throws IOException {
        Allure.addAttachment("Page screenshot", new FileInputStream(ScreenshotMaker.makeScreenshotOnFailure(driver)));
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
    }

    @AfterAll
    static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
