package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class o5 extends n implements h6, d7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k1 f14203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final c6 f14204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final WeakReference<p5> f14205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final c7 f14206e;

    public o5(@NotNull p5 listener, @NotNull k1 adTools, @NotNull c6 bannerAdProperties, @NotNull p6 bannerViewContainer) {
        kotlin.jvm.internal.t.i(listener, "listener");
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.t.i(bannerViewContainer, "bannerViewContainer");
        this.f14203b = adTools;
        this.f14204c = bannerAdProperties;
        this.f14205d = new WeakReference<>(listener);
        this.f14206e = c7.f11533c.a(adTools, bannerViewContainer, adTools.b(bannerAdProperties.b()), bannerAdProperties, this, b());
    }

    private final e6 a(k1 k1Var, c6 c6Var, boolean z10) {
        IronLog.INTERNAL.verbose();
        return new e6(k1Var, f6.A.a(c6Var, a().a(), z10), this);
    }

    @Override // com.ironsource.h6
    public /* bridge */ /* synthetic */ v8.k0 c(p1 p1Var) {
        r(p1Var);
        return v8.k0.f35197a;
    }

    public final void d() {
        this.f14206e.d();
    }

    public final void e() {
        this.f14206e.e();
    }

    @Override // com.ironsource.h6
    public /* bridge */ /* synthetic */ v8.k0 f(p1 p1Var) {
        s(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.h6
    public /* bridge */ /* synthetic */ v8.k0 h(p1 p1Var) {
        p(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 j(p1 p1Var) {
        o(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 m(p1 p1Var) {
        q(p1Var);
        return v8.k0.f35197a;
    }

    public void o(@NotNull p1 adUnitCallback) {
        p5 p5Var;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (p5Var = this.f14205d.get()) == null) {
            return;
        }
        p5Var.g(levelPlayAdInfoC);
    }

    public void p(@NotNull p1 adUnitCallback) {
        p5 p5Var;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (p5Var = this.f14205d.get()) == null) {
            return;
        }
        p5Var.k(levelPlayAdInfoC);
    }

    public void q(@NotNull p1 adUnitCallback) {
        p5 p5Var;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (p5Var = this.f14205d.get()) == null) {
            return;
        }
        p5Var.c(levelPlayAdInfoC);
    }

    public void r(@NotNull p1 adUnitCallback) {
        p5 p5Var;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (p5Var = this.f14205d.get()) == null) {
            return;
        }
        p5Var.e(levelPlayAdInfoC);
    }

    public void s(@NotNull p1 adUnitCallback) {
        p5 p5Var;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (p5Var = this.f14205d.get()) == null) {
            return;
        }
        p5Var.a(levelPlayAdInfoC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e6 a(o5 this$0, boolean z10) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        return this$0.a(this$0.f14203b, this$0.f14204c, z10);
    }

    private final g6 b() {
        return new g6() { // from class: com.ironsource.qy
            @Override // com.ironsource.g6
            public final e6 a(boolean z10) {
                return o5.a(this.f14607a, z10);
            }
        };
    }

    public final void c() {
        this.f14203b.e().e().a(this.f14203b.g());
        this.f14206e.a();
    }

    @Override // com.ironsource.d7
    public void e(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        p5 p5Var = this.f14205d.get();
        if (p5Var != null) {
            p5Var.a(new LevelPlayAdError(ironSourceError, this.f14204c.b()));
        }
    }

    public final void f() {
        this.f14206e.f();
    }

    @Override // com.ironsource.d7
    public void b(@NotNull p1 adUnitCallback) {
        p5 p5Var;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (p5Var = this.f14205d.get()) == null) {
            return;
        }
        p5Var.a(levelPlayAdInfoC, false);
    }
}
