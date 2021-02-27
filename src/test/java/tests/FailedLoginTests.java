package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.*;
import utils.testng.listeners.RetryAnalyzer;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestHelper {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    //@Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The purpose of this test is to perform a login with invalid data and" +
            "check that it results in not being logged in and diplaying a message" +
            "Invalid username or password")
    public void asUserTryToLogInWithIncorrectLoginAndPasswordStartFromLandingPage() {

        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStoreLink()
                    .clickOnSignInLink()
                    .typeIntoUsernameField("dupa")
                    .typeIntoPasswordField("zbitaaa")
                    .clickLoginButton();
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.getWarningMessage(),"Invalid username or password. Signon failed.");
    }

    @TmsLink("ID-2")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The purpose of this test is to start from landing page, then go to login page and" +
            "perform a login with invalid data and" +
            "check that it results in not being logged in and diplaying a message" +
            "Invalid username or password")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUsernameField("incorrentLogin")
                 .typeIntoPasswordField("incorrentPassword")
                 .clickLoginButton();
                loginPage
                 .assertThatWarningIsDisplayed("Invalid username ordddd password. Signon failed."); //wrong text on purpose
                //using assertJ from generic.assertions.AssertWebElement
                //asserts are inside PageObject classes

        //Assert.assertEquals(loginPage.getWarningMessage(),"Invalid username or password. Signon failed.");
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
