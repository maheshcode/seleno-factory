package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public void init(WebDriver driver){
        this.driver = driver;
        this.initFindByAnnotations(this);
    }


    private <E extends BasePage> void initFindByAnnotations(E page){
        PageFactory.initElements(this.driver,page);
    }

    public void open(String url){
        this.driver.get(url);
    }
}
