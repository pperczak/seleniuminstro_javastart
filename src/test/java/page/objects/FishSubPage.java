package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishSubPage {

    @FindBy(xpath = "//a[contains(text(),'FI-SW-01')]")
    WebElement angelFishLink;

    Logger logger = LogManager.getLogger(FishSubPage.class);

    public FishSubPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public AngelFishSubPage clickAngelFishLink() {
        WaitForElement.waitUntilElementIsClickable(angelFishLink);
        angelFishLink.click();
        logger.info("Clicking angel fish link");
        return new AngelFishSubPage();
    }
}
