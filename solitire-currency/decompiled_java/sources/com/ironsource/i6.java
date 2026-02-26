package com.ironsource;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mg;
import com.unity3d.ironsourceads.banner.BannerAdInfo;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class i6 implements v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final mi f12551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final jf f12552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final p4 f12553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final j3 f12554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final em f12555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final jt f12556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final mg f12557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final mg.a f12558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private BannerAdInfo f12559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private WeakReference<j6> f12560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private WeakReference<FrameLayout> f12561k;

    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v10) {
            kotlin.jvm.internal.t.i(v10, "v");
            hf size = i6.this.d().getSize();
            ((FrameLayout) v10).addView(i6.this.d(), 0, new FrameLayout.LayoutParams(size.c(), size.a(), 17));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v10) {
            kotlin.jvm.internal.t.i(v10, "v");
            ((FrameLayout) v10).removeAllViews();
        }
    }

    public i6(@NotNull mi adInstance, @NotNull jf container, @NotNull p4 auctionDataReporter, @NotNull j3 analytics, @NotNull em networkDestroyAPI, @NotNull jt threadManager, @NotNull mg sessionDepthService, @NotNull mg.a sessionDepthServiceEditor) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(container, "container");
        kotlin.jvm.internal.t.i(auctionDataReporter, "auctionDataReporter");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(networkDestroyAPI, "networkDestroyAPI");
        kotlin.jvm.internal.t.i(threadManager, "threadManager");
        kotlin.jvm.internal.t.i(sessionDepthService, "sessionDepthService");
        kotlin.jvm.internal.t.i(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        this.f12551a = adInstance;
        this.f12552b = container;
        this.f12553c = auctionDataReporter;
        this.f12554d = analytics;
        this.f12555e = networkDestroyAPI;
        this.f12556f = threadManager;
        this.f12557g = sessionDepthService;
        this.f12558h = sessionDepthServiceEditor;
        String strF = adInstance.f();
        kotlin.jvm.internal.t.h(strF, "adInstance.instanceId");
        String strE = adInstance.e();
        kotlin.jvm.internal.t.h(strE, "adInstance.id");
        this.f12559i = new BannerAdInfo(strF, strE);
        this.f12560j = new WeakReference<>(null);
        this.f12561k = new WeakReference<>(null);
        cn cnVar = new cn();
        adInstance.a(cnVar);
        cnVar.a(this);
    }

    private final a a() {
        return new a();
    }

    public final void b() {
        bx.a(this.f12556f, new Runnable() { // from class: com.ironsource.vw
            @Override // java.lang.Runnable
            public final void run() {
                i6.a(this.f15980a);
            }
        }, 0L, 2, null);
    }

    @NotNull
    public final BannerAdInfo c() {
        return this.f12559i;
    }

    protected final void finalize() {
        b();
    }

    @Override // com.ironsource.v5
    public void onBannerClick() {
        c3.a.f11491a.a().a(this.f12554d);
        this.f12556f.a(new Runnable() { // from class: com.ironsource.uw
            @Override // java.lang.Runnable
            public final void run() {
                i6.b(this.f15624a);
            }
        });
    }

    @Override // com.ironsource.v5
    public void onBannerShowSuccess() {
        mg mgVar = this.f12557g;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        c3.a.f11491a.f(new f3.w(mgVar.a(ad_unit))).a(this.f12554d);
        this.f12558h.b(ad_unit);
        this.f12553c.c("onBannerShowSuccess");
        this.f12556f.a(new Runnable() { // from class: com.ironsource.tw
            @Override // java.lang.Runnable
            public final void run() {
                i6.c(this.f15487a);
            }
        });
    }

    public /* synthetic */ i6(mi miVar, jf jfVar, p4 p4Var, j3 j3Var, em emVar, jt jtVar, mg mgVar, mg.a aVar, int i10, kotlin.jvm.internal.k kVar) {
        this(miVar, jfVar, p4Var, j3Var, (i10 & 16) != 0 ? new fm() : emVar, (i10 & 32) != 0 ? ve.f15889a : jtVar, (i10 & 64) != 0 ? el.f11917p.d().k() : mgVar, (i10 & 128) != 0 ? el.f11917p.a().e() : aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(i6 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        c3.d.f11513a.b().a(this$0.f12554d);
        this$0.f12555e.a(this$0.f12551a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(i6 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        j6 j6Var = this$0.f12560j.get();
        if (j6Var != null) {
            j6Var.onBannerAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(i6 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        j6 j6Var = this$0.f12560j.get();
        if (j6Var != null) {
            j6Var.onBannerAdShown();
        }
    }

    @NotNull
    public final jf d() {
        return this.f12552b;
    }

    @NotNull
    public final WeakReference<j6> e() {
        return this.f12560j;
    }

    @NotNull
    public final WeakReference<FrameLayout> f() {
        return this.f12561k;
    }

    public final void a(@NotNull BannerAdInfo bannerAdInfo) {
        kotlin.jvm.internal.t.i(bannerAdInfo, "<set-?>");
        this.f12559i = bannerAdInfo;
    }

    public final void b(@NotNull WeakReference<FrameLayout> value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.f12561k = value;
        FrameLayout frameLayout = value.get();
        if (frameLayout != null) {
            frameLayout.addOnAttachStateChangeListener(a());
        }
    }

    public final void a(@NotNull WeakReference<j6> weakReference) {
        kotlin.jvm.internal.t.i(weakReference, "<set-?>");
        this.f12560j = weakReference;
    }
}
