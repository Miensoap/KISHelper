package io.github.miensoap.kishelper.data.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestUrl {
    public static final String API_BASE_PATH = "uapi";
    public static final String OVERSEA_PRICE = "overseas-price";
    public static final String VERSION = "v1";
    public static final String KEY_AUTH = "AUTH";

    public static class UrlBuilder {
        private final List<String> path = new ArrayList<>();
        private final Map<String, String> params = new HashMap<>();

        public UrlBuilder path(String path) {
            this.path.add(path);
            return this;
        }

        public UrlBuilder param(String key, String value) {
            params.put(key, value);
            return this;
        }

        public String build() {
            String pathString = String.join("/", this.path);

            String paramString = this.params.entrySet().stream()
                    .map((param) -> param.getKey() + "=" + param.getValue())
                    .collect(Collectors.joining("&"));

            return "/" + pathString + "?" + paramString;
        }
    }

    public static UrlBuilder builder() {
        return new UrlBuilder()
                .path(API_BASE_PATH);
    }

    public static UrlBuilder ofOverseasPrice() {
        return builder()
                .path(OVERSEA_PRICE)
                .path(VERSION)
                .param(KEY_AUTH, "");
    }
}


