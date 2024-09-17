package io.github.miensoap.kishelper.core;


import io.github.miensoap.kishelper.data.Response.AccessTokenResponse;
import io.github.miensoap.kishelper.data.Response.StockQuotationsResponse;
import io.github.miensoap.kishelper.data.consts.Exchange;
import io.github.miensoap.kishelper.data.request.ApiAuth;
import io.github.miensoap.kishelper.domain.Stock;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FeignExceptionUtil;

import java.time.LocalDateTime;
import java.util.Map;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.anyMap;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClientTest {

    private Client kisClient;
    private KoreaInvestmentApi kisMock;

    @BeforeEach
    void setUp() {
        ApiAuth expiredAuth = new ApiAuth(
                "", "", "expired token"
        );
        kisMock = mock(KoreaInvestmentApi.class);
        AccessTokenResponse tokenResponseMock = mock(AccessTokenResponse.class);

        when(tokenResponseMock.getAccessToken()).thenReturn("valid token");
        when(tokenResponseMock.getExpireTime()).thenReturn(LocalDateTime.MAX);
        when(kisMock.getToken(nullable(String.class), nullable(String.class)))
                .thenReturn(tokenResponseMock);

        kisClient = new KISClient(expiredAuth, kisMock);
        kisClient = KISClient.createProxy(kisClient);
    }

    @DisplayName("API 호출중 토큰 만료 예외가 발생했다면 토큰을 다시 발급받은 후 다시 시도한다.")
    @Test
    void testMethodRetryAfterTokenRefresh() {
        doAnswer(invocation -> {
            Map<String, String> headers = invocation.getArgument(1);
            if ("Bearer valid token".equals(headers.get("authorization"))) {
                return new StockQuotationsResponse();
            } else {
                throw FeignExceptionUtil.createTokenExpireError();
            }
        }).when(kisMock).getOverseasPeriodPrice(anyMap(), anyMap());

        kisClient.getOverseasPeriodPrice("exchange", "symbol", "period", "20230101", true);

        verify(kisMock, times(2)).getOverseasPeriodPrice(anyMap(), anyMap());
        verify(kisMock, times(1)).getToken(anyString(), anyString());
    }

    @DisplayName("API 호출중 토큰 만료 예외가 발생했다면 토큰을 다시 발급받는다.")
    @Test
    void testAccessTokenRefreshedBeforeRetry() {
        doAnswer(invocation -> {
            Map<String, String> headers = invocation.getArgument(1);
            if ("Bearer valid token".equals(headers.get("authorization"))) {
                return new StockQuotationsResponse();
            } else {
                throw FeignExceptionUtil.createTokenExpireError();
            }
        }).when(kisMock).getOverseasPeriodPrice(anyMap(), anyMap());

        kisClient.getOverseasPeriodPrice("exchange", "symbol", "period", "20230101", true);

        verify(kisMock, times(1)).getToken(anyString(), anyString());
    }

    @DisplayName("예외가 발생하지 않으면 다시 시도하지 않는다.")
    @Test
    void testNoRetryWhenNoException() {
        when(kisMock.getOverseasPeriodPrice(anyMap(), anyMap()))
                .thenReturn(new StockQuotationsResponse());

        kisClient.getOverseasPeriodPrice("exchange", "symbol", "period", "20230101", true);

        verify(kisMock, times(1)).getOverseasPeriodPrice(anyMap(), anyMap());
    }
}
