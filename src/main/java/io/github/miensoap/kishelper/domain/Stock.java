package io.github.miensoap.kishelper.domain;

import io.github.miensoap.kishelper.core.KISClient;
import io.github.miensoap.kishelper.util.StringUtil;

import java.time.LocalDate;
import java.util.Optional;

import static io.github.miensoap.kishelper.data.consts.QueryParamValue.PERIOD_DIVISION_DAY;

public class Stock {

    private final String symbol;
    private final String exchange;
    private final KISClient client;

    public Stock(String symbol, String exchange) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.client = KISClient.getInstance();
    }

    public PeriodStockPriceInfo getPriceOfDate(LocalDate date, boolean modified) {
        String dateString = StringUtil.convertToDateFormat(date);

        Optional<PeriodStockPriceInfo> priceOfDate = client.getOverseasPeriodPrice(this.exchange,
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
}
