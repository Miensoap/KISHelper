package io.github.miensoap.kishelper.core;

import feign.Feign;
import feign.gson.GsonDecoder;
import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import io.github.miensoap.kishelper.data.Response.StockQuotationsResponse;
import io.github.miensoap.kishelper.data.consts.ApiPath;
import io.github.miensoap.kishelper.data.consts.TradingID;
import io.github.miensoap.kishelper.data.request.ApiAuth;
import io.github.miensoap.kishelper.data.request.QueryParams;
import io.github.miensoap.kishelper.data.request.RequestHeader;
import io.github.miensoap.kishelper.domain.data.StockDetails;
import io.github.miensoap.kishelper.util.ConfigLoader;

import java.lang.reflect.Proxy;
import java.util.Map;

import static io.github.miensoap.kishelper.data.consts.QueryParamKey.APPLY_MODIFIED_PRICE;
import static io.github.miensoap.kishelper.data.consts.QueryParamKey.EXCHANGE_CODE;
import static io.github.miensoap.kishelper.data.consts.QueryParamKey.INQUIRY_DATE;
import static io.github.miensoap.kishelper.data.consts.QueryParamKey.PERIOD_DIVISION;
import static io.github.miensoap.kishelper.data.consts.QueryParamKey.PRODUCT_NUMBER;
import static io.github.miensoap.kishelper.data.consts.QueryParamKey.PRODUCT_TYPE_CODE;
import static io.github.miensoap.kishelper.data.consts.QueryParamKey.STOCK_SYMBOL;

public class KISClient implements Client {

    private final ApiAuth auth;
    private final KoreaInvestmentApi kis;

    private static Client instance;

    public static Client getInstance() {
        if (instance != null) return instance;
        instance = createProxy(new KISClient(ConfigLoader.getAuth()));
        return instance;
    }

    protected static Client createProxy(Client realInstance) {
        return (Client) Proxy.newProxyInstance(
                Client.class.getClassLoader(),
                new Class[]{Client.class},
                new KISClientInvocationHandler(realInstance)
        );
    }

    protected KISClient(ApiAuth auth, KoreaInvestmentApi api) {
        this.auth = auth;
        this.kis = api;
    }

    private KISClient(ApiAuth auth) {
        this.auth = auth;
        this.kis = Feign.builder()
                .decoder(new GsonDecoder())
                .target(KoreaInvestmentApi.class, ApiPath.KOREA_INVESTMENT_API_PROD);
        if (!auth.isAccessTokenPresent()) getAccessToken();
    }

    // TODO. 접근토큰 발급 잠시 후 다시 시도하세요(1분당 1회) 오류
    public void getAccessToken() {
        AccessTokenResponse token = kis.getToken(auth.getAppKey(), auth.getAppSecret());
        this.auth.setAccessToken(token.getAccessToken());
        ConfigLoader.setAccessToken(token);
    }

    public StockQuotationsResponse getOverseasPeriodPrice(String exchange,
                                                          String symbol,
                                                          String period,
                                                          String inquiryDate,
                                                          boolean modified) {
        Map<String, String> params = new QueryParams()
                .addParam(EXCHANGE_CODE, exchange)
                .addParam(STOCK_SYMBOL, symbol)
                .addParam(PERIOD_DIVISION, period)
                .addParam(INQUIRY_DATE, inquiryDate)
                .addParam(APPLY_MODIFIED_PRICE, modified ? "1" : "0")
                .build();


        Map<String, Object> headers = RequestHeader.basicBuilder(auth)
                .tradingId(TradingID.OVERSEAS_DAILY_PRICE)
                .build().toMap();

        return kis.getOverseasPeriodPrice(params, headers);
    }

    public StockDetails getStockDetailInfo(String productType, String symbol) {

        Map<String, String> params = new QueryParams()
                .addParam(PRODUCT_TYPE_CODE, productType)
                .addParam(PRODUCT_NUMBER, symbol)
                .build();

        Map<String, Object> headers = RequestHeader.basicBuilder(auth)
                .tradingId(TradingID.OVERSEAS_SEARCH_INFO)
                .build().toMap();

        return kis.getOverseasStockInfo(params, headers).stockDetails();
    }
}
