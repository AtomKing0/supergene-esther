package com.ironsource.mediationsdk.model;

import com.ironsource.co;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Placement extends BasePlacement {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private String f13720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13721f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Placement(int i10, @NotNull String placementName, boolean z10, @NotNull String rewardName, int i11, @Nullable co coVar) {
        super(i10, placementName, z10, coVar);
        t.i(placementName, "placementName");
        t.i(rewardName, "rewardName");
        this.f13721f = i11;
        this.f13720e = rewardName;
    }

    public final int getRewardAmount() {
        return this.f13721f;
    }

    @NotNull
    public final String getRewardName() {
        return this.f13720e;
    }

    @Override // com.ironsource.mediationsdk.model.BasePlacement
    @NotNull
    public String toString() {
        return super.toString() + ", reward name: " + this.f13720e + " , amount: " + this.f13721f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Placement(@NotNull BasePlacement placement) {
        super(placement.getPlacementId(), placement.getPlacementName(), placement.isDefault(), placement.getPlacementAvailabilitySettings());
        t.i(placement, "placement");
        this.f13720e = "";
    }
}
