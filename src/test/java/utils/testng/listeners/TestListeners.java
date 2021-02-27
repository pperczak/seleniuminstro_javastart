package utils.testng.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static utils.ScreenShotMaker.makeScreenShot;

public class TestListeners implements ITestListener {

    private Logger logger = LogManager.getLogger(ITestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Starting test: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test {} passed successfully", iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test {} failed!", iTestResult.getName());
        makeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test {} skipped!", iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Test {} failed!", iTestResult.getName());
        makeScreenShot();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
