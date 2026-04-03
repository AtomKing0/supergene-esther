package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetCommonTransactionRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetCommonTransactionRequest implements GetTransactionRequest {

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.GetCommonTransactionRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetCommonTransactionRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.events.GetCommonTransactionRequest", f = "GetCommonTransactionRequest.kt", l = {14}, m = "invoke")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return GetCommonTransactionRequest.this.invoke(null, this);
        }
    }

    public GetCommonTransactionRequest(@NotNull DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        this.deviceInfoRepository = deviceInfoRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.events.GetTransactionRequest
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.util.List<gatewayprotocol.v1.TransactionEventRequestOuterClass.TransactionData> r6, @org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.TransactionEventRequestOuterClass.TransactionEventRequest> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.domain.events.GetCommonTransactionRequest.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.ads.core.domain.events.GetCommonTransactionRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetCommonTransactionRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.events.GetCommonTransactionRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetCommonTransactionRequest$invoke$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r6 = r0.L$4
            gatewayprotocol.v1.TransactionEventRequestKt$Dsl r6 = (gatewayprotocol.v1.TransactionEventRequestKt.Dsl) r6
            java.lang.Object r1 = r0.L$3
            gatewayprotocol.v1.TransactionEventRequestKt$Dsl r1 = (gatewayprotocol.v1.TransactionEventRequestKt.Dsl) r1
            java.lang.Object r2 = r0.L$2
            gatewayprotocol.v1.TransactionEventRequestKt$Dsl r2 = (gatewayprotocol.v1.TransactionEventRequestKt.Dsl) r2
            java.lang.Object r3 = r0.L$1
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.events.GetCommonTransactionRequest r0 = (com.unity3d.ads.core.domain.events.GetCommonTransactionRequest) r0
            v8.u.b(r7)
            goto L72
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            v8.u.b(r7)
            gatewayprotocol.v1.TransactionEventRequestKt$Dsl$Companion r7 = gatewayprotocol.v1.TransactionEventRequestKt.Dsl.Companion
            gatewayprotocol.v1.TransactionEventRequestOuterClass$TransactionEventRequest$Builder r2 = gatewayprotocol.v1.TransactionEventRequestOuterClass.TransactionEventRequest.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.t.h(r2, r4)
            gatewayprotocol.v1.TransactionEventRequestKt$Dsl r7 = r7._create(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r5.deviceInfoRepository
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r7
            r0.L$4 = r7
            r0.label = r3
            java.lang.Object r0 = r2.staticDeviceInfo(r0)
            if (r0 != r1) goto L6c
            return r1
        L6c:
            r3 = r6
            r6 = r7
            r1 = r6
            r2 = r1
            r7 = r0
            r0 = r5
        L72:
            gatewayprotocol.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r7 = (gatewayprotocol.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r7
            r6.setStaticDeviceInfo(r7)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r6 = r0.deviceInfoRepository
            gatewayprotocol.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r6 = r6.getDynamicDeviceInfo()
            r1.setDynamicDeviceInfo(r6)
            gatewayprotocol.v1.TransactionEventRequestOuterClass$StoreType r6 = gatewayprotocol.v1.TransactionEventRequestOuterClass.StoreType.STORE_TYPE_GOOGLE_PLAY
            r1.setAppStore(r6)
            com.google.protobuf.kotlin.DslList r6 = r1.getTransactionData()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r1.addAllTransactionData(r6, r3)
            gatewayprotocol.v1.TransactionEventRequestOuterClass$TransactionEventRequest r6 = r2._build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetCommonTransactionRequest.invoke(java.util.List, z8.d):java.lang.Object");
    }
}
