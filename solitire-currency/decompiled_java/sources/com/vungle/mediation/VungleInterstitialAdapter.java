package com.vungle.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.c;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.vungle.ads.a2;
import com.vungle.ads.b2;
import com.vungle.ads.n0;
import com.vungle.ads.p0;
import com.vungle.ads.r;
import com.vungle.ads.u;
import com.vungle.ads.z1;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class VungleInterstitialAdapter extends VungleMediationAdapter implements MediationInterstitialAdapter, MediationBannerAdapter {
    private a2 bannerAdView;
    private RelativeLayout bannerLayout;
    private n0 interstitialAd;
    private MediationBannerListener mediationBannerListener;
    private MediationInterstitialListener mediationInterstitialListener;

    class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f24431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.vungle.ads.c f24433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediationInterstitialListener f24434d;

        a(Context context, String str, com.vungle.ads.c cVar, MediationInterstitialListener mediationInterstitialListener) {
            this.f24431a = context;
            this.f24432b = str;
            this.f24433c = cVar;
            this.f24434d = mediationInterstitialListener;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            this.f24434d.onAdFailedToLoad(VungleInterstitialAdapter.this, adError);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            VungleInterstitialAdapter.this.interstitialAd = new n0(this.f24431a, this.f24432b, this.f24433c);
            VungleInterstitialAdapter.this.interstitialAd.setAdListener(new d());
            VungleInterstitialAdapter.this.interstitialAd.load(null);
        }
    }

    class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f24436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdSize f24437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z1 f24438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f24439d;

        b(Context context, AdSize adSize, z1 z1Var, String str) {
            this.f24436a = context;
            this.f24437b = adSize;
            this.f24438c = z1Var;
            this.f24439d = str;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            if (VungleInterstitialAdapter.this.mediationBannerListener != null) {
                VungleInterstitialAdapter.this.mediationBannerListener.onAdFailedToLoad(VungleInterstitialAdapter.this, adError);
            }
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            VungleInterstitialAdapter.this.bannerLayout = new RelativeLayout(this.f24436a);
            int heightInPixels = this.f24437b.getHeightInPixels(this.f24436a);
            if (heightInPixels <= 0) {
                heightInPixels = Math.round(this.f24438c.getHeight() * this.f24436a.getResources().getDisplayMetrics().density);
            }
            VungleInterstitialAdapter.this.bannerLayout.setLayoutParams(new RelativeLayout.LayoutParams(this.f24437b.getWidthInPixels(this.f24436a), heightInPixels));
            VungleInterstitialAdapter.this.bannerAdView = new a2(this.f24436a, this.f24439d, this.f24438c);
            VungleInterstitialAdapter.this.bannerAdView.setAdListener(new c());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            VungleInterstitialAdapter.this.bannerLayout.addView(VungleInterstitialAdapter.this.bannerAdView, layoutParams);
            VungleInterstitialAdapter.this.bannerAdView.load(null);
        }
    }

    private class c implements r {
        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdClicked(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationBannerListener != null) {
                VungleInterstitialAdapter.this.mediationBannerListener.onAdClicked(VungleInterstitialAdapter.this);
                VungleInterstitialAdapter.this.mediationBannerListener.onAdOpened(VungleInterstitialAdapter.this);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
            AdError adError = VungleMediationAdapter.getAdError(b2Var);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            if (VungleInterstitialAdapter.this.mediationBannerListener != null) {
                VungleInterstitialAdapter.this.mediationBannerListener.onAdFailedToLoad(VungleInterstitialAdapter.this, adError);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
            Log.w(VungleMediationAdapter.TAG, VungleMediationAdapter.getAdError(b2Var).toString());
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdLeftApplication(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationBannerListener != null) {
                VungleInterstitialAdapter.this.mediationBannerListener.onAdLeftApplication(VungleInterstitialAdapter.this);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdLoaded(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationBannerListener != null) {
                VungleInterstitialAdapter.this.mediationBannerListener.onAdLoaded(VungleInterstitialAdapter.this);
            }
        }

        private c() {
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdEnd(@NonNull u uVar) {
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdImpression(@NonNull u uVar) {
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdStart(@NonNull u uVar) {
        }
    }

    private class d implements p0 {
        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdClicked(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationInterstitialListener != null) {
                VungleInterstitialAdapter.this.mediationInterstitialListener.onAdClicked(VungleInterstitialAdapter.this);
            }
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdEnd(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationInterstitialListener != null) {
                VungleInterstitialAdapter.this.mediationInterstitialListener.onAdClosed(VungleInterstitialAdapter.this);
            }
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
            AdError adError = VungleMediationAdapter.getAdError(b2Var);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            if (VungleInterstitialAdapter.this.mediationInterstitialListener != null) {
                VungleInterstitialAdapter.this.mediationInterstitialListener.onAdFailedToLoad(VungleInterstitialAdapter.this, adError);
            }
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
            Log.w(VungleMediationAdapter.TAG, VungleMediationAdapter.getAdError(b2Var).toString());
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdLeftApplication(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationInterstitialListener != null) {
                VungleInterstitialAdapter.this.mediationInterstitialListener.onAdLeftApplication(VungleInterstitialAdapter.this);
            }
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdLoaded(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationInterstitialListener != null) {
                VungleInterstitialAdapter.this.mediationInterstitialListener.onAdLoaded(VungleInterstitialAdapter.this);
            }
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdStart(@NonNull u uVar) {
            if (VungleInterstitialAdapter.this.mediationInterstitialListener != null) {
                VungleInterstitialAdapter.this.mediationInterstitialListener.onAdOpened(VungleInterstitialAdapter.this);
            }
        }

        private d() {
        }

        @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
        public void onAdImpression(@NonNull u uVar) {
        }
    }

    @NonNull
    public static z1 getVungleBannerAdSizeFromGoogleAdSize(AdSize adSize, String str) {
        z1 validAdSizeFromSize = z1.getValidAdSizeFromSize(adSize.getWidth(), adSize.getHeight(), str);
        Log.d(VungleMediationAdapter.TAG, "The requested ad size: " + adSize + "; placementId=" + str + "; vngAdSize=" + validAdSizeFromSize);
        return validAdSizeFromSize;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    @NonNull
    public View getBannerView() {
        Log.d(VungleMediationAdapter.TAG, "getBannerView # instance: " + hashCode());
        return this.bannerLayout;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        Log.d(VungleMediationAdapter.TAG, "onDestroy: " + hashCode());
        if (this.bannerAdView != null) {
            this.bannerLayout.removeAllViews();
            this.bannerAdView.finishAd();
            this.bannerAdView = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(@NonNull Context context, @NonNull MediationBannerListener mediationBannerListener, @NonNull Bundle bundle, @NonNull AdSize adSize, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) {
        this.mediationBannerListener = mediationBannerListener;
        String string = bundle.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load waterfall banner ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            mediationBannerListener.onAdFailedToLoad(this, adError);
            return;
        }
        com.google.ads.mediation.vungle.c.a().c(mediationAdRequest.taggedForChildDirectedTreatment());
        String string2 = bundle.getString("placementID");
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load waterfall banner ad from Liftoff Monetize. Missing or invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            mediationBannerListener.onAdFailedToLoad(this, adError2);
            return;
        }
        z1 vungleBannerAdSizeFromGoogleAdSize = getVungleBannerAdSizeFromGoogleAdSize(adSize, string2);
        Log.d(VungleMediationAdapter.TAG, "requestBannerAd for Placement: " + string2 + " ### Adapter instance: " + hashCode());
        com.google.ads.mediation.vungle.c.a().b(string, context, new b(context, adSize, vungleBannerAdSizeFromGoogleAdSize, string2));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(@NonNull Context context, @NonNull MediationInterstitialListener mediationInterstitialListener, @NonNull Bundle bundle, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) {
        this.mediationInterstitialListener = mediationInterstitialListener;
        String string = bundle.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load waterfall interstitial ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            mediationInterstitialListener.onAdFailedToLoad(this, adError);
            return;
        }
        String string2 = bundle.getString("placementID");
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load waterfall interstitial ad from Liftoff Monetize. Missing or invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            mediationInterstitialListener.onAdFailedToLoad(this, adError2);
        } else {
            com.google.ads.mediation.vungle.c.a().c(mediationAdRequest.taggedForChildDirectedTreatment());
            com.vungle.ads.c cVar = new com.vungle.ads.c();
            if (bundle2 != null && bundle2.containsKey("adOrientation")) {
                cVar.setAdOrientation(bundle2.getInt("adOrientation", 2));
            }
            com.google.ads.mediation.vungle.c.a().b(string, context, new a(context, string2, cVar, mediationInterstitialListener));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        n0 n0Var = this.interstitialAd;
        if (n0Var != null) {
            n0Var.play(null);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }
}
