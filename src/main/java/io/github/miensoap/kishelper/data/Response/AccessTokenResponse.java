package io.github.miensoap.kishelper.data.Response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class AccessTokenResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("access_token_token_expired")
    private String accessTokenTokenExpired;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    public LocalDateTime getExpireTime() {
        return LocalDateTime.now()
                .plus(Duration.ofSeconds(this.expiresIn));
    }
}
