package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbxa extends RewardedInterstitialAd {
    private final String zza;
    private final zzbwg zzb;
    private final Context zzc;

    @Nullable
    private FullScreenContentCallback zze;

    @Nullable
    private OnAdMetadataChangedListener zzf;

    @Nullable
    private OnPaidEventListener zzg;
    private final long zzh = System.currentTimeMillis();
    private final zzbwy zzd = new zzbwy();

    public zzbxa(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = com.google.android.gms.ads.internal.client.zzay.zza().zzq(context, str, new zzboi());
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final Bundle getAdMetadata() {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                return zzbwgVar.zzb();
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final String getAdUnitId() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @NonNull
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzc = null;
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzdnVarZzc = zzbwgVar.zzc();
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
        return ResponseInfo.zzb(zzdnVarZzc);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @NonNull
    public final RewardItem getRewardItem() {
        try {
            zzbwg zzbwgVar = this.zzb;
            zzbwd zzbwdVarZzd = zzbwgVar != null ? zzbwgVar.zzd() : null;
            if (zzbwdVarZzd != null) {
                return new zzbwq(zzbwdVarZzd);
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setImmersiveMode(boolean z10) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzh(z10);
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzi(new com.google.android.gms.ads.internal.client.zzfd(onAdMetadataChangedListener));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzj(new com.google.android.gms.ads.internal.client.zzfe(onPaidEventListener));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzl(new zzbwu(serverSideVerificationOptions));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzdx zzdxVar, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            if (this.zzb != null) {
                zzdxVar.zzq(this.zzh);
                this.zzb.zzg(com.google.android.gms.ads.internal.client.zzp.zza.zza(this.zzc, zzdxVar), new zzbwz(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }
}
