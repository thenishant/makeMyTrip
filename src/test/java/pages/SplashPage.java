package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SplashPage extends BasePage {

    @FindBy(className = "android.widget.TextView")
    private WebElement textOnSplashScreen;

    @FindBy(id = "com.makemytrip:id/layout_onboarding_right_img_vw")
    private WebElement moveToNextScreen;

    @FindBy(id = "com.makemytrip:id/layout_onboarding_skip_txt_vw")
    private WebElement skipLogin;

    @FindBy(id = "com.makemytrip:id/tv_first_permission_main")
    private WebElement firstPermission;

    @FindBy(id = "com.makemytrip:id/btn_grant_permission")
    private WebElement grantPermission;

    private String moveToNextScreenText = "com.makemytrip:id/layout_onboarding_right_img_vw";
    private AppiumDriver driver;

    public SplashPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void moveToNextScreen() {
        for (int i = 0; i < 3; i++) {
            if (isElementPresent(By.id(moveToNextScreenText))) {
                waitForElementToBeClickable(moveToNextScreen);
                moveToNextScreen.click();
            }
        }
    }

    public void skipLoginAndContinue() {
        waitForElementToBeVisible(skipLogin);
        skipLogin.click();
        allowPermission();
        allowPermissionPopup();
    }

    private void allowPermission() {
        if (isElementPresent(By.id("com.makemytrip:id/tv_first_permission_main"))
                && isElementPresent(By.id("com.makemytrip:id/tv_second_permission_main"))) {
            waitForElementToBeClickable(grantPermission);
            grantPermission.click();
        }
    }
}