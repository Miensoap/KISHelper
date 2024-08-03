package io.github.miensoap.kishelper.data.request;

import lombok.Getter;

@Getter
public class ApiAuth {
    private final String BEARER_TOKEN_PREFIX = "Bearer ";
    private final String appKey;
    private final String appSecret;
    private String accessToken = null;

    public ApiAuth(String appKey, String appSecret, String accessToken) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.accessToken = BEARER_TOKEN_PREFIX + accessToken;
    }

    public boolean isAccessTokenPresent() {
        return this.accessToken != null;
    }

    public void setAccessToken(String token) {
        this.accessToken = BEARER_TOKEN_PREFIX + token;
    }
}
