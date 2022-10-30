package base;

public enum Environment {

    MOCK("mock"){
        @Override
        CommonProperties loadProperties() {
            return CommonProperties.load(this.getEnvironmentName()+".properties");
        }
    },
    QA("qa"){
        @Override
        CommonProperties loadProperties() {
            return CommonProperties.load(this.getEnvironmentName()+".properties");
        }
    },
    DEFAULT("default"){
        @Override
        CommonProperties loadProperties() {
            return CommonProperties.load(this.getEnvironmentName()+".properties");
        }
    };


    public static Environment get(){
        switch (System.getProperty("environment")){
            case "mock":
                return MOCK;
            case "qa":
                return QA;
            default:
                return DEFAULT;
        }
    }

    private final String environmentName;
    private final CommonProperties properties;
    Environment(String environmentName) {
        this.environmentName = environmentName;
        properties = loadProperties();
    }

    abstract CommonProperties loadProperties();

    public String getEnvironmentName() {
        return environmentName;
    }

    public CommonProperties getProperties() {
        return properties;
    }
}
