package com.ironsource;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class pl extends x implements NativeAdListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdData f14358v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdViewBinder f14359w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pl(@NotNull p2 adTools, @NotNull y instanceData, @NotNull b0 listener) {
        super(adTools, instanceData, listener);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        kotlin.jvm.internal.t.i(listener, "listener");
    }

    @Nullable
    public final AdapterNativeAdData G() {
        return this.f14358v;
    }

    @Nullable
    public final AdapterNativeAdViewBinder H() {
        return this.f14359w;
    }

    @Override // com.ironsource.x
    public void a(@NotNull f0 adInstancePresenter) {
        kotlin.jvm.internal.t.i(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    @Override // com.ironsource.x
    public void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o());
        if (f() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (f() instanceof AdapterNativeAdInterface) {
                Object objF = f();
                kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                ((AdapterNativeAdInterface) objF).destroyAd(h());
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            e().e().g().f(str);
        }
        super.b();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener
    public void onAdLoadSuccess(@NotNull AdapterNativeAdData adapterNativeAdData, @NotNull AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.t.i(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.t.i(nativeAdViewBinder, "nativeAdViewBinder");
        this.f14358v = adapterNativeAdData;
        this.f14359w = nativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    @Override // com.ironsource.x
    protected void y() {
        if (!(f() instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
            return;
        }
        AdData adDataH = h();
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            IronLog.INTERNAL.error(a("activity must not be null"));
            e().e().g().f("activity must not be null");
            return;
        }
        Object objF = f();
        kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        kotlin.jvm.internal.t.h(currentActiveActivity, "getInstance().currentActiveActivity");
        ((AdapterNativeAdInterface) objF).loadAd(adDataH, currentActiveActivity, this);
    }

    public final void a(@NotNull il nativeAdBinder) {
        kotlin.jvm.internal.t.i(nativeAdBinder, "nativeAdBinder");
        nativeAdBinder.a(this.f14358v);
        nativeAdBinder.a(this.f14359w);
    }
}
