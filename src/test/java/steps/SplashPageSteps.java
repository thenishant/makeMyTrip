package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.SplashPage;

public class SplashPageSteps extends BaseSteps{

    SplashPage splashPage = new SplashPage(getDriverInstanceFor("optimus"));
    @Given("^I have MakeMyTrip application$")
    public void iHaveMakeMyTripApplication() {
        splashPage.moveToNextScreen();
    }

    @When("^I continue without login into the app$")
    public void iContinueWithoutLoginIntoTheApp() throws Throwable {
        splashPage.skipLoginAndContinue();
    }
}
