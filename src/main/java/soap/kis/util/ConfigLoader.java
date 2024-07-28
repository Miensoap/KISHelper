package soap.kis.util;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigLoader {

    private static final String CONFIG_FILE_NAME = "kish.yml";

    @Getter
    private static String appSecret;
    @Getter
    private static String appKey;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getResourceAsStream("kish.yml")) {
            if (inputStream == null) throw new IllegalArgumentException("File not found! kish.yml");

            Map<String, Object> obj = yaml.load(inputStream);
            appSecret = (String) obj.get("appsecret");
            appKey = (String) obj.get("appkey");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getResourceAsStream(String resourceName) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceStream = contextClassLoader.getResourceAsStream(resourceName);

        if (resourceStream == null) resourceStream = ConfigLoader.class.getClassLoader().getResourceAsStream(resourceName);
        return resourceStream;
    }
}

