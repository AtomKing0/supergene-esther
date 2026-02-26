package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcjj implements zzdtm {
    private final Long zza;
    private final String zzb;
    private final zzcif zzc;
    private final zzcjn zzd;

    /* synthetic */ zzcjj(zzcif zzcifVar, zzcjn zzcjnVar, Long l10, String str, zzcji zzcjiVar) {
        this.zzc = zzcifVar;
        this.zzd = zzcjnVar;
        this.zza = l10;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdtw zza() {
        zzcjn zzcjnVar = this.zzd;
        return zzdtx.zza(this.zza.longValue(), zzcjnVar.zza, zzdtq.zzc(zzcjnVar.zzb), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdua zzb() {
        zzcjn zzcjnVar = this.zzd;
        return zzdub.zza(this.zza.longValue(), zzcjnVar.zza, zzdtq.zzc(zzcjnVar.zzb), this.zzc, this.zzb);
    }
}
