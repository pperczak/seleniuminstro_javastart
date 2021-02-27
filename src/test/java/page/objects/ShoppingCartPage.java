package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCartPage {

    @FindBy(xpath = "//a[contains(text(),'Proceed to Checkout')]")
    WebElement proceedToCheckoutButton;

    Logger logger = LogManager.getLogger(ShoppingCartPage.class);

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public CheckoutPage setProceedToCheckoutButtonClick() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Proceed to checkout button clicked");
        return new CheckoutPage();
    }
}
