package com.unity3d.ads.core.domain;

import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetAndroidInitializationRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidInitializationRequest implements GetInitializationRequest {

    @NotNull
    private final GetInitializationRequestPayload getInitializationRequestPayload;

    @NotNull
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAndroidInitializationRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.GetAndroidInitializationRequest", f = "GetAndroidInitializationRequest.kt", l = {11, 15}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
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
            return GetAndroidInitializationRequest.this.invoke(this);
        }
    }

    public GetAndroidInitializationRequest(@NotNull GetInitializationRequestPayload getInitializationRequestPayload, @NotNull GetUniversalRequestForPayLoad getUniversalRequestForPayLoad) {
        t.i(getInitializationRequestPayload, "getInitializationRequestPayload");
        t.i(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        this.getInitializationRequestPayload = getInitializationRequestPayload;
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetInitializationRequest
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.unity3d.ads.core.domain.GetAndroidInitializationRequest.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r8)
            goto L75
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest r2 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest) r2
            v8.u.b(r8)
            goto L4d
        L3c:
            v8.u.b(r8)
            com.unity3d.ads.core.domain.GetInitializationRequestPayload r8 = r7.getInitializationRequestPayload
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.invoke(r0)
            if (r8 != r1) goto L4c
            return r1
        L4c:
            r2 = r7
        L4d:
            gatewayprotocol.v1.InitializationRequestOuterClass$InitializationRequest r8 = (gatewayprotocol.v1.InitializationRequestOuterClass.InitializationRequest) r8
            gatewayprotocol.v1.UniversalRequestKt r4 = gatewayprotocol.v1.UniversalRequestKt.INSTANCE
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r4 = gatewayprotocol.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r5 = gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            java.lang.String r6 = "newBuilder()"
            kotlin.jvm.internal.t.h(r5, r6)
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl r4 = r4._create(r5)
            r4.setInitializationRequest(r8)
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload r8 = r4._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r2 = r2.getUniversalRequestForPayLoad
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r8 = r2.invoke(r8, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidInitializationRequest.invoke(z8.d):java.lang.Object");
    }
}
