package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.mediation.AppLovinExtras;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoader;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;

/* JADX INFO: compiled from: IronSourceRtbRewardedAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements MediationRewardedAd, RewardedAdLoaderListener, RewardedAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private MediationRewardedAdCallback f8328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> f8329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f8330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RewardedAd f8333f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f8334g;

    public i(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.f8331d = mediationRewardedAdConfiguration.getServerParameters().getString("instanceId", "");
        this.f8330c = mediationRewardedAdConfiguration.getContext();
        this.f8332e = mediationRewardedAdConfiguration.getBidResponse();
        this.f8334g = mediationRewardedAdConfiguration.getWatermark();
        this.f8329b = mediationAdLoadCallback;
    }

    private void b(@NonNull AdError adError) {
        Log.w(c.f8309a, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f8328a;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.f8331d)) {
            this.f8329b.onFailure(r1.a.a(101, "Missing or invalid instance ID."));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinExtras.Keys.KEY_WATERMARK, this.f8334g);
            RewardedAdLoader.loadAd(new RewardedAdRequest.Builder(this.f8331d, this.f8332e).withExtraParams(bundle).build(), this);
        }
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdClicked(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f8328a;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.reportAdClicked();
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdDismissed(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f8328a;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onAdClosed();
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdFailedToShow(@NonNull RewardedAd rewardedAd, @NonNull IronSourceError ironSourceError) {
        b(r1.a.b(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
    public void onRewardedAdLoadFailed(@NonNull IronSourceError ironSourceError) {
        this.f8329b.onFailure(r1.a.b(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
    public void onRewardedAdLoaded(@NonNull RewardedAd rewardedAd) {
        this.f8333f = rewardedAd;
        this.f8328a = this.f8329b.onSuccess(this);
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdShown(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f8328a;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onAdOpened();
        this.f8328a.onVideoStart();
        this.f8328a.reportAdImpression();
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onUserEarnedReward(@NonNull RewardedAd rewardedAd) {
        if (this.f8328a == null) {
            return;
        }
        r1.b bVar = new r1.b();
        this.f8328a.onVideoComplete();
        this.f8328a.onUserEarnedReward(bVar);
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        Log.d(c.f8309a, String.format("Showing IronSource rewarded ad for instance ID: %s", this.f8331d));
        RewardedAd rewardedAd = this.f8333f;
        if (rewardedAd == null) {
            b(r1.a.a(107, "ad is null"));
            return;
        }
        try {
            rewardedAd.setListener(this);
            this.f8333f.show((Activity) context);
        } catch (ClassCastException unused) {
            b(r1.a.a(102, "IronSource requires an Activity context to load ads."));
        }
    }
}
