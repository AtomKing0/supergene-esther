package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class zh extends b1 {
    public zh() {
        this("", null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zh(@NotNull String adUnitId, @Nullable ts tsVar) {
        super(IronSource.AD_UNIT.INTERSTITIAL, adUnitId, null, tsVar, 4, null);
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
    }
}
