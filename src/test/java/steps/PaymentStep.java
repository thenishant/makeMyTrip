package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import pages.PaymentPage;

public class PaymentStep extends BaseSteps {
    @Then("^I should see a payment success method$")
    public void iShouldSeeAPaymentSuccessMethod() throws Throwable {
        new PaymentPage(getDriverInstanceFor("optimus")).paymentFailure();
        throw new PendingException();
    }
}
