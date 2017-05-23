package pages.payment;

import exception.NoPaymentModeFoundException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.PaymentPage;

public class MobikwikWallet extends BasePage {

    AppiumDriver driver;

    public MobikwikWallet(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "com.makemytrip:id/tool_bar")
    private WebElement toolBar;

    @FindBy(id = "com.makemytrip:id/ok_button")
    private WebElement okButton;

    private By paymentFailure = By.id("com.makemytrip:id/payment_failure_ok_button");

    @FindBy(id = "com.makemytrip:id/payment_failure_ok_button")
    private WebElement paymentFailEle;

    private By progressBar = By.id("com.makemytrip:id/progressBar");

    public void payByWallets() throws NoPaymentModeFoundException {

        waitForElementToBeInvisible(progressBar);
        if (isElementPresent(paymentFailure)) {
            paymentFailEle.click();
            return;
        }
        waitForElementToBeClickable(toolBar);
        waitForElementToBeClickable(toolBar);
        navigateBack();
        waitForElementToBeClickable(okButton);
        okButton.click();
        new PaymentPage(driver).paymentFailure();
    }
}
