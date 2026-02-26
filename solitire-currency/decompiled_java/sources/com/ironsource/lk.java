package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class lk extends xj implements hp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final kk f13049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private gp f13050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private mk f13051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private ImpressionDataListener f13052g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lk(@NotNull kk levelPlayRewardedVideoAd) {
        super(new k1(IronSource.AD_UNIT.REWARDED_VIDEO, x1.b.MEDIATION));
        kotlin.jvm.internal.t.i(levelPlayRewardedVideoAd, "levelPlayRewardedVideoAd");
        this.f13049d = levelPlayRewardedVideoAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lk this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.a(this$0.f13049d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(lk this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.b(this$0.f13049d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(lk this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.c(this$0.f13049d, adInfo);
        }
    }

    public final void a(@NotNull final Activity activity, @Nullable final String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        a(new Runnable() { // from class: com.ironsource.rx
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(this.f14747a, str, activity);
            }
        });
    }

    @Override // com.ironsource.hp
    public void onRewardedVideoAdEnded() {
        b(new Runnable() { // from class: com.ironsource.nx
            @Override // java.lang.Runnable
            public final void run() {
                lk.b(this.f14185a);
            }
        });
    }

    @Override // com.ironsource.hp
    public void onRewardedVideoAdStarted() {
        b(new Runnable() { // from class: com.ironsource.kx
            @Override // java.lang.Runnable
            public final void run() {
                lk.c(this.f12932a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lk this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        gp gpVar = null;
        if (this$0.c()) {
            IronLog.INTERNAL.warning(k1.a(this$0.a(), "Rewarded ad load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            gp gpVar2 = this$0.f13050e;
            if (gpVar2 == null) {
                kotlin.jvm.internal.t.A("rewardedVideoAdController");
            } else {
                gpVar = gpVar2;
            }
            gpVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lk this$0, Placement placement, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(placement, "$placement");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.b(this$0.f13049d, placement, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(lk this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.a(this$0.f13049d, adInfo);
        }
    }

    @Override // com.ironsource.hp
    public void d(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.ix
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(this.f12672a, adInfo);
            }
        });
    }

    public final boolean e() {
        if (!c()) {
            return false;
        }
        gp gpVar = this.f13050e;
        if (gpVar == null) {
            kotlin.jvm.internal.t.A("rewardedVideoAdController");
            gpVar = null;
        }
        return gpVar.b().a();
    }

    public final void f() {
        a(new Runnable() { // from class: com.ironsource.mx
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(this.f14045a);
            }
        });
    }

    @Override // com.ironsource.hp
    public void h(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.tx
            @Override // java.lang.Runnable
            public final void run() {
                lk.c(this.f15488a, adInfo);
            }
        });
    }

    @Override // com.ironsource.hp
    public void i(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.gx
            @Override // java.lang.Runnable
            public final void run() {
                lk.d(this.f12355a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lk this$0, Placement placement, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(placement, "$placement");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.a(this$0.f13049d, placement, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lk this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.d(this$0.f13049d, adInfo);
        }
    }

    @Override // com.ironsource.xj
    public boolean d() {
        lp lpVar = new lp(b());
        a(lpVar);
        this.f13050e = new gp(this, a(), lpVar);
        ImpressionDataListener impressionDataListener = this.f13052g;
        if (impressionDataListener == null) {
            return true;
        }
        lj.b().a(impressionDataListener);
        return true;
    }

    @Override // com.ironsource.hp
    public void f(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.jx
            @Override // java.lang.Runnable
            public final void run() {
                lk.b(this.f12789a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lk this$0, mk mkVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f13051f = mkVar;
    }

    @Override // com.ironsource.hp
    public void b(@NotNull final Placement placement, @NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(placement, "placement");
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.lx
            @Override // java.lang.Runnable
            public final void run() {
                lk.b(this.f13092a, placement, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lk this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.b(this$0.f13049d, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lk this$0, String str, Activity activity) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(activity, "$activity");
        Placement placementG = this$0.a().g(str);
        gp gpVar = this$0.f13050e;
        if (gpVar == null) {
            kotlin.jvm.internal.t.A("rewardedVideoAdController");
            gpVar = null;
        }
        gpVar.a(activity, placementG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lk this$0, boolean z10, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        mk mkVar = this$0.f13051f;
        if (mkVar != null) {
            mkVar.a(this$0.f13049d, z10, adInfo);
        }
    }

    public final void a(@Nullable ImpressionDataListener impressionDataListener) {
        this.f13052g = impressionDataListener;
    }

    @Override // com.ironsource.hp
    public void a(@Nullable final IronSourceError ironSourceError) {
        b(new Runnable() { // from class: com.ironsource.px
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(ironSourceError, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError ironSourceError, lk this$0) {
        mk mkVar;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (ironSourceError == null || (mkVar = this$0.f13051f) == null) {
            return;
        }
        mkVar.a(this$0.f13049d, ironSourceError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError ironSourceError, lk this$0, LevelPlayAdInfo adInfo) {
        mk mkVar;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        if (ironSourceError == null || (mkVar = this$0.f13051f) == null) {
            return;
        }
        mkVar.a(this$0.f13049d, ironSourceError, adInfo);
    }

    @Override // com.ironsource.hp
    public void a(@Nullable final IronSourceError ironSourceError, @NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.qx
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(ironSourceError, this, adInfo);
            }
        });
    }

    @Override // com.ironsource.hp
    public void a(@NotNull final Placement placement, @NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(placement, "placement");
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.ox
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(this.f14283a, placement, adInfo);
            }
        });
    }

    public final void a(@Nullable final mk mkVar) {
        a(new Runnable() { // from class: com.ironsource.sx
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(this.f15347a, mkVar);
            }
        });
    }

    @Override // com.ironsource.hp
    public void a(final boolean z10, @NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.hx
            @Override // java.lang.Runnable
            public final void run() {
                lk.a(this.f12513a, z10, adInfo);
            }
        });
    }
}
