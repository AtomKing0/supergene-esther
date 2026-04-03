package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbqs implements MediationAdLoadCallback {
    final /* synthetic */ zzbqc zza;
    final /* synthetic */ zzbos zzb;
    final /* synthetic */ zzbqy zzc;

    zzbqs(zzbqy zzbqyVar, zzbqc zzbqcVar, zzbos zzbosVar) {
        this.zza = zzbqcVar;
        this.zzb = zzbosVar;
        this.zzc = zzbqyVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    @Nullable
    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationInterstitialAd mediationInterstitialAd = (MediationInterstitialAd) obj;
        if (mediationInterstitialAd != null) {
            try {
                this.zzc.zzb = mediationInterstitialAd;
                this.zza.zzg();
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            }
            return new zzbqz(this.zzb);
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zza.zze("Adapter returned null.");
            return null;
        } catch (RemoteException e11) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e11);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }
}
