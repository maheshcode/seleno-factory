package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public void init(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.initFindByAnnotations(this);
    }


    private <E extends BasePage> void initFindByAnnotations(E page){
        PageFactory.initElements(this.driver,page);
    }

    public void open(String url){
        this.driver.get(url);
    }
}
