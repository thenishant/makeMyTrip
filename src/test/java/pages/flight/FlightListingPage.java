package pages.flight;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class FlightListingPage extends BasePage {

    @FindBy(id = "com.makemytrip:id/list_item_parent_layout")
    private List<WebElement> flightListing;

    @FindBy(id = "com.makemytrip:id/flt_iv_zc_review")
    private WebElement ticketCancel;

    @FindBy(id = "com.makemytrip:id/ivInsuranceSelectOption")
    private WebElement secureMyTrip;

    @FindBy(id = "com.makemytrip:id/ivInsuranceSelectRiskOption")
    private WebElement doNotSecureMyTrip;

    @FindBy(id = "com.makemytrip:id/continue_text")
    private WebElement continueButton;

    @FindBy(id = "com.makemytrip:id/current_date_footer_line_view")
    private WebElement currentDateFooter;

    public FlightListingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void chooseAFlightFormList() {
        waitForElementToBeClickable(currentDateFooter);
        flightListing.size();
        flightListing.stream().findFirst().get().click();
    }

    public void chooseToCancelTicket(boolean isChecked) {
        if (isElementPresent(By.id("com.makemytrip:id/flt_iv_zc_review"))) {
            waitForElementToBeClickable(ticketCancel);
            if (isChecked)
                ticketCancel.click();
        }
    }

    public void insurance(boolean isSecure) {
        scrollDownTo("My Trip Rewards");
        waitForElementToBeClickable(secureMyTrip);
        if (isSecure)
            secureMyTrip.click();
        else
            doNotSecureMyTrip.click();
    }

    public void continueToBookFlight(){
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }
}
