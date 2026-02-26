package com.ironsource;

import android.app.Activity;
import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mg;
import com.unity3d.ironsourceads.interstitial.InterstitialAdInfo;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ph implements nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private mi f14332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private w0 f14333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private q4 f14334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private j3 f14335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private em f14336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private jt f14337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private mg f14338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private mg.a f14339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final Map<String, ph> f14340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private InterstitialAdInfo f14341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private qh f14342k;

    public ph(@NotNull mi adInstance, @NotNull w0 adNetworkShow, @NotNull q4 auctionDataReporter, @NotNull j3 analytics, @NotNull em networkDestroyAPI, @NotNull jt threadManager, @NotNull mg sessionDepthService, @NotNull mg.a sessionDepthServiceEditor, @NotNull Map<String, ph> retainer) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(adNetworkShow, "adNetworkShow");
        kotlin.jvm.internal.t.i(auctionDataReporter, "auctionDataReporter");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(networkDestroyAPI, "networkDestroyAPI");
        kotlin.jvm.internal.t.i(threadManager, "threadManager");
        kotlin.jvm.internal.t.i(sessionDepthService, "sessionDepthService");
        kotlin.jvm.internal.t.i(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        kotlin.jvm.internal.t.i(retainer, "retainer");
        this.f14332a = adInstance;
        this.f14333b = adNetworkShow;
        this.f14334c = auctionDataReporter;
        this.f14335d = analytics;
        this.f14336e = networkDestroyAPI;
        this.f14337f = threadManager;
        this.f14338g = sessionDepthService;
        this.f14339h = sessionDepthServiceEditor;
        this.f14340i = retainer;
        String strF = adInstance.f();
        kotlin.jvm.internal.t.h(strF, "adInstance.instanceId");
        String strE = this.f14332a.e();
        kotlin.jvm.internal.t.h(strE, "adInstance.id");
        this.f14341j = new InterstitialAdInfo(strF, strE);
        lc lcVar = new lc();
        this.f14332a.a(lcVar);
        lcVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ph this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        qh qhVar = this$0.f14342k;
        if (qhVar != null) {
            qhVar.onAdInstanceDidShow();
        }
    }

    public final void a() {
        bx.a(this.f14337f, new Runnable() { // from class: com.ironsource.nz
            @Override // java.lang.Runnable
            public final void run() {
                ph.a(this.f14187a);
            }
        }, 0L, 2, null);
    }

    @NotNull
    public final InterstitialAdInfo b() {
        return this.f14341j;
    }

    @Nullable
    public final qh c() {
        return this.f14342k;
    }

    protected final void finalize() {
        a();
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidBecomeVisible() {
        c3.a.f11491a.f(new g3[0]).a(this.f14335d);
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidClick() {
        c3.a.f11491a.a().a(this.f14335d);
        this.f14337f.a(new Runnable() { // from class: com.ironsource.oz
            @Override // java.lang.Runnable
            public final void run() {
                ph.b(this.f14287a);
            }
        });
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidDismiss() {
        this.f14340i.remove(this.f14341j.getAdId());
        c3.a.f11491a.a(new g3[0]).a(this.f14335d);
        this.f14337f.a(new Runnable() { // from class: com.ironsource.mz
            @Override // java.lang.Runnable
            public final void run() {
                ph.c(this.f14051a);
            }
        });
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidShow() {
        mg mgVar = this.f14338g;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        c3.a.f11491a.b(new f3.w(mgVar.a(ad_unit))).a(this.f14335d);
        this.f14339h.b(ad_unit);
        this.f14334c.c("onAdInstanceDidShow");
        this.f14337f.a(new Runnable() { // from class: com.ironsource.lz
            @Override // java.lang.Runnable
            public final void run() {
                ph.d(this.f13098a);
            }
        });
    }

    public /* synthetic */ ph(mi miVar, w0 w0Var, q4 q4Var, j3 j3Var, em emVar, jt jtVar, mg mgVar, mg.a aVar, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this(miVar, w0Var, q4Var, j3Var, (i10 & 16) != 0 ? new fm() : emVar, (i10 & 32) != 0 ? ve.f15889a : jtVar, (i10 & 64) != 0 ? el.f11917p.d().k() : mgVar, (i10 & 128) != 0 ? el.f11917p.a().e() : aVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ph this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        qh qhVar = this$0.f14342k;
        if (qhVar != null) {
            qhVar.onAdInstanceDidClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ph this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        qh qhVar = this$0.f14342k;
        if (qhVar != null) {
            qhVar.onAdInstanceDidDismiss();
        }
    }

    public final void a(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f14340i.put(this.f14341j.getAdId(), this);
        if (!this.f14333b.a(this.f14332a)) {
            a(hb.f12462a.t());
        } else {
            c3.a.f11491a.d(new g3[0]).a(this.f14335d);
            this.f14333b.a(activity, this.f14332a);
        }
    }

    public final boolean d() {
        boolean zA = this.f14333b.a(this.f14332a);
        c3.a.f11491a.a(zA).a(this.f14335d);
        return zA;
    }

    private final void a(final IronSourceError ironSourceError) {
        this.f14340i.remove(this.f14341j.getAdId());
        c3.a.f11491a.a(new f3.j(ironSourceError.getErrorCode()), new f3.k(ironSourceError.getErrorMessage())).a(this.f14335d);
        this.f14337f.a(new Runnable() { // from class: com.ironsource.pz
            @Override // java.lang.Runnable
            public final void run() {
                ph.a(this.f14403a, ironSourceError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ph this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        c3.d.f11513a.b().a(this$0.f14335d);
        this$0.f14336e.a(this$0.f14332a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ph this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        qh qhVar = this$0.f14342k;
        if (qhVar != null) {
            qhVar.onAdInstanceDidFailedToShow(error);
        }
    }

    public final void a(@Nullable qh qhVar) {
        this.f14342k = qhVar;
    }

    public final void a(@NotNull InterstitialAdInfo interstitialAdInfo) {
        kotlin.jvm.internal.t.i(interstitialAdInfo, "<set-?>");
        this.f14341j = interstitialAdInfo;
    }

    @Override // com.ironsource.nc
    public void a(@Nullable String str) {
        a(hb.f12462a.c(new IronSourceError(0, str)));
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidReward(@Nullable String str, int i10) {
    }
}
