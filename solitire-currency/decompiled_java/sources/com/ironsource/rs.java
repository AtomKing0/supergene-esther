package com.ironsource;

import android.webkit.JavascriptInterface;
import com.ironsource.mediationsdk.IronSource;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class rs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ns f14726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ss f14727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final qg f14728c;

    public rs(@NotNull ns adsManager, @NotNull qg uiLifeCycleListener, @NotNull ss javaScriptEvaluator) {
        kotlin.jvm.internal.t.i(adsManager, "adsManager");
        kotlin.jvm.internal.t.i(uiLifeCycleListener, "uiLifeCycleListener");
        kotlin.jvm.internal.t.i(javaScriptEvaluator, "javaScriptEvaluator");
        this.f14726a = adsManager;
        this.f14727b = javaScriptEvaluator;
        this.f14728c = uiLifeCycleListener;
    }

    private final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.f14727b.a(str, ad_unit, list);
    }

    @JavascriptInterface
    public final void addBannerAdToScreen(double d10) {
        this.f14726a.a().a(d10);
    }

    @JavascriptInterface
    public final void closeTestSuite() {
        destroyBannerAd();
        this.f14728c.onClosed();
    }

    @JavascriptInterface
    public final void destroyBannerAd() {
        this.f14726a.a().b();
    }

    @JavascriptInterface
    public final void isInterstitialReady() {
        a("isInterstitialReady", IronSource.AD_UNIT.INTERSTITIAL, et.f11994a.a(Boolean.valueOf(this.f14726a.b().e())));
    }

    @JavascriptInterface
    public final void isRewardedVideoReady() {
        a("isRewardedVideoReady", IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(Boolean.valueOf(this.f14726a.c().a())));
    }

    @JavascriptInterface
    public final void loadBannerAd(@Nullable String str, @NotNull String adNetwork, boolean z10, boolean z11, @NotNull String description, int i10, int i11) {
        kotlin.jvm.internal.t.i(adNetwork, "adNetwork");
        kotlin.jvm.internal.t.i(description, "description");
        this.f14726a.a().a(new ts(adNetwork, z10, Boolean.valueOf(z11), str), description, i10, i11);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(@Nullable String str, @NotNull String adNetwork, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(adNetwork, "adNetwork");
        this.f14726a.b().a(new ts(adNetwork, z10, Boolean.valueOf(z11), str));
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(@NotNull String adNetwork, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(adNetwork, "adNetwork");
        this.f14726a.c().b(new ts(adNetwork, z10, Boolean.valueOf(z11), null, 8, null));
    }

    @JavascriptInterface
    public final void onDataLoaded() {
        this.f14728c.onUIReady();
    }

    @JavascriptInterface
    public final void showInterstitialAd() {
        this.f14726a.b().c();
    }

    @JavascriptInterface
    public final void showRewardedVideoAd() {
        this.f14726a.c().d();
    }

    @JavascriptInterface
    public final void loadBannerAd(@NotNull String adNetwork, boolean z10, boolean z11, @NotNull String description, int i10, int i11) {
        kotlin.jvm.internal.t.i(adNetwork, "adNetwork");
        kotlin.jvm.internal.t.i(description, "description");
        loadBannerAd(null, adNetwork, z10, z11, description, i10, i11);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(@NotNull String adNetwork, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(adNetwork, "adNetwork");
        loadInterstitialAd(null, adNetwork, z10, z11);
    }
}
