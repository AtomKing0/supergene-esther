package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.service_locator.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class r {
    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q> a(@NotNull Context context, @NotNull com.moloco.sdk.internal.ortb.model.c bid, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, @NotNull u decLoader) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(loadVast, "loadVast");
        kotlin.jvm.internal.t.i(decLoader, "decLoader");
        return new p(context, bid, loadVast, decLoader, z10, watermark);
    }

    public static /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j b(Context context, com.moloco.sdk.internal.ortb.model.c cVar, boolean z10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar, u uVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            dVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(context);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2 = dVar;
        if ((i10 & 32) != 0) {
            uVar = a.C0337a.f18870a.a();
        }
        return a(context, cVar, z10, rVar, dVar2, uVar);
    }
}
