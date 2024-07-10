package soap.kis.core;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import soap.kis.data.AccessToken;

public interface KoreaInvestmentApi {

    @RequestLine("POST /oauth2/tokenP")
    @Headers("Content-Type: application/json")
    @Body("%7B\"grant_type\": \"client_credentials\", \"appkey\": \"{appkey}\", \"appsecret\": \"{appsecret}\"%7D")
    AccessToken getToken(@Param("appkey") String appKey,
                         @Param("appsecret") String appSecret);


    @RequestLine("POST {apiUrl}")
    @Headers("Content-Type: application/json")
    Response getDailyPrice(@Param("apiUrl") String url);
}

