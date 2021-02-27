package excercises.chapter_11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class JavaScripAlertsTests {

    private WebDriver driver;
    private final String URL="http://przyklady.javastart.pl:8095/javascript_alerts";
    private final String URL_JSError = "http://przyklady.javastart.pl:8095/javascript_error";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    @Test
    public void javaScriptAlertTest() {

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();

        assertEquals(driver.findElement(By.id("result")).getText(),"You successfuly clicked an alert");
        System.out.println(driver.findElement(By.id("result")).getText());
    }

    @Test
    public void javaScriptAlertConfirmTest() {

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");

        jsConfirm.click();
        driver.switchTo().alert().dismiss();
        assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");

    }

    @Test
    public void javaScriptAlertPromptTest() {

        String textToEnter = "Selenium is cool";
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(textToEnter);
        alert.accept();

        assertEquals(driver.findElement(By.id("result")).getText(),"You entered: "+textToEnter);

    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }

}
