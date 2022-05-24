package pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;


        initElements(this.driver, this);
    }
}
