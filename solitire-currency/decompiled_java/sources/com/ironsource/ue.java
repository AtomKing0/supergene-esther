package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ue {
    @NotNull
    public final String a() {
        String OMID_LIB_VERSION = zm.f16439f;
        kotlin.jvm.internal.t.h(OMID_LIB_VERSION, "OMID_LIB_VERSION");
        return OMID_LIB_VERSION;
    }

    @NotNull
    public final String b() {
        return zm.f16438e;
    }

    @NotNull
    public final String c() {
        String sDKVersion = SDKUtils.getSDKVersion();
        kotlin.jvm.internal.t.h(sDKVersion, "getSDKVersion()");
        return sDKVersion;
    }
}
