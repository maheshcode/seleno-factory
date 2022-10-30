package base.drivers;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {
    String FIREFOX = "firefox";
    String CHROME = "chrome";
    String SAFARI = "safari";
    String IE = "ie";
    String EDGE = "edge";

    String WINDOWS = "windows";
    String LINUX = "linux";
    String MAC = "mac";

    WebDriver getDriver();
}
