package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    @NotNull
    public static final j<e, f> a(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @Nullable g gVar, @NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull z externalLinkHandler, @NotNull r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.f(context, customUserEventBuilderService, gVar, bid, externalLinkHandler, watermark);
    }

    public static /* synthetic */ j b(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, g gVar, com.moloco.sdk.internal.ortb.model.c cVar, z zVar, r rVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            gVar = null;
        }
        return a(context, aVar, gVar, cVar, zVar, rVar);
    }
}
