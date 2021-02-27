package examples;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactoryExample {

    public static WebDriver getWebDriverExample(BrowserTypeExample browserTypeExample) {
        switch (browserTypeExample) {
            case FF:
                System.setProperty("webdriver.gecko.driver","D:/IdeaProjects/geckodriver.exe");
                return new FirefoxDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
                return new ChromeDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "D:/IdeaProjects/IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                System.out.println("No browser selected");
                throw new IllegalStateException("Unknown browser");
        }
    }
}
