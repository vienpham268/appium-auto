package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {
    private static final String CONFIG_PATH = "src/test/resources/";

    public static Properties loadConfig(String platform) {
        Properties props = new Properties();
        String fileName;

        switch (platform.toLowerCase()) {
            case "android":
                fileName = "android.properties";
                break;
            case "ios":
                fileName = "ios.properties";
                break;

            default:
                throw new RuntimeException("Platform not supported" + platform);
        }

        try {
            FileInputStream fis = new FileInputStream(CONFIG_PATH + fileName);
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config file" + fileName, e);
        }

        return props;
    }
}
