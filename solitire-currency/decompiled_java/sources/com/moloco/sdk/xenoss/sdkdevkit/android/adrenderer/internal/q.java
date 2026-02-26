package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f19696a = new q();

    public final boolean a(@NotNull String adm) {
        kotlin.jvm.internal.t.i(adm, "adm");
        return p9.r.N(adm, com.vungle.ads.internal.l.AD_MRAID_JS_FILE_NAME, true);
    }

    public final boolean b(@NotNull String adm) {
        kotlin.jvm.internal.t.i(adm, "adm");
        return p9.r.N(adm, "<VAST", true);
    }

    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g c(@NotNull String adm) {
        kotlin.jvm.internal.t.i(adm, "adm");
        return b(adm) ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.VAST : a(adm) ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.MRAID : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.STATIC;
    }
}
