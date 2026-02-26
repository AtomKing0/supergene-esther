package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcuu implements zzhfc {
    private final zzhfu zza;

    public zzcuu(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzctx zzctxVar = (zzctx) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        zzfxw zzfxwVarZzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeZ)).booleanValue() ? zzfxw.zzo(new zzdei(zzctxVar, zzgcuVar)) : zzfxw.zzn();
        zzhfk.zzb(zzfxwVarZzo);
        return zzfxwVarZzo;
    }
}
