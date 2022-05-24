package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ByerInformationPage extends StaticElementsOnPage {


    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    private WebElement labelError;
    @FindBy(id = "cancel")
    private WebElement cancelButton;



    public ByerInformationPage(WebDriver driver) {
        super(driver);
    }


    public ByerInformationPage enterFirstName() {
        firstName.click();
        firstName.sendKeys("firstname");
        return this;
    }

    public ByerInformationPage enterLastName() {
        lastName.click();
        lastName.sendKeys("lastname");
        return this;
    }

    public ByerInformationPage enterPostalCode() {
        postalCode.click();
        postalCode.sendKeys("12345");
        return this;
    }


    public ByerInformationPage clickToContinueButton() {
        continueButton.click();
        return new ByerInformationPage(driver);
    }


    public ByerInformationPage checkStepOnePageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        return this;
    }



    public ByerInformationPage checkFirstNamePlaceholder() {
        assertThat(firstName.getAttribute("placeholder"), equalTo("First Name"));
        return this;
    }


    public ByerInformationPage checkLastNamePlaceholder() {
        assertThat(lastName.getAttribute("placeholder"), equalTo("Last Name"));
        return this;
    }


    public ByerInformationPage checkPostalCodePlaceholder() {
        assertThat(postalCode.getAttribute("placeholder"), equalTo("Zip/Postal Code"));
        return this;
    }


    public ByerInformationPage checkLabelCancelButton() {
        assertThat(cancelButton.getText(), equalTo("CANCEL"));
        return this;
    }


    public ByerInformationPage checkLabelContinueButton() {
        assertThat(continueButton.getAttribute("value"), equalTo("Continue"));
        return this;
    }

}
