package com.vungle.ads;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InterstitialAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n0 extends d0 {
    public /* synthetic */ n0(Context context, String str, c cVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, (i10 & 4) != 0 ? new c() : cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(@NotNull Context context, @NotNull String placementId, @NotNull c adConfig) {
        super(context, placementId, adConfig);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
        kotlin.jvm.internal.t.i(adConfig, "adConfig");
    }

    @Override // com.vungle.ads.u
    @NotNull
    public o0 constructAdInternal$vungle_ads_release(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return new o0(context);
    }
}
