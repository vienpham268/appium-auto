package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final int TIME_OUT = 15;
    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    public WebElement waitForVisible(WebElement element) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(TIME_OUT)).until(
                ExpectedConditions.visibilityOf(element)
        );
    }
}
