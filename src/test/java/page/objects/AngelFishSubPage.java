package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelFishSubPage {

    @FindBy(xpath = "//a[@href='/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-2']")
    WebElement smallAngelFishAddToBasket;

    @FindBy(xpath = "//a[contains(text(),'EST-2')]")
    WebElement smallAngelFishLink;

    Logger logger = LogManager.getLogger(AngelFishSubPage.class);

    public AngelFishSubPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void smallAngelFishLinkClick() {
        smallAngelFishLink.click();
    }

    public ShoppingCartPage smallAngelFishAddToBasketClick() {
        WaitForElement.waitUntilElementIsClickable(smallAngelFishAddToBasket);
        smallAngelFishAddToBasket.click();
        logger.info("Small angel fish add to basket icon clicked");
        return new ShoppingCartPage();
    }
}
