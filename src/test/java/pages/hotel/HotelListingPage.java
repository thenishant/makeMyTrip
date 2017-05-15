package pages.hotel;

import io.appium.java_client.AppiumDriver;
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

    @FindBy(id = "com.makemytrip:id/llHotelListItem")
    private List<WebElement> hotelList;

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

    private void chooseAHotelFormList() {
        waitForElementToBeClickable(hotelList);
        hotelList.stream().findFirst().get().click();
    }

    private void hotelDetails() {
        waitForElementToBeClickable(hotelImage);
        swipeRightToLeft();
        waitForElementToBeClickable(photoText);
        swipeRightToLeft();
        waitForElementToBeClickable(reviews);
        swipeRightToLeft();
        waitForElementToBeClickable(nearByPlaces);
    }

    private void selectRoom(){
        chooseAHotelFormList();
        hotelDetails();
    }
}
