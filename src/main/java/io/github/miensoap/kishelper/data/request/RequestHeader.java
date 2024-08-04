package io.github.miensoap.kishelper.data.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Builder
public class RequestHeader {
    @SerializedName("content-type")
    private String contentType; // 컨텐츠타입

    @SerializedName("authorization")
    private String authorization; // 접근토큰

    @SerializedName("appkey")
    private String appKey; // 앱키

    @SerializedName("appsecret")
    private String appSecret; // 앱시크릿키

    @SerializedName("personalseckey")
    private String personalSecurityKey; // 고객식별키 (Optional)

    @SerializedName("tr_id")
    private String tradingId; // 거래 ID

    @SerializedName("tr_cont")
    private String tradingContinue; // 연속 거래 여부 (Optional)

    @SerializedName("custtype")
    private String customerType; // 고객 타입 (Optional)

    @SerializedName("seq_no")
    private String sequenceNumber; // 일련번호 (Optional)

    @SerializedName("mac_address")
    private String macAddress; // 맥주소 (Optional)

    @SerializedName("phone_number")
    private String phoneNumber; // 핸드폰번호 (Optional)

    @SerializedName("ip_addr")
    private String ipAddress; // 접속 단말 공인 IP (Optional)

    @SerializedName("hashkey")
    private String hashKey; // 해쉬키 (Optional)

    @SerializedName("gt_uid")
    private String globalUID; // Global UID (Optional)


    public static RequestHeaderBuilder basicBuilder(ApiAuth auth) {
        return RequestHeader.builder()
                .contentType("application/json")
                .appKey(auth.getAppKey())
                .appSecret(auth.getAppSecret())
                .customerType("P")
                .authorization(auth.getAccessToken());
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(this);
                if (value != null) {
                    SerializedName annotation = field.getAnnotation(SerializedName.class);
                    map.put(annotation != null ? annotation.value() : field.getName(), value.toString());
                }
            } catch (IllegalAccessException e) {
                System.out.println("[RequestHeader] Fail to add " + field.getName());
            }
        }
        return map;
    }
}
