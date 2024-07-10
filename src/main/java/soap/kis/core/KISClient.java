package soap.kis.core;

import feign.Feign;
import feign.gson.GsonDecoder;
import soap.kis.data.AccessToken;
import soap.kis.data.ApiAuth;
import soap.kis.domain.DailyStockPriceInfo;
import soap.kis.data.RequestUrl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class KISClient {
    private final String KOREA_INVESTMENT_API_PROD = "https://openapi.koreainvestment.com:9443";
    private final ApiAuth auth;
    private final KoreaInvestmentApi kis;

    private String accessToken;

    public KISClient(ApiAuth auth) {
        this.auth = auth;
        this.kis = Feign.builder()
                .decoder(new GsonDecoder())
                .target(KoreaInvestmentApi.class, KOREA_INVESTMENT_API_PROD);
    }

    public void getAccessToken() {
        AccessToken token = kis.getToken(auth.appKey(), auth.appSecret());
        this.accessToken = token.getAccessToken();
    }

}
