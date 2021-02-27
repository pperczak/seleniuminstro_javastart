package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/hovers");
    }

    @Test
    public void hoverTests() {
        WebElement firstAvatar = driver.findElement(By.xpath("//div[@class='example']//div[1]/img[1]"));
        WebElement secondAvatar = driver.findElement(By.xpath("//div[@class='example']//div[2]/img[1]"));
        WebElement thirdAvatar = driver.findElement(By.xpath("//div[@class='example']//div[3]/img[1]"));

        WebElement firstAvatarName = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        WebElement secondAvatarName = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
        WebElement thirdAvatarName = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));

        Actions action = new Actions(driver);
        action.moveToElement(firstAvatar).build().perform();
        sleep();
        assertTrue(firstAvatarName.isDisplayed());
        assertEquals(firstAvatarName.getText(),"name: user1");
        assertFalse(secondAvatarName.isDisplayed());
        assertEquals(secondAvatarName.getText(),"");
        assertFalse(thirdAvatarName.isDisplayed());
        assertEquals(thirdAvatarName.getText(),"");

        action.moveToElement(secondAvatar).build().perform();
        assertEquals(firstAvatarName.getText(),"");
        assertEquals(secondAvatarName.getText(),"name: user2");
        assertEquals(thirdAvatarName.getText(),"");

        action.moveToElement(thirdAvatar).build().perform();
        assertEquals(firstAvatarName.getText(),"");
        assertEquals(secondAvatarName.getText(),"");
        assertEquals(thirdAvatarName.getText(),"name: user3");

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
