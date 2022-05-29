package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;


        initElements(this.driver, this);
    }
}
