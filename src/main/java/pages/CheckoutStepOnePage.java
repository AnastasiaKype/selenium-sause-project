package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class CheckoutStepOnePage extends BaseAuthorizedPage{

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "first-name")
    private WebElement firstnameInput;

    @FindBy(id = "last-name")
    private WebElement lastnameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(className = "header_secondary_container")
    private WebElement headerTitle;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    @FindBy(css = ".app_logo")
    private WebElement logoPic;

    @FindBy(className = "footer_copy")
    private WebElement footerText;

    @FindBy(className = "footer_robot")
    private WebElement footerRobot;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepOnePage checkCheckoutStepOnePageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        return this;
    }

    public CheckoutStepOnePage checkHeaderTitle(){
        assertThat(headerTitle.getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
        return this;
    }

    public CheckoutStepOnePage checkFirstnameTitle(){
        assertThat(firstnameInput.getAccessibleName(), equalTo("First Name"));
        return this;
    }

    public CheckoutStepOnePage checkLastnameTitle(){
        assertThat(lastnameInput.getAccessibleName(), equalTo("Last Name"));
        return this;
    }

    public CheckoutStepOnePage checkPostalCodeTitle(){
        assertThat(postalCodeInput.getAccessibleName(), equalTo("Zip/Postal Code"));
        return this;
    }

    public CheckoutStepOnePage checkCancelButton(){
        String id = cancelButton.getAttribute("id");
        assertThat(existElementById(id) , equalTo(true));
        return this;
    }

    public CheckoutStepOnePage checkContinueButton(){
        String id = continueButton.getAttribute("id");
        assertThat(existElementById(id) , equalTo(true));
        return this;
    }

    public CheckoutStepOnePage checkCartButton(){
        String id = cartButton.getAttribute("id");
        assertThat(existElementById(id) , equalTo(true));
        return this;
    }

    public CheckoutStepOnePage checkLogo(){
        assertThat(logout.getSize(), not(equalTo("0")));
        return this;
    }

    public CheckoutStepOnePage checkFooterText(){
        assertThat(footerText.getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        return this;
    }

    public CheckoutStepOnePage checkFooterRobot(){
        assertThat(footerRobot.getSize(), not(equalTo("0")));
        return this;
    }

    public CheckoutStepOnePage enterFirstname(String firstname){
        firstnameInput.click();
        firstnameInput.sendKeys(firstname);
        return this;
    }

    public CheckoutStepOnePage enterLastname(String lastname){
        lastnameInput.click();
        lastnameInput.sendKeys(lastname);
        return this;
    }

    public CheckoutStepOnePage enterPostalCode(String postalCode){
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    public CartPage clickCancelButton(){
        cancelButton.click();
        return new CartPage(driver);
    }

    public CheckoutStepTwoPage clickContinueButton(){
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }

}
