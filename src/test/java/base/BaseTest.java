package base;

import config.ConfigManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    @BeforeMethod
    @Parameters("platform")
    public void setUp(@Optional("android") String platform) throws Exception {
        Properties props = ConfigManager.loadConfig(platform);
        DriverFactory.initDriver(props);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
