package base.drivers;

import base.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverCreation {

    public WebDriver initDriver(DesiredCapabilities capabilities) {
        DriverFactory driverFactory;
        URL gridUrl = getGridHubUrl();
        boolean isHeadless = Configuration.headless;
        if (Configuration.runWithGrid) {
            driverFactory = new RemoteDriverFactory(Configuration.browser, Configuration.platform, capabilities, isHeadless, gridUrl);
        } else {
            driverFactory = new LocalDriverFactory(Configuration.browser, Configuration.platform, capabilities, isHeadless);
        }

        return driverFactory.getDriver();
    }

    private URL getGridHubUrl() {
        URL url;
        try {
            url = new URL(Configuration.gridHubUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("gridhuburl creation error " + Configuration.gridHubUrl);
        }
        return url;
    }
}
