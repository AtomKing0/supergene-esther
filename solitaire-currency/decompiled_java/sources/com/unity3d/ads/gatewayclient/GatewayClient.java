package com.unity3d.ads.gatewayclient;

import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.services.UnityAdsConstants;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: GatewayClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GatewayClient {

    /* JADX INFO: compiled from: GatewayClient.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object request$default(GatewayClient gatewayClient, String str, UniversalRequestOuterClass.UniversalRequest universalRequest, RequestPolicy requestPolicy, OperationType operationType, d dVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
            }
            if ((i10 & 1) != 0) {
                str = UnityAdsConstants.DefaultUrls.GATEWAY_URL;
            }
            String str2 = str;
            if ((i10 & 8) != 0) {
                operationType = OperationType.UNKNOWN;
            }
            return gatewayClient.request(str2, universalRequest, requestPolicy, operationType, dVar);
        }
    }

    @Nullable
    Object request(@NotNull String str, @NotNull UniversalRequestOuterClass.UniversalRequest universalRequest, @NotNull RequestPolicy requestPolicy, @NotNull OperationType operationType, @NotNull d<? super UniversalResponseOuterClass.UniversalResponse> dVar);
}
