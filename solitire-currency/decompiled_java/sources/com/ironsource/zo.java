package com.ironsource;

import android.app.Activity;
import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
import com.unity3d.ironsourceads.rewarded.RewardedAdInfo;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class zo implements nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private mi f16472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private w0 f16473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private q4 f16474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private j3 f16475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private em f16476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private jt f16477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private mg f16478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private mg.a f16479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final Map<String, zo> f16480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private RewardedAdInfo f16481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ap f16482k;

    public zo(@NotNull mi adInstance, @NotNull w0 adNetworkShow, @NotNull q4 auctionDataReporter, @NotNull j3 analytics, @NotNull em networkDestroyAPI, @NotNull jt threadManager, @NotNull mg sessionDepthService, @NotNull mg.a sessionDepthServiceEditor, @NotNull Map<String, zo> retainer) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(adNetworkShow, "adNetworkShow");
        kotlin.jvm.internal.t.i(auctionDataReporter, "auctionDataReporter");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(networkDestroyAPI, "networkDestroyAPI");
        kotlin.jvm.internal.t.i(threadManager, "threadManager");
        kotlin.jvm.internal.t.i(sessionDepthService, "sessionDepthService");
        kotlin.jvm.internal.t.i(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        kotlin.jvm.internal.t.i(retainer, "retainer");
        this.f16472a = adInstance;
        this.f16473b = adNetworkShow;
        this.f16474c = auctionDataReporter;
        this.f16475d = analytics;
        this.f16476e = networkDestroyAPI;
        this.f16477f = threadManager;
        this.f16478g = sessionDepthService;
        this.f16479h = sessionDepthServiceEditor;
        this.f16480i = retainer;
        String strF = adInstance.f();
        kotlin.jvm.internal.t.h(strF, "adInstance.instanceId");
        String strE = this.f16472a.e();
        kotlin.jvm.internal.t.h(strE, "adInstance.id");
        this.f16481j = new RewardedAdInfo(strF, strE);
        lc lcVar = new lc();
        this.f16472a.a(lcVar);
        lcVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(zo this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        ap apVar = this$0.f16482k;
        if (apVar != null) {
            apVar.onUserEarnedReward();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(zo this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        ap apVar = this$0.f16482k;
        if (apVar != null) {
            apVar.onRewardedAdShown();
        }
    }

    public final void a() {
        bx.a(this.f16477f, new Runnable() { // from class: com.ironsource.e20
            @Override // java.lang.Runnable
            public final void run() {
                zo.a(this.f11889a);
            }
        }, 0L, 2, null);
    }

    @Nullable
    public final ap c() {
        return this.f16482k;
    }

    protected final void finalize() {
        a();
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidBecomeVisible() {
        c3.a.f11491a.f(new g3[0]).a(this.f16475d);
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidClick() {
        c3.a.f11491a.a().a(this.f16475d);
        this.f16477f.a(new Runnable() { // from class: com.ironsource.d20
            @Override // java.lang.Runnable
            public final void run() {
                zo.b(this.f11743a);
            }
        });
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidDismiss() {
        this.f16480i.remove(this.f16481j.getAdId());
        c3.a.f11491a.a(new g3[0]).a(this.f16475d);
        this.f16477f.a(new Runnable() { // from class: com.ironsource.g20
            @Override // java.lang.Runnable
            public final void run() {
                zo.c(this.f12212a);
            }
        });
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidReward(@Nullable String str, int i10) {
        f3.u uVar = new f3.u("Virtual Item");
        f3.t tVar = new f3.t(1);
        f3.q qVar = new f3.q("DefaultRewardedVideo");
        String transId = IronSourceUtils.getTransId(System.currentTimeMillis(), this.f16472a.g());
        kotlin.jvm.internal.t.h(transId, "getTransId(System.curren…illis(), adInstance.name)");
        c3.a.f11491a.c(uVar, tVar, qVar, new f3.y(transId)).a(this.f16475d);
        this.f16477f.a(new Runnable() { // from class: com.ironsource.i20
            @Override // java.lang.Runnable
            public final void run() {
                zo.d(this.f12540a);
            }
        });
    }

    @Override // com.ironsource.nc
    public void onAdInstanceDidShow() {
        mg mgVar = this.f16478g;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        c3.a.f11491a.b(new f3.w(mgVar.a(ad_unit))).a(this.f16475d);
        this.f16479h.b(ad_unit);
        this.f16474c.c("onAdInstanceDidShow");
        this.f16477f.a(new Runnable() { // from class: com.ironsource.f20
            @Override // java.lang.Runnable
            public final void run() {
                zo.e(this.f12018a);
            }
        });
    }

    public /* synthetic */ zo(mi miVar, w0 w0Var, q4 q4Var, j3 j3Var, em emVar, jt jtVar, mg mgVar, mg.a aVar, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this(miVar, w0Var, q4Var, j3Var, (i10 & 16) != 0 ? new fm() : emVar, (i10 & 32) != 0 ? ve.f15889a : jtVar, (i10 & 64) != 0 ? el.f11917p.d().k() : mgVar, (i10 & 128) != 0 ? el.f11917p.a().e() : aVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(zo this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        ap apVar = this$0.f16482k;
        if (apVar != null) {
            apVar.onRewardedAdDismissed();
        }
    }

    public final void a(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f16480i.put(this.f16481j.getAdId(), this);
        if (!this.f16473b.a(this.f16472a)) {
            a(hb.f12462a.t());
        } else {
            c3.a.f11491a.d(new g3[0]).a(this.f16475d);
            this.f16473b.a(activity, this.f16472a);
        }
    }

    @NotNull
    public final RewardedAdInfo b() {
        return this.f16481j;
    }

    public final boolean d() {
        boolean zA = this.f16473b.a(this.f16472a);
        c3.a.f11491a.a(zA).a(this.f16475d);
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(zo this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        ap apVar = this$0.f16482k;
        if (apVar != null) {
            apVar.onRewardedAdClicked();
        }
    }

    public final void a(@Nullable ap apVar) {
        this.f16482k = apVar;
    }

    private final void a(final IronSourceError ironSourceError) {
        this.f16480i.remove(this.f16481j.getAdId());
        c3.a.f11491a.a(new f3.j(ironSourceError.getErrorCode()), new f3.k(ironSourceError.getErrorMessage())).a(this.f16475d);
        this.f16477f.a(new Runnable() { // from class: com.ironsource.h20
            @Override // java.lang.Runnable
            public final void run() {
                zo.a(this.f12375a, ironSourceError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(zo this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        c3.d.f11513a.b().a(this$0.f16475d);
        this$0.f16476e.a(this$0.f16472a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(zo this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        ap apVar = this$0.f16482k;
        if (apVar != null) {
            apVar.onRewardedAdFailedToShow(error);
        }
    }

    public final void a(@NotNull RewardedAdInfo rewardedAdInfo) {
        kotlin.jvm.internal.t.i(rewardedAdInfo, "<set-?>");
        this.f16481j = rewardedAdInfo;
    }

    @Override // com.ironsource.nc
    public void a(@Nullable String str) {
        a(hb.f12462a.c(new IronSourceError(0, str)));
    }
}
