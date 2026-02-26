package com.google.ads.mediation.ironsource;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: IronSourceRewardedAdListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements ISDemandOnlyRewardedVideoListener {
    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdClicked(@NonNull String str) {
        MediationRewardedAdCallback mediationRewardedAdCallbackD;
        Log.d(c.f8309a, String.format("IronSource rewarded ad clicked for instance ID: %s", str));
        f fVarA = f.a(str);
        if (fVarA == null || (mediationRewardedAdCallbackD = fVarA.d()) == null) {
            return;
        }
        mediationRewardedAdCallbackD.reportAdClicked();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdClosed(@NonNull String str) {
        MediationRewardedAdCallback mediationRewardedAdCallbackD;
        Log.d(c.f8309a, String.format("IronSource rewarded ad closed for instance ID: %s", str));
        f fVarA = f.a(str);
        if (fVarA != null && (mediationRewardedAdCallbackD = fVarA.d()) != null) {
            mediationRewardedAdCallbackD.onAdClosed();
        }
        f.i(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdLoadFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        AtomicBoolean atomicBoolean = IronSourceMediationAdapter.firstLoadDone;
        if (!atomicBoolean.get()) {
            Log.d(c.f8309a, "(latency fix) skipping first load");
            atomicBoolean.set(true);
            return;
        }
        String str2 = c.f8309a;
        Log.d(str2, String.format("IronSource rewarded ad failed for instance ID: %s", str));
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.e(str2, adError.toString());
        f fVarA = f.a(str);
        if (fVarA != null && fVarA.c() != null) {
            fVarA.c().onFailure(adError);
        }
        f.i(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdLoadSuccess(@NonNull String str) {
        AtomicBoolean atomicBoolean = IronSourceMediationAdapter.firstLoadDone;
        if (!atomicBoolean.get()) {
            Log.d(c.f8309a, "(latency fix) skipping first load");
            atomicBoolean.set(true);
            f.i(str);
        } else {
            Log.d(c.f8309a, String.format("IronSource rewarded ad loaded for instance ID: %s", str));
            f fVarA = f.a(str);
            if (fVarA == null || fVarA.c() == null) {
                return;
            }
            fVarA.j(fVarA.c().onSuccess(fVarA));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdOpened(@NonNull String str) {
        MediationRewardedAdCallback mediationRewardedAdCallbackD;
        Log.d(c.f8309a, String.format("IronSource rewarded ad opened for instance ID: %s", str));
        f fVarA = f.a(str);
        if (fVarA == null || (mediationRewardedAdCallbackD = fVarA.d()) == null) {
            return;
        }
        mediationRewardedAdCallbackD.onAdOpened();
        mediationRewardedAdCallbackD.onVideoStart();
        mediationRewardedAdCallbackD.reportAdImpression();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdRewarded(@NonNull String str) {
        MediationRewardedAdCallback mediationRewardedAdCallbackD;
        r1.b bVar = new r1.b();
        Log.d(c.f8309a, String.format("IronSource rewarded ad received reward: %d %s, for instance ID: %s", Integer.valueOf(bVar.getAmount()), bVar.getType(), str));
        f fVarA = f.a(str);
        if (fVarA == null || (mediationRewardedAdCallbackD = fVarA.d()) == null) {
            return;
        }
        mediationRewardedAdCallbackD.onVideoComplete();
        mediationRewardedAdCallbackD.onUserEarnedReward(bVar);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdShowFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        MediationRewardedAdCallback mediationRewardedAdCallbackD;
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.e(c.f8309a, adError.toString());
        f fVarA = f.a(str);
        if (fVarA != null && (mediationRewardedAdCallbackD = fVarA.d()) != null) {
            mediationRewardedAdCallbackD.onAdFailedToShow(adError);
        }
        f.i(str);
    }
}
