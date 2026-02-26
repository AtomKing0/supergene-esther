package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidGetInitializationRequestPayload.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidGetInitializationRequestPayload implements GetInitializationRequestPayload {

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final GetClientInfo getClientInfo;

    @NotNull
    private final LegacyUserConsentRepository legacyUserConsentRepository;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidGetInitializationRequestPayload.kt */
    @f(c = "com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload", f = "AndroidGetInitializationRequestPayload.kt", l = {22, 30, 31, 42, 47, 52, 57}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
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
            return AndroidGetInitializationRequestPayload.this.invoke(this);
        }
    }

    public AndroidGetInitializationRequestPayload(@NotNull GetClientInfo getClientInfo, @NotNull SessionRepository sessionRepository, @NotNull DeviceInfoRepository deviceInfoRepository, @NotNull LegacyUserConsentRepository legacyUserConsentRepository) {
        t.i(getClientInfo, "getClientInfo");
        t.i(sessionRepository, "sessionRepository");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(legacyUserConsentRepository, "legacyUserConsentRepository");
        this.getClientInfo = getClientInfo;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.legacyUserConsentRepository = legacyUserConsentRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0258 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0296 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.unity3d.ads.core.domain.GetInitializationRequestPayload
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super gatewayprotocol.v1.InitializationRequestOuterClass.InitializationRequest> r24) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload.invoke(z8.d):java.lang.Object");
    }
}
