package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

import java.time.Duration;

public class FluentWaitTests2 {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_loading/2");
    }

    @Test
    public void fluentWaitWithExceptionTest() {
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        WebElement helloWorldMessage = fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));

        assertTrue(helloWorldMessage.isDisplayed());
    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }
}
