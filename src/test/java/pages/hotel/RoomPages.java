package pages.hotel;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class RoomPages extends BasePage {
    public RoomPages(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "com.makemytrip:id/rb_select_tariff")
    private List<WebElement> selectTariff;

    @FindBy(id = "com.makemytrip:id/btnShowAllHotels")
    private WebElement continueButton;

    private void chooseTariff(){
        waitForElementToBeClickable(selectTariff);
        selectTariff.get(0).click();
    }

    private void continueBooking(){
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    public void selectRoom(){
        chooseTariff();
        continueBooking();
    }

}
