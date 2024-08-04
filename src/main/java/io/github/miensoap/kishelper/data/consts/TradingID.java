package io.github.miensoap.kishelper.data.consts;

/**
 * TradingID 클래스는 거래 ID를 정의합니다.
 */
public abstract class TradingID {

    /**
     * 해외주식 현재체결가
     * <p>[v1_해외주식-009]</p>
     */
    public static final String OVERSEAS_CURRENT_PRICE = "HHDFS00000300";

    /**
     * 해외주식 기간별시세
     * <p>[v1_해외주식-010]</p>
     */
    public static final String OVERSEAS_DAILY_PRICE = "HHDFS76240000";

    /**
     * 해외주식 종목/지수/환율 기간별 시세 (일/주/월/년)
     * <p>[v1_해외주식-012]</p>
     */
    public static final String OVERSEAS_CHAT_PRICE = "FHKST03030100";

    /**
     * 해외주식 조건 검색
     * <p>[v1_해외주식-015]</p>
     */
    public static final String OVERSEAS_SEARCH = "HHDFS76410000";

    /**
     * 해외 결제 일자 조회
     * <p>[해외주식-017]</p>
     */
    public static final String OVERSEAS_COUNTRIES_HOLIDAY = "CTOS5011R";

    /**
     * 해외주식 현재가 상세
     * <p>[v1_해외주식-029]</p>
     */
    public static final String OVERSEAS_PRICE_DETAIL = "HHDFS76200200";

    /**
     * 해외주식 분봉 조회
     * <p>[v1_해외주식-030]</p>
     */
    public static final String OVERSEAS_ITEM_TIME_CHART_PRICE = "HHDFS76950200";

    /**
     * 해외지수 분봉 조회
     * <p>[v1_해외주식-031]</p>
     */
    public static final String OVERSEAS_INDEX_TIME_CHART_PRICE = "FHKST03030200";

    /**
     * 해외주식 상품 기본 정보
     * <p>[v1_해외주식-034]</p>
     */
    public static final String OVERSEAS_SEARCH_INFO = "CTPF1702R";

    /**
     * 해외주식 현재가 10호가
     * <p>[해외주식-033]</p>
     */
    public static final String OVERSEAS_ASKING_PRICE = "HHDFS76200100";
}
