package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {

    @FindBy(how= How.XPATH,using = "//a[@href='actions/Catalog.action']")
    //@FindBy(css = "#Content a")
    WebElement enterStore;

    private Logger logger = LogManager.getLogger(LandingPage.class);

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public TopMenuPage enterTheStoreLink() {
        WaitForElement.waitUntilElementIsClickable(enterStore);
        enterStore.click();
        logger.info("Enter store link clicked successfully");
        return new TopMenuPage();
    }
}
