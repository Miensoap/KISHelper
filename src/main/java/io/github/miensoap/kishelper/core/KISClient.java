package io.github.miensoap.kishelper.core;

import feign.Feign;
import feign.gson.GsonDecoder;
import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import io.github.miensoap.kishelper.data.request.ApiAuth;
import io.github.miensoap.kishelper.data.request.RequestUrl;
import io.github.miensoap.kishelper.domain.DailyStockPriceInfo;
import io.github.miensoap.kishelper.util.ConfigLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KISClient {

    private final ApiAuth auth;
    private String accessToken;
    private final KoreaInvestmentApi kis;

    private static KISClient instance;

    public static KISClient getInstance() {
        if (instance != null) return instance;

        ApiAuth auth = new ApiAuth(ConfigLoader.getAppKey(), ConfigLoader.getAppSecret());
        String accessToken = ConfigLoader.getAccessToken();

        if (accessToken == null) instance = new KISClient(auth);
        else instance = new KISClient(auth, accessToken);
        return instance;
    }

    private KISClient(ApiAuth auth) {
        this.auth = auth;
        this.kis = Feign.builder()
                .decoder(new GsonDecoder())
        getAccessToken();
                .target(KoreaInvestmentApi.class, Path.KOREA_INVESTMENT_API_PROD);
    }

    private KISClient(ApiAuth auth, String accessToken) {
        this.auth = auth;
        this.kis = Feign.builder()
                .decoder(new GsonDecoder())
                .target(KoreaInvestmentApi.class, KOREA_INVESTMENT_API_PROD);
        this.accessToken = accessToken;
    }
    
    // TODO. 접근토큰 발급 잠시 후 다시 시도하세요(1분당 1회) 오류
    private void getAccessToken() {
        AccessTokenResponse token = kis.getToken(auth.appKey(), auth.appSecret());
        this.accessToken = token.getAccessToken();
        ConfigLoader.setAccessToken(token);
    }

    public List<DailyStockPriceInfo> getOverseasDailyPrice(String exchange, String symbol, boolean modified) {
        String url = RequestUrl.ofOverseasPrice()
                .path("quotations")
                .path("dailyprice")
                .param("EXCD", exchange)
                .param("SYMB", symbol)
                .param("GUBN", "0")
                .param("BYMD", "")
                .param("MODP", modified ? "1" : "0")
                .build();

        Map<String, Object> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("authorization", "Bearer " + accessToken);
        headers.put("appkey", auth.appKey());
        headers.put("appsecret", auth.appSecret());
        headers.put("tr_id", "HHDFS76240000");

        return kis.getDailyPrice(url, headers).getPrices();
    }
}
