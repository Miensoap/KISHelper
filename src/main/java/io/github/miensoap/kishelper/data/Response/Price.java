package io.github.miensoap.kishelper.data.Response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import io.github.miensoap.kishelper.domain.DailyStockPriceInfo;

import java.util.List;

@Getter
@ToString
public class Price {
    @SerializedName("output1")
    private PriceInfo priceInfo;

    @SerializedName("output2")
    private List<DailyStockPriceInfo> prices;

    @Getter
    public static class PriceInfo {
        @SerializedName("rsym")
        private String 실시간조회종목코드;

        @SerializedName("zdiv")
        private String 소수점자리수;

        @SerializedName("nrec")
        private String 전일종가;
    }
}
