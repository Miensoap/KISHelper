package io.github.miensoap.kishelper.domain;

import com.google.gson.annotations.SerializedName;

public record PeriodStockPriceInfo(
        @SerializedName("xymd") String date,        // 날짜 (YYYYMMDD)
        @SerializedName("clos") double closePrice,  // 종가
        @SerializedName("sign") int changeSign,     // 등락 기호 (0: 보합, 1: 상승, 2: 하락)
        @SerializedName("diff") double changeAmount,// 이전 기간 대비 등락액
        @SerializedName("rate") String changeRate,  // 등락률
        @SerializedName("open") double openPrice,   // 시가
        @SerializedName("high") double highPrice,   // 고가
        @SerializedName("low") double lowPrice,     // 저가
        @SerializedName("tvol") int tradingVolume,  // 거래량
        @SerializedName("tamt") double tradingAmount,// 거래대금
        @SerializedName("pbid") double bidPrice,    // 매수 호가
        @SerializedName("vbid") int bidVolume,      // 매수 잔량
        @SerializedName("pask") double askPrice,    // 매도 호가
        @SerializedName("vask") int askVolume       // 매도 잔량
) {
}

