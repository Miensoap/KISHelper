package util;

import feign.FeignException;
import feign.Request;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class FeignExceptionUtil {

    public static FeignException.InternalServerError createInternalServerError(String responseBody) {
        byte[] bodyBytes = responseBody.getBytes(StandardCharsets.UTF_8);

        Request request = Request.create(
                Request.HttpMethod.GET,
                "/test",
                Collections.emptyMap(),
                null,
                null,
                null
        );

        return new FeignException.InternalServerError(
                "Internal Server Error",
                request,
                bodyBytes,
                null
        );
    }

    public static FeignException.InternalServerError createTokenExpireError() {
        return createInternalServerError
                ("{\"errorCode\":\"EGW00123\",\"message\":\"Access Token expired\"}");
    }
}
