package pages;

import exception.NoResultsFound;
import exception.NoPaymentModeFoundException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends BasePage {
    public PaymentPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.makemytrip:id/payment_option_header_layout")
    private WebElement paymentHeader;

    @FindBy(id = "com.makemytrip:id/payment_options_layout")
    private List<WebElement> paymentOptions;

    @FindBy(id = "com.makemytrip:id/rlPaymentOptions")
    private List<WebElement> mobileWallets;

    @FindBy(id = "com.makemytrip:id/continue_layout")
    private WebElement continueButton;

    @FindBy(id = "com.makemytrip:id/payment_failure_ok_button")
    private WebElement paymentFailureOkButton;

    @FindBy(id = "com.makemytrip:id/payment_option_header_textView")
    private List<WebElement> paymentModeNames;

    public void selectPaymentMode() throws NoPaymentModeFoundException, NoResultsFound {
        waitForElementToBeClickable(paymentHeader);
        waitForElementToBeClickable(paymentOptions);
        paymentModeNames.size();
        paymentModeNames.get(3).click();
        waitForElementToBeClickable(mobileWallets);
        mobileWallets.get(0).click();
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    private void chooseCreditCard() {
        waitForElementToBeClickable(paymentOptions);
        List<WebElement> elements = paymentOptions.get(0).findElements(By.className("android.widget.RelativeLayout"));
        elements.size();
        elements.get(7).click();
    }

    private void continueToPay() {
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    public void payByCreditCard() {
        chooseCreditCard();
        continueToPay();
    }

    public void paymentFailure() {
        waitForElementToBeClickable(paymentFailureOkButton);
        paymentFailureOkButton.click();
    }
}