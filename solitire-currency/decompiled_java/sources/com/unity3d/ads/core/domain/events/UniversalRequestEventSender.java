package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.gatewayclient.GatewayClient;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UniversalRequestEventSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestEventSender {

    @NotNull
    private final GatewayClient gatewayClient;

    @NotNull
    private final HandleGatewayEventResponse handleGatewayEventResponse;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.UniversalRequestEventSender$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversalRequestEventSender.kt */
    @f(c = "com.unity3d.ads.core.domain.events.UniversalRequestEventSender", f = "UniversalRequestEventSender.kt", l = {15, 21}, m = "invoke")
    static final class AnonymousClass1 extends d {
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
            return UniversalRequestEventSender.this.invoke(null, null, this);
        }
    }

    public UniversalRequestEventSender(@NotNull GatewayClient gatewayClient, @NotNull HandleGatewayEventResponse handleGatewayEventResponse) {
        t.i(gatewayClient, "gatewayClient");
        t.i(handleGatewayEventResponse, "handleGatewayEventResponse");
        this.gatewayClient = gatewayClient;
        this.handleGatewayEventResponse = handleGatewayEventResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest r12, @org.jetbrains.annotations.NotNull com.unity3d.ads.gatewayclient.RequestPolicy r13, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.events.UniversalRequestEventSender.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.unity3d.ads.core.domain.events.UniversalRequestEventSender$invoke$1 r0 = (com.unity3d.ads.core.domain.events.UniversalRequestEventSender.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.events.UniversalRequestEventSender$invoke$1 r0 = new com.unity3d.ads.core.domain.events.UniversalRequestEventSender$invoke$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r9 = a9.b.e()
            int r1 = r0.label
            r10 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L34
            if (r1 != r10) goto L2c
            v8.u.b(r14)
            goto L66
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L34:
            java.lang.Object r12 = r0.L$0
            com.unity3d.ads.core.domain.events.UniversalRequestEventSender r12 = (com.unity3d.ads.core.domain.events.UniversalRequestEventSender) r12
            v8.u.b(r14)
            goto L56
        L3c:
            v8.u.b(r14)
            com.unity3d.ads.gatewayclient.GatewayClient r1 = r11.gatewayClient
            r14 = 0
            com.unity3d.ads.core.data.model.OperationType r5 = com.unity3d.ads.core.data.model.OperationType.UNIVERSAL_EVENT
            r7 = 1
            r8 = 0
            r0.L$0 = r11
            r0.label = r2
            r2 = r14
            r3 = r12
            r4 = r13
            r6 = r0
            java.lang.Object r14 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r14 != r9) goto L55
            return r9
        L55:
            r12 = r11
        L56:
            gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse r14 = (gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r14
            com.unity3d.ads.core.domain.events.HandleGatewayEventResponse r12 = r12.handleGatewayEventResponse
            r13 = 0
            r0.L$0 = r13
            r0.label = r10
            java.lang.Object r12 = r12.invoke(r14, r0)
            if (r12 != r9) goto L66
            return r9
        L66:
            v8.k0 r12 = v8.k0.f35197a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.UniversalRequestEventSender.invoke(gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest, com.unity3d.ads.gatewayclient.RequestPolicy, z8.d):java.lang.Object");
    }
}
