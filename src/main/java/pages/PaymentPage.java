package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentPage extends StaticElementsOnPage {

    @FindBy(className = "summary_info_label")
    private WebElement paymentInformation;
    @FindBy(id = "finish")
    private WebElement finishButton;


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage checkPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }


    public PaymentPage checkLabelInformation() {
        assertThat(paymentInformation.getText(), equalTo("Payment Information:"));
        return this;
    }

    public FinishPage clickToFinishButton() {
        finishButton.click();
        return new FinishPage(driver);
    }
}
