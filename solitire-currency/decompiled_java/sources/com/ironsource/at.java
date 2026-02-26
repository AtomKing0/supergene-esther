package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ss f11314a;

    public static final class a implements LevelPlayInterstitialListener {
        a() {
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdClicked(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11466f, IronSource.AD_UNIT.INTERSTITIAL, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdClosed(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11467g, IronSource.AD_UNIT.INTERSTITIAL, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdLoadFailed(@Nullable IronSourceError ironSourceError) {
            at atVar = at.this;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            et etVar = et.f11994a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            atVar.a(bt.f11462b, ad_unit, etVar.a(objArr));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdOpened(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11463c, IronSource.AD_UNIT.INTERSTITIAL, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdReady(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11461a, IronSource.AD_UNIT.INTERSTITIAL, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdShowFailed(@Nullable IronSourceError ironSourceError, @Nullable AdInfo adInfo) {
            at atVar = at.this;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            et etVar = et.f11994a;
            Object[] objArr = new Object[2];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            objArr[1] = adInfo;
            atVar.a(bt.f11465e, ad_unit, etVar.a(objArr));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdShowSucceeded(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11464d, IronSource.AD_UNIT.INTERSTITIAL, et.f11994a.a(adInfo));
        }
    }

    public static final class b implements LevelPlayRewardedVideoManualListener, LevelPlayRewardedVideoListener {
        b() {
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener
        public void onAdAvailable(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11468h, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdClicked(@Nullable Placement placement, @Nullable AdInfo adInfo) {
            at.this.a(bt.f11466f, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(zs.f16492a.a(placement), adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdClosed(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11467g, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
        public void onAdLoadFailed(@Nullable IronSourceError ironSourceError) {
            at atVar = at.this;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            et etVar = et.f11994a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            atVar.a(bt.f11462b, ad_unit, etVar.a(objArr));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdOpened(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11463c, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
        public void onAdReady(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11461a, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdRewarded(@Nullable Placement placement, @Nullable AdInfo adInfo) {
            at.this.a(bt.f11469i, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(zs.f16492a.a(placement), adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdShowFailed(@Nullable IronSourceError ironSourceError, @Nullable AdInfo adInfo) {
            at atVar = at.this;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            et etVar = et.f11994a;
            Object[] objArr = new Object[2];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            objArr[1] = adInfo;
            atVar.a(bt.f11465e, ad_unit, etVar.a(objArr));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener
        public void onAdUnavailable() {
            at.this.a(bt.f11474n, IronSource.AD_UNIT.REWARDED_VIDEO, et.f11994a.a(new Object[0]));
        }
    }

    public static final class c implements LevelPlayBannerListener {
        c() {
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdClicked(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11466f, IronSource.AD_UNIT.BANNER, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLeftApplication(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11471k, IronSource.AD_UNIT.BANNER, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLoadFailed(@Nullable IronSourceError ironSourceError) {
            at atVar = at.this;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            et etVar = et.f11994a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            atVar.a(bt.f11462b, ad_unit, etVar.a(objArr));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLoaded(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11470j, IronSource.AD_UNIT.BANNER, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdScreenDismissed(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11473m, IronSource.AD_UNIT.BANNER, et.f11994a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdScreenPresented(@Nullable AdInfo adInfo) {
            at.this.a(bt.f11472l, IronSource.AD_UNIT.BANNER, et.f11994a.a(adInfo));
        }
    }

    public at(@NotNull ss javaScriptEvaluator) {
        kotlin.jvm.internal.t.i(javaScriptEvaluator, "javaScriptEvaluator");
        this.f11314a = javaScriptEvaluator;
    }

    private final void b() {
        zs zsVar = zs.f16492a;
        zsVar.a((LevelPlayInterstitialListener) null);
        zsVar.a((LevelPlayRewardedVideoBaseListener) null);
        zsVar.a((LevelPlayBannerListener) null);
    }

    private final void c() {
        zs.f16492a.i();
    }

    public final void a() {
        b();
        c();
    }

    public final void d() {
        zs zsVar = zs.f16492a;
        zsVar.a(new a());
        zsVar.a(new b());
        zsVar.a(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.f11314a.a(str, ad_unit, list);
    }
}
