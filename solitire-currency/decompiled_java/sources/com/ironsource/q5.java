package com.ironsource;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class q5 extends x implements BannerAdListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private WeakReference<s5> f14433v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private View f14434w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private FrameLayout.LayoutParams f14435x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q5(@NotNull p2 adTools, @NotNull y instanceData, @NotNull s5 listener) {
        super(adTools, instanceData, listener);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f14433v = new WeakReference<>(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(q5 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(q5 this$0) {
        String placementName;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        j0 j0VarA = this$0.e().e().a();
        Placement placementI = this$0.i();
        if (placementI == null || (placementName = placementI.getPlacementName()) == null) {
            placementName = "";
        }
        j0VarA.j(placementName);
    }

    public final void a(@NotNull final du viewBinder) {
        kotlin.jvm.internal.t.i(viewBinder, "viewBinder");
        ok.a(e(), new Runnable() { // from class: com.ironsource.f00
            @Override // java.lang.Runnable
            public final void run() {
                q5.a(this.f12011a, viewBinder);
            }
        }, 0L, 2, (Object) null);
    }

    @Override // com.ironsource.x
    public void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o());
        ok.a(e(), new Runnable() { // from class: com.ironsource.d00
            @Override // java.lang.Runnable
            public final void run() {
                q5.a(this.f11739a);
            }
        }, 0L, 2, (Object) null);
        if (f() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (f() instanceof AdapterBannerInterface) {
                Object objF = f();
                kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<*>");
                ((AdapterBannerInterface) objF).destroyAd(h());
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            e().e().g().f(str);
        }
        super.b();
    }

    @Override // com.ironsource.x
    @NotNull
    public LevelPlayAdInfo d() {
        String strB = l().i().b().b();
        String string = l().h().toString();
        kotlin.jvm.internal.t.h(string, "instanceData.adFormat.toString()");
        ImpressionData impressionDataA = l().n().a(j());
        s1 s1VarI = l().i();
        kotlin.jvm.internal.t.g(s1VarI, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return new LevelPlayAdInfo(strB, string, impressionDataA, ((f6) s1VarI).b().g());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        a(new Runnable() { // from class: com.ironsource.g00
            @Override // java.lang.Runnable
            public final void run() {
                q5.b(this.f12195a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(@NotNull final View adView, @NotNull final FrameLayout.LayoutParams frameLayoutParams) {
        kotlin.jvm.internal.t.i(adView, "adView");
        kotlin.jvm.internal.t.i(frameLayoutParams, "frameLayoutParams");
        ok.a(e(), new Runnable() { // from class: com.ironsource.c00
            @Override // java.lang.Runnable
            public final void run() {
                q5.a(this.f11484a, adView, frameLayoutParams);
            }
        }, 0L, 2, (Object) null);
        super.onAdLoadSuccess();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        a(new Runnable() { // from class: com.ironsource.e00
            @Override // java.lang.Runnable
            public final void run() {
                q5.c(this.f11882a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        a(new Runnable() { // from class: com.ironsource.i00
            @Override // java.lang.Runnable
            public final void run() {
                q5.d(this.f12523a);
            }
        });
    }

    @Override // com.ironsource.x
    protected void y() {
        if (!(f() instanceof AdapterBannerInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
            return;
        }
        AdData adDataH = h();
        ISBannerSize iSBannerSizeG = G();
        Map<String, Object> adUnitData = adDataH.getAdUnitData();
        kotlin.jvm.internal.t.h(adUnitData, "adData.adUnitData");
        adUnitData.put("bannerLayout", new IronSourceBannerLayout(ContextProvider.getInstance().getCurrentActiveActivity(), iSBannerSizeG));
        Object objF = f();
        kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterBannerInterface) objF).loadAd(adDataH, ContextProvider.getInstance().getCurrentActiveActivity(), iSBannerSizeG, this);
    }

    private final ISBannerSize G() {
        p2 p2VarE = e();
        s1 s1VarI = l().i();
        kotlin.jvm.internal.t.g(s1VarI, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return p2VarE.a(((f6) s1VarI).b().g());
    }

    private final void H() {
        Placement placementI = i();
        if (placementI != null) {
            e().e().a().f(placementI.getPlacementName());
        }
        s5 s5Var = this.f14433v.get();
        if (s5Var != null) {
            s5Var.a(this);
        }
    }

    private final void I() {
        Placement placementI = i();
        if (placementI != null) {
            e().e().a().c(placementI.getPlacementName());
        }
        s5 s5Var = this.f14433v.get();
        if (s5Var != null) {
            s5Var.b(this);
        }
    }

    private final void J() {
        Placement placementI = i();
        if (placementI != null) {
            e().e().a().h(placementI.getPlacementName());
        }
        s5 s5Var = this.f14433v.get();
        if (s5Var != null) {
            s5Var.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(q5 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(q5 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.J();
    }

    @Override // com.ironsource.x
    public void a(@NotNull f0 adInstancePresenter) {
        kotlin.jvm.internal.t.i(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(q5 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f14434w = null;
        this$0.f14435x = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(q5 this$0, View adView, FrameLayout.LayoutParams frameLayoutParams) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adView, "$adView");
        kotlin.jvm.internal.t.i(frameLayoutParams, "$frameLayoutParams");
        this$0.f14434w = adView;
        this$0.f14435x = frameLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final q5 this$0, du viewBinder) {
        FrameLayout.LayoutParams layoutParams;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(viewBinder, "$viewBinder");
        View view = this$0.f14434w;
        if (view == null || (layoutParams = this$0.f14435x) == null) {
            return;
        }
        viewBinder.a(view, layoutParams);
        IronLog.INTERNAL.verbose(k1.a(this$0.e(), "Bind banner view", (String) null, 2, (Object) null));
        this$0.e().d(new Runnable() { // from class: com.ironsource.h00
            @Override // java.lang.Runnable
            public final void run() {
                q5.e(this.f12361a);
            }
        });
    }
}
