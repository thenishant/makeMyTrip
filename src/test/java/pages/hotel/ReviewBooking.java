package pages.hotel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ReviewBooking extends BasePage{

    public ReviewBooking(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "com.makemytrip:id/etGuestInfoName")
    private WebElement fName;

    @FindBy(id = "com.makemytrip:id/etGuestInfoNameLast")
    private WebElement lName;

    @FindBy(id = "com.makemytrip:id/etGuestInfoEmail")
    private WebElement email;

    @FindBy(id = "com.makemytrip:id/etGuestInfoPhone")
    private WebElement phone;

    @FindBy(id = "com.makemytrip:id/btnShowAllHotels")
    private WebElement continueButton;

    private void enterGuestDetails(String firstName, String lastName, String emailId, int number){
        waitForElementToBeClickable(fName);
        scrollDownTo("My Rewards");
        fName.click();
        fName.sendKeys(firstName);
        waitForElementToBeClickable(lName);
        lName.click();
        lName.sendKeys(lastName);
        navigateBack();
        waitForElementToBeClickable(email);
        email.click();
        email.sendKeys(emailId);
        waitForElementToBeClickable(phone);
        phone.sendKeys(String.valueOf(number));
        navigateBack();
        scrollDownTo("I agree to the Terms & Conditions and Cancellation & Hotel Booking Policies");
    }

    private void continueBooking(){
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    public void reviewBooikngAndProceed(String firstName, String lastName, String emailId, int phoneNumber){
        enterGuestDetails(firstName,lastName,emailId,phoneNumber);
        continueBooking();
    }

}

