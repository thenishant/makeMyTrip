package steps;

import cucumber.api.java.en.And;
import exception.NoResultsFound;
import exception.NoPaymentModeFoundException;
import pages.*;
import pages.flight.FlightListingPage;
import pages.flight.FlightSearchPage;
import pages.flight.TravelerDetailsPage;
import pages.payment.MobikwikWallet;

public class FlightBookingSteps extends BaseSteps {

    private HomePage homePage = new HomePage(getDriverInstanceFor("optimus"));
    private FlightSearchPage flightSearchPage = new FlightSearchPage(getDriverInstanceFor("optimus"));
    private FlightListingPage flightListingPage = new FlightListingPage(getDriverInstanceFor("optimus"));
    private TravelerDetailsPage travelerDetailsPage = new TravelerDetailsPage(getDriverInstanceFor("optimus"));
    private PaymentPage paymentPage = new PaymentPage(getDriverInstanceFor("optimus"));

    @And("^I search flight from ([^\"]*) to ([^\"]*) departing on ([^\"]*) for ([^\"]*) on ([^\"]*)$")
    public void iSearchFlightFromSourceToDestinationDepartingOnDateForNoOfPassengerOnClass(String dCity, String aCity, String date, int passenger, String clazz) throws Throwable {
        flightSearchPage.selectFromCity(dCity);
        flightSearchPage.SelectToCity(aCity);
        flightSearchPage.chooseDepartureDate(date);
        flightSearchPage.chooseNoOfPassengers(passenger);
        flightSearchPage.chooseClazz(clazz);
        flightSearchPage.searchFilght();
    }

    @And("^I choose a flight based on price$")
    public void iChooseAFlightBasedOnPrice() throws NoResultsFound {
        flightListingPage.selectOneWayFlight();
    }

    @And("^I enter ([^\"]*), ([^\"]*),([^\"]*) as traveler details$")
    public void iEnterFirstNameLastNameGenderAsTravelerDetails(String fName, String lName, String gender) throws Throwable {
        travelerDetailsPage.enterTravelerDetails(fName, lName, gender);
    }

    @And("^I provide contact ([^\"]*), ([^\"]*) as contact details$")
    public void iProvideContactEmailPhoneNumberAsContactDetails(String email, String phoneNumber) throws Throwable {
        travelerDetailsPage.enterContactInfo(email, phoneNumber);
        travelerDetailsPage.bookAFlight();
    }

    @And("^I pay by using a payment mode$")
    public void iChooseToPayByMobileWallet() throws NoPaymentModeFoundException, NoResultsFound {
        paymentPage.selectPaymentMode();
        new MobikwikWallet(getDriverInstanceFor("optimus")).payByWallets();
//        paymentPage.paymentFailure();
    }

    @And("^I search flight from ([^\"]*) to ([^\"]*) departing ([^\"]*) returning ([^\"]*) for ([^\"]*) on ([^\"]*)$")
    public void iSearchFlightFromSourceToDestinationDepartingAndReturningOnDateForNoOfPassengerOnClass(String dCity, String aCity, String depaturedate, String returnDate, int passenger, String clazz) throws Throwable {
        flightSearchPage.selectFromCity(dCity);
        flightSearchPage.SelectToCity(aCity);
        flightSearchPage.chooseDepartureDate(depaturedate);
        flightSearchPage.chooseReturnDate(returnDate);
        flightSearchPage.chooseNoOfPassengers(passenger);
        flightSearchPage.chooseClazz(clazz);
        flightSearchPage.searchFilght();
    }

    @And("^I choose a two flight based on price$")
    public void iChooseATwoFlightBasedOnPrice() throws Throwable {
        flightListingPage.selectTwoWayFlight();
    }
}
