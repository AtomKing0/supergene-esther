package com.ironsource;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.k7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Arrays;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class wl extends k7<j2> implements NativeAdListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdData f16041r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdViewBinder f16042s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl(@NotNull ko threadInterface, @NotNull i1 adSmashData, @Nullable BaseAdAdapter<?, AdapterAdListener> baseAdAdapter, @Nullable Placement placement, @NotNull f5 item, @Nullable j2 j2Var) {
        super(threadInterface, adSmashData, baseAdAdapter, new v2(adSmashData.g(), adSmashData.g().getNativeAdSettings(), IronSource.AD_UNIT.NATIVE_AD), item, j2Var);
        kotlin.jvm.internal.t.i(threadInterface, "threadInterface");
        kotlin.jvm.internal.t.i(adSmashData, "adSmashData");
        kotlin.jvm.internal.t.i(item, "item");
        this.f12823g = placement;
    }

    private final void J() {
        ut utVar;
        IronLog.INTERNAL.verbose(d());
        if (y()) {
            super.onAdOpened();
            return;
        }
        if (this.f12821e != k7.h.FAILED) {
            kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
            String str = String.format("unexpected onAdOpened for %s, state - %s", Arrays.copyOf(new Object[]{k(), this.f12821e}, 2));
            kotlin.jvm.internal.t.h(str, "format(format, *args)");
            x1 x1Var = this.f12820d;
            if (x1Var == null || (utVar = x1Var.f16112k) == null) {
                return;
            }
            utVar.o(str);
        }
    }

    @Override // com.ironsource.k7
    protected void G() {
        ut utVar;
        if (!(this.f12819c instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterNativeAdInterface"));
            return;
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            IronLog.INTERNAL.error(a("activity must not be null"));
            x1 x1Var = this.f12820d;
            if (x1Var == null || (utVar = x1Var.f16112k) == null) {
                return;
            }
            utVar.f("activity must not be null");
            return;
        }
        Object obj = this.f12819c;
        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
        AdData mCurrentAdData = this.f12827k;
        kotlin.jvm.internal.t.h(mCurrentAdData, "mCurrentAdData");
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        kotlin.jvm.internal.t.h(currentActiveActivity, "getInstance().currentActiveActivity");
        ((AdapterNativeAdInterface) obj).loadAd(mCurrentAdData, currentActiveActivity, this);
    }

    @Nullable
    public final AdapterNativeAdViewBinder R() {
        return this.f16042s;
    }

    @Override // com.ironsource.k7, com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@NotNull u1 event) {
        kotlin.jvm.internal.t.i(event, "event");
        Map<String, Object> data = super.a(event);
        if (this.f12823g != null) {
            kotlin.jvm.internal.t.h(data, "data");
            data.put("placement", j());
        }
        kotlin.jvm.internal.t.h(data, "data");
        return data;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener
    public void onAdLoadSuccess(@NotNull final AdapterNativeAdData adapterNativeAdData, @NotNull final AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.t.i(adapterNativeAdData, "adapterNativeAdData");
        kotlin.jvm.internal.t.i(nativeAdViewBinder, "nativeAdViewBinder");
        if (u().c()) {
            u().a(new Runnable() { // from class: com.ironsource.b10
                @Override // java.lang.Runnable
                public final void run() {
                    wl.a(this.f11333a, adapterNativeAdData, nativeAdViewBinder);
                }
            });
        } else {
            a(adapterNativeAdData, nativeAdViewBinder);
        }
    }

    @Override // com.ironsource.k7, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().c()) {
            u().a(new Runnable() { // from class: com.ironsource.c10
                @Override // java.lang.Runnable
                public final void run() {
                    wl.a(this.f11488a);
                }
            });
        } else {
            J();
        }
    }

    private final void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        this.f16041r = adapterNativeAdData;
        this.f16042s = adapterNativeAdViewBinder;
        super.onAdLoadSuccess();
    }

    public final void P() {
        ut utVar;
        sk skVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(k7.h.NONE);
        Object obj = this.f12819c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterNativeAdInterface) {
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                AdData mCurrentAdData = this.f12827k;
                kotlin.jvm.internal.t.h(mCurrentAdData, "mCurrentAdData");
                ((AdapterNativeAdInterface) obj).destroyAd(mCurrentAdData);
            } else {
                ironLog.error(a("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            x1 x1Var = this.f12820d;
            if (x1Var != null && (utVar = x1Var.f16112k) != null) {
                utVar.f(str);
            }
        }
        x1 x1Var2 = this.f12820d;
        if (x1Var2 == null || (skVar = x1Var2.f16108g) == null) {
            return;
        }
        Integer sessionDepth = r();
        kotlin.jvm.internal.t.h(sessionDepth, "sessionDepth");
        skVar.a(sessionDepth.intValue());
    }

    @Nullable
    public final AdapterNativeAdData Q() {
        return this.f16041r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wl this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wl this$0, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adapterNativeAdData, "$adapterNativeAdData");
        kotlin.jvm.internal.t.i(nativeAdViewBinder, "$nativeAdViewBinder");
        this$0.a(adapterNativeAdData, nativeAdViewBinder);
    }
}
