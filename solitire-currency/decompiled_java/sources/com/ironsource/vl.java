package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class vl extends b1 {
    /* JADX WARN: Multi-variable type inference failed */
    public vl() {
        this("", null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl(@NotNull String adUnitId, @Nullable Placement placement) {
        super(IronSource.AD_UNIT.NATIVE_AD, adUnitId, placement, null, 8, null);
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
    }

    public /* synthetic */ vl(String str, Placement placement, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : placement);
    }
}
