package excercises.chapter_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptErrorTests {

    private final String URL_JSError = "http://przyklady.javastart.pl:8095/javascript_error";
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL_JSError);
    }

    @Test


    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }
}
