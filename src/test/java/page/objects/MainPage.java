package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    WebElement fishMainMenuIcon;

    @FindBy(xpath = "//img[@src='../images/dogs_icon.gif']")
    WebElement dogsMainMenuIcon;

    @FindBy(xpath = "//img[@src='../images/cats_icon.gif']")
    WebElement catsMainMenuIcon;

    @FindBy(xpath = "//img[@src='../images/reptiles_icon.gif']")
    WebElement reptilesMainMenuIcon;

    @FindBy(xpath = "//img[@src='../images/birds_icon.gif']")
    WebElement birdsMainMenuIcon;

    Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public FishSubPage clickFishMainMenuIcon() {
        WaitForElement.waitUntilElementIsClickable(fishMainMenuIcon);
        fishMainMenuIcon.click();
        logger.info("Fish icon in menu was clicked");
        return new FishSubPage();
    }
}
