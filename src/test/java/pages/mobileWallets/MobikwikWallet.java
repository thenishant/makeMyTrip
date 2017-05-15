package pages.mobileWallets;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class MobikwikWallet extends BasePage {

    public MobikwikWallet(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.makemytrip:id/tool_bar")
    private WebElement toolBar;

    @FindBy(id = "com.makemytrip:id/ok_button")
    private WebElement okButton;

    public void payByWallets() {
        waitForElementToBeClickable(toolBar);
        waitForElementToBeClickable(toolBar);
        navigateBack();
        waitForElementToBeClickable(okButton);
        okButton.click();
    }

}
