package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ll extends n implements zl, f2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ol f13053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k1 f13054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final vl f13055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private xl f13056e;

    public ll(@NotNull ol listener, @NotNull k1 adTools, @NotNull vl nativeAdProperties) {
        kotlin.jvm.internal.t.i(listener, "listener");
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(nativeAdProperties, "nativeAdProperties");
        this.f13053b = listener;
        this.f13054c = adTools;
        this.f13055d = nativeAdProperties;
    }

    private final xl a(k1 k1Var, vl vlVar) {
        IronLog.INTERNAL.verbose();
        return new xl(k1Var, yl.f16333z.a(vlVar, a().a()), this);
    }

    public final void b() {
        xl xlVar = this.f13056e;
        if (xlVar == null) {
            kotlin.jvm.internal.t.A("nativeAdUnit");
            xlVar = null;
        }
        xlVar.d();
    }

    public final void c() {
        xl xlVarA = a(this.f13054c, this.f13055d);
        this.f13056e = xlVarA;
        if (xlVarA == null) {
            kotlin.jvm.internal.t.A("nativeAdUnit");
            xlVarA = null;
        }
        xlVarA.a(this);
    }

    public void f(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f13053b.onNativeAdLoadFailed(ironSourceError);
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
        p(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 m(p1 p1Var) {
        q(p1Var);
        return v8.k0.f35197a;
    }

    public void o(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.f13053b.j(levelPlayAdInfoC);
        }
    }

    public void p(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.f13053b.b(levelPlayAdInfoC);
        }
    }

    public void q(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 a(p1 p1Var, IronSourceError ironSourceError) {
        f(p1Var, ironSourceError);
        return v8.k0.f35197a;
    }

    public final void a(@NotNull il nativeAdBinder) {
        kotlin.jvm.internal.t.i(nativeAdBinder, "nativeAdBinder");
        xl xlVar = this.f13056e;
        if (xlVar == null) {
            kotlin.jvm.internal.t.A("nativeAdUnit");
            xlVar = null;
        }
        xlVar.a(new ql(nativeAdBinder));
    }
}
