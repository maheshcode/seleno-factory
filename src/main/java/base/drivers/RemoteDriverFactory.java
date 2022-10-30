package base.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteDriverFactory implements DriverFactory {

    private final String browserName;
    private final String platformName;
    private final DesiredCapabilities desiredCapabilities;
    private final boolean isHeadless;
    private final URL gridUrl;

    public RemoteDriverFactory(String browserName, String platformName, DesiredCapabilities desiredCapabilities, boolean isHeadless, URL gridUrl) {
        this.browserName = browserName;
        this.platformName = platformName;
        this.desiredCapabilities = desiredCapabilities;
        this.isHeadless = isHeadless;
        this.gridUrl = gridUrl;
    }

    @Override
    public WebDriver getDriver() {
        switch (browserName.toLowerCase().trim()) {
            case FIREFOX: {
                return firefox();
            }
            case CHROME: {
                return chrome();
            }
            case EDGE: {
                return edge();
            }
            case IE: {
                return ie();
            }
            case SAFARI: {
                return safari();
            }
            default: {
                return throwException();
            }
        }
    }

    private WebDriver throwException() {
        throw new RuntimeException("Not supported for platform: " + platformName);
    }

    private WebDriver safari() {
        return new RemoteWebDriver(this.gridUrl, WebDriverOptions.safariOptions(platformName, desiredCapabilities));
    }

    private WebDriver ie() {
        return new RemoteWebDriver(this.gridUrl, WebDriverOptions.internetExplorerOptions(platformName, desiredCapabilities));
    }

    private WebDriver edge() {
        return new RemoteWebDriver(this.gridUrl, WebDriverOptions.edgeOptions(platformName, desiredCapabilities));
    }

    private WebDriver firefox() {
        return new RemoteWebDriver(this.gridUrl, WebDriverOptions.firefoxOptions(platformName, desiredCapabilities));
    }

    private WebDriver chrome() {
        return new RemoteWebDriver(this.gridUrl, WebDriverOptions.chromeOptions(platformName, desiredCapabilities, isHeadless));
    }
}
