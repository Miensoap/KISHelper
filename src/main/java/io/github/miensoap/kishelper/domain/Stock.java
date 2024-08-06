package io.github.miensoap.kishelper.domain;

import io.github.miensoap.kishelper.core.KISClient;
import io.github.miensoap.kishelper.data.consts.Exchange;
import io.github.miensoap.kishelper.domain.data.PeriodStockPriceInfo;
import io.github.miensoap.kishelper.domain.data.StockDetails;
import io.github.miensoap.kishelper.exception.StockNotFoundException;
import io.github.miensoap.kishelper.util.StringUtil;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Optional;

import static io.github.miensoap.kishelper.data.consts.QueryParamValue.PERIOD_DIVISION_DAY;

public class Stock {

    @Getter
    private final String symbol;

    @Getter
    private final Exchange exchange;

    @Getter
    private StockDetails details;

    private final KISClient client;

    public Stock(String symbol, Exchange exchange) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.client = KISClient.getInstance();
        this.details = client.getStockDetailInfo(
                this.exchange.getProductTypeCode(),
                this.symbol);
        if(this.details == null) {
            throw new StockNotFoundException(this.symbol, this.exchange);
        }
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

        if (priceOfDate.isEmpty()) {
            throw new IllegalArgumentException("No stock price information available for " + dateString);
        }
        return priceOfDate.get();
    }
}
