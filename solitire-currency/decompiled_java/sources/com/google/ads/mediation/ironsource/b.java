package com.google.ads.mediation.ironsource;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: IronSourceBannerAdListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements ISDemandOnlyBannerListener {
    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdClicked(@NonNull String str) {
        MediationBannerAdCallback mediationBannerAdCallbackC;
        Log.d(c.f8309a, String.format("IronSource banner ad clicked for instance ID: %s", str));
        a aVarD = a.d(str);
        if (aVarD == null || (mediationBannerAdCallbackC = aVarD.c()) == null) {
            return;
        }
        mediationBannerAdCallbackC.onAdOpened();
        mediationBannerAdCallbackC.reportAdClicked();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdLeftApplication(@NonNull String str) {
        MediationBannerAdCallback mediationBannerAdCallbackC;
        Log.d(c.f8309a, String.format("IronSource banner ad has caused user to leave the application for instance ID: %s", str));
        a aVarD = a.d(str);
        if (aVarD == null || (mediationBannerAdCallbackC = aVarD.c()) == null) {
            return;
        }
        mediationBannerAdCallbackC.onAdLeftApplication();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdLoadFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.toString());
        a aVarD = a.d(str);
        if (aVarD == null) {
            return;
        }
        MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallbackB = aVarD.b();
        if (mediationAdLoadCallbackB != null) {
            mediationAdLoadCallbackB.onFailure(adError);
        }
        if (ironSourceError.getErrorCode() == 1050 || ironSourceError.getErrorCode() == 619) {
            return;
        }
        a.j(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdLoaded(@NonNull String str) {
        Log.d(c.f8309a, String.format("IronSource banner ad loaded for instance ID: %s", str));
        a aVarD = a.d(str);
        if (aVarD == null || aVarD.e() == null) {
            return;
        }
        aVarD.e().addView(aVarD.f());
        if (aVarD.b() != null) {
            aVarD.k(aVarD.b().onSuccess(aVarD));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdShown(@NonNull String str) {
        MediationBannerAdCallback mediationBannerAdCallbackC;
        Log.d(c.f8309a, String.format("IronSource banner ad shown for instance ID: %s", str));
        a aVarD = a.d(str);
        if (aVarD != null && (mediationBannerAdCallbackC = aVarD.c()) != null) {
            mediationBannerAdCallbackC.reportAdImpression();
        }
        a.a(str);
    }
}
