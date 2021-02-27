package excercises.chapter_11;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class ScreenShotMakerTests {

    private WebDriver driver;
    private final String URL = "http://google.pl";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    @Test
    public void screenshotMakerTest() {

        ScreenShotMaker("GoogleBeforeTypingQueryPage.png");
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Kurs Selenium");
        ScreenShotMaker("GoogleAfterTypingQueryPage.png");
        query.submit();
        ScreenShotMaker("GoogleSearchResultsPage.png");

        Assert.assertTrue(driver.getTitle().contains("Kurs Selenium"));



    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();

    }

    private void ScreenShotMaker(String fileName) {
        File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempFile,new File("screenshots/"+fileName));
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save file "+fileName);
        }
    }
}
