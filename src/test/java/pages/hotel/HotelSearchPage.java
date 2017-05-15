package pages.hotel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.Calender;

import java.util.List;

public class HotelSearchPage extends BasePage {
    public HotelSearchPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.makemytrip:id/rlDestinationBlock")
    private WebElement place;

    @FindBy(id = "com.makemytrip:id/tvAutoCompleteSearch")
    private WebElement placeText;

    @FindBy(id = "com.makemytrip:id/rlAutocompleteListItem")
    private List<WebElement> placeList;

    @FindBy(id = "com.makemytrip:id/rlCheckInDate")
    private WebElement checkInDate;

    @FindBy(id = "com.makemytrip:id/calendar_month")
    private List<WebElement> month;

    @FindBy(id = "com.makemytrip:id/calOK")
    private WebElement oK;

    @FindBy(id = "com.makemytrip:id/rlCheckoutBlock")
    private WebElement checkOutDate;

    @FindBy(id = "com.makemytrip:id/calRetLayout")
    private WebElement checkOutDateFromCal;

    @FindBy(id = "com.makemytrip:id/rlNoOfRooms")
    private WebElement rooms;

    @FindBy(id = "com.makemytrip:id/ivadultadd")
    private WebElement addAdultGuests;

    @FindBy(id = "com.makemytrip:id/ivadultsubtract")
    private WebElement removeAdultGuests;

    @FindBy(id = "com.makemytrip:id/btn_add_room")
    private WebElement addRooms;

    @FindBy(id = "com.makemytrip:id/btn_done")
    private WebElement done;

    @FindBy(id = "com.makemytrip:id/BtnSearch")
    private WebElement search;

    private void selectPlace(String dest) {
        waitForElementToBeClickable(place);
        place.click();
        waitForElementToBeClickable(placeText);
        placeText.sendKeys(dest);
        waitForElementToBeClickable(placeList);
        placeList.stream().findFirst().get().click();
    }

    private void selectCheckInCheckOutDate(String InDate, String outDate) {
        waitForElementToBeClickable(this.checkInDate);
        this.checkInDate.click();
        getCheckInDate(InDate, month);
        waitForElementToBeClickable(checkOutDateFromCal);
        checkOutDateFromCal.click();
        getCheckOutDate(outDate, month);
        waitForElementToBeClickable(oK);
        oK.click();
    }

    private void checkOutDate(String outDate) {
        waitForElementToBeClickable(checkOutDate);
        checkOutDate.click();
        getCheckOutDate(outDate, month);
        waitForElementToBeClickable(oK);
        oK.click();
    }

    private void getCheckOutDate(String checkOutDate, List<WebElement> list) {
        waitForElementToBeClickable(month);
        new Calender().getDate(checkOutDate, month);
    }

    private void getCheckInDate(String date, List<WebElement> list) {
        waitForElementToBeClickable(month);
        new Calender().getDate(date, month);
    }

    private void bookRoom(int noOfRooms, int adult) {
        waitForElementToBeClickable(rooms);
        rooms.click();
        waitForElementToBeClickable(addAdultGuests);
        removeAdultGuests.click();
        for (int i = 1; i < noOfRooms; i++) {
            waitForElementToBeClickable(addAdultGuests);
            for (int j = 1; j < noOfRooms; j++) {
                addAdultGuests.click();
            }
            waitForElementToBeClickable(addRooms);
            addRooms.click();
        }
        waitForElementToBeClickable(done);
        done.click();
    }

    private void clickSearchButton(){
        waitForElementToBeClickable(search);
        search.click();
    }


    public void searchAHotel(String destination, String inDate, String outDate, int rooms, int adults) {
//        selectPlace(destination);
//        selectCheckInCheckOutDate(inDate, outDate);
        bookRoom(rooms, adults);
        clickSearchButton();
    }


}

