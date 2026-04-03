package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.uc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class vc extends uc implements f2, o2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k1 f15884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final uc.a f15885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final wc f15886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final sc f15887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private rc f15888g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc(@NotNull k1 adTools, @NotNull uc.a config, @NotNull b1 adProperties, @NotNull wc fullscreenStrategyListener, @NotNull sc fullscreenAdUnitFactory) {
        super(config, adProperties);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(fullscreenStrategyListener, "fullscreenStrategyListener");
        kotlin.jvm.internal.t.i(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        this.f15884c = adTools;
        this.f15885d = config;
        this.f15886e = fullscreenStrategyListener;
        this.f15887f = fullscreenAdUnitFactory;
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 a(p1 p1Var, IronSourceError ironSourceError) {
        c(p1Var, ironSourceError);
        return v8.k0.f35197a;
    }

    @NotNull
    public final k1 b() {
        return this.f15884c;
    }

    @NotNull
    public final uc.a c() {
        return this.f15885d;
    }

    @Override // com.ironsource.o2
    public /* bridge */ /* synthetic */ v8.k0 d(p1 p1Var) {
        b(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.f2
    public void i(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f15886e.g(adUnitCallback);
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 l(p1 p1Var) {
        a(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.uc
    public void a() {
        rc rcVarA = this.f15887f.a(true);
        this.f15888g = rcVarA;
        if (rcVarA == null) {
            kotlin.jvm.internal.t.A("fullscreenAdUnit");
            rcVarA = null;
        }
        rcVarA.a(this);
    }

    @Override // com.ironsource.o2
    public /* bridge */ /* synthetic */ v8.k0 b(p1 p1Var, IronSourceError ironSourceError) {
        d(p1Var, ironSourceError);
        return v8.k0.f35197a;
    }

    public void c(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f15886e.c(adUnitCallback, ironSourceError);
    }

    public void d(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f15886e.d(adUnitCallback, ironSourceError);
    }

    @Override // com.ironsource.uc
    public void a(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        rc rcVar = this.f15888g;
        if (rcVar == null) {
            kotlin.jvm.internal.t.A("fullscreenAdUnit");
            rcVar = null;
        }
        rcVar.a(activity, this);
    }

    public void b(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f15886e.k(adUnitCallback);
    }

    public void a(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f15886e.e(adUnitCallback);
    }
}
