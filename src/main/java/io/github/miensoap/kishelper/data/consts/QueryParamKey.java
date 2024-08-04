package io.github.miensoap.kishelper.data.consts;

/**
 * QueryParamKey 클래스는 다양한 조회 조건에 사용되는 상수 필드를 정의합니다.
 */
public abstract class QueryParamKey {
    /**
     * 사용자 인증 정보
     */
    public static final String USER_AUTH_INFO = "AUTH";

    /**
     * 거래소 코드
     */
    public static final String EXCHANGE_CODE = "EXCD";

    /**
     * 주식 심볼
     */
    public static final String STOCK_SYMBOL = "SYMB";

    /**
     * 기간 구분 <p>
     * (0: 일, 1: 주, 2: 월)
     */
    public static final String PERIOD_DIVISION = "GUBN";

    /**
     * 조회 기준 일자 <p>
     * (YYYYMMDD) <p>
     * 공란 설정 시, 기준일은 오늘 날짜로 설정
     */
    public static final String INQUIRY_DATE = "BYMD";

    /**
     * 수정 주가 반영 여부 <p>
     * (0: 미반영, 1: 반영)
     */
    public static final String APPLY_MODIFIED_PRICE = "MODP";

    /**
     * 다음 키 버퍼
     */
    public static final String NEXT_KEY_BUFFER = "KEYB";

    /**
     * 기준 일자 <p>
     * (YYYYMMDD)
     */
    public static final String TRADE_DATE = "TRAD_DT";

    /**
     * 연속 조회 키
     */
    public static final String CONTINUOUS_QUERY_KEY = "CTX_AREA_NK";

    /**
     * 연속 조회 검색 조건
     */
    public static final String CONTINUOUS_QUERY_CONDITION = "CTX_AREA_FK";

    /**
     * 분 갭 <p>
     * (1: 1분봉, 2: 2분봉, ...)
     */
    public static final String MINUTE_GAP = "NMIN";

    /**
     * 전일 포함 여부 <p>
     * (0: 당일, 1: 전일 포함)
     */
    public static final String INCLUDE_PREVIOUS_DAY = "PINC";

    /**
     * 다음 여부
     */
    public static final String INCLUDE_NEXT = "NEXT";

    /**
     * 요청 갯수 <p>
     * (최대 120)
     */
    public static final String REQUEST_COUNT = "NREC";

    /**
     * 미체결 채움 구분
     */
    public static final String INCLUDE_UNFILLED = "FILL";

    /**
     * 상품 유형 코드 <p>
     * (예: 512 미국 나스닥)
     */
    public static final String PRODUCT_TYPE_CODE = "RDT_TYPE_CD";

    /**
     * 상품 번호 <p>
     * (예: AAPL)
     */
    public static final String PRODUCT_NUMBER = "PDNO";

    // ---------------------------------------------------------------------
    // FID (Field Identifier)

    /**
     * 시장 구분 코드 <p>
     * (N: 해외지수, X: 환율, I: 국채, S: 금선물)
     */
    public static final String FID_MARKET_DIVISION_CODE = "FID_COND_MRKT_DIV_CODE";

    /**
     * 종목코드 <p>
     * 해외주식 마스터 코드 참조
     */
    public static final String FID_INPUT_SYMBOL = "FID_INPUT_ISCD";

    /**
     * 입력 일자 1
     */
    public static final String FID_INPUT_DATE_1 = "FID_INPUT_DATE_1";

    /**
     * 입력 일자 2
     */
    public static final String FID_INPUT_DATE_2 = "FID_INPUT_DATE_2";

    /**
     * 기간 구분 코드 <p>
     * (D: 일, W: 주, M: 월, Y: 년)
     */
    public static final String FID_PERIOD_DIVISION_CODE = "FID_PERIOD_DIV_CODE";

    /**
     * 시간 구분 코드 <p>
     * (0: 정규장, 1: 시간외)
     */
    public static final String FID_HOUR_CLASSIFY_CODE = "FID_HOUR_CLS_CODE";

    /**
     * 과거 데이터 포함 여부
     * (Y/N)
     */
    public static final String FID_INCLUDE_PAST_DATA = "FID_PW_DATA_INCU_YN";

    // ---------------------------------------------------------------------
    // CO (Condition)

    /**
     * 현재가 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_CURRENT_PRICE = "CO_YN_PRICECUR";

    /**
     * 현재가 시작 범위
     */
    public static final String START_CURRENT_PRICE = "CO_ST_PRICECUR";

    /**
     * 현재가 끝 범위
     */
    public static final String END_CURRENT_PRICE = "CO_EN_PRICECUR";

    /**
     * 등락율 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_CHANGE_RATE = "CO_YN_RATE";

    /**
     * 등락율 시작율
     */
    public static final String START_CHANGE_RATE = "CO_ST_RATE";

    /**
     * 등락율 끝율
     */
    public static final String END_CHANGE_RATE = "CO_EN_RATE";

    /**
     * 시가 총액 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_MARKET_CAP = "CO_YN_VALX";

    /**
     * 시가 총액 시작액
     */
    public static final String START_MARKET_CAP = "CO_ST_VALX";

    /**
     * 시가 총액 끝액
     */
    public static final String END_MARKET_CAP = "CO_EN_VALX";

    /**
     * 발행 주식 수 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_SHARES_OUTSTANDING = "CO_YN_SHAR";

    /**
     * 발행 주식 시작 수
     */
    public static final String START_SHARES_OUTSTANDING = "CO_ST_SHAR";

    /**
     * 발행 주식 끝 수
     */
    public static final String END_SHARES_OUTSTANDING = "CO_EN_SHAR";

    /**
     * 거래량 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_VOLUME = "CO_YN_VOLUME";

    /**
     * 거래량 시작량
     */
    public static final String START_VOLUME = "CO_ST_VOLUME";

    /**
     * 거래량 끝량
     */
    public static final String END_VOLUME = "CO_EN_VOLUME";

    /**
     * 거래 대금 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_TRANSACTION_AMOUNT = "CO_YN_AMT";

    /**
     * 거래 대금 시작금
     */
    public static final String START_TRANSACTION_AMOUNT = "CO_ST_AMT";

    /**
     * 거래 대금 끝금
     */
    public static final String END_TRANSACTION_AMOUNT = "CO_EN_AMT";

    /**
     * EPS 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_EPS = "CO_YN_EPS";

    /**
     * EPS 시작
     */
    public static final String START_EPS = "CO_ST_EPS";

    /**
     * EPS 끝
     */
    public static final String END_EPS = "CO_EN_EPS";

    /**
     * PER 선택 조건 <p>
     * (해당 조건 사용 시: 1, 미사용 시: 필수 항목 아님)
     */
    public static final String INCLUDE_PER = "CO_YN_PER";

    /**
     * PER 시작
     */
    public static final String START_PER = "CO_ST_PER";

    /**
     * PER 끝
     */
    public static final String END_PER = "CO_EN_PER";
}
