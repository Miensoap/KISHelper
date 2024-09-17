package io.github.miensoap.kishelper.core;

import io.github.miensoap.kishelper.data.Response.StockQuotationsResponse;
import io.github.miensoap.kishelper.domain.data.StockDetails;

public interface Client {
    void getAccessToken();

    // Todo. Proxy 사용을 위해 인터페이스 -> ??
    StockQuotationsResponse getOverseasPeriodPrice(String exchange,
                                                   String symbol,
                                                   String period,
                                                   String inquiryDate,
                                                   boolean modified);

    StockDetails getStockDetailInfo(String productType, String symbol);
}

