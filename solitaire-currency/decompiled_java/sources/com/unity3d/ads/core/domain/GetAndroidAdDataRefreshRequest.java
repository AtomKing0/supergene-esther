package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetAndroidAdDataRefreshRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidAdDataRefreshRequest implements GetAdDataRefreshRequest {

    @NotNull
    private final CampaignRepository campaignRepository;

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAndroidAdDataRefreshRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest", f = "GetAndroidAdDataRefreshRequest.kt", l = {25, 34}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
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
            return GetAndroidAdDataRefreshRequest.this.invoke(null, null, this);
        }
    }

    public GetAndroidAdDataRefreshRequest(@NotNull GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, @NotNull SessionRepository sessionRepository, @NotNull DeviceInfoRepository deviceInfoRepository, @NotNull CampaignRepository campaignRepository) {
        t.i(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        t.i(sessionRepository, "sessionRepository");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(campaignRepository, "campaignRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.campaignRepository = campaignRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetAdDataRefreshRequest
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r9, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r10, @org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest> r11) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest.invoke(com.google.protobuf.ByteString, com.google.protobuf.ByteString, z8.d):java.lang.Object");
    }
}
