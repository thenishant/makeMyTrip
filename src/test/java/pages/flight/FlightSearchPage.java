package pages.flight;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchPage extends BasePage {

    @FindBy(id = "com.makemytrip:id/depCity")
    private WebElement depCity;

    @FindBy(id = "com.makemytrip:id/arrCity")
    private WebElement arrCity;

    @FindBy(id = "com.makemytrip:id/depDateLayout")
    private WebElement departureDate;

    @FindBy(id = "com.makemytrip:id/returnDateLayout")
    private WebElement returnDate;

    @FindBy(id = "com.makemytrip:id/travellerLayout")
    private WebElement passenger;

    @FindBy(id = "com.makemytrip:id/adultAddLayout")
    private WebElement adultPassenger;

    @FindBy(id = "com.makemytrip:id/adultAddLayout")
    private WebElement addAdultPassenger;

    @FindBy(id = "com.makemytrip:id/classLayout")
    private WebElement clazz;

    @FindBy(id = "com.makemytrip:id/city_edit_text")
    private WebElement cityText;

    @FindBy(id = "com.makemytrip:id/cityPickerRow")
    private List<WebElement> chooseCity;

    @FindBy(id = "com.makemytrip:id/calendar_day")
    private List<WebElement> selectDate;

    @FindBy(id = "com.makemytrip:id/calDepLayout")
    private WebElement currentDate;

    @FindBy(id = "com.makemytrip:id/calOK")
    private WebElement okDate;

    @FindBy(id = "com.makemytrip:id/okLayout")
    private WebElement okPassenger;

    @FindBy(id = "com.makemytrip:id/economyClass")
    private WebElement economyClass;

    @FindBy(id = "com.makemytrip:id/premiumEconomyClass")
    private WebElement premiumEconomyClass;

    @FindBy(id = "com.makemytrip:id/businessClass")
    private WebElement businessClass;

    @FindBy(id = "com.makemytrip:id/searchFlights")
    private WebElement searchFlight;

    @FindBy(id = "com.makemytrip:id/calendar_month")
    private List<WebElement> month;

    @FindBy(id = "com.makemytrip:id/calendar_day_row")
    private List<WebElement> dayRow;

    @FindBy(id = "com.makemytrip:id/calendar_month_name")
    private List<WebElement> monthName;

    @FindBy(id = "com.makemytrip:id/calendar_day")
    private By day;

    @FindBy(id = "com.makemytrip:id/cv_pager")
    private WebElement calender;

    private AppiumDriver driver;

    public FlightSearchPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFromCity(String city) {
        waitForElementToBeClickable(depCity);
        depCity.click();
        waitForElementToBeClickable(cityText);
        cityText.sendKeys(city);
        chooseCity.stream().findFirst().get().click();
    }

    public void SelectToCity(String city) {
        waitForElementToBeClickable(arrCity);
        arrCity.click();
        waitForElementToBeClickable(cityText);
        cityText.sendKeys(city);
        chooseCity.stream().findFirst().get().click();
    }

    private void getDepartureDate(String date) {
        waitForElementToBeClickable(month);
        getDate(date,month);
    }

    private void getReturnDate(String date) {
        waitForElementToBeClickable(month);
        getDate(date,month);
    }

    public void chooseDepartureDate(String date) {
        waitForElementToBeClickable(departureDate);
        departureDate.click();
        waitForElementToBeClickable(currentDate);
        getDepartureDate(date);
        waitForElementToBeClickable(okDate);
        okDate.click();
    }

    public void chooseReturnDate(String date) {
        waitForElementToBeClickable(returnDate);
        returnDate.click();
        waitForElementToBeClickable(currentDate);
        getReturnDate(date);
        waitForElementToBeClickable(okDate);
        okDate.click();
    }

    public void chooseNoOfPassengers(int noOfPassenger) {
        waitForElementToBeClickable(passenger);
        passenger.click();
        waitForElementToBeClickable(addAdultPassenger);
        for (int i = 1; i < noOfPassenger; i++) {
            addAdultPassenger.click();
        }
        waitForElementToBeClickable(okPassenger);
        okPassenger.click();
    }

    public void chooseClazz(String claz) {
        waitForElementToBeClickable(clazz);
        clazz.click();
        String travelClass = claz.toLowerCase();
        waitForElementToBeClickable(economyClass);
        switch (travelClass) {
            case "economy":
                economyClass.click();
                break;
            case "premium":
                premiumEconomyClass.click();
                break;
            case "business":
                businessClass.click();
                break;
        }
    }

    public void searchFilght() {
        waitForElementToBeClickable(searchFlight);
        searchFlight.click();
    }

    public void searchAFlight(String dCity, String aCity, String date, int passenger, String clazz) {
        selectFromCity(dCity);
        SelectToCity(aCity);
        chooseDepartureDate(date);
        chooseNoOfPassengers(passenger);
        chooseClazz(clazz);
        searchFilght();
    }

    public void searchAFlight(String dCity, String aCity, String departureDate, String returnDate, int passenger, String clazz) {
        selectFromCity(dCity);
        SelectToCity(aCity);
        chooseDepartureDate(departureDate);
        chooseReturnDate(returnDate);
        chooseNoOfPassengers(passenger);
        chooseClazz(clazz);
        searchFilght();
    }
}
