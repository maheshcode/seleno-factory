package base.drivers;

import base.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.logging.Logger;

import static base.drivers.DriverHolder.getDriver;

public class WebDriverFactory {

    private static final Logger logger = Logger.getLogger(WebDriverFactory.class.getName());

    public static void initDriver(DesiredCapabilities capabilities) {
        if (getDriver() != null) {
            quitWebDriver();
        }
        if (getDriver() == null) {
            try {
                WebDriver webDriver= new DriverCreation().initDriver(capabilities);
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Configuration.timeout));
                DriverHolder.setDriver(webDriver);
            } catch (Throwable t) {
                logger.info(t.getLocalizedMessage());
                throw new WebDriverException("Unable to init driver :" + t.getMessage());
            }
        }
    }

    public static void initDriver() {
        initDriver(new DesiredCapabilities());
    }


    private static void quitWebDriver() {
        try {
            getDriver().quit();
        } catch (Throwable t) {
            logger.info(t.getLocalizedMessage());
        }
        DriverHolder.setDriver(null);
    }


}
