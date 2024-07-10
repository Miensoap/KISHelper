package soap.kis.core;

import feign.Body;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import soap.kis.data.AccessTokenResponse;
import soap.kis.domain.Price;

import java.util.Map;

public interface KoreaInvestmentApi {

    @RequestLine("POST /oauth2/tokenP")
    @Headers("Content-Type: application/json")
    @Body("%7B\"grant_type\": \"client_credentials\", \"appkey\": \"{appkey}\", \"appsecret\": \"{appsecret}\"%7D")
    AccessTokenResponse getToken(@Param("appkey") String appKey,
                                 @Param("appsecret") String appSecret);


    @RequestLine("POST {apiUrl}")
    Price getDailyPrice(@Param("apiUrl") String url, @HeaderMap Map<String, Object> headers);
}

