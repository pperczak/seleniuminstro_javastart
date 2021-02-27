package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

import java.time.Duration;

public class FluentWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_loading/1");

    }

    @Test
    public void fluentWaitTest_OneApproach() {

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(5));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
    }

    @Test
    public void fluentWaitTest_SecondApproach() {

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        WebElement helloWorldMessage = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));

        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        WebElement helloworld =  fluentWait
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(helloWorldMessage));

        assertTrue(helloworld.isDisplayed());

    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }
}
