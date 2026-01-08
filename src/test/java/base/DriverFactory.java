package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal();

    public static void initDriver(Properties props) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", props.getProperty("platformName"));
        caps.setCapability("appium:deviceName", props.getProperty("deviceName"));
        caps.setCapability("appium:automationName", props.getProperty("automationName"));

        if (props.getProperty("platformName").equalsIgnoreCase("Android")) {
            caps.setCapability("appium:appPackage", props.getProperty("appPackage"));
            caps.setCapability("appium:appActivity", props.getProperty("appActivity"));
            caps.setCapability("appium:noReset", Boolean.parseBoolean(props.getProperty("noReset")));
            driver.set(new AndroidDriver(
                    new URL("http://127.0.0.1:4723"), caps));
        } else {
            caps.setCapability("appium:bundleId", props.getProperty("bundleId"));
            driver.set(new IOSDriver(
                    new URL("http://127.0.0.1:4723"), caps));
        }

    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
