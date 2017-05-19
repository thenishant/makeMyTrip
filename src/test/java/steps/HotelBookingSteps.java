package steps;

import cucumber.api.java.en.And;
import pages.hotel.BookingPage;
import pages.hotel.HotelListingPage;
import pages.hotel.HotelSearchPage;
import pages.hotel.RoomPages;

public class HotelBookingSteps extends BaseSteps {

    private HotelSearchPage hotelSearchPage = new HotelSearchPage(getDriverInstanceFor("optimus"));
    private HotelListingPage hotelListingPage = new HotelListingPage(getDriverInstanceFor("optimus"));

    @And("^I search a hotel in ([^\"]*) from ([^\"]*) to ([^\"]*) taking ([^\"]*) for ([^\"]*)$")
    public void iSearchAHotelInCityFromFromDateToToDateTakingRoomForCustomers(String dest, String inDate, String outDate, int room, int customer) {
        hotelSearchPage.searchAHotel(dest, inDate, outDate, room, customer);
    }

    @And("^I choose a hotel from the list of hotels$")
    public void iChooseAHotelFromTheListOfHotels() throws Throwable {
        hotelListingPage.selectHotel();
    }

    @And("^I check the details of that hotel$")
    public void iCheckTheDetailsOfThatHotel() throws Throwable {
        hotelListingPage.hotelDetails();
    }

    @And("^I book a room that hotel$")
    public void iBookARoomThatHotel() throws Throwable {
        new RoomPages(getDriverInstanceFor("optimus")).selectRoom();
    }

    @And("^I review my booking by providing ([^\"]*),([^\"]*),([^\"]*) and ([^\"]*)$")
    public void iReviewMyBookingByProvidingFirstNameLastNameEmailAndPhoneNumber(String fName, String lName, String email, String phoneNumber) throws Throwable {
        new BookingPage(getDriverInstanceFor("optimus")).reviewBooking(fName, lName, email, phoneNumber);
    }
}
