package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WebElementsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","D:/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ericl@o2.pl");

        String inputmade = username.getAttribute("value");

        assertEquals(inputmade,"ericl@o2.pl");

    }

    @Test
    public void filePickingTest() {
        WebElement chooseFile = driver.findElement(By.name("upload_file"));
        chooseFile.sendKeys("D:/_cisza_nocna.txt");

        sleep();
    }

    @Test
    public void typingAndClearingValueInsideWebElement() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Jomaha Jomaso");
        sleep();
        assertEquals(username.getAttribute("value"), "Jomaha Jomaso");

        username.clear();
        sleep();
        assertEquals(username.getAttribute("value"),"");
    }

    @Test
    public void checkRadioButtonTest() {
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='male']"));
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());

        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='female']"));
        femaleRadioButton.click();
        sleep();
        assertTrue(femaleRadioButton.isSelected());

    }

    @Test
    public void checkBoxButtonTest() {
        WebElement pizza = driver.findElement(By.xpath("//input[@value='pizza']"));
        WebElement spaghetti = driver.findElement(By.xpath("//input[@value='spaghetti']"));
        WebElement hamburger = driver.findElement(By.xpath("//input[@value='hamburger']"));

        pizza.click();
        sleep();
        assertTrue(pizza.isSelected());
        assertFalse(hamburger.isSelected());

        spaghetti.click();
        sleep();
        assertTrue(spaghetti.isSelected());

        hamburger.click();
        sleep();
        assertTrue(hamburger.isSelected());
        hamburger.click();
        sleep();
        assertFalse(hamburger.isSelected());
    }

    @Test
    public void dropDownListTest() {
        WebElement country = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(country);

        List<WebElement> countryList = countryDropDown.getOptions();
        List<String> countriesFoundInCountryList = new ArrayList<String>();

        for (WebElement countryChosen: countryList) {
            countriesFoundInCountryList.add(countryChosen.getText());
        }
        List<String> expectedCountriesFoundInCountryList = Arrays.asList("Germany","Poland", "UK");
        //porównywanie list Stringów
        assertEquals(countriesFoundInCountryList, expectedCountriesFoundInCountryList);
    }

    @Test
    public void selectingOptionsFromDropDownTest() {
        WebElement country = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(country);

        countryDropDown.selectByValue("de_DE");
        sleep();
        countryDropDown.selectByValue("pl_PL");
        sleep();
        countryDropDown.selectByValue("en_GB");
        sleep();

        assertEquals(country.getAttribute("value"),"en_GB");

        countryDropDown.selectByVisibleText("Poland");
        sleep();
        assertEquals(country.getAttribute("value"),"pl_PL");
    }

    @Test
    public void checkIfElementsOnPageTest() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailCheck = driver.findElement(By.xpath("//span[@class='help-block']"));

        System.out.println("usernameField displayed "+usernameField.isDisplayed());
        System.out.println("usernameField enabled "+usernameField.isEnabled());

        System.out.println("passwordField displayed "+passwordField.isDisplayed());
        System.out.println("passwordField enabled "+passwordField.isEnabled());

        System.out.println("emailCheck displayed "+emailCheck.isDisplayed());
        System.out.println("emailCheck enabled "+emailCheck.isEnabled());

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    //tylko do celow edukacyjnych zeby zobaczyc co sie dzieje jak selenium cos robi
    //nie stosowac Thread.sleep przy pisaniu testow!!!
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
