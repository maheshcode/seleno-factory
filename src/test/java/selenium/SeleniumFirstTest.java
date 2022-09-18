package selenium;

import base.BaseTest;
import base.CommonProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.PageProvider;
import pages.selenium.SeleniumHomePage;

public class SeleniumFirstTest extends BaseTest {

    @Test
    public void loadSeleniumTest(){
        String bannerText = PageProvider.get(SeleniumHomePage.class, CommonProperties.get("selenium.host")).getMainBannerText();
        Assert.assertTrue(bannerText.contains("Selenium automates browsers. That's it!"));
    }
}
