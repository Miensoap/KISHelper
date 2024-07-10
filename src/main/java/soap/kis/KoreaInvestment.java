package soap.kis;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import soap.kis.domain.AccessToken;

public interface KoreaInvestment {

    @RequestLine("POST /oauth2/tokenP")
    @Headers("Content-Type: application/json")
    @Body("%7B\"grant_type\": \"client_credentials\", \"appkey\": \"{appkey}\", \"appsecret\": \"{appsecret}\"%7D")
    AccessToken getToken(@Param("appkey") String appKey,
                         @Param("appsecret") String appSecret);
}