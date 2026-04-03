package com.ironsource;

import android.app.Activity;
import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.environment.ContextProvider;
import com.ironsource.m1;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class oc extends x implements InterstitialAdListener, AdapterAdRewardListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private WeakReference<pc> f14228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private ta f14229w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oc(@NotNull p2 adTools, @NotNull y instanceData, @NotNull pc listener) {
        super(adTools, instanceData, listener);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f14228v = new WeakReference<>(listener);
    }

    private final void b(int i10, String str) {
        IronLog.INTERNAL.verbose(a("error = " + i10 + ", " + str));
        e().e().a().a(j(), i10, str, "");
        a(m1.a.FailedToShow);
        IronSourceError ironSourceError = new IronSourceError(i10, str);
        pc pcVar = this.f14228v.get();
        if (pcVar != null) {
            pcVar.a(ironSourceError, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(oc this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(oc this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(oc this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(oc this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.L();
    }

    public final void a(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + j()));
        try {
            e().e().a().a(activity, j());
            if (f() instanceof AdapterAdFullScreenInterface) {
                Object objF = f();
                kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
                ((AdapterAdFullScreenInterface) objF).showAd(h(), this);
            } else {
                ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
                e().e().g().f("showAd - adapter not instance of AdapterAdFullScreenInterface");
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "showAd - exception = " + th.getMessage();
            IronLog.INTERNAL.error(a(str));
            e().e().g().f(str);
            b(t1.h(l().h()), str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        a(new Runnable() { // from class: com.ironsource.vy
            @Override // java.lang.Runnable
            public final void run() {
                oc.a(this.f15982a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        a(new Runnable() { // from class: com.ironsource.uy
            @Override // java.lang.Runnable
            public final void run() {
                oc.b(this.f15627a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        a(new Runnable() { // from class: com.ironsource.wy
            @Override // java.lang.Runnable
            public final void run() {
                oc.c(this.f16071a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowFailed(final int i10, @Nullable final String str) {
        a(new Runnable() { // from class: com.ironsource.ty
            @Override // java.lang.Runnable
            public final void run() {
                oc.a(this.f15490a, i10, str);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess() {
        a(new Runnable() { // from class: com.ironsource.ry
            @Override // java.lang.Runnable
            public final void run() {
                oc.d(this.f14750a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        a(new Runnable() { // from class: com.ironsource.sy
            @Override // java.lang.Runnable
            public final void run() {
                oc.e(this.f15349a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        a(new Runnable() { // from class: com.ironsource.xy
            @Override // java.lang.Runnable
            public final void run() {
                oc.f(this.f16212a);
            }
        });
    }

    @Override // com.ironsource.x
    protected void y() {
        if (!(f() instanceof AdapterAdFullScreenInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
            return;
        }
        Object objF = f();
        kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterAdFullScreenInterface) objF).loadAd(l().g(), ContextProvider.getInstance().getCurrentActiveActivity(), this);
    }

    private final void G() {
        this.f14229w = new ta();
        IronLog.INTERNAL.verbose(x.a(this, (String) null, 1, (Object) null));
        e().e().a().a(j(), "");
        pc pcVar = this.f14228v.get();
        if (pcVar != null) {
            pcVar.c(this);
        }
    }

    private final void H() {
        IronLog.INTERNAL.verbose(x.a(this, (String) null, 1, (Object) null));
        e().e().a().d(j());
    }

    private final void I() {
        if (i() == null) {
            IronLog.INTERNAL.verbose(a("placement is null "));
            e().e().g().f("mCurrentPlacement is null");
            return;
        }
        IronLog.INTERNAL.verbose(a("placement name = " + j()));
        HashMap map = new HashMap();
        Map<String, String> mapL = e().l();
        if (mapL != null) {
            for (String str : mapL.keySet()) {
                map.put(ContentMetadata.KEY_CUSTOM_PREFIX + str, mapL.get(str));
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = e().a(jCurrentTimeMillis, n());
        long jA = ta.a(this.f14229w);
        j0 j0VarA = e().e().a();
        String strJ = j();
        Placement placementI = i();
        String rewardName = placementI != null ? placementI.getRewardName() : null;
        Placement placementI2 = i();
        j0VarA.a(strJ, rewardName, placementI2 != null ? placementI2.getRewardAmount() : 0, jCurrentTimeMillis, strA, jA, map, e().k());
        pc pcVar = this.f14228v.get();
        if (pcVar != null) {
            pcVar.a(this);
        }
    }

    private final void J() {
        IronLog.INTERNAL.verbose(x.a(this, (String) null, 1, (Object) null));
        e().e().a().l(j());
        pc pcVar = this.f14228v.get();
        if (pcVar != null) {
            pcVar.b(this);
        }
    }

    private final void K() {
        IronLog.INTERNAL.verbose(x.a(this, (String) null, 1, (Object) null));
        e().e().a().i(j());
    }

    private final void L() {
        IronLog.INTERNAL.verbose(x.a(this, (String) null, 1, (Object) null));
        e().e().a().k(j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(oc this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.H();
    }

    @Override // com.ironsource.x
    public void a(@NotNull f0 adInstancePresenter) {
        kotlin.jvm.internal.t.i(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(oc this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(oc this$0, int i10, String str) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.b(i10, str);
    }
}
