package io.github.miensoap.kishelper.exception;

import io.github.miensoap.kishelper.data.consts.Exchange;

/**
 * If you attempt to create a Stock with an invalid symbol and exchange, this exception will be thrown.
 */
public class StockNotFoundException extends IllegalArgumentException {
    private final String symbol;
    private final Exchange exchange;

    public StockNotFoundException(String symbol, Exchange exchange) {
        super();
        this.symbol = symbol;
        this.exchange = exchange;
    }

    @Override
    public String getMessage() {
        return "Cannot find %s in %s. Please check the symbol or exchange"
                .formatted(this.symbol, this.exchange.name());
    }
}
