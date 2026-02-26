package com.ironsource;

import android.content.Context;
import com.ironsource.c3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.f3;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mt;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import com.unity3d.ironsourceads.banner.BannerAdView;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class w6 implements tk, t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final BannerAdRequest f15998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final AdSize f15999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final e5 f16000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final uk f16001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final nm f16002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j3 f16003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final p0<BannerAdView> f16004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final w5 f16005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final mt.c f16006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final Executor f16007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ta f16008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private mt f16009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private p4 f16010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f16011n;

    public static final class a implements mt.a {
        a() {
        }

        @Override // com.ironsource.mt.a
        public void a() {
            w6.this.a(hb.f12462a.s());
        }
    }

    public w6(@NotNull BannerAdRequest adRequest, @NotNull AdSize size, @NotNull e5 auctionResponseFetcher, @NotNull uk loadTaskConfig, @NotNull nm networkLoadApi, @NotNull j3 analytics, @NotNull p0<BannerAdView> adLoadTaskListener, @NotNull w5 adLayoutFactory, @NotNull mt.c timerFactory, @NotNull Executor taskFinishedExecutor) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(size, "size");
        kotlin.jvm.internal.t.i(auctionResponseFetcher, "auctionResponseFetcher");
        kotlin.jvm.internal.t.i(loadTaskConfig, "loadTaskConfig");
        kotlin.jvm.internal.t.i(networkLoadApi, "networkLoadApi");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.t.i(adLayoutFactory, "adLayoutFactory");
        kotlin.jvm.internal.t.i(timerFactory, "timerFactory");
        kotlin.jvm.internal.t.i(taskFinishedExecutor, "taskFinishedExecutor");
        this.f15998a = adRequest;
        this.f15999b = size;
        this.f16000c = auctionResponseFetcher;
        this.f16001d = loadTaskConfig;
        this.f16002e = networkLoadApi;
        this.f16003f = analytics;
        this.f16004g = adLoadTaskListener;
        this.f16005h = adLayoutFactory;
        this.f16006i = timerFactory;
        this.f16007j = taskFinishedExecutor;
    }

    public final void a(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f16007j.execute(new Runnable() { // from class: com.ironsource.z00
            @Override // java.lang.Runnable
            public final void run() {
                w6.a(this.f16361a, error);
            }
        });
    }

    @Override // com.ironsource.t5
    public void onBannerLoadFail(@NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        a(hb.f12462a.c(description));
    }

    @Override // com.ironsource.t5
    public void onBannerLoadSuccess(@NotNull final mi adInstance, @NotNull final jf adContainer) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(adContainer, "adContainer");
        this.f16007j.execute(new Runnable() { // from class: com.ironsource.y00
            @Override // java.lang.Runnable
            public final void run() {
                w6.a(this.f16231a, adInstance, adContainer);
            }
        });
    }

    @Override // com.ironsource.tk
    public void start() {
        this.f16008k = new ta();
        this.f16003f.a(new f3.s(this.f16001d.f()), new f3.n(this.f16001d.g().b()), new f3.c(this.f15999b), new f3.b(this.f15998a.getAdId$mediationsdk_release()));
        c3.c.f11505a.a().a(this.f16003f);
        long jH = this.f16001d.h();
        mt.c cVar = this.f16006i;
        mt.b bVar = new mt.b();
        bVar.b(jH);
        v8.k0 k0Var = v8.k0.f35197a;
        mt mtVarA = cVar.a(bVar);
        this.f16009l = mtVarA;
        if (mtVarA != null) {
            mtVarA.a(new a());
        }
        Object objA = this.f16000c.a();
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
        j3 j3Var = this.f16003f;
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
        gh ghVarG = this.f16001d.g();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        hf hfVar = new hf(AdapterUtils.dpToPixels(applicationContext, this.f15999b.getWidth()), AdapterUtils.dpToPixels(applicationContext, this.f15999b.getHeight()), this.f15999b.getSizeDescription());
        cn cnVar = new cn();
        cnVar.a(this);
        mi adInstance = new ni(this.f15998a.getProviderName$mediationsdk_release().value(), cnVar).a(ghVarG.b(gh.Bidder)).a(hfVar).b(this.f16001d.i()).a(this.f15998a.getAdId$mediationsdk_release()).a(new gm().a()).a();
        pm pmVar = new pm(b5Var, this.f16001d.j());
        this.f16010m = new p4(new fh(this.f15998a.getInstanceId(), ghVarG.b(), b5Var.a()), new com.ironsource.mediationsdk.d(), b5Var.c());
        c3.d.f11513a.c().a(this.f16003f);
        nm nmVar = this.f16002e;
        kotlin.jvm.internal.t.h(adInstance, "adInstance");
        nmVar.a(adInstance, pmVar);
    }

    public /* synthetic */ w6(BannerAdRequest bannerAdRequest, AdSize adSize, e5 e5Var, uk ukVar, nm nmVar, j3 j3Var, p0 p0Var, w5 w5Var, mt.c cVar, Executor executor, int i10, kotlin.jvm.internal.k kVar) {
        this(bannerAdRequest, adSize, e5Var, ukVar, nmVar, j3Var, p0Var, w5Var, (i10 & 256) != 0 ? new mt.d() : cVar, (i10 & 512) != 0 ? ve.f15889a.c() : executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(w6 this$0, IronSourceError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        if (this$0.f16011n) {
            return;
        }
        this$0.f16011n = true;
        mt mtVar = this$0.f16009l;
        if (mtVar != null) {
            mtVar.cancel();
        }
        c3.c.a aVar = c3.c.f11505a;
        f3.j jVar = new f3.j(error.getErrorCode());
        f3.k kVar = new f3.k(error.getErrorMessage());
        ta taVar = this$0.f16008k;
        if (taVar == null) {
            kotlin.jvm.internal.t.A("taskStartedTime");
            taVar = null;
        }
        aVar.a(jVar, kVar, new f3.f(ta.a(taVar))).a(this$0.f16003f);
        p4 p4Var = this$0.f16010m;
        if (p4Var != null) {
            p4Var.a("onBannerLoadFail");
        }
        this$0.f16004g.onAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(w6 this$0, mi adInstance, jf adContainer) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInstance, "$adInstance");
        kotlin.jvm.internal.t.i(adContainer, "$adContainer");
        if (this$0.f16011n) {
            return;
        }
        this$0.f16011n = true;
        mt mtVar = this$0.f16009l;
        if (mtVar != null) {
            mtVar.cancel();
        }
        ta taVar = this$0.f16008k;
        if (taVar == null) {
            kotlin.jvm.internal.t.A("taskStartedTime");
            taVar = null;
        }
        c3.c.f11505a.a(new f3.f(ta.a(taVar))).a(this$0.f16003f);
        p4 p4Var = this$0.f16010m;
        if (p4Var != null) {
            p4Var.b("onBannerLoadSuccess");
        }
        w5 w5Var = this$0.f16005h;
        p4 p4Var2 = this$0.f16010m;
        kotlin.jvm.internal.t.f(p4Var2);
        this$0.f16004g.a(w5Var.a(adInstance, adContainer, p4Var2));
    }
}
