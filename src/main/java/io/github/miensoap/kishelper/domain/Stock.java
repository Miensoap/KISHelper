package io.github.miensoap.kishelper.domain;

import io.github.miensoap.kishelper.core.KISClient;
import io.github.miensoap.kishelper.data.consts.Exchange;
import io.github.miensoap.kishelper.domain.data.PeriodStockPriceInfo;
import io.github.miensoap.kishelper.domain.data.StockDetails;
import io.github.miensoap.kishelper.util.StringUtil;

import java.time.LocalDate;
import java.util.Optional;

import static io.github.miensoap.kishelper.data.consts.QueryParamValue.PERIOD_DIVISION_DAY;

public class Stock {

    private final String symbol;
    private final Exchange exchange;
    private final KISClient client;
    private StockDetails details;

    public Stock(String symbol, Exchange exchange) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.client = KISClient.getInstance();
    }

    public PeriodStockPriceInfo getPriceOfDate(LocalDate date, boolean modified) {
        String dateString = StringUtil.convertToDateFormat(date);

        Optional<PeriodStockPriceInfo> priceOfDate = client.getOverseasPeriodPrice(
                this.exchange.getCode(),
                this.symbol,
                PERIOD_DIVISION_DAY,
                dateString,
                modified
        ).ofDate(date);

        if(priceOfDate.isEmpty()) {
            throw new IllegalArgumentException("No stock price information available for " + dateString);
        }
        return priceOfDate.get();
    }

    public StockDetails getDetails(){
        if(this.details != null) return this.details;

        this.details = client.getStockDetailInfo(
                this.exchange.getProductTypeCode(),
                this.symbol);
        return this.details;
    }
}
