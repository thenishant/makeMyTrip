package steps;

import cucumber.api.java.en.And;
import pages.hotel.HotelSearchPage;

public class HotelBookingSteps extends BaseSteps {

    private HotelSearchPage hotelSearchPage = new HotelSearchPage(getDriverInstanceFor("optimus"));

    @And("^I search a Hotel in ([^\"]*) from ([^\"]*) to ([^\"]*) taking ([^\"]*) for ([^\"]*)$")
    public void iSearchAHotelInCityFromFromDateToToDateTakingRoomForCustomers(String dest, String inDate, String outDate, int room, int customer) {
        hotelSearchPage.searchAHotel(dest, inDate, outDate,room,customer);
    }
}
