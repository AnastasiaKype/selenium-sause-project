package pages;

import io.qameta.allure.Step;
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

    @Step("Вводим логин {loginName}")
    public LoginPage loginEnter(String loginName) {
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }

    @Step("Вводим пароль {password}")
    public LoginPage passwordEnter(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку авторизации")
    public InventoryPage clickLoginButton() {
        loginButton.click();
        return new InventoryPage(driver);
    }
    @Step("Вводим логин {loginName} perfomance")
    public LoginPage loginEnterPerfomance(String loginNameTwo) {
        loginInput.click();
        loginInput.sendKeys(loginNameTwo);
        return this;
    }
}
