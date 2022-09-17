package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    public void driverSetup() {
        Environment.get();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void initiateDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverHolder.setDriver(driver);
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

    }
}
