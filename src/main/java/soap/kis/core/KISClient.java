package soap.kis.core;

import feign.Feign;
import feign.gson.GsonDecoder;
import soap.kis.data.AccessTokenResponse;
import soap.kis.data.ApiAuth;
import soap.kis.data.RequestUrl;
import soap.kis.domain.DailyStockPriceInfo;
import soap.kis.util.ConfigLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KISClient {
    private final String KOREA_INVESTMENT_API_PROD = "https://openapi.koreainvestment.com:9443";
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
                .target(KoreaInvestmentApi.class, KOREA_INVESTMENT_API_PROD);
        getAccessToken();
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
        System.out.println("새 토큰이 발급되었습니다!\n" + token.getAccessToken());
    }

    public List<DailyStockPriceInfo> getOverseasDailyPrice(String exchange, String symbol, boolean modified) throws IOException {
        String url = RequestUrl.ofOverseasPrice()
                .path("quotations")
                .path("dailyprice")
                .param("EXCD", exchange)
                .param("SYMB", symbol)
                .param("GUBN", "0")
                .param("BYMD", "")
                .param("MODP", "1")
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
