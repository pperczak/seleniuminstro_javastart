package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class VanillaJSExampleHelper {

    public WebDriver driver;
    private String URL = "http://todomvc.com/examples/vanillajs/";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }

}
