package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    @NotNull
    public static final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k> a(@NotNull c cVar, @NotNull j mraidFullscreenContentController, int i10, @NotNull Context context, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        kotlin.jvm.internal.t.i(mraidFullscreenContentController, "mraidFullscreenContentController");
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k[] kVarArr = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k[2];
        kVarArr[0] = new k.d(mraidFullscreenContentController);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s sVarB = cVar.b();
        kVarArr[1] = sVarB != null ? new k.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.c(sVarB, null, c0.c(n9.o.e(i10, 0)), context, customUserEventBuilderService, externalLinkHandler, null)) : null;
        return kotlin.collections.v.p(kVarArr);
    }
}
