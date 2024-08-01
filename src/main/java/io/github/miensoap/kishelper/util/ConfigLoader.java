package io.github.miensoap.kishelper.util;

import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class ConfigLoader {

    private static final String CONFIG_FILE_NAME = "kish.yml";
    private static final String APP_KEY = "appkey";
    private static final String APP_SECRET = "appsecret";
    private static final String ACCESS_TOKEN = "accessToken";
    private static final String EXPIRE_TIME = "expireTime";


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
            if (inputStream == null) throw new IllegalArgumentException("File not found! " + CONFIG_FILE_NAME);

            Map<String, Object> obj = yaml.load(inputStream);
            appKey = (String) obj.get(APP_KEY);
            appSecret = (String) obj.get(APP_SECRET);
            accessToken = (String) obj.getOrDefault(ACCESS_TOKEN, null);

            Date tokenExpires = (Date) obj.getOrDefault(EXPIRE_TIME, null);
            if (isTokenExpired(tokenExpires)) {
                System.out.println("Access Token is expired");
                accessToken = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isTokenExpired(Date tokenExpires) {
        return tokenExpires != null &&
                tokenExpires.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().isBefore(LocalDateTime.now());
    }

    private static InputStream getResourceAsStream(String resourceName) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceStream = contextClassLoader.getResourceAsStream(resourceName);

        if (resourceStream == null) {
            resourceStream = ConfigLoader.class.getClassLoader().getResourceAsStream(resourceName);
        }
        return resourceStream;
    }

    // TODO. yml 파일 수정해 자동 업데이트
    public static void setAccessToken(AccessTokenResponse token) {
        System.out.println("A new token has been issued! To continue using the token, please add the following to your configuration file:\n");
        System.out.println(ACCESS_TOKEN + ": `" + token.getAccessToken() + "`");
        System.out.println(EXPIRE_TIME + ": `" + token.getExpireTime().toString() + "`\n");
    }
}

