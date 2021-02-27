package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.*;

public class OldFailedLoginTests extends TestHelper{

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {

        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUsernameField("dupa");
        loginPage.typeIntoPasswordField("dupaZbita");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getWarningMessage(),"Invalid username or password. Signon failed.");

    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
