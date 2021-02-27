package driver.manager;

import configuration.LocalWebDriverProperties;
import configuration.TestRunProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import driver.listeners.DriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static configuration.TestRunProperties.*;
import static driver.BrowserType.*;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if(driver == null) {
            driver = new BrowserFactory(getBrowserToRun(),getRunType()).getBrowser();
        }

        /*EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        DriverEventListener listener = new DriverEventListener();
        eventDriver.register(listener);
        */
        //System.out.println("Jestem w wykonaniu getWebDriver() w DriverManager()");
        return driver;
        //return eventDriver;
    }

    public static void disposeDriver() {
        driver.close();

        if(!getBrowserToRun().equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
