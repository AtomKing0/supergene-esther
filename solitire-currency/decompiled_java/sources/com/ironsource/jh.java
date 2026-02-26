package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.rc;
import com.ironsource.uc;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class jh extends n implements ei, wc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k1 f12738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final zh f12739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final rc.a f12740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final WeakReference<lh> f12741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final uc f12742f;

    public jh(@NotNull lh listener, @NotNull k1 adTools, @NotNull zh interstitialAdProperties, @NotNull uc.b interstitialStrategyFactory, @NotNull rc.a fullscreenAdUnitFactory) {
        kotlin.jvm.internal.t.i(listener, "listener");
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(interstitialAdProperties, "interstitialAdProperties");
        kotlin.jvm.internal.t.i(interstitialStrategyFactory, "interstitialStrategyFactory");
        kotlin.jvm.internal.t.i(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        this.f12738b = adTools;
        this.f12739c = interstitialAdProperties;
        this.f12740d = fullscreenAdUnitFactory;
        this.f12741e = new WeakReference<>(listener);
        this.f12742f = interstitialStrategyFactory.a(adTools, adTools.c(interstitialAdProperties.b()), interstitialAdProperties, this, b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rc a(jh this$0, boolean z10) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        return this$0.f12740d.a(this$0.f12738b, this$0.f12739c, z10, this$0, this$0.a().a());
    }

    public final void c() {
        this.f12742f.a();
    }

    @Override // com.ironsource.wc
    public void d(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        lh lhVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (lhVar = this.f12741e.get()) == null) {
            return;
        }
        lhVar.a(new LevelPlayAdError(ironSourceError, this.f12739c.b()), levelPlayAdInfoC);
    }

    @Override // com.ironsource.wc
    public void e(@NotNull p1 adUnitCallback) {
        lh lhVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (lhVar = this.f12741e.get()) == null) {
            return;
        }
        lhVar.d(levelPlayAdInfoC);
    }

    @Override // com.ironsource.wc
    public void g(@NotNull p1 adUnitCallback) {
        lh lhVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (lhVar = this.f12741e.get()) == null) {
            return;
        }
        lhVar.onAdInfoChanged(levelPlayAdInfoC);
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 j(p1 p1Var) {
        o(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.wc
    public void k(@NotNull p1 adUnitCallback) {
        lh lhVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (lhVar = this.f12741e.get()) == null) {
            return;
        }
        lhVar.c(levelPlayAdInfoC);
    }

    @Override // com.ironsource.d2
    public /* bridge */ /* synthetic */ v8.k0 m(p1 p1Var) {
        q(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.tc
    public /* bridge */ /* synthetic */ v8.k0 n(p1 p1Var) {
        r(p1Var);
        return v8.k0.f35197a;
    }

    public void o(@NotNull p1 adUnitCallback) {
        lh lhVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (lhVar = this.f12741e.get()) == null) {
            return;
        }
        lhVar.a(levelPlayAdInfoC);
    }

    public void p(@NotNull p1 adUnitCallback) {
        lh lhVar;
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC == null || (lhVar = this.f12741e.get()) == null) {
            return;
        }
        lhVar.b(levelPlayAdInfoC);
    }

    public void q(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
    }

    public void r(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
    }

    public /* synthetic */ jh(lh lhVar, k1 k1Var, zh zhVar, uc.b bVar, rc.a aVar, int i10, kotlin.jvm.internal.k kVar) {
        this(lhVar, k1Var, zhVar, (i10 & 8) != 0 ? new uc.b() : bVar, (i10 & 16) != 0 ? new rc.a() : aVar);
    }

    private final sc b() {
        return new sc() { // from class: com.ironsource.ax
            @Override // com.ironsource.sc
            public final rc a(boolean z10) {
                return jh.a(this.f11320a, z10);
            }
        };
    }

    @Override // com.ironsource.tc
    public /* bridge */ /* synthetic */ v8.k0 a(p1 p1Var) {
        p(p1Var);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.wc
    public void c(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        lh lhVar = this.f12741e.get();
        if (lhVar != null) {
            lhVar.a(new LevelPlayAdError(ironSourceError, this.f12739c.b()));
        }
    }

    public final void a(@NotNull Activity activity, @Nullable Placement placement) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f12739c.a(placement);
        this.f12742f.a(activity);
    }
}
