package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(how = How.NAME, using="signon")
    WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//ul/li")
    WebElement warningMessage;

    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUsernameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Typed data into username field");
        return this;

    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed data into password field");
        return this;
    }

    @Step("Click on Login Button")
    public FooterPage clickLoginButton() {
        loginButton.click();
        logger.info("Login button clicked");
        return new FooterPage();
    }

    @Step("Getting warning message from Login Page")
    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(warningMessage);
        String warningText = warningMessage.getText();
        logger.info("Warning message was: "+warningText);
        return warningText;
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warnMess) {
        logger.info("Checking if warning message {} is displayed", warnMess);
        WaitForElement.waitUntilElementIsVisible(warningMessage);
        AssertWebElement.assertThat(warningMessage).isDisplayed().hasText(warnMess);
        return this;
    }
}
