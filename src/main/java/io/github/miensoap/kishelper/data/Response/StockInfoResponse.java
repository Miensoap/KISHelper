package io.github.miensoap.kishelper.data.Response;

import com.google.gson.annotations.SerializedName;
import io.github.miensoap.kishelper.domain.data.StockDetails;

public record StockInfoResponse(
        @SerializedName("rt_cd") String resultCode,                           // 성공 실패 여부
        @SerializedName("msg_cd") String responseCode,                        // 응답코드
        @SerializedName("msg1") String responseMessage,                       // 응답메세지
        @SerializedName("output") StockDetails stockDetails                  // 응답상세1
) {
}

