package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Calender;

import java.util.List;

public class FlightSearchPage extends BasePage {

    @FindBy(id = "com.makemytrip:id/depCity")
    private WebElement depCity;

    @FindBy(id = "com.makemytrip:id/arrCity")
    private WebElement arrCity;

    @FindBy(id = "com.makemytrip:id/depDateLayout")
    private WebElement depDate;

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

    @FindBy(id = "com.makemytrip:id/calendar_day")
    private By day;

    private AppiumDriver driver;

    public FlightSearchPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void selectFromCity(String city) {
        waitForElementToBeClickable(depCity);
        depCity.click();
        waitForElementToBeClickable(cityText);
        cityText.sendKeys(city);
        chooseCity.stream().findFirst().get().click();
    }

    private void SelectToCity(String city) {
        waitForElementToBeClickable(arrCity);
        arrCity.click();
        waitForElementToBeClickable(cityText);
        cityText.sendKeys(city);
        chooseCity.stream().findFirst().get().click();
    }

    private void getDepDate(String date) {
        waitForElementToBeClickable(month);
        new Calender().getDate(date,month);
    }

    private void getDepDate1(String date) {
        waitForElementToBeClickable(month);

    }

    private void chooseDate(String date) {
        waitForElementToBeClickable(depDate);
        depDate.click();
        waitForElementToBeClickable(currentDate);
        getDepDate(date);
        waitForElementToBeClickable(okDate);
        okDate.click();
    }

    private void chooseNoOfPassengers(int noOfPassenger) {
        waitForElementToBeClickable(passenger);
        passenger.click();
        waitForElementToBeClickable(addAdultPassenger);
        for (int i = 1; i < noOfPassenger; i++) {
            addAdultPassenger.click();
        }
        waitForElementToBeClickable(okPassenger);
        okPassenger.click();
    }

    private void chooseClazz(String claz) {
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

    private void searchFilght() {
        waitForElementToBeClickable(searchFlight);
        searchFlight.click();
    }

    public void searchAFlight(String dCity, String aCity, String date, int passenger, String clazz) {
        selectFromCity(dCity);
        SelectToCity(aCity);
        chooseDate(date);
        chooseNoOfPassengers(passenger);
        chooseClazz(clazz);
        searchFilght();
    }

    private void chooseDate1(String date) {
        String newDate[] = date.split(" ");
        String month = newDate[1]+" "+newDate[2];
        scrollUpTo(month);
    }
}
