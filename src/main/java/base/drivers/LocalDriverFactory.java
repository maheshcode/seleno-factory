package base.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public class LocalDriverFactory implements DriverFactory {

    private final String browserName;
    private final String platformName;
    private final DesiredCapabilities desiredCapabilities;
    private final boolean isHeadless;

    public LocalDriverFactory(String browserName, String platformName, DesiredCapabilities desiredCapabilities, boolean isHeadless) {
        this.browserName = browserName;
        this.platformName = platformName;
        this.desiredCapabilities = desiredCapabilities;
        this.isHeadless = isHeadless;
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

    private WebDriver safari() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver(WebDriverOptions.safariOptions(platformName, desiredCapabilities));
    }

    private WebDriver ie() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver(WebDriverOptions.internetExplorerOptions(platformName, desiredCapabilities));
    }

    private WebDriver edge() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(WebDriverOptions.edgeOptions(platformName, desiredCapabilities));
    }

    private WebDriver chrome() {
        WebDriverManager.chromedriver().setup();
        ChromeDriverService service = ChromeDriverService.createDefaultService();
        return new ChromeDriver(service, WebDriverOptions.chromeOptions(platformName, desiredCapabilities, isHeadless));
    }

    private WebDriver firefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(WebDriverOptions.firefoxOptions(platformName, desiredCapabilities));
    }


    private WebDriver throwException() {
        throw new RuntimeException("Not supported for platform: " + platformName);
    }
}
