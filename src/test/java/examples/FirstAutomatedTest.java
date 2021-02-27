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

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FirstAutomatedTest {

    private WebDriver driver;

    @DataProvider(name = "Queries")
    public static Object[][] phrases() {
        return new Object[][] {{"java1","java2"}, {"java3", "java4"}};
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    @Test(dataProvider = "Queries", dependsOnMethods = "myFirstTest")
    public void queryGoogleWithDataProvider(String in1, String in2) {
        driver.navigate().to("http://google.pl");

        WebElement queryField = driver.findElement(By.name("q"));
        queryField.sendKeys(in1);
        queryField.submit();
        sleep();

        JavascriptExecutor js;
        js = (JavascriptExecutor)driver;
        js.executeScript("window.history.go(-1)");
        sleep();

        WebElement queryField2 = driver.findElement(By.name("q"));
        queryField2.sendKeys(in2);
        queryField2.submit();
        sleep();

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
