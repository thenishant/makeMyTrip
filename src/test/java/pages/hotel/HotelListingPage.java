package pages.hotel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class HotelListingPage extends BasePage {


    public HotelListingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.makemytrip:id/tvHotelName")
    private List<WebElement> hotelName;

    @FindBy(id = "com.makemytrip:id/sort_filter")
    private WebElement sortAndFilter;

    @FindBy(id = "com.makemytrip:id/iv_hotel_image")
    private WebElement hotelImage;

    @FindBy(id = "com.makemytrip:id/image_label")
    private WebElement photoText;

    @FindBy(id = "com.makemytrip:id/ll_tabs")
    private WebElement reviews;

    @FindBy(id = "com.makemytrip:id/nearby_button_text")
    private WebElement nearByPlaces;

    @FindBy(id = "com.makemytrip:id/btnShowAllHotels")
    private WebElement selectRoomButton;

    private By skipList = By.id("com.makemytrip:id/tvSkipMatchmaker");
    private By continueMatchMakerButton = By.id("com.makemytrip:id/matchmakerContinueBtn");
    private By matchMakerButton = By.id("com.makemytrip:id/btn_match_maker_give_try");
    private By closeHElper = By.id("com.makemytrip:id/close_helper");

    @FindBy(id = "com.makemytrip:id/close_helper")
    private WebElement helperEle;

    @FindBy(id = "com.makemytrip:id/btn_match_maker_give_try")
    private WebElement matchMakerButtonEle;

    @FindBy(id = "android.widget.imageView")
    private WebElement imageView;

    @FindBy(className = "android.support.v7.app.a$c")
    private List<WebElement> details;

    @FindBy(id = "com.makemytrip:id/tvSkipMatchmaker")
    private WebElement skipListEle;

    public void hotelDetails() {
        for (int i = 0; i < details.size(); i++) {
            details.get(i).click();
        }
        selectRoomButton.click();
    }

    public void selectHotel() {

        if (isElementPresent(matchMakerButton)) {
            waitForElementToBeClickable(matchMakerButtonEle);
            navigateBack();
            waitForElementToBeInvisible(matchMakerButton);

        }
        if (isElementPresent(closeHElper)) {
            waitForElementToBeClickable(helperEle);
            helperEle.click();
        }
        if (isElementPresent(skipList)) {
            waitForElementToBeClickable(skipList);
            skipListEle.click();
        }
        waitForElementToBeClickable(sortAndFilter);
        hotelName.get(0).click();
    }
}