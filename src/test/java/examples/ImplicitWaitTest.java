package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ImplicitWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://google.pl");

        WebElement queryField = driver.findElement(By.name("q"));
        queryField.sendKeys("JavaStart");
        queryField.submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }


    @Test
    public void mySecondTest() {

        driver.navigate().to("http://www.seleniumhq.org/");
        assertEquals(driver.getTitle(),"Selenium - Web Browser Automation");
        //assertTrue(driver.getTitle().contains("Selenium - Web Browser Automation"));
    }

    @AfterMethod
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
