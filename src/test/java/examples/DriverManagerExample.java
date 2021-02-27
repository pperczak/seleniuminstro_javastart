package examples;

import org.openqa.selenium.WebDriver;

public class DriverManagerExample {

    private static final BrowserTypeExample browserTypeEx = BrowserTypeExample.CHROME;
    private static WebDriver driver;

    public DriverManagerExample() {
    }

    public static WebDriver getWebDriverExample() {
        if (driver == null) {
            driver = BrowserFactoryExample.getWebDriverExample(BrowserTypeExample.CHROME);
        }
        return driver;
    }

    public void disposeDriver() {
        driver.close();
        if (!browserTypeEx.equals(BrowserTypeExample.FF)) {
            driver.quit();
        }
        driver = null;
    }
}
