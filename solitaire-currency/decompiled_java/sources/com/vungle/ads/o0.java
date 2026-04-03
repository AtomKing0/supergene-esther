package com.vungle.ads;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InterstitialAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o0 extends j0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdTypeForPlacement(@NotNull com.vungle.ads.internal.model.j placement) {
        kotlin.jvm.internal.t.i(placement, "placement");
        return placement.isInterstitial() || placement.isAppOpen();
    }
}
