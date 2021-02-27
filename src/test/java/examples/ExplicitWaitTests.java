package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ExplicitWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement() {
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        sleep();
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        driver.findElement(By.id("btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"It's gone!"));
    }

    @Test
    public void waitForPresenceOfTheElement() {
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        sleep();
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement btn = driver.findElement(By.id("btn"));
        btn.click();
        sleep();
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"It's gone!"));
        sleep();
        btn = driver.findElement(By.id("btn"));
        btn.click();
        sleep();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("checkbox")));
        sleep();

    }

    @Test
    public void waitForPresenceOfTheElementRewritten() {
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WaitUntil waitUntil = new WaitUntil(driver);

        WebElement btn = driver.findElement(By.id("btn"));
        btn.click();

        waitUntil.textToBePresentInElementLocated("message");
        //sleep();
        btn = driver.findElement(By.id("btn"));
        btn.click();

        waitUntil.visibilityOfElementLocated("checkbox");
        checkbox = driver.findElement(By.id("checkbox"));
        /*
        checkbox = waitUntil.waitUntilpresenceOfElementLocated(By.id("checkbox"));
        */
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
        sleep();


    }

    @AfterMethod
    public void after() {
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

    public class WaitUntil {

        private WebDriverWait webDriverWait;

        public WaitUntil(WebDriver driver) {
            webDriverWait = new WebDriverWait(driver,10);
        }

        public void visibilityOfElementLocated(String whatToWaitFor) {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(whatToWaitFor)));
        }
        public void textToBePresentInElementLocated(String whatToWaitFor) {
            webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(whatToWaitFor),"It's gone!"));

        }
        public WebElement waitUntilpresenceOfElementLocated(By by) {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }

    }
}
