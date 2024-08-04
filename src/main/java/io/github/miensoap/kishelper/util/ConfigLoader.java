package io.github.miensoap.kishelper.util;

import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import io.github.miensoap.kishelper.data.request.ApiAuth;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ConfigLoader {

    private static final String CONFIG_FILE_NAME = "kish.yml";
    private static final String APP_KEY = "appkey";
    private static final String APP_SECRET = "appsecret";
    private static final String ACCESS_TOKEN = "accessToken";
    private static final String EXPIRE_TIME = "expireTime";


    private static String appSecret;
    private static String appKey;
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

            String tokenExpires = (String) obj.getOrDefault(EXPIRE_TIME, null);
            if (tokenExpires != null && isTokenExpired(tokenExpires)) {
                System.out.println("Access Token is expired");
                accessToken = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isTokenExpired(String tokenExpires) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime expireTime = LocalDateTime.parse(tokenExpires, formatter);
        return expireTime.isBefore(LocalDateTime.now());
    }

    private static InputStream getResourceAsStream(String resourceName) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceStream = contextClassLoader.getResourceAsStream(resourceName);

        if (resourceStream == null) {
            resourceStream = ConfigLoader.class.getClassLoader().getResourceAsStream(resourceName);
        }
        return resourceStream;
    }

    public static ApiAuth getAuth() {
        return new ApiAuth(appKey, appSecret, accessToken != null ? accessToken : null);
    }

    // TODO. yml 파일 수정해 자동 업데이트
    public static void setAccessToken(AccessTokenResponse token) {
        System.out.println("A new token has been issued! To continue using the token, please add the following to your configuration file:\n");
        System.out.println(ACCESS_TOKEN + ": " + StringUtil.encloseInSingleQuote(token.getAccessToken()));
        System.out.println(EXPIRE_TIME + ": " + StringUtil.encloseInSingleQuote(token.getExpireTime().toString()));
        System.out.println();
    }
}

