package pages;

import base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "com.google.android.dialer:id/dialpad_fab")
    private WebElement btnDialPad;

    @AndroidFindBy(id = "com.google.android.dialer:id/one")
    private WebElement btnOne;

    @AndroidFindBy(id = "com.google.android.dialer:id/dialpad_voice_call_button")
    private WebElement btnCall;

    @AndroidFindBy(id = "android:id/message")
    private WebElement txtMessage;

    public void dialAndCall() {
        btnDialPad.click();
        btnOne.click();
        btnCall.click();
    }

    public void verifyDialMessage() {
        this.waitForVisible(txtMessage);
        Assert.assertEquals(txtMessage.getText(), "USSD code running…");
    }


}
