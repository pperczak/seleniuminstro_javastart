package driver.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class DriverEventListener implements WebDriverEventListener {

    Logger logger = LogManager.getLogger(DriverEventListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("Trying to accept alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("Accepted alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("Dismissed alert ");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("Trying to dismiss alert");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.info("Trying to navigate to " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.info("Navigated to " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("Trying to navigate back for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("Navigated back for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("Trying to navigate forward for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("Navigated forward for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("Trying to refresh page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("Refreshed page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to find element with locator " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Found element with locator " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to click on element with tag name: " + webElement.getTagName());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Clicked on element "+webElement.getTagName());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if (charSequences == null) {
            logger.info("Trying to enter empty string or clear element: " + webElement.getTagName());
        } else {
            logger.info("Trying to type into element: " + webElement.getTagName() + " text " + Arrays.toString(charSequences));
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if (charSequences == null) {
            logger.info("Entered empty string or cleared element: " + webElement.getTagName());
        } else {
            logger.info("Typed into element: " + webElement.getTagName() + " text " + Arrays.toString(charSequences));
        }
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("Trying to execute JS script: " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.info("Executed JS script: " + s);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Trying to switch to window: " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Switched to window: " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("There was an exception with message: " + throwable.getMessage());
    }
}
