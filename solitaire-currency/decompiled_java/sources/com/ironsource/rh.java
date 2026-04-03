package com.ironsource;

import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mt;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class rh implements tk, mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final InterstitialAdRequest f14684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final uk f14685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final p0<InterstitialAd> f14686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final e5 f14687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final nm f14688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j3 f14689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final y0<InterstitialAd> f14690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final mt.c f14691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final Executor f14692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ta f14693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private mt f14694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private p4 f14695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14696m;

    public static final class a implements mt.a {
        a() {
        }

        @Override // com.ironsource.mt.a
        public void a() {
            rh.this.a(hb.f12462a.s());
        }
    }

    public rh(@NotNull InterstitialAdRequest adRequest, @NotNull uk loadTaskConfig, @NotNull p0<InterstitialAd> adLoadTaskListener, @NotNull e5 auctionResponseFetcher, @NotNull nm networkLoadApi, @NotNull j3 analytics, @NotNull y0<InterstitialAd> adObjectFactory, @NotNull mt.c timerFactory, @NotNull Executor taskFinishedExecutor) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(loadTaskConfig, "loadTaskConfig");
        kotlin.jvm.internal.t.i(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.t.i(auctionResponseFetcher, "auctionResponseFetcher");
        kotlin.jvm.internal.t.i(networkLoadApi, "networkLoadApi");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(adObjectFactory, "adObjectFactory");
        kotlin.jvm.internal.t.i(timerFactory, "timerFactory");
        kotlin.jvm.internal.t.i(taskFinishedExecutor, "taskFinishedExecutor");
        this.f14684a = adRequest;
        this.f14685b = loadTaskConfig;
        this.f14686c = adLoadTaskListener;
        this.f14687d = auctionResponseFetcher;
        this.f14688e = networkLoadApi;
        this.f14689f = analytics;
        this.f14690g = adObjectFactory;
        this.f14691h = timerFactory;
        this.f14692i = taskFinishedExecutor;
    }

    public final void a(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f14692i.execute(new Runnable() { // from class: com.ironsource.k00
            @Override // java.lang.Runnable
            public final void run() {
                rh.a(this.f12806a, error);
            }
        });
    }

    @Override // com.ironsource.tk
    public void start() {
        this.f14693j = new ta();
        this.f14689f.a(new f3.s(this.f14685b.f()), new f3.n(this.f14685b.g().b()), new f3.b(this.f14684a.getAdId$mediationsdk_release()));
        c3.c.f11505a.a().a(this.f14689f);
        long jH = this.f14685b.h();
        mt.c cVar = this.f14691h;
        mt.b bVar = new mt.b();
        bVar.b(jH);
        v8.k0 k0Var = v8.k0.f35197a;
        mt mtVarA = cVar.a(bVar);
        this.f14694k = mtVarA;
        if (mtVarA != null) {
            mtVarA.a(new a());
        }
        Object objA = this.f14687d.a();
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
        j3 j3Var = this.f14689f;
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
        gh ghVarG = this.f14685b.g();
        lc lcVar = new lc();
        lcVar.a(this);
        mi adInstance = new ni(this.f14684a.getProviderName$mediationsdk_release().value(), lcVar).a(ghVarG.b(gh.Bidder)).b(this.f14685b.i()).a(this.f14684a.getAdId$mediationsdk_release()).a(kotlin.collections.r0.n(new gm().a(), bc.f11389a.a(this.f14684a.getExtraParams()))).a();
        j3 j3Var2 = this.f14689f;
        String strE = adInstance.e();
        kotlin.jvm.internal.t.h(strE, "adInstance.id");
        j3Var2.a(new f3.b(strE));
        pm pmVar = new pm(b5Var, this.f14685b.j());
        this.f14695l = new p4(new fh(this.f14684a.getInstanceId(), ghVarG.b(), b5Var.a()), new com.ironsource.mediationsdk.d(), b5Var.c());
        c3.d.f11513a.c().a(this.f14689f);
        nm nmVar = this.f14688e;
        kotlin.jvm.internal.t.h(adInstance, "adInstance");
        nmVar.a(adInstance, pmVar);
    }

    public /* synthetic */ rh(InterstitialAdRequest interstitialAdRequest, uk ukVar, p0 p0Var, e5 e5Var, nm nmVar, j3 j3Var, y0 y0Var, mt.c cVar, Executor executor, int i10, kotlin.jvm.internal.k kVar) {
        this(interstitialAdRequest, ukVar, p0Var, e5Var, nmVar, j3Var, y0Var, (i10 & 128) != 0 ? new mt.d() : cVar, (i10 & 256) != 0 ? ve.f15889a.c() : executor);
    }

    @Override // com.ironsource.mc
    public void a(@NotNull final mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        this.f14692i.execute(new Runnable() { // from class: com.ironsource.l00
            @Override // java.lang.Runnable
            public final void run() {
                rh.a(this.f12941a, adInstance);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(rh this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        if (this$0.f14696m) {
            return;
        }
        this$0.f14696m = true;
        mt mtVar = this$0.f14694k;
        if (mtVar != null) {
            mtVar.cancel();
        }
        c3.c.a aVar = c3.c.f11505a;
        f3.j jVar = new f3.j(error.getErrorCode());
        f3.k kVar = new f3.k(error.getErrorMessage());
        ta taVar = this$0.f14693j;
        if (taVar == null) {
            kotlin.jvm.internal.t.A("taskStartedTime");
            taVar = null;
        }
        aVar.a(jVar, kVar, new f3.f(ta.a(taVar))).a(this$0.f14689f);
        p4 p4Var = this$0.f14695l;
        if (p4Var != null) {
            p4Var.a("onAdInstanceDidFailToLoad");
        }
        this$0.f14686c.onAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(rh this$0, mi adInstance) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInstance, "$adInstance");
        if (this$0.f14696m) {
            return;
        }
        this$0.f14696m = true;
        mt mtVar = this$0.f14694k;
        if (mtVar != null) {
            mtVar.cancel();
        }
        ta taVar = this$0.f14693j;
        if (taVar == null) {
            kotlin.jvm.internal.t.A("taskStartedTime");
            taVar = null;
        }
        c3.c.f11505a.a(new f3.f(ta.a(taVar))).a(this$0.f14689f);
        p4 p4Var = this$0.f14695l;
        if (p4Var != null) {
            p4Var.b("onAdInstanceDidLoad");
        }
        y0<InterstitialAd> y0Var = this$0.f14690g;
        p4 p4Var2 = this$0.f14695l;
        kotlin.jvm.internal.t.f(p4Var2);
        this$0.f14686c.a(y0Var.a(adInstance, p4Var2));
    }

    @Override // com.ironsource.mc
    public void a(@NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        a(hb.f12462a.c(description));
    }
}
