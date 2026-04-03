package com.ironsource;

import com.ironsource.c7;
import com.ironsource.ks;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.uc;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class k1 extends ok {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f12808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ks.b f12809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final lb f12810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ig f12811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12812f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f12813a = new a();

        private a() {
        }

        @NotNull
        public static final k1 a(@NotNull IronSource.AD_UNIT adFormat, @NotNull x1.b level) {
            kotlin.jvm.internal.t.i(adFormat, "adFormat");
            kotlin.jvm.internal.t.i(level, "level");
            return new k1(adFormat, level);
        }
    }

    public k1(@NotNull k1 adTools, @NotNull x1.b level) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(level, "level");
        this.f12811e = el.f11917p.d().r();
        this.f12812f = TimeUnit.HOURS.toMillis(1L);
        IronSource.AD_UNIT ad_unit = adTools.f12808b;
        this.f12808b = ad_unit;
        this.f12809c = adTools.f12809c;
        this.f12810d = new lb(ad_unit, level, adTools.f12810d.c(), null, 8, null);
    }

    @NotNull
    public final ISBannerSize a(@NotNull LevelPlayAdSize adSize) {
        kotlin.jvm.internal.t.i(adSize, "adSize");
        return new h1().b(adSize);
    }

    @NotNull
    public final c7.b b(@NotNull String adUnitId) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        ak akVarA = this.f12811e.a();
        if (akVarA != null) {
            return akVarA.a(adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    @NotNull
    public final uc.a c(@NotNull String adUnitId) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        ak akVarA = this.f12811e.a();
        if (akVarA != null) {
            return akVarA.b(adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    @NotNull
    protected final IronSource.AD_UNIT d() {
        return this.f12808b;
    }

    @NotNull
    public final lb e() {
        return this.f12810d;
    }

    public final long f() {
        ak akVarA = this.f12811e.a();
        return akVarA != null ? akVarA.i() : this.f12812f;
    }

    public final int g() {
        return el.f11917p.d().k().a(this.f12808b);
    }

    public final boolean h() {
        return el.f11917p.d().r().c();
    }

    public k1(@NotNull IronSource.AD_UNIT adFormat, @NotNull x1.b level) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(level, "level");
        this.f12811e = el.f11917p.d().r();
        this.f12812f = TimeUnit.HOURS.toMillis(1L);
        this.f12808b = adFormat;
        this.f12810d = new lb(adFormat, level, null, null, 12, null);
        ks.b bVarA = ks.a(adFormat);
        kotlin.jvm.internal.t.h(bVarA, "createLogFactory(adFormat)");
        this.f12809c = bVarA;
    }

    @NotNull
    public final Placement a(@NotNull String placementName) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        ak akVarA = this.f12811e.a();
        if (akVarA == null) {
            throw new IllegalStateException("Error getting sdk configurations");
        }
        Placement placementA = akVarA.a(LevelPlay.AdFormat.BANNER, placementName);
        if (placementA != null) {
            return placementA;
        }
        throw new IllegalStateException("Error getting placement");
    }

    @NotNull
    public final com.ironsource.lifecycle.b b() {
        com.ironsource.lifecycle.b bVarD = com.ironsource.lifecycle.b.d();
        kotlin.jvm.internal.t.h(bVarD, "getInstance()");
        return bVarD;
    }

    @NotNull
    public final String c() {
        return a(this, (String) null, (String) null, 3, (Object) null);
    }

    @Nullable
    public final Placement d(@Nullable String str) {
        ak akVarA;
        if (str == null || (akVarA = this.f12811e.a()) == null) {
            return null;
        }
        return akVarA.a(LevelPlay.AdFormat.INTERSTITIAL, str);
    }

    @NotNull
    public final String e(@Nullable String str) {
        return a(this, str, (String) null, 2, (Object) null);
    }

    @NotNull
    public final Placement f(@NotNull String placementName) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        ak akVarA = this.f12811e.a();
        if (akVarA == null) {
            throw new IllegalStateException("Error getting sdk configurations");
        }
        Placement placementA = akVarA.a(LevelPlay.AdFormat.NATIVE_AD, placementName);
        if (placementA != null) {
            return placementA;
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    @Nullable
    public final Placement g(@Nullable String str) {
        ak akVarA = this.f12811e.a();
        if (akVarA != null) {
            return akVarA.a(LevelPlay.AdFormat.REWARDED, str);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public static /* synthetic */ String a(k1 k1Var, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return k1Var.a(str, str2);
    }

    @NotNull
    public final String a(@Nullable String str, @Nullable String str2) {
        String strA = this.f12809c.a(str, str2);
        kotlin.jvm.internal.t.h(strA, "logFactory.createLogMessage(message, suffix)");
        return strA;
    }

    public final void a(@NotNull Map<String, Object> data, @NotNull ISBannerSize size) {
        kotlin.jvm.internal.t.i(data, "data");
        kotlin.jvm.internal.t.i(size, "size");
        com.ironsource.mediationsdk.l.a(data, size);
    }
}
