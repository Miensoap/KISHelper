package io.github.miensoap.kishelper.core;

import feign.Body;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Response;
import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import io.github.miensoap.kishelper.data.Response.StockInfoResponse;
import io.github.miensoap.kishelper.data.Response.StockQuotationsResponse;
import io.github.miensoap.kishelper.data.consts.ApiPath;

import java.util.Map;

public interface KoreaInvestmentApi {
    @RequestLine("POST {path}")
    Response request(@Param("path") String url,
                     @QueryMap Map<String, String> params,
                     @HeaderMap Map<String, Object> headers);

    @RequestLine("GET {path}")
    Response requestGet(@Param("path") String url,
                     @QueryMap Map<String, String> params,
                     @HeaderMap Map<String, Object> headers);

    @RequestLine("POST {path}")
    Response requestPost(@Param("path") String url,
                     @QueryMap Map<String, String> params,
                     @HeaderMap Map<String, Object> headers);

    @RequestLine("POST /oauth2/tokenP")
    @Headers("Content-Type: application/json")
    @Body("%7B\"grant_type\": \"client_credentials\", \"appkey\": \"{appkey}\", \"appsecret\": \"{appsecret}\"%7D")
    AccessTokenResponse getToken(@Param("appkey") String appKey,
                                 @Param("appsecret") String appSecret);


    @RequestLine("GET " + ApiPath.OVERSEAS_DAILY_PRICE)
    StockQuotationsResponse getOverseasPeriodPrice(@QueryMap Map<String, String> params,
                                          @HeaderMap Map<String, Object> headers);

    @RequestLine("GET " + ApiPath.OVERSEAS_SEARCH_INFO)
    StockInfoResponse getOverseasStockInfo(@QueryMap Map<String, String> params,
                                           @HeaderMap Map<String, Object> headers);
}

