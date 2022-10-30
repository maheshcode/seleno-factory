package base.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariOptions;

public class WebDriverOptions {

    public static ChromeOptions chromeOptions(String platformName, Capabilities desiredCapabilities,boolean isHeadless){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPlatformName(platformName);
        if (isHeadless) {
            chromeOptions.addArguments("headless");
        }
        chromeOptions.merge(desiredCapabilities);
        return chromeOptions;
    }

    public static FirefoxOptions firefoxOptions(String platformName, Capabilities desiredCapabilities){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPlatformName(platformName);
        firefoxOptions.merge(desiredCapabilities);
        return firefoxOptions;
    }

    public static EdgeOptions edgeOptions(String platformName, Capabilities desiredCapabilities) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPlatformName(platformName);
        edgeOptions.merge(desiredCapabilities);
        return edgeOptions;
    }

    public static InternetExplorerOptions internetExplorerOptions(String platformName, Capabilities desiredCapabilities){
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setPlatformName(platformName);
        internetExplorerOptions.merge(desiredCapabilities);
        return internetExplorerOptions;
    }

    public static SafariOptions safariOptions(String platformName, Capabilities desiredCapabilities){
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPlatformName(platformName);
        safariOptions.merge(desiredCapabilities);
        return safariOptions;
    }
}
