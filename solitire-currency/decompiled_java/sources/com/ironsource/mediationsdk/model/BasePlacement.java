package com.ironsource.mediationsdk.model;

import com.ironsource.co;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BasePlacement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f13697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final co f13699d;

    public BasePlacement(int i10, @NotNull String placementName, boolean z10, @Nullable co coVar) {
        t.i(placementName, "placementName");
        this.f13696a = i10;
        this.f13697b = placementName;
        this.f13698c = z10;
        this.f13699d = coVar;
    }

    @Nullable
    public final co getPlacementAvailabilitySettings() {
        return this.f13699d;
    }

    public final int getPlacementId() {
        return this.f13696a;
    }

    @NotNull
    public final String getPlacementName() {
        return this.f13697b;
    }

    public final boolean isDefault() {
        return this.f13698c;
    }

    public final boolean isPlacementId(int i10) {
        return this.f13696a == i10;
    }

    @NotNull
    public String toString() {
        return "placement name: " + this.f13697b;
    }

    public /* synthetic */ BasePlacement(int i10, String str, boolean z10, co coVar, int i11, k kVar) {
        this((i11 & 1) != 0 ? 0 : i10, str, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? null : coVar);
    }
}
