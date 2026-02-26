package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class lp extends b1 {
    public lp() {
        this("");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lp(@NotNull String adUnitId) {
        super(IronSource.AD_UNIT.REWARDED_VIDEO, adUnitId, null, null, 12, null);
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
    }
}
