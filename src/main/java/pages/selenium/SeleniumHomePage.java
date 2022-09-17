package pages.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

import java.util.List;

public class SeleniumHomePage extends BasePage {

    @FindBy(xpath = "//*[@id='td-cover-block-0']/*")
    List<WebElement> textBanner;

    public String getMainBannerText() {
        return textBanner.stream().filter(webElement -> !webElement.getText().isEmpty())
                .findFirst().get().getText();
    }
}
