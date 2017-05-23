package pages.flight;

import exception.NoResultsFound;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class TravelerDetailsPage extends BasePage {

    @FindBy(id = "com.makemytrip:id/traveller_adult_count")
    private WebElement adultPassengers;

    @FindBy(id = "com.makemytrip:id/traveller_add_new_pax_text")
    private WebElement addNewAdult;

    @FindBy(id = "com.makemytrip:id/pax_first_name")
    private WebElement firstName;

    @FindBy(id = "com.makemytrip:id/pax_last_name")
    private WebElement lastName;

    @FindBy(id = "com.makemytrip:id/llGenderMale")
    private WebElement male;

    @FindBy(id = "com.makemytrip:id/llGenderFemale")
    private WebElement female;

    @FindBy(id = "com.makemytrip:id/pax_add_traveller_button")
    private WebElement addNextTraveler;

    @FindBy(id = "com.makemytrip:id/pax_email")
    private WebElement email;

    @FindBy(id = "com.makemytrip:id/pax_phone_number")
    private WebElement phoneNumber;

    @FindBy(id = "com.makemytrip:id/ivInsuranceCheckBoxOption")
    private WebElement insurance;

    @FindBy(id = "com.makemytrip:id/df_book_flight")
    private WebElement bookFlight;

    @FindBy(id = "com.makemytrip:id/tvInsuranceAgree")
    private WebElement termsAndConditions;

    @FindBy(id = "com.makemytrip:id/tvAddMealsHeader")
    private WebElement addMealsHeader;

    private By fareChangeBy = By.id("com.makemytrip:id/button_fare_change_continue");
    private By selectanotherFlight = By.id("com.makemytrip:id/dialog_re_select");

    @FindBy(id = "com.makemytrip:id/button_fare_change_continue")
    private WebElement fareChangeContinue;

    @FindBy(id = "com.makemytrip:id/dialog_re_select")
    private WebElement reSelectFlight;

    public TravelerDetailsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private int result;

    private int getAdultPassenger() {
        waitForElementToBeClickable(adultPassengers);
        String totalAdults = adultPassengers.getText();
        String splitAdults[] = totalAdults.split("/");
        result = Integer.parseInt(splitAdults[1]) - Integer.parseInt(splitAdults[0]);
        return result;
    }

    public void enterTravelerDetails(String fName, String lName, String gender) {
        waitForElementToBeClickable(adultPassengers);
        if (isElementPresent(By.id("com.makemytrip:id/traveller_add_new_pax_text"))) {
            waitForElementToBeClickable(addNewAdult);
            getAdultPassenger();
            addNewAdult.click();
            for (int i = 0; i < result; i++) {
                waitForElementToBeClickable(firstName);
                firstName.sendKeys(fName);
                lastName.sendKeys(lName);
                String g = gender.toLowerCase();
                switch (g) {
                    case "male":
                        waitForElementToBeClickable(male);
                        male.click();
                        break;
                    case "female":
                        waitForElementToBeClickable(female);
                        female.click();
                        break;
                }
                waitForElementToBeClickable(addNextTraveler);
                addNextTraveler.click();
            }
        }
    }

    private void selectAnotherFlight() {
        if (isElementPresent(selectanotherFlight)) {
            waitForElementToBeClickable(reSelectFlight);
            reSelectFlight.click();
        }
    }

    private void fareChangeContinue() {
        if (isElementPresent(fareChangeBy)) {
            waitForElementToBeClickable(fareChangeContinue);
            fareChangeContinue.click();
//            waitForElementToBeClickable(bookFlight);
//            bookFlight.click();

        }
    }

    public void enterContactInfo(String emailId, String number) {
        waitForElementToBeClickable(addNewAdult);
        scrollDownTo("91");
        waitForElementToBeClickable(email);
        email.click();
        email.sendKeys(emailId);
        navigateBack();
//        scrollDownTo("Phone Number");
        waitForElementToBeClickable(phoneNumber);
        phoneNumber.click();
        phoneNumber.sendKeys(number);
        navigateBack();
        scrollDownTo("I agree to the Terms & Conditions and Fare Rules");
    }

    public void bookAFlight() throws NoResultsFound {
        try {
            waitForElementToBeClickable(bookFlight);
            bookFlight.click();
            selectAnotherFlight();
            fareChangeContinue();
            if (isElementPresent(By.id("com.makemytrip:id/tvAddMealsHeader"))) {
                waitForElementToBeClickable(addMealsHeader);
                bookFlight.click();
            }
        } catch (Exception e) {
            throw new NoResultsFound("Unable to book the flight");
        }
    }
}