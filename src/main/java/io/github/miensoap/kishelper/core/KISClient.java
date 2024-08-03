package io.github.miensoap.kishelper.core;

import feign.Feign;
import feign.gson.GsonDecoder;
import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import io.github.miensoap.kishelper.data.consts.Path;
import io.github.miensoap.kishelper.data.request.ApiAuth;
import io.github.miensoap.kishelper.data.request.RequestHeader;
import io.github.miensoap.kishelper.data.request.RequestUrl;
import io.github.miensoap.kishelper.domain.DailyStockPriceInfo;
import io.github.miensoap.kishelper.util.ConfigLoader;

import java.util.List;
import java.util.Map;

public class KISClient {

    private final ApiAuth auth;
    private final KoreaInvestmentApi kis;

    private static KISClient instance;

    public static KISClient getInstance() {
        if (instance != null) return instance;
        instance = new KISClient(ConfigLoader.getAuth());
        return instance;
    }

    private KISClient(ApiAuth auth) {
        this.auth = auth;
        this.kis = Feign.builder()
                .decoder(new GsonDecoder())
                .target(KoreaInvestmentApi.class, Path.KOREA_INVESTMENT_API_PROD);
        if (!auth.isAccessTokenPresent()) getAccessToken();
    }

    // TODO. 접근토큰 발급 잠시 후 다시 시도하세요(1분당 1회) 오류
    private void getAccessToken() {
        AccessTokenResponse token = kis.getToken(auth.getAppKey(), auth.getAppSecret());
        this.auth.setAccessToken(token.getAccessToken());
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
