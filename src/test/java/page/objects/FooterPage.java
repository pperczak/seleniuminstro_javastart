package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class FooterPage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement dogBanner;

    Logger logger = LogManager.getLogger(FooterPage.class);

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Getting is dog banner is displayed")
    public boolean isDogBannerDisplayedAfterLogin() {
        WaitForElement.waitUntilElementIsVisible(dogBanner);
        boolean isDogBannerDisplayed = dogBanner.isDisplayed();
        logger.info("Is dogBanner displayed?: "+isDogBannerDisplayed);
        return isDogBannerDisplayed;
    }

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed(){
        logger.info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(dogBanner);
        assertThat(dogBanner).isDisplayed();
        return this;
    }
}
