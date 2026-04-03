package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetAndroidAdPlayerContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidAdPlayerContext {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String KEY_GAME_ID = "gameId";

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: compiled from: GetAndroidAdPlayerContext.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.GetAndroidAdPlayerContext$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAndroidAdPlayerContext.kt */
    @f(c = "com.unity3d.ads.core.domain.GetAndroidAdPlayerContext", f = "GetAndroidAdPlayerContext.kt", l = {15}, m = "invoke")
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
            return GetAndroidAdPlayerContext.this.invoke(this);
        }
    }

    public GetAndroidAdPlayerContext(@NotNull DeviceInfoRepository deviceInfoRepository, @NotNull SessionRepository sessionRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(sessionRepository, "sessionRepository");
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r7) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidAdPlayerContext.invoke(z8.d):java.lang.Object");
    }
}
