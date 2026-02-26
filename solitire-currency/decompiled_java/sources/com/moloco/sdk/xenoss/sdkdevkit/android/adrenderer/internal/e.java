package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> a(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adm, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        return new b(context, customUserEventBuilderService, adm, externalLinkHandler, watermark);
    }
}
