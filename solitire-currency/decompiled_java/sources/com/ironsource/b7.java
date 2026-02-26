package com.ironsource;

import com.ironsource.mediationsdk.model.BasePlacement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class b7 extends BasePlacement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b7(int i10, @NotNull String placementName, boolean z10, @Nullable co coVar) {
        super(i10, placementName, z10, coVar);
        kotlin.jvm.internal.t.i(placementName, "placementName");
    }

    @Override // com.ironsource.mediationsdk.model.BasePlacement
    @NotNull
    public String toString() {
        return super.toString() + ", placementId: " + getPlacementId();
    }
}
