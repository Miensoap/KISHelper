package io.github.miensoap.kishelper.data.consts;

import lombok.Getter;

/**
 * Exchange enum은 거래소 코드와 상품 유형 코드를 정의합니다.
 */
@Getter
public enum Exchange {
    // Exchange Codes
    NEW_YORK_EXCHANGE("NYS", "513"),
    NEW_YORK_DAY_EXCHANGE("BAY"),
    NASDAQ_EXCHANGE("NAS", "512"),
    NASDAQ_DAY_EXCHANGE("BAQ"),
    AMEX_EXCHANGE("AMS", "529"),
    AMEX_DAY_EXCHANGE("BAA"),
    HONG_KONG_EXCHANGE("HKS", "501"),
    TOKYO_EXCHANGE("TSE", "515"),
    SHANGHAI_EXCHANGE("SHS", "552"),
    SHANGHAI_INDEX("SHI"),
    SHENZHEN_EXCHANGE("SHN", "512"),
    SHENZHEN_INDEX("SZI"),
    HO_CHI_MINH_EXCHANGE("HSX", "551"),
    HANOI_EXCHANGE("HNX", "507"),

    // Product Type Codes
    JAPAN_PRODUCT(null, "515"),
    HONG_KONG_PRODUCT(null, "501"),
    HONG_KONG_CNY_PRODUCT(null, "543"),
    HONG_KONG_USD_PRODUCT(null, "558"),
    SHANGHAI_A_PRODUCT(null, "552"),
    SHENZHEN_A_PRODUCT(null, "512");

    private final String code;
    private final String productTypeCode;

    Exchange(String code) {
        this.code = code;
        this.productTypeCode = null;
    }

    Exchange(String code, String productTypeCode) {
        this.code = code;
        this.productTypeCode = productTypeCode;
    }

    public static Exchange fromCode(String code) {
        for (Exchange exchange : Exchange.values()) {
            if (code.equals(exchange.getCode())) return exchange;
        }
        throw new IllegalArgumentException("No matching Exchange for code: " + code);
    }
}

