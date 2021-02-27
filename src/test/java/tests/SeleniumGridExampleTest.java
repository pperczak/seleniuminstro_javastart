package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        //DesiredCapabilities usage. As it becomes depreciated - Mutable Capabilities are introduced.
        //That means - ChromeOptions etc, find them below
        /*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("internet explorer"); //chrome, firefox etc
        capabilities.setCapability("platform","WINDOWS"); //LINUX, OTHER etc
        driver = new RemoteWebDriver(new URL("http://192.168.0.20:4444/wd/hub"),capabilities);
        */

        //FirefoxOptions example
        /*
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("platform",Platform.WINDOWS);
        firefoxOptions.addPreference("browser.startup.page", 1);
        driver = new RemoteWebDriver(new URL("http://192.168.0.20:4444/wd/hub"),firefoxOptions);
        */

        //InternetExplorerOptions example
        /*
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.enablePersistentHovering();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.setCapability("platform",Platform.WINDOWS);
        internetExplorerOptions.setCapability("version","11"); //dla wersji IE8 - wstaw 8 ;)
        driver = new RemoteWebDriver(new URL("http://192.168.0.20:4444/wd/hub"), internetExplorerOptions);
        */

        //ChromeOptions example

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setCapability("platform",Platform.WIN10);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.20:4444/wd/hub"),chromeOptions);
        } catch (MalformedURLException murl) {
            throw new IllegalStateException("Cannot create URL "+murl);
        }

    }

    @Test
    public void searchQueryInGoogle() {
        driver.navigate().to("http://www.google.pl");

        driver.findElement(By.name("q")).sendKeys("JavaStart");
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
