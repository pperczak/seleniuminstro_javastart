package configuration;

import driver.BrowserType;

public class TestRunProperties {

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }
    public static boolean getRunType() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }
    public static String getGridUrl() {
        return String.valueOf(ConfigurationProperties.getProperties().getProperty("grid.url"));
    }

}
