package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "com.makemytrip:id/activity_home_launcher_flights_imgvw")
    private WebElement flights;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowPermission;

    @FindBy(id = "com.makemytrip:id/refer_earn_banner_linearlayout")
    private WebElement referFriend;

    @FindBy(id = "com.makemytrip:id/notificationCenterLnrLyt")
    private WebElement notification;

    @FindBy(id = "com.makemytrip:id/activity_home_launcher_hotels_imgvw")
    private WebElement hotels;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickFlights(){
        skipReferAFriend();
        waitForElementToBeClickable(flights);
        flights.click();
    }

    public void clickHotels(){
        skipReferAFriend();
        waitForElementToBeClickable(hotels);
        hotels.click();
    }

    private void skipReferAFriend(){
        if (isElementPresent(By.id("com.makemytrip:id/refer_earn_banner_linearlayout"))){
            waitForElementToBeClickable(referFriend);
            navigateBack();
        }
    }
}
