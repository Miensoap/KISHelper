package io.github.miensoap.kishelper.domain.data;

public record BasicInfo(

        String ticker,
        String productName,
        String englishName,

        String countryName,
        String marketName,

        String ISINCode,
        String LEICode,
        CurrencyInfo currency
) {

    public static BasicInfo of(String ticker, StockDetails details) {
        return new BasicInfo(
                ticker,
                details.productName(),
                details.englishName(),

                details.countryName(),
                details.marketName(),

                details.standardProductNumber(),
                details.leiCode(),
                new CurrencyInfo(
                        details.tradingCurrencyCode(),
                        details.currencyName())
        );
    }
}
