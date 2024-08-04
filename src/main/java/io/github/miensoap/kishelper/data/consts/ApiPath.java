package io.github.miensoap.kishelper.data.consts;

/**
 * ApiPath 클래스는 한국투자증권 API 경로를 정의합니다.
 */
public abstract class ApiPath {

    /** 한국투자증권 API 실전 베이스 URL */
    public static final String KOREA_INVESTMENT_API_PROD = "https://openapi.koreainvestment.com:9443";

    private static final String VERSION = "/v1";
    private static final String QUOTATIONS = "/quotations";

    /** 해외주식 가격 관련 기본 경로 */
    public static final String OVERSEAS_PRICE_BASE = "/uapi/overseas-price";

    /** 해외주식 관련 기본 경로 */
    public static final String OVERSEAS_STOCK_BASE = "/uapi/overseas-stock";

    // Path

    /**
     * 해외주식 현재체결가
     * <p>[v1_해외주식-009]</p>
     */
    public static final String OVERSEAS_CURRENT_PRICE = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/price";

    /**
     * 해외주식 기간별 시세
     * <p>[v1_해외주식-010]</p>
     */
    public static final String OVERSEAS_DAILY_PRICE = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/dailyprice";

    /**
     * 해외주식 종목/지수/환율 기간별 시세 (일/주/월/년)
     * <p>[v1_해외주식-012]</p>
     */
    public static final String OVERSEAS_CHAT_PRICE = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/inquire-daily-chartprice";

    /**
     * 해외주식 조건 검색
     * <p>[v1_해외주식-015]</p>
     */
    public static final String OVERSEAS_SEARCH = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/inquire-search";

    /**
     * 해외 결제 일자 조회
     * <p>[해외주식-017]</p>
     */
    public static final String OVERSEAS_COUNTRIES_HOLIDAY = OVERSEAS_STOCK_BASE + VERSION + QUOTATIONS + "/countries-holiday";

    /**
     * 해외주식 현재가 상세
     * <p>[v1_해외주식-029]</p>
     */
    public static final String OVERSEAS_PRICE_DETAIL = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/price-detail";

    /**
     * 해외주식 분봉 조회
     * <p>[v1_해외주식-030]</p>
     */
    public static final String OVERSEAS_ITEM_TIME_CHART_PRICE = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/inquire-time-itemchartprice";

    /**
     * 해외지수 분봉 조회
     * <p>[v1_해외주식-031]</p>
     */
    public static final String OVERSEAS_INDEX_TIME_CHART_PRICE = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/inquire-time-indexchartprice";

    /**
     * 해외주식 상품 기본 정보
     * <p>[v1_해외주식-034]</p>
     */
    public static final String OVERSEAS_SEARCH_INFO = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/search-info";

    /**
     * 해외주식 현재가 10호가
     * <p>[해외주식-033]</p>
     */
    public static final String OVERSEAS_ASKING_PRICE = OVERSEAS_PRICE_BASE + VERSION + QUOTATIONS + "/inquire-asking-price";
}
