package base;

import base.drivers.DriverHolder;
import base.drivers.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Logger;

import static java.lang.System.getProperty;

public class BaseTest {
    private final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeSuite
    public void driverSetup() {
        logger.info("Test Suite Started");
        Environment.get();
    }

    @BeforeMethod
    public void initiateDriver() {
        try {
            WebDriverFactory.initDriver();
        } catch (Exception ex) {
            logger.warning(ex.getLocalizedMessage());

        }
    }

    @AfterTest
    public void quitDriver() {
        if (DriverHolder.getDriver() != null) {
            DriverHolder.getDriver().quit();
            DriverHolder.setDriver(null);
        }
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("Test Suite Finish");
    }
}
