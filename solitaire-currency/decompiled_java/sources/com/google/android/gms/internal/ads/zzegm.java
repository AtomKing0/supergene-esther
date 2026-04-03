package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegm implements zzgcf {
    final /* synthetic */ zzegn zza;

    zzegm(zzegn zzegnVar) {
        this.zza = zzegnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzdB(zzeVarZza);
        zzfgd.zzb(zzeVarZza.zza, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* synthetic */ void zzb(Object obj) {
        ((zzcpk) obj).zzk();
    }
}
