package steps;

import cucumber.api.java.en.And;
import pages.*;
import pages.mobileWallets.MobikwikWallet;

public class FlightBookingSteps extends BaseSteps {

    private HomePage homePage = new HomePage(getDriverInstanceFor("optimus"));
    private FlightSearchPage flightSearchPage= new FlightSearchPage(getDriverInstanceFor("optimus"));
    private FlightListingPage flightListingPage = new FlightListingPage(getDriverInstanceFor("optimus"));
    private TravelerDetailsPage travelerDetailsPage = new TravelerDetailsPage(getDriverInstanceFor("optimus"));
    private PaymentPage paymentPage = new PaymentPage(getDriverInstanceFor("optimus"));

    @And("^I search flight from ([^\"]*) to ([^\"]*) departing on ([^\"]*) for ([^\"]*) on ([^\"]*)$")
    public void iSearchFlightFromSourceToDestinationDepartingOnDateForNoOfPassengerOnClass(String dCity, String aCity, String date, int passenger, String clazz) throws Throwable {
        flightSearchPage.searchAFlight(dCity, aCity, date, passenger, clazz);
    }

    @And("^I choose a flight based on price$")
    public void iChooseAFlightBasedOnPrice() {
        flightListingPage.chooseAFlightFormList();
        flightListingPage.chooseToCancelTicket(true);
        flightListingPage.insurance(true);
        flightListingPage.continueToBookFlight();
    }

    @And("^I enter ([^\"]*), ([^\"]*),([^\"]*) as traveler details$")
    public void iEnterFirstNameLastNameGenderAsTravelerDetails(String fName,String lName,String gender) throws Throwable {
        travelerDetailsPage.enterTravelerDetails(fName, lName, gender);
    }

    @And("^I provide contact ([^\"]*), ([^\"]*) as contact details$")
    public void iProvideContactEmailPhoneNumberAsContactDetails(String email, String phoneNumber) throws Throwable {
        travelerDetailsPage.enterContactInfo(email, phoneNumber);
        travelerDetailsPage.bookAFlight();
    }

    @And("^I choose to pay by Mobile Wallet$")
    public void iChooseToPayByMobileWallet() throws Throwable {
        paymentPage.selectPaymentMode();
        new MobikwikWallet(getDriverInstanceFor("optimus")).payByWallets();
        paymentPage.paymentFailure();
    }
}