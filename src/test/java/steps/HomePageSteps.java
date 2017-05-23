package steps;

import cucumber.api.java.en.And;
import pages.HomePage;

public class HomePageSteps extends BaseSteps {

    private HomePage homePage = new HomePage(getDriverInstanceFor("optimus"));



    @And("^I choose to search a hotel$")
    public void iChooseToSearchAHotel() {
        homePage.clickHotels();
    }

    @And("^I choose to search a flight$")
    public void iChooseToSearchAFlight() {
        homePage.clickFlights();
    }
}
