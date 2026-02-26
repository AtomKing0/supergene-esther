package com.unity3d.ads.core.domain;

import com.unity3d.ads.gatewayclient.GatewayClient;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TriggerAndroidInitializationCompletedRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TriggerAndroidInitializationCompletedRequest implements TriggerInitializationCompletedRequest {

    @NotNull
    private final GatewayClient gatewayClient;

    @NotNull
    private final GetInitializationCompletedRequest getInitializationCompletedRequest;

    @NotNull
    private final GetRequestPolicy getRequestPolicy;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: TriggerAndroidInitializationCompletedRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest", f = "TriggerAndroidInitializationCompletedRequest.kt", l = {33, 35}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
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
            return TriggerAndroidInitializationCompletedRequest.this.invoke(this);
        }
    }

    public TriggerAndroidInitializationCompletedRequest(@NotNull GetInitializationCompletedRequest getInitializationCompletedRequest, @NotNull GetRequestPolicy getRequestPolicy, @NotNull GatewayClient gatewayClient, @NotNull SendDiagnosticEvent sendDiagnosticEvent) {
        t.i(getInitializationCompletedRequest, "getInitializationCompletedRequest");
        t.i(getRequestPolicy, "getRequestPolicy");
        t.i(gatewayClient, "gatewayClient");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.getInitializationCompletedRequest = getInitializationCompletedRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.gatewayClient = gatewayClient;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc A[Catch: Exception -> 0x0112, TRY_LEAVE, TryCatch #5 {Exception -> 0x0112, blocks: (B:36:0x00c4, B:38:0x00cc), top: B:65:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r27) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest.invoke(z8.d):java.lang.Object");
    }
}
