package soap.kis;

import feign.Feign;
import feign.gson.GsonDecoder;
import soap.kis.domain.AccessToken;
import soap.kis.domain.ApiAuth;

public class KISClient {
    private final String KOREA_INVESTMENT_API_PROD = "https://openapi.koreainvestment.com:9443";
    private final ApiAuth auth;
    private final KoreaInvestment kis;

    private String accessToken;

    public KISClient(ApiAuth auth) {
        this.auth = auth;
        this.kis = Feign.builder()
                .decoder(new GsonDecoder())
                .target(KoreaInvestment.class, KOREA_INVESTMENT_API_PROD);
    }

    public String getAccessToken() {
        AccessToken token = kis.getToken(auth.appKey(), auth.appSecret());
        return token.getAccessToken();
    }
}
