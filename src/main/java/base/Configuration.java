package base;

public final class Configuration {

    public static String platform = System.getProperty("seleno.platform", "windows");
    public static String browser = System.getProperty("seleno.browser", "chrome");
    public static int timeout = Integer.parseInt(System.getProperty("seleno.timeout", "10"));
    public static boolean runWithGrid = Boolean.parseBoolean(System.getProperty("seleno.runWithGrid", "false"));
    public static String gridHubUrl = System.getProperty("seleno.gridHubUrl", "http://localhost:4444/wd/hub");
    public static boolean headless = Boolean.parseBoolean(System.getProperty("seleno.headless", "false"));

    private Configuration() {
    }

}
