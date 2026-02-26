package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.GetByteStringId;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetOperativeEventRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetOperativeEventRequest {

    @NotNull
    private final CampaignRepository campaignRepository;

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final GetByteStringId generateByteStringId;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetOperativeEventRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.events.GetOperativeEventRequest", f = "GetOperativeEventRequest.kt", l = {35}, m = "invoke")
    static final class AnonymousClass1 extends d {
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
            return GetOperativeEventRequest.this.invoke(null, null, null, null, null, this);
        }
    }

    public GetOperativeEventRequest(@NotNull GetByteStringId generateByteStringId, @NotNull DeviceInfoRepository deviceInfoRepository, @NotNull SessionRepository sessionRepository, @NotNull CampaignRepository campaignRepository) {
        t.i(generateByteStringId, "generateByteStringId");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(sessionRepository, "sessionRepository");
        t.i(campaignRepository, "campaignRepository");
        this.generateByteStringId = generateByteStringId;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.campaignRepository = campaignRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType r6, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r7, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r8, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventRequest> r11) {
        /*
            r5 = this;
            boolean r0 = r11 instanceof com.unity3d.ads.core.domain.events.GetOperativeEventRequest.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetOperativeEventRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$3
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r6 = (gatewayprotocol.v1.OperativeEventRequestKt.Dsl) r6
            java.lang.Object r7 = r0.L$2
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r7 = (gatewayprotocol.v1.OperativeEventRequestKt.Dsl) r7
            java.lang.Object r8 = r0.L$1
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r8 = (gatewayprotocol.v1.OperativeEventRequestKt.Dsl) r8
            java.lang.Object r9 = r0.L$0
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest r9 = (com.unity3d.ads.core.domain.events.GetOperativeEventRequest) r9
            v8.u.b(r11)
            goto L8e
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            v8.u.b(r11)
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl$Companion r11 = gatewayprotocol.v1.OperativeEventRequestKt.Dsl.Companion
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventRequest$Builder r2 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventRequest.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.t.h(r2, r4)
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r11 = r11._create(r2)
            com.unity3d.ads.core.domain.GetByteStringId r2 = r5.generateByteStringId
            com.google.protobuf.ByteString r2 = r2.invoke()
            r11.setEventId(r2)
            r11.setEventType(r6)
            r11.setImpressionOpportunityId(r8)
            r11.setTrackingToken(r7)
            r11.setAdditionalData(r9)
            if (r10 == 0) goto L6d
            r11.setSid(r10)
        L6d:
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r6 = r5.deviceInfoRepository
            gatewayprotocol.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r6 = r6.getDynamicDeviceInfo()
            r11.setDynamicDeviceInfo(r6)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r6 = r5.deviceInfoRepository
            r0.L$0 = r5
            r0.L$1 = r11
            r0.L$2 = r11
            r0.L$3 = r11
            r0.label = r3
            java.lang.Object r6 = r6.staticDeviceInfo(r0)
            if (r6 != r1) goto L89
            return r1
        L89:
            r9 = r5
            r7 = r11
            r8 = r7
            r11 = r6
            r6 = r8
        L8e:
            gatewayprotocol.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r11 = (gatewayprotocol.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r11
            r6.setStaticDeviceInfo(r11)
            com.unity3d.ads.core.data.repository.SessionRepository r6 = r9.sessionRepository
            gatewayprotocol.v1.SessionCountersOuterClass$SessionCounters r6 = r6.getSessionCounters()
            r7.setSessionCounters(r6)
            com.unity3d.ads.core.data.repository.CampaignRepository r6 = r9.campaignRepository
            gatewayprotocol.v1.CampaignStateOuterClass$CampaignState r6 = r6.getCampaignState()
            r7.setCampaignState(r6)
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventRequest r6 = r8._build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetOperativeEventRequest.invoke(gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType, com.google.protobuf.ByteString, com.google.protobuf.ByteString, com.google.protobuf.ByteString, java.lang.String, z8.d):java.lang.Object");
    }
}
