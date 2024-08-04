package io.github.miensoap.kishelper.data.request;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static io.github.miensoap.kishelper.data.consts.QueryParamKey.USER_AUTH_INFO;
import static io.github.miensoap.kishelper.data.consts.QueryParamValue.USER_AUTH_DEFAULT;

public class QueryParams {
    private final Map<String, String> parameters = new HashMap<>();

    public QueryParams addParam(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    /**
     * 기본정보 (사용자 인증 정보 공백) 을 추가한 뒤 unmodifiableMap 반환
     * @return QueryMap
     */
    public Map<String, String> build() {
        this.addParam(USER_AUTH_INFO, USER_AUTH_DEFAULT);
        return Collections.unmodifiableMap(this.parameters);
    }

    public String toString() {
        String paramString = this.parameters.entrySet().stream()
                .map((param) -> param.getKey() + "=" + param.getValue())
                .collect(Collectors.joining("&"));

        return "?" + paramString;
    }
}
