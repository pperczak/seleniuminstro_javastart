package examples;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameExample {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        //System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        //driver = new ChromeDriver();
        driver = DriverManagerExample.getWebDriverExample();
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl:8095/iframe");
    }

    @Test
    public void iFrameTest() throws InterruptedException {
        driver.switchTo().frame("mce_0_ifr");
        WebElement editable = driver.findElement(By.id("tinymce"));
        editable.clear();
        editable.sendKeys("abrakadavra");
        Thread.sleep(4000);

        driver.switchTo().parentFrame();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }
}
