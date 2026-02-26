package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetAndroidInitializationCompletedRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidInitializationCompletedRequest implements GetInitializationCompletedRequest {

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAndroidInitializationCompletedRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest", f = "GetAndroidInitializationCompletedRequest.kt", l = {16, 24}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return GetAndroidInitializationCompletedRequest.this.invoke(this);
        }
    }

    public GetAndroidInitializationCompletedRequest(@NotNull GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, @NotNull DeviceInfoRepository deviceInfoRepository) {
        t.i(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.deviceInfoRepository = deviceInfoRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetInitializationCompletedRequest
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            java.lang.String r3 = "newBuilder()"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            v8.u.b(r9)
            goto Lad
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L37:
            java.lang.Object r2 = r0.L$3
            gatewayprotocol.v1.InitializationCompletedEventRequestKt$Dsl r2 = (gatewayprotocol.v1.InitializationCompletedEventRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$2
            gatewayprotocol.v1.InitializationCompletedEventRequestKt$Dsl r5 = (gatewayprotocol.v1.InitializationCompletedEventRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$1
            gatewayprotocol.v1.InitializationCompletedEventRequestKt$Dsl r6 = (gatewayprotocol.v1.InitializationCompletedEventRequestKt.Dsl) r6
            java.lang.Object r7 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest r7 = (com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest) r7
            v8.u.b(r9)
            goto L71
        L4b:
            v8.u.b(r9)
            gatewayprotocol.v1.InitializationCompletedEventRequestKt$Dsl$Companion r9 = gatewayprotocol.v1.InitializationCompletedEventRequestKt.Dsl.Companion
            gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass$InitializationCompletedEventRequest$Builder r2 = gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.newBuilder()
            kotlin.jvm.internal.t.h(r2, r3)
            gatewayprotocol.v1.InitializationCompletedEventRequestKt$Dsl r2 = r9._create(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r9 = r8.deviceInfoRepository
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r5
            java.lang.Object r9 = r9.staticDeviceInfo(r0)
            if (r9 != r1) goto L6e
            return r1
        L6e:
            r7 = r8
            r5 = r2
            r6 = r5
        L71:
            gatewayprotocol.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r9 = (gatewayprotocol.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r9
            r2.setStaticDeviceInfo(r9)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r9 = r7.deviceInfoRepository
            gatewayprotocol.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r9 = r9.getDynamicDeviceInfo()
            r5.setDynamicDeviceInfo(r9)
            gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass$InitializationCompletedEventRequest r9 = r6._build()
            gatewayprotocol.v1.UniversalRequestKt r2 = gatewayprotocol.v1.UniversalRequestKt.INSTANCE
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r2 = gatewayprotocol.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r5 = gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            kotlin.jvm.internal.t.h(r5, r3)
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl r2 = r2._create(r5)
            r2.setInitializationCompletedEventRequest(r9)
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload r9 = r2._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r2 = r7.getUniversalRequestForPayLoad
            r3 = 0
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r0.label = r4
            java.lang.Object r9 = r2.invoke(r9, r0)
            if (r9 != r1) goto Lad
            return r1
        Lad:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest.invoke(z8.d):java.lang.Object");
    }
}
