package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class gp extends n implements tc, f2, o2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k1 f12324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final lp f12325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final WeakReference<hp> f12326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private rc f12327e;

    public gp(@NotNull hp listener, @NotNull k1 adTools, @NotNull lp rewardedVideoAdProperties) {
        kotlin.jvm.internal.t.i(listener, "listener");
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(rewardedVideoAdProperties, "rewardedVideoAdProperties");
        this.f12324b = adTools;
        this.f12325c = rewardedVideoAdProperties;
        this.f12326d = new WeakReference<>(listener);
    }

    private final rc a(k1 k1Var, b1 b1Var) {
        IronLog.INTERNAL.verbose();
        return new rc(k1Var, fp.f12162z.a(b1Var, a().a()), this);
    }

    @NotNull
    public final f1 b() {
        rc rcVar = this.f12327e;
        if (rcVar == null) {
            kotlin.jvm.internal.t.A("rewardedVideoAdUnit");
            rcVar = null;
        }
        return rcVar.e();
    }

    public final void c() {
        rc rcVarA = a(this.f12324b, this.f12325c);
        this.f12327e = rcVarA;
        if (rcVarA == null) {
            kotlin.jvm.internal.t.A("rewardedVideoAdUnit");
            rcVarA = null;
        }
        rcVarA.a(this);
    }

    @Override // com.ironsource.o2
    public /* bridge */ /* synthetic */ v8.k0 d(p1 p1Var) {
        t(p1Var);
        return v8.k0.f35197a;
    }

    public void f(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        hpVar.a(ironSourceError, levelPlayAdInfoC);
    }

    @Override // com.ironsource.f2
    public /* synthetic */ void i(p1 p1Var) {
        ew.a(this, p1Var);
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 j(p1 p1Var) {
        o(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 l(p1 p1Var) {
        q(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 m(p1 p1Var) {
        r(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.tc
    public /* bridge */ /* synthetic */ v8.k0 n(p1 p1Var) {
        s(p1Var);
        return v8.k0.f35197a;
    }

    public void o(@NotNull p1 adUnitCallback) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        Placement placementE = this.f12325c.e();
        kotlin.jvm.internal.t.f(placementE);
        hpVar.a(placementE, levelPlayAdInfoC);
    }

    public void p(@NotNull p1 adUnitCallback) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        hpVar.d(levelPlayAdInfoC);
    }

    public void q(@NotNull p1 adUnitCallback) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        hpVar.h(levelPlayAdInfoC);
    }

    public void r(@NotNull p1 adUnitCallback) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        hpVar.f(levelPlayAdInfoC);
    }

    public void s(@NotNull p1 adUnitCallback) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        Placement placementE = this.f12325c.e();
        kotlin.jvm.internal.t.f(placementE);
        hpVar.b(placementE, levelPlayAdInfoC);
    }

    public void t(@NotNull p1 adUnitCallback) {
        hp hpVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (hpVar = this.f12326d.get()) == null) {
            return;
        }
        hpVar.i(levelPlayAdInfoC);
    }

    @Override // com.ironsource.tc
    public /* bridge */ /* synthetic */ v8.k0 a(p1 p1Var) {
        p(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.o2
    public /* bridge */ /* synthetic */ v8.k0 b(p1 p1Var, IronSourceError ironSourceError) {
        f(p1Var, ironSourceError);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.f2
    @Nullable
    public v8.k0 a(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        hp hpVar = this.f12326d.get();
        if (hpVar == null) {
            return null;
        }
        hpVar.a(ironSourceError);
        return v8.k0.f35197a;
    }

    public final void a(@NotNull Activity activity, @Nullable Placement placement) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f12325c.a(placement);
        rc rcVar = this.f12327e;
        if (rcVar == null) {
            kotlin.jvm.internal.t.A("rewardedVideoAdUnit");
            rcVar = null;
        }
        rcVar.a(activity, this);
    }
}
