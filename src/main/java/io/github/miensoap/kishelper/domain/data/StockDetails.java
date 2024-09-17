package io.github.miensoap.kishelper.domain.data;

import com.google.gson.annotations.SerializedName;

public record StockDetails(
        @SerializedName("std_pdno") String standardProductNumber,            // 표준상품번호 (ISIN)
        @SerializedName("prdt_name") String productName,                     // 상품명
        @SerializedName("prdt_eng_name") String englishName,                 // 상품영문명
        @SerializedName("prdt_clsf_cd") String productClassificationCode,    // 상품분류코드
        @SerializedName("prdt_clsf_name") String productClassificationName,  // 상품분류명
        @SerializedName("prdt_type_cd_2") String productTypeCode2,           // 상품유형코드2

        @SerializedName("natn_cd") String countryCode,                       // 국가코드
        @SerializedName("natn_name") String countryName,                     // 국가명

        @SerializedName("tr_mket_cd") String marketCode,                     // 거래시장코드
        @SerializedName("tr_mket_name") String marketName,                   // 거래시장명

        @SerializedName("ovrs_excg_cd") String overseasExchangeCode,         // 해외거래소코드
        @SerializedName("ovrs_excg_name") String overseasExchangeName,       // 해외거래소명
        @SerializedName("ovrs_stck_dvsn_cd") String overseasStockDivisionCode, // 해외주식구분코드
        @SerializedName("ovrs_stck_prdt_grp_no") String overseasStockProductGroupNumber, // 해외주식상품그룹번호
        @SerializedName("ovrs_stck_erlm_rosn_cd") String overseasStockEnrollmentReasonCode, // 해외주식등록사유코드
        @SerializedName("ovrs_stck_hist_rght_dvsn_cd") String overseasStockHistoryRightDivisionCode, // 해외주식이력권리구분코드
        @SerializedName("ovrs_stck_etf_risk_drtp_cd") String overseasStockETFRiskIndicatorCode, // 해외주식ETF위험지표코드
        @SerializedName("ovrs_item_name") String overseasItemName,           // 해외종목명
        @SerializedName("ovrs_stck_stop_rson_cd") String overseasStockStopReasonCode, // 해외주식정지사유코드

        @SerializedName("sedol_no") String SEDOLNumber,                      // SEDOL번호
        @SerializedName("blbg_tckr_text") String bloombergTicker,            // 블룸버그티커내용
        @SerializedName("istt_usge_isin_cd") String institutionalUseISINCode, // 기관용도ISIN코드
        @SerializedName("lei_cd") String leiCode,                            // LEI코드

        @SerializedName("tr_crcy_cd") String tradingCurrencyCode,            // 거래통화코드
        @SerializedName("crcy_name") String currencyName,                    // 통화명
        @SerializedName("ovrs_papr") String overseasFaceValue,               // 해외액면가

        @SerializedName("sll_unit_qty") String sellUnitQuantity,             // 매도단위수량
        @SerializedName("buy_unit_qty") String buyUnitQuantity,              // 매수단위수량
        @SerializedName("tr_unit_amt") String tradeUnitAmount,               // 거래단위금액

        @SerializedName("lstg_stck_num") String listedStockNumber,           // 상장주식수
        @SerializedName("lstg_dt") String listingDate,                       // 상장일자
        @SerializedName("lstg_yn") String listingStatus,                     // 상장여부
        @SerializedName("lstg_abol_item_yn") String delisted,                // 상장폐지종목여부
        @SerializedName("lstg_abol_dt") String delistedDate,                 // 상장폐지일자

        @SerializedName("mint_svc_yn") String mintServiceStatus,             // MINT서비스여부
        @SerializedName("mint_svc_yn_chng_dt") String mintServiceChangeDate, // MINT서비스여부변경일자
        @SerializedName("mint_frst_svc_erlm_dt") String mintFirstServiceEnrollmentDate, // MINT최초서비스등록일자
        @SerializedName("mint_dcpt_trad_psbl_yn") String mintFractionalTradePossible, // MINT소수점매매가능여부
        @SerializedName("mint_fnum_trad_psbl_yn") String mintWholeNumberTradePossible, // MINT정수매매가능여부
        @SerializedName("mint_cblc_cvsn_ipsb_yn") String mintBalanceConversionImpossible, // MINT잔고전환불가여부

        @SerializedName("ptp_item_yn") String ptpItemStatus,                 // PTP종목여부
        @SerializedName("ptp_item_trfx_exmt_yn") String ptpItemTransferTaxExemptionStatus, // PTP종목양도세면제여부
        @SerializedName("ptp_item_trfx_exmt_strt_dt") String ptpItemTransferTaxExemptionStartDate, // PTP종목양도세면제시작일자
        @SerializedName("ptp_item_trfx_exmt_end_dt") String ptpItemTransferTaxExemptionEndDate, // PTP종목양도세면제종료일자

        @SerializedName("dtm_tr_psbl_yn") String daytimeTradePossible,       // 주간거래가능여부
        @SerializedName("sdrf_stop_ecls_yn") String suddenRiseFallStopExclusion, // 급등락정지제외여부
        @SerializedName("sdrf_stop_ecls_erlm_dt") String suddenRiseFallStopExclusionDate // 급등락정지제외등록일자
) {
}
