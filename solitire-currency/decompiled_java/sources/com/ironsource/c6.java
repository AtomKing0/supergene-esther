package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdSize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class c6 extends b1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final LevelPlayAdSize f11530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final Boolean f11531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final Long f11532h;

    public c6() {
        this("", null, null, null, null, null, 62, null);
    }

    @NotNull
    public final LevelPlayAdSize g() {
        return this.f11530f;
    }

    @Nullable
    public final Boolean h() {
        return this.f11531g;
    }

    @Nullable
    public final Long i() {
        return this.f11532h;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c6(@NotNull String adUnitId, @Nullable Placement placement, @NotNull LevelPlayAdSize adSize, @Nullable Boolean bool, @Nullable Long l10, @Nullable ts tsVar) {
        super(IronSource.AD_UNIT.BANNER, adUnitId, placement, tsVar);
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(adSize, "adSize");
        this.f11530f = adSize;
        this.f11531g = bool;
        this.f11532h = l10;
    }

    public /* synthetic */ c6(String str, Placement placement, LevelPlayAdSize levelPlayAdSize, Boolean bool, Long l10, ts tsVar, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : placement, (i10 & 4) != 0 ? LevelPlayAdSize.BANNER : levelPlayAdSize, (i10 & 8) != 0 ? null : bool, (i10 & 16) != 0 ? null : l10, (i10 & 32) == 0 ? tsVar : null);
    }
}
