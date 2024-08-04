package io.github.miensoap.kishelper.data.consts;

public abstract class QueryParamValue {
    /**
     * 사용자 인증 정보
     */
    public static final String USER_AUTH_DEFAULT = "";

    /**
     * 기간 구분 <p>
     * (0: 일, 1: 주, 2: 월)
     */
    public static final String PERIOD_DIVISION_DAY = "0";
    public static final String PERIOD_DIVISION_WEEK = "1";
    public static final String PERIOD_DIVISION_MONTH = "2";


    /**
     * 조회 기준 일자 <p>
     */
    public static final String INQUIRY_FROM_TODAY = "";

    // ---------------------------------------------------------------------
    // FID (Field Identifier)

    /**
     * 시장 구분 코드 <p>
     */
    public static final String FID_MARKET_INDEX = "N";
    public static final String FID_MARKET_CURRENCY = "X";
    public static final String FID_MARKET_BONDS = "I";
    public static final String FID_MARKET_GOLD_FUTURES = "S";

    /**
     * 기간 구분 코드 <p>
     * (D: 일, W: 주, M: 월, Y: 년)
     */
    public static final String FID_PERIOD_DAY = "D";
    public static final String FID_PERIOD_WEEK = "W";
    public static final String FID_PERIOD_MONTH = "M";
    public static final String FID_PERIOD_YEAR = "Y";

    /**
     * 시간 구분 코드 <p>
     * (0: 정규장, 1: 시간외)
     */
    public static final String FID_REGULAR_HOURS = "0";
    public static final String FID_AFTER_HOURS = "1";
}
