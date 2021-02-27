package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }

    @Test
    public void actionsTest() {
        WebElement smile1 = driver.findElement(By.id("smiley"));
        WebElement smile2 = driver.findElement(By.id("smiley2"));

        Actions action = new Actions(driver);

        action.moveToElement(smile1).moveToElement(smile2).build().perform();
        sleep();

        action.dragAndDrop(smile1,smile2).build();
        sleep();
        action.perform();
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
}
