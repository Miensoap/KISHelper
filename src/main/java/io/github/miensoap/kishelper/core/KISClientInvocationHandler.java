package io.github.miensoap.kishelper.core;

import feign.FeignException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * API 요청 에러 응답시 새로운 토큰으로 재시도
 */
public class KISClientInvocationHandler implements InvocationHandler {
    private final Client target;

    public KISClientInvocationHandler(Client target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();

            if (cause instanceof FeignException) {
                return handleFeignException((FeignException) cause, method, args);
            }
            throw cause;
        }
    }

    private Object handleFeignException(FeignException e, Method method, Object[] args) throws Throwable {
        if (e.responseBody().isEmpty()) throw e;

        String responseBody = decodeResponseBody(e.responseBody().get());
        if (!isAccessTokenExpired(responseBody)) throw e;

        return reTryAfterRefreshingToken(method, args);
    }

    private Object reTryAfterRefreshingToken(Method method, Object[] args) throws Throwable {
        System.out.println("AccessToken expired. Refreshing token and retrying...");
        target.getAccessToken();
        return method.invoke(target, args);
    }

    // Todo. ErrorDecoder 구현
    private String decodeResponseBody(ByteBuffer byteBuffer) {
        return StandardCharsets.UTF_8.decode(byteBuffer).toString();
    }

    private boolean isAccessTokenExpired(String responseBody) {
        return responseBody.contains("EGW00123");
    }
}


