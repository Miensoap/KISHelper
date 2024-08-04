package io.github.miensoap.kishelper.data.Response;

import com.google.gson.annotations.SerializedName;
import io.github.miensoap.kishelper.util.StringUtil;
import lombok.Getter;
import lombok.ToString;
import io.github.miensoap.kishelper.domain.data.PeriodStockPriceInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Getter
@ToString
public class StockQuotationsResponse {
    @SerializedName("output1")
    private PriceInfo priceInfo;

    @SerializedName("output2")
    private List<PeriodStockPriceInfo> prices;

    @Getter
    public static class PriceInfo {
        @SerializedName("rsym")
        private String 실시간조회종목코드;

        @SerializedName("zdiv")
        private String 소수점자리수;

        @SerializedName("nrec")
        private String 전일종가;
    }

    public Optional<PeriodStockPriceInfo> ofDate(LocalDate date){
        String dateString = StringUtil.convertToDateFormat(date);

        return this.prices.stream()
                .filter((price) -> price.date().equals(dateString))
                .findAny();
    }
}
