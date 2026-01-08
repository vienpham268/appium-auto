package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.RetryUtils;

public class CallTest extends BaseTest {

    @Test()
    public void dial() {
        MainPage mainPage = new MainPage();
        mainPage.dialAndCall();
        mainPage.verifyDialMessage();
    }
}
