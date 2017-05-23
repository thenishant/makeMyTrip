package pages;

import io.appium.java_client.AppiumDriver;

public class ExamplePage extends BasePage {
    private AppiumDriver driver;

    public ExamplePage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ExamplePage doSomething() {
        return this;
    }

}
