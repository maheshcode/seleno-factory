package base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class CommonProperties extends Properties {

    private CommonProperties() {
        super();
    }

    public static CommonProperties load(String... filePathArray) {
        CommonProperties allProperties = new CommonProperties();
        Arrays.stream(filePathArray).forEach(allProperties::loadFileByPath);
        return allProperties;
    }

    public static String get(String key) {
        return Environment.get().getProperties().getProperty(key);
    }

    private void loadFileByPath(String filePath) {
        try {
            load(CommonProperties.class.getResourceAsStream("/properties/" + filePath));
        } catch (IOException e) {
            throw new RuntimeException("cannot find path");
        }
    }
}
