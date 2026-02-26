package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HandleAndroidGatewayUniversalResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HandleAndroidGatewayUniversalResponse implements HandleGatewayUniversalResponse {

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: HandleAndroidGatewayUniversalResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse", f = "HandleAndroidGatewayUniversalResponse.kt", l = {36, 42, 45}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
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
            return HandleAndroidGatewayUniversalResponse.this.invoke(null, this);
        }
    }

    public HandleAndroidGatewayUniversalResponse(@NotNull SessionRepository sessionRepository, @NotNull DeviceInfoRepository deviceInfoRepository) {
        t.i(sessionRepository, "sessionRepository");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.HandleGatewayUniversalResponse
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse r9, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r10) throws com.unity3d.ads.core.data.model.exception.GatewayException {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse.invoke(gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse, z8.d):java.lang.Object");
    }
}
