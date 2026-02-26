package com.google.ads.mediation;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class c extends InterstitialAdLoadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    final AbstractAdViewAdapter f8288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final MediationInterstitialListener f8289b;

    public c(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f8288a = abstractAdViewAdapter;
        this.f8289b = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f8289b.onAdFailedToLoad(this.f8288a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void onAdLoaded(InterstitialAd interstitialAd) {
        AbstractAdViewAdapter abstractAdViewAdapter = this.f8288a;
        InterstitialAd interstitialAd2 = interstitialAd;
        abstractAdViewAdapter.mInterstitialAd = interstitialAd2;
        interstitialAd2.setFullScreenContentCallback(new d(abstractAdViewAdapter, this.f8289b));
        this.f8289b.onAdLoaded(this.f8288a);
    }
}
