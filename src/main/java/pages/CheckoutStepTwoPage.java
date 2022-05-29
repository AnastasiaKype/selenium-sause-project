package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutStepTwoPage extends BaseAuthorizedPage{

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepTwoPage checkCheckOutStepTwoRageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

    public CheckoutStepTwoPage checkBackpackOnOrder(){
        assertThat(driver.findElement(By.cssSelector("#item_4_title_link")).getAccessibleName(), equalTo("Sauce Labs Backpack"));
        return this;
    }


    public CheckoutCompletePage clickFinishButton(){
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    public CheckoutStepOnePage clickCancelButton(){
        cancelButton.click();
        return new CheckoutStepOnePage(driver);
    }

}
