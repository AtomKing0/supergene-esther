package com.ironsource.mediationsdk.model;

import com.ironsource.co;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InterstitialPlacement extends BasePlacement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialPlacement(int i10, @NotNull String placementName, boolean z10, @Nullable co coVar) {
        super(i10, placementName, z10, coVar);
        t.i(placementName, "placementName");
    }
}
