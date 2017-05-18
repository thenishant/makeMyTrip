import gherkin.lexer.Pa;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ScrollsTo;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class CreditCard extends BasePage {

    AppiumDriver driver;

    public CreditCard(AppiumDriver driver) {
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

    private void cardDetails(String cNumber, String cName, String month, String year, String cvv){
        waitForElementToBeClickable(cardNmber);
        cardNmber.sendKeys(cNumber);
        waitForElementToBeClickable(name);
        name.sendKeys(cName);
        waitForElementToBeClickable(expMonth);
        expMonth.click();
        driver.scrollTo(month);
        waitForElementToBeClickable(expYear);
        expYear.click();
        driver.scrollToExact(year);
        waitForElementToBeClickable(this.cvv);
        this.cvv.sendKeys(cvv);
        navigateBack();
    }

    private void acceptTerms(){
        scrollDownTo("I agree with card charge terms of MakeMyTrip");
        waitForElementToBeClickable(termsAndConditions);
        termsAndConditions.click();
    }

    public void enterCardDetailsAndPay(String cNumber, String cName, String month, String year, String cvv){
        cardDetails(cNumber, cName,  month, year,cvv);
        acceptTerms();
    }
}
