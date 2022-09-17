package base;

import java.util.HashMap;
import java.util.Map;

public class PageProvider {
    private static final ThreadLocal<Map<String, Object>> pageObjects = ThreadLocal.withInitial(HashMap::new);

    public static <T extends BasePage> T get(Class<T> target) {
        return getPage(target);
    }

    public static <T extends BasePage> T get(Class<T> target, String url) {
        T page = get(target);
        page.open(url);
        return page;
    }

    private static <T extends BasePage> T getPage(Class<T> page) {
        String className = page.getName();
        if (pageObjects.get().containsKey(className)) {
            T pageToReInit = (T) pageObjects.get().get(className);
            pageToReInit.init(DriverHolder.getDriver());
            return pageToReInit;
        } else {
            Object value;
            try {
                value = Class.forName(className).getDeclaredConstructor().newInstance();
            } catch (Exception var) {
                throw new RuntimeException("Unable to find the class :" + var.getMessage()+" in class path");
            }
            T pageObject = (T) value;
            pageObject.init(DriverHolder.getDriver());
            return pageObject;
        }
    }
}
