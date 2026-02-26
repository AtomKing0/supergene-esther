package com.ironsource;

import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final l1 f14291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final LevelPlayAdInfo f14292b;

    public p1(@NotNull l1 adUnit, @Nullable LevelPlayAdInfo levelPlayAdInfo) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        this.f14291a = adUnit;
        this.f14292b = levelPlayAdInfo;
    }

    @NotNull
    public final l1 a() {
        return this.f14291a;
    }

    @Nullable
    public final LevelPlayAdInfo b() {
        return this.f14292b;
    }

    @Nullable
    public final LevelPlayAdInfo c() {
        return this.f14292b;
    }

    @NotNull
    public final l1 d() {
        return this.f14291a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return kotlin.jvm.internal.t.d(this.f14291a, p1Var.f14291a) && kotlin.jvm.internal.t.d(this.f14292b, p1Var.f14292b);
    }

    public int hashCode() {
        int iHashCode = this.f14291a.hashCode() * 31;
        LevelPlayAdInfo levelPlayAdInfo = this.f14292b;
        return iHashCode + (levelPlayAdInfo == null ? 0 : levelPlayAdInfo.hashCode());
    }

    @NotNull
    public String toString() {
        return "AdUnitCallback(adUnit=" + this.f14291a + ", adInfo=" + this.f14292b + ')';
    }

    public /* synthetic */ p1(l1 l1Var, LevelPlayAdInfo levelPlayAdInfo, int i10, kotlin.jvm.internal.k kVar) {
        this(l1Var, (i10 & 2) != 0 ? null : levelPlayAdInfo);
    }

    @NotNull
    public final p1 a(@NotNull l1 adUnit, @Nullable LevelPlayAdInfo levelPlayAdInfo) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        return new p1(adUnit, levelPlayAdInfo);
    }

    public static /* synthetic */ p1 a(p1 p1Var, l1 l1Var, LevelPlayAdInfo levelPlayAdInfo, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l1Var = p1Var.f14291a;
        }
        if ((i10 & 2) != 0) {
            levelPlayAdInfo = p1Var.f14292b;
        }
        return p1Var.a(l1Var, levelPlayAdInfo);
    }
}
