package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazk extends zzazr {

    @Nullable
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzazk(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzd(zzazp zzazpVar) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzazl(zzazpVar, this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzb(int i10) {
    }
}
