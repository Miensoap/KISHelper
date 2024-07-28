package soap.kis.util;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigLoader {

    private static final String CONFIG_FILE_NAME = "kish.yml";
    private static final String APP_KEY = "appkey";
    private static final String APP_SECRET = "appsecret";
    private static final String ACCESS_TOKEN = "accessToken";


    @Getter
    private static String appSecret;
    @Getter
    private static String appKey;
    @Getter
    private static String accessToken;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getResourceAsStream(CONFIG_FILE_NAME)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found! kish.yml");
            }

            Map<String, Object> obj = yaml.load(inputStream);
            appKey = (String) obj.get(APP_KEY);
            appSecret = (String) obj.get(APP_SECRET);
            accessToken = (String) obj.getOrDefault(ACCESS_TOKEN, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getResourceAsStream(String resourceName) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceStream = contextClassLoader.getResourceAsStream(resourceName);

        if (resourceStream == null) {
            resourceStream = ConfigLoader.class.getClassLoader().getResourceAsStream(resourceName);
        }
        return resourceStream;
    }
}

