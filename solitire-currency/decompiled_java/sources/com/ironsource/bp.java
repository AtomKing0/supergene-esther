package com.ironsource;

import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mt;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bp implements tk, mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final RewardedAdRequest f11446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final uk f11447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final p0<RewardedAd> f11448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final e5 f11449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final nm f11450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j3 f11451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final y0<RewardedAd> f11452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final mt.c f11453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final Executor f11454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ta f11455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private mt f11456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private p4 f11457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f11458m;

    public static final class a implements mt.a {
        a() {
        }

        @Override // com.ironsource.mt.a
        public void a() {
            bp.this.a(hb.f12462a.s());
        }
    }

    public bp(@NotNull RewardedAdRequest adRequest, @NotNull uk loadTaskConfig, @NotNull p0<RewardedAd> adLoadTaskListener, @NotNull e5 auctionResponseFetcher, @NotNull nm networkLoadApi, @NotNull j3 analytics, @NotNull y0<RewardedAd> adObjectFactory, @NotNull mt.c timerFactory, @NotNull Executor taskFinishedExecutor) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(loadTaskConfig, "loadTaskConfig");
        kotlin.jvm.internal.t.i(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.t.i(auctionResponseFetcher, "auctionResponseFetcher");
        kotlin.jvm.internal.t.i(networkLoadApi, "networkLoadApi");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(adObjectFactory, "adObjectFactory");
        kotlin.jvm.internal.t.i(timerFactory, "timerFactory");
        kotlin.jvm.internal.t.i(taskFinishedExecutor, "taskFinishedExecutor");
        this.f11446a = adRequest;
        this.f11447b = loadTaskConfig;
        this.f11448c = adLoadTaskListener;
        this.f11449d = auctionResponseFetcher;
        this.f11450e = networkLoadApi;
        this.f11451f = analytics;
        this.f11452g = adObjectFactory;
        this.f11453h = timerFactory;
        this.f11454i = taskFinishedExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bp this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        if (this$0.f11458m) {
            return;
        }
        this$0.f11458m = true;
        mt mtVar = this$0.f11456k;
        if (mtVar != null) {
            mtVar.cancel();
        }
        c3.c.a aVar = c3.c.f11505a;
        f3.j jVar = new f3.j(error.getErrorCode());
        f3.k kVar = new f3.k(error.getErrorMessage());
        ta taVar = this$0.f11455j;
        if (taVar == null) {
            kotlin.jvm.internal.t.A("taskStartedTime");
            taVar = null;
        }
        aVar.a(jVar, kVar, new f3.f(ta.a(taVar))).a(this$0.f11451f);
        p4 p4Var = this$0.f11457l;
        if (p4Var != null) {
            p4Var.a("onAdInstanceLoadFail");
        }
        this$0.f11448c.onAdLoadFailed(error);
    }

    @Override // com.ironsource.tk
    public void start() {
        this.f11455j = new ta();
        this.f11451f.a(new f3.s(this.f11447b.f()), new f3.n(this.f11447b.g().b()), new f3.b(this.f11446a.getAdId$mediationsdk_release()));
        c3.c.f11505a.a().a(this.f11451f);
        long jH = this.f11447b.h();
        mt.c cVar = this.f11453h;
        mt.b bVar = new mt.b();
        bVar.b(jH);
        v8.k0 k0Var = v8.k0.f35197a;
        mt mtVarA = cVar.a(bVar);
        this.f11456k = mtVarA;
        if (mtVarA != null) {
            mtVarA.a(new a());
        }
        Object objA = this.f11449d.a();
        Throwable thE = v8.t.e(objA);
        if (thE != null) {
            kotlin.jvm.internal.t.g(thE, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.error.ISException");
            a(((ef) thE).a());
            objA = null;
        }
        b5 b5Var = (b5) objA;
        if (b5Var == null) {
            return;
        }
        j3 j3Var = this.f11451f;
        String strB = b5Var.b();
        if (strB != null) {
            j3Var.a(new f3.d(strB));
        }
        JSONObject jSONObjectF = b5Var.f();
        if (jSONObjectF != null) {
            j3Var.a(new f3.m(jSONObjectF));
        }
        String strA = b5Var.a();
        if (strA != null) {
            j3Var.a(new f3.g(strA));
        }
        gh ghVarG = this.f11447b.g();
        lc lcVar = new lc();
        lcVar.a(this);
        mi adInstance = new ni(this.f11446a.getProviderName$mediationsdk_release().value(), lcVar).a(ghVarG.b(gh.Bidder)).b(this.f11447b.i()).c().a(this.f11446a.getAdId$mediationsdk_release()).a(kotlin.collections.r0.n(new gm().a(), bc.f11389a.a(this.f11446a.getExtraParams()))).a();
        j3 j3Var2 = this.f11451f;
        String strE = adInstance.e();
        kotlin.jvm.internal.t.h(strE, "adInstance.id");
        j3Var2.a(new f3.b(strE));
        pm pmVar = new pm(b5Var, this.f11447b.j());
        this.f11457l = new p4(new fh(this.f11446a.getInstanceId(), ghVarG.b(), b5Var.a()), new com.ironsource.mediationsdk.d(), b5Var.c());
        c3.d.f11513a.c().a(this.f11451f);
        nm nmVar = this.f11450e;
        kotlin.jvm.internal.t.h(adInstance, "adInstance");
        nmVar.a(adInstance, pmVar);
    }

    public /* synthetic */ bp(RewardedAdRequest rewardedAdRequest, uk ukVar, p0 p0Var, e5 e5Var, nm nmVar, j3 j3Var, y0 y0Var, mt.c cVar, Executor executor, int i10, kotlin.jvm.internal.k kVar) {
        this(rewardedAdRequest, ukVar, p0Var, e5Var, nmVar, j3Var, y0Var, (i10 & 128) != 0 ? new mt.d() : cVar, (i10 & 256) != 0 ? ve.f15889a.c() : executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bp this$0, mi adInstance) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInstance, "$adInstance");
        if (this$0.f11458m) {
            return;
        }
        this$0.f11458m = true;
        mt mtVar = this$0.f11456k;
        if (mtVar != null) {
            mtVar.cancel();
        }
        ta taVar = this$0.f11455j;
        if (taVar == null) {
            kotlin.jvm.internal.t.A("taskStartedTime");
            taVar = null;
        }
        c3.c.f11505a.a(new f3.f(ta.a(taVar))).a(this$0.f11451f);
        p4 p4Var = this$0.f11457l;
        if (p4Var != null) {
            p4Var.b("onAdInstanceLoadSuccess");
        }
        y0<RewardedAd> y0Var = this$0.f11452g;
        p4 p4Var2 = this$0.f11457l;
        kotlin.jvm.internal.t.f(p4Var2);
        this$0.f11448c.a(y0Var.a(adInstance, p4Var2));
    }

    public final void a(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f11454i.execute(new Runnable() { // from class: com.ironsource.cv
            @Override // java.lang.Runnable
            public final void run() {
                bp.a(this.f11719a, error);
            }
        });
    }

    @Override // com.ironsource.mc
    public void a(@NotNull final mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        this.f11454i.execute(new Runnable() { // from class: com.ironsource.dv
            @Override // java.lang.Runnable
            public final void run() {
                bp.a(this.f11867a, adInstance);
            }
        });
    }

    @Override // com.ironsource.mc
    public void a(@NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        a(hb.f12462a.c(description));
    }
}
