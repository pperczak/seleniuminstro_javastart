package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.logging.Level;

import static org.testng.AssertJUnit.assertEquals;

public class BrowserLogs {

    private static WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.INFO);

        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        driver = new ChromeDriver(chromeOptions);

        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void browserLogExampleTest() {
        WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();

        WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signOnLink.click();

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("NotExistingLogin");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("NotProperPassword");

        WebElement signOnButton = driver.findElement(By.name("signon"));
        signOnButton.click();

        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));
        assertEquals("Invalid username or password. Signon failed.", messageLabel.getText());

        /*Logi przegladarki*/

        //getting browser logs
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);

        for(LogEntry log: browserLogs) {
            System.out.println(new Date(log.getTimestamp())+" "+log.getLevel()+" "+log.getMessage());
            //assertFalse(log.getLevel().equals(Level.SEVERE));
        }
    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }

}
