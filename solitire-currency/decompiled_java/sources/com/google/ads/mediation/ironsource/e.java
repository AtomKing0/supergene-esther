package com.google.ads.mediation.ironsource;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: IronSourceInterstitialAdListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements ISDemandOnlyInterstitialListener {
    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClicked(@NonNull String str) {
        MediationInterstitialAdCallback mediationInterstitialAdCallbackB;
        Log.d(c.f8309a, String.format("IronSource interstitial ad clicked for instance ID: %s", str));
        d dVarA = d.a(str);
        if (dVarA == null || (mediationInterstitialAdCallbackB = dVarA.b()) == null) {
            return;
        }
        mediationInterstitialAdCallbackB.reportAdClicked();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClosed(@NonNull String str) {
        MediationInterstitialAdCallback mediationInterstitialAdCallbackB;
        Log.d(c.f8309a, String.format("IronSource interstitial ad closed for instance ID: %s", str));
        d dVarA = d.a(str);
        if (dVarA != null && (mediationInterstitialAdCallbackB = dVarA.b()) != null) {
            mediationInterstitialAdCallbackB.onAdClosed();
        }
        d.i(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdLoadFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.toString());
        d dVarA = d.a(str);
        if (dVarA != null && dVarA.d() != null) {
            dVarA.d().onFailure(adError);
        }
        d.i(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdOpened(@NonNull String str) {
        MediationInterstitialAdCallback mediationInterstitialAdCallbackB;
        Log.d(c.f8309a, String.format("IronSource interstitial ad opened for instance ID: %s", str));
        d dVarA = d.a(str);
        if (dVarA == null || (mediationInterstitialAdCallbackB = dVarA.b()) == null) {
            return;
        }
        mediationInterstitialAdCallbackB.onAdOpened();
        mediationInterstitialAdCallbackB.reportAdImpression();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdReady(@NonNull String str) {
        Log.d(c.f8309a, String.format("IronSource interstitial ad is ready for instance ID: %s", str));
        d dVarA = d.a(str);
        if (dVarA == null || dVarA.d() == null) {
            return;
        }
        dVarA.j(dVarA.d().onSuccess(dVarA));
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdShowFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        MediationInterstitialAdCallback mediationInterstitialAdCallbackB;
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.toString());
        d dVarA = d.a(str);
        if (dVarA != null && (mediationInterstitialAdCallbackB = dVarA.b()) != null) {
            mediationInterstitialAdCallbackB.onAdFailedToShow(adError);
        }
        d.i(str);
    }
}
