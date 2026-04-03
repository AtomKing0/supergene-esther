package com.unity3d.ads.gatewayclient;

import com.google.protobuf.InvalidProtocolBufferException;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.ui.a;
import gatewayprotocol.v1.ErrorKt;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.UniversalResponseKt;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import l9.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q9.j;
import v8.y;

/* JADX INFO: compiled from: CommonGatewayClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonGatewayClient implements GatewayClient {
    public static final int CODE_400 = 400;
    public static final int CODE_599 = 599;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String RETRY_ATTEMPT_HEADER = "X-RETRY-ATTEMPT";

    @NotNull
    private final HandleGatewayUniversalResponse handleGatewayUniversalResponse;

    @NotNull
    private final HttpClient httpClient;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: compiled from: CommonGatewayClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonGatewayClient.kt */
    @f(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", l = {94, 103, 110}, m = a.REQUEST_KEY_EXTRA)
    static final class AnonymousClass1 extends d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonGatewayClient.this.request(null, null, null, null, this);
        }
    }

    public CommonGatewayClient(@NotNull HttpClient httpClient, @NotNull HandleGatewayUniversalResponse handleGatewayUniversalResponse, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull SessionRepository sessionRepository) {
        t.i(httpClient, "httpClient");
        t.i(handleGatewayUniversalResponse, "handleGatewayUniversalResponse");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(sessionRepository, "sessionRepository");
        this.httpClient = httpClient;
        this.handleGatewayUniversalResponse = handleGatewayUniversalResponse;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sessionRepository = sessionRepository;
    }

    private final long calculateDelayTime(RequestPolicy requestPolicy, int i10) {
        long jCalculateExponentialBackoff = calculateExponentialBackoff(requestPolicy.getRetryWaitBase(), i10);
        return jCalculateExponentialBackoff + calculateJitter(jCalculateExponentialBackoff, requestPolicy.getRetryJitterPct());
    }

    private final long calculateExponentialBackoff(int i10, int i11) {
        return ((long) i10) * ((long) Math.pow(2.0d, i11));
    }

    private final long calculateJitter(long j10, float f10) {
        long j11 = (long) (j10 * f10);
        return c.f30972a.h(-j11, j11 + 1);
    }

    private final UniversalResponseOuterClass.UniversalResponse getUniversalResponse(HttpResponse httpResponse, OperationType operationType) {
        try {
            Object body = httpResponse.getBody();
            if (body instanceof byte[]) {
                UniversalResponseOuterClass.UniversalResponse from = UniversalResponseOuterClass.UniversalResponse.parseFrom((byte[]) body);
                t.h(from, "parseFrom(responseBody)");
                return from;
            }
            if (!(body instanceof String)) {
                throw new InvalidProtocolBufferException("Could not parse response from gateway service");
            }
            byte[] bytes = ((String) body).getBytes(p9.d.f32957g);
            t.h(bytes, "this as java.lang.String).getBytes(charset)");
            UniversalResponseOuterClass.UniversalResponse from2 = UniversalResponseOuterClass.UniversalResponse.parseFrom(bytes);
            t.h(from2, "parseFrom(\n             …8859_1)\n                )");
            return from2;
        } catch (InvalidProtocolBufferException e10) {
            DeviceLog.debug("Failed to parse response from gateway service with exception: %s", e10.getLocalizedMessage());
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_parse_failure", null, r0.j(y.a("operation", operationType.toString()), y.a("reason", "protobuf_parsing"), y.a("reason_debug", httpResponse.getBody().toString())), null, null, 26, null);
            UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
            UniversalResponseOuterClass.UniversalResponse.Builder builderNewBuilder = UniversalResponseOuterClass.UniversalResponse.newBuilder();
            t.h(builderNewBuilder, "newBuilder()");
            UniversalResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
            ErrorKt.Dsl.Companion companion2 = ErrorKt.Dsl.Companion;
            ErrorOuterClass.Error.Builder builderNewBuilder2 = ErrorOuterClass.Error.newBuilder();
            t.h(builderNewBuilder2, "newBuilder()");
            ErrorKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
            dsl_create2.setErrorText("ERROR: Could not parse response from gateway service");
            dsl_create.setError(dsl_create2._build());
            return dsl_create._build();
        }
    }

    private final void sendNetworkErrorDiagnosticEvent(UnityAdsNetworkException unityAdsNetworkException, int i10, OperationType operationType, j jVar) {
        if (operationType == OperationType.UNIVERSAL_EVENT) {
            return;
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_failure_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(jVar)), r0.l(y.a("operation", operationType.toString()), y.a("retries", String.valueOf(i10)), y.a("protocol", String.valueOf(unityAdsNetworkException.getProtocol())), y.a("network_client", String.valueOf(unityAdsNetworkException.getClient())), y.a("reason_code", String.valueOf(unityAdsNetworkException.getCode())), y.a("reason_debug", unityAdsNetworkException.getMessage())), null, null, 24, null);
    }

    private final void sendNetworkSuccessDiagnosticEvent(HttpResponse httpResponse, int i10, OperationType operationType, j jVar) {
        if (operationType == OperationType.UNIVERSAL_EVENT) {
            return;
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(jVar)), r0.l(y.a("operation", operationType.toString()), y.a("retries", String.valueOf(i10)), y.a("protocol", httpResponse.getProtocol()), y.a("network_client", httpResponse.getClient()), y.a("reason_code", String.valueOf(httpResponse.getStatusCode()))), null, null, 24, null);
    }

    private final boolean shouldRetry(int i10) {
        return 400 <= i10 && i10 < 600;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:69|27|(1:29)|30|80|31|32|72|33|(1:35)(9:36|78|37|38|76|39|40|52|(2:54|(2:56|(1:58)(2:59|60))(2:61|62))(2:63|(1:65)(3:66|67|(2:70|71)(0))))) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:36|(1:78)|37|38|76|39|40|52|(2:54|(2:56|(1:58)(2:59|60))(2:61|62))(2:63|(1:65)(3:66|67|(2:70|71)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x017b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0180, code lost:
    
        r1 = r0;
        r0 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0184, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0186, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0187, code lost:
    
        r42 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0189, code lost:
    
        r1 = r0;
        r2 = r8;
        r0 = r42;
        r5 = r3;
        r3 = r9;
        r8 = r5;
        r39 = r14;
        r14 = r4;
        r4 = r11;
        r11 = r12;
        r13 = r39;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x022f -> B:67:0x0240). Please report as a decompilation issue!!! */
    @Override // com.unity3d.ads.gatewayclient.GatewayClient
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object request(@org.jetbrains.annotations.NotNull java.lang.String r42, @org.jetbrains.annotations.NotNull gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest r43, @org.jetbrains.annotations.NotNull com.unity3d.ads.gatewayclient.RequestPolicy r44, @org.jetbrains.annotations.NotNull com.unity3d.ads.core.data.model.OperationType r45, @org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse> r46) throws com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException {
        /*
            Method dump skipped, instruction units count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.gatewayclient.CommonGatewayClient.request(java.lang.String, gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest, com.unity3d.ads.gatewayclient.RequestPolicy, com.unity3d.ads.core.data.model.OperationType, z8.d):java.lang.Object");
    }
}
