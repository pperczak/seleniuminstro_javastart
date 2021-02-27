package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class OldShoppingCartTest extends TestHelper{

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStoreLink();
        sleep();
        MainPage mainPage = new MainPage();
        mainPage.clickFishMainMenuIcon();
        FishSubPage fishSubPage = new FishSubPage();
        fishSubPage.clickAngelFishLink();
        AngelFishSubPage angelFishSubPage = new AngelFishSubPage();
        angelFishSubPage.smallAngelFishAddToBasketClick();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.setProceedToCheckoutButtonClick();
        LoginPage loginPage = new LoginPage();

        assertEquals(loginPage.getWarningMessage(),"You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
