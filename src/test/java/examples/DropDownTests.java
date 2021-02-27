package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DropDownTests {

    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dropdown");
    }

    @Test
    public void checkboxesTest() {
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        Select dropDownSelect = new Select(dropDown);
        WebElement onStartSelected = dropDownSelect.getFirstSelectedOption();

        assertEquals(onStartSelected.getText(),"Please select an option");

        dropDownSelect.selectByVisibleText("Option 1");
        sleep();
        assertEquals(dropDownSelect.getFirstSelectedOption().getText(),"Option 1");

        dropDownSelect.selectByVisibleText("Option 2");
        sleep();
        assertEquals(dropDownSelect.getFirstSelectedOption().getText(),"Option 2");

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
