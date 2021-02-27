package tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import page.objects.*;

public class ShoppingCartTest extends TestHelper{

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStoreLink();
        MainPage mainPage = new MainPage();
        mainPage.clickFishMainMenuIcon()
                .clickAngelFishLink()
                .smallAngelFishAddToBasketClick()
                .setProceedToCheckoutButtonClick();
        LoginPage loginPage = new LoginPage();

        assertEquals(loginPage.getWarningMessage(),"You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
