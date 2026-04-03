package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdz extends zzaz {
    final /* synthetic */ zzea zza;

    zzdz(zzea zzeaVar) {
        this.zza = zzeaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzaz, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzea zzeaVar = this.zza;
        zzeaVar.zze.zzb(zzeaVar.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    @Override // com.google.android.gms.ads.internal.client.zzaz, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        zzea zzeaVar = this.zza;
        zzeaVar.zze.zzb(zzeaVar.zzi());
        super.onAdLoaded();
    }
}
