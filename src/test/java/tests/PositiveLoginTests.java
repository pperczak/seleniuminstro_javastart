package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.*;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestHelper{

    @TmsLink("ID-3")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after, starting from Landing Page")
    public void asUserTryToLogInWithCorrectLoginAndPasswordStartFromLandingPage() {

        LandingPage landingPage = new LandingPage();

        landingPage.enterTheStoreLink()
                    .clickOnSignInLink()
                    .typeIntoUsernameField("j2ee")
                    .typeIntoPasswordField("j2ee")
                    .clickLoginButton()
                    .assertThatDogBannerIsDisplayed();
        //using assertJ from generic.assertions.AssertWebElement
        //asserts are inside PageObject classes

                    //.isDogBannerDisplayedAfterLogin();

        //assertTrue(isDogBannerDisplayedAfterLogin);
    }

    @TmsLink("ID-4")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserTryToLogInWithCorrectLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();

        boolean isDogBannerDisplayedAfterLogin =
                loginPage.typeIntoUsernameField("j2ee")
                         .typeIntoPasswordField("j2ee")
                         .clickLoginButton()
                         .isDogBannerDisplayedAfterLogin();
        assertTrue(isDogBannerDisplayedAfterLogin);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
