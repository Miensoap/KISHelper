package soap.kis.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RequestHeader {
    private String contentType = "application/json"; // 컨텐츠타입
    private String authorization; // 접근토큰
    private String appkey; // 앱키
    private String appsecret; // 앱시크릿키
    private String personalseckey; // 고객식별키 (Optional)
    private String trId; // 거래ID
    private String trCont; // 연속 거래 여부 (Optional)
    private String custtype; // 고객 타입 (Optional)
    private String seqNo; // 일련번호 (Optional)
    private String macAddress; // 맥주소 (Optional)
    private String phoneNumber; // 핸드폰번호 (Optional)
    private String ipAddr; // 접속 단말 공인 IP (Optional)
    private String hashkey; // 해쉬키 (Optional)
    private String gtUid; // Global UID (Optional)
}
