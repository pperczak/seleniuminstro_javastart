package tests;

import org.testng.annotations.Test;
import page.objects.*;


import static org.testng.Assert.assertTrue;

public class OldPositiveLoginTests extends TestHelper{

    @Test
    public void asUserTryToLogInWithCorrectLoginAndPassword() {

        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUsernameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickLoginButton();
        FooterPage footerPage = new FooterPage();
        assertTrue(footerPage.isDogBannerDisplayedAfterLogin());
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
