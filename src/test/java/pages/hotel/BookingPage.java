package pages.hotel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class BookingPage extends BasePage {
    public BookingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "com.makemytrip:id/tv_offers_review_page")
    private WebElement offers;

    @FindBy(id = "com.makemytrip:id/etGuestInfoName")
    private WebElement firstName;

    @FindBy(id = "com.makemytrip:id/etGuestInfoNameLast")
    private WebElement lastName;

    @FindBy(id = "com.makemytrip:id/etGuestInfoEmail")
    private WebElement email;

    @FindBy(id = "com.makemytrip:id/etGuestInfoPhone")
    private WebElement phoneNumber;

    private void enterTravelerDetails(String fname,String lName, String emailId, String number){
        if(isElementPresent(By.id("com.makemytrip:id/tvReviewFlexibleFareDismiss"))){
//            waitForElementToBeClickable();
        }


        waitForElementToBeClickable(offers);
        scrollDownTo("Offers");
        waitForElementToBeClickable(firstName);
        firstName.click();
        firstName.sendKeys(fname);
        lastName.click();
        lastName.sendKeys(lName);
        navigateBack();
        email.click();
        email.sendKeys(emailId);
        navigateBack();
        phoneNumber.click();
        phoneNumber.sendKeys(number);
        scrollDownTo("I agree to the Terms & Conditions and Cancellation & Hotel Booking Policies");
    }
}
