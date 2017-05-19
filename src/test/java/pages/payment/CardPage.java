package pages.payment;

import gherkin.lexer.Pa;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ScrollsTo;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class CardPage extends BasePage {

    AppiumDriver driver;

    public CardPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "com.makemytrip:id/card_number_editText")
    private WebElement cardNmber;

    @FindBy(id = "com.makemytrip:id/card_name_editText")
    private WebElement name;

    @FindBy(id = "com.makemytrip:id/custom_spinner_expiry_month")
    private WebElement expMonth;

    @FindBy(id = "com.makemytrip:id/custom_spinner_expiry_year")
    private WebElement expYear;

    @FindBy(id = "com.makemytrip:id/cvv_editText")
    private WebElement cvv;

    @FindBy(id = "com.makemytrip:id/pay_at_hotel_card_terms_checkBox")
    private WebElement termsAndConditions;

    @FindBy(id = "com.makemytrip:id/tvCardDate")
    private List<WebElement> monthAndYear;

    @FindBy(id = "com.makemytrip:id/continue_layout")
    private WebElement continueButton;

    private void selectMonth(String month){
        waitForElementToBeClickable(expMonth);
        expMonth.click();
        String m = month +" [(\\d)]+";
        scrollDownTo(m);
        monthAndYear.get(6).click();
    }

    private void selectYear(String year){
        waitForElementToBeClickable(expYear);
        expYear.click();
        scrollDownTo(year);
        monthAndYear.get(2).click();
    }

    private void cardDetails(String cNumber, String cName, String month, String year, String cvv){
        waitForElementToBeClickable(cardNmber);
        cardNmber.sendKeys(cNumber);
        waitForElementToBeClickable(name);
        name.sendKeys(cName);
        selectMonth(month);
        selectYear(year);
        waitForElementToBeClickable(this.cvv);
        this.cvv.sendKeys(cvv);
        hideKeyboard();
    }

    private void pay(){
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    private void acceptTerms(){
        scrollDownTo("I agree with card charge terms of MakeMyTrip");
        waitForElementToBeClickable(termsAndConditions);
        termsAndConditions.click();
    }

    public void enterCardDetailsAndPay(String cNumber, String cName, String month, String year, String cvv){
        cardDetails(cNumber, cName,  month, year,cvv);
        acceptTerms();
        pay();
    }
}
