package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "user-name")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginEnter(String loginName) {
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }

    public LoginPage passwordEnter(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    public InventoryPage clickLoginButton() {
        loginButton.click();
        return new InventoryPage(driver);
    }
}
