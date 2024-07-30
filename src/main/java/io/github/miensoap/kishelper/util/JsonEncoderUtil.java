package io.github.miensoap.kishelper.util;

import com.google.gson.Gson;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class JsonEncoderUtil {

    private static final Gson gson = new Gson();

    public static String encodeObject(Object obj) {
        String jsonString = gson.toJson(obj);
        return urlEncode(jsonString);
    }

    private static String urlEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20"); // Optional: to handle spaces correctly
    }
}
