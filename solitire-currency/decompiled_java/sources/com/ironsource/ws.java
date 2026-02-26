package com.ironsource;

import android.os.Handler;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.ironsource.ns;
import com.ironsource.pg;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAd;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ws implements ns.c, ns.d, ns.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final pg.a f16046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final WeakReference<TestSuiteActivity> f16047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Handler f16048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final AtomicReference<LevelPlayBannerAdView> f16049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final AtomicReference<LevelPlayInterstitialAd> f16050e;

    public ws(@NotNull TestSuiteActivity activity, @NotNull Handler handler) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(handler, "handler");
        this.f16046a = el.f11917p.a().q();
        this.f16047b = new WeakReference<>(activity);
        this.f16048c = handler;
        this.f16049d = new AtomicReference<>();
        this.f16050e = new AtomicReference<>();
    }

    private final TestSuiteActivity f() {
        return this.f16047b.get();
    }

    @Override // com.ironsource.ns.b
    public void a(final double d10) {
        final LevelPlayBannerAdView levelPlayBannerAdView;
        final TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF == null || (levelPlayBannerAdView = this.f16049d.get()) == null) {
            return;
        }
        this.f16048c.post(new Runnable() { // from class: com.ironsource.e10
            @Override // java.lang.Runnable
            public final void run() {
                ws.a(testSuiteActivityF, levelPlayBannerAdView, this, d10);
            }
        });
    }

    @Override // com.ironsource.ns.c
    public boolean e() {
        LevelPlayInterstitialAd levelPlayInterstitialAd = this.f16050e.get();
        if (levelPlayInterstitialAd != null) {
            return levelPlayInterstitialAd.isAdReady();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView it) {
        kotlin.jvm.internal.t.i(testSuiteActivity, "$testSuiteActivity");
        kotlin.jvm.internal.t.i(it, "$it");
        testSuiteActivity.getContainer().removeView(it);
    }

    private final FrameLayout.LayoutParams b(double d10) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (((double) zs.f16492a.a()) * d10);
        return layoutParams;
    }

    @Override // com.ironsource.ns.c
    public void c() {
        TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF != null) {
            LevelPlayInterstitialAd levelPlayInterstitialAd = this.f16050e.get();
            kotlin.jvm.internal.t.h(levelPlayInterstitialAd, "interstitialAdRef.get()");
            LevelPlayInterstitialAd.showAd$default(levelPlayInterstitialAd, testSuiteActivityF, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView banner, ws this$0, double d10) {
        kotlin.jvm.internal.t.i(testSuiteActivity, "$testSuiteActivity");
        kotlin.jvm.internal.t.i(banner, "$banner");
        kotlin.jvm.internal.t.i(this$0, "this$0");
        testSuiteActivity.getContainer().addView(banner, this$0.b(d10));
    }

    @Override // com.ironsource.ns.b
    public void b() {
        final LevelPlayBannerAdView andSet;
        final TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF == null || (andSet = this.f16049d.getAndSet(null)) == null) {
            return;
        }
        andSet.destroy();
        this.f16048c.post(new Runnable() { // from class: com.ironsource.d10
            @Override // java.lang.Runnable
            public final void run() {
                ws.a(testSuiteActivityF, andSet);
            }
        });
    }

    @Override // com.ironsource.ns.c
    public void a(@NotNull ts loadAdConfig) {
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
        this.f16046a.a(loadAdConfig);
        AtomicReference<LevelPlayInterstitialAd> atomicReference = this.f16050e;
        String strA = loadAdConfig.a();
        if (strA == null) {
            strA = "";
        }
        LevelPlayInterstitialAd levelPlayInterstitialAd = new LevelPlayInterstitialAd(strA);
        levelPlayInterstitialAd.setListener(new ys());
        levelPlayInterstitialAd.loadAd();
        atomicReference.set(levelPlayInterstitialAd);
    }

    @Override // com.ironsource.ns.d
    public void b(@NotNull ts loadAdConfig) {
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
    }

    @Override // com.ironsource.ns.b
    public void a(@NotNull ts loadAdConfig, @NotNull String description, int i10, int i11) {
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
        kotlin.jvm.internal.t.i(description, "description");
        b();
        TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF != null) {
            this.f16046a.a(loadAdConfig);
            AtomicReference<LevelPlayBannerAdView> atomicReference = this.f16049d;
            String strA = loadAdConfig.a();
            if (strA == null) {
                strA = "";
            }
            LevelPlayBannerAdView levelPlayBannerAdView = new LevelPlayBannerAdView(testSuiteActivityF, strA);
            levelPlayBannerAdView.setAdSize(LevelPlayAdSize.Companion.createCustomSize(i10, i11));
            levelPlayBannerAdView.setBannerListener(new xs());
            levelPlayBannerAdView.loadAd();
            atomicReference.set(levelPlayBannerAdView);
        }
    }

    @Override // com.ironsource.ns.d
    public boolean a() {
        return false;
    }

    @Override // com.ironsource.ns.d
    public void d() {
    }
}
