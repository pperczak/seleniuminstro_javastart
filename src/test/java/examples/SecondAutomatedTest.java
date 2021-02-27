package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SecondAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");

        //using xpath
        //driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/input[1]")).sendKeys("Manx");
        //driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        //using cssselector
        WebElement w1 = driver.findElement(By.cssSelector("input[name=\"keyword\"]"));
        w1.sendKeys("Manx");
        WebElement w2 = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        w2.click();

        assertTrue(driver.getPageSource().contains("Great for reducing"));

    }

    @AfterMethod
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }
}
