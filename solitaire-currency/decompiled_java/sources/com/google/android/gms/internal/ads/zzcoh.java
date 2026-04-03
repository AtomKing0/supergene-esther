package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcoh implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzcoh(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzaxs zzaxsVar = (zzaxs) this.zza.zzb();
        zzbnx zzbnxVar = (zzbnx) this.zzb.zzb();
        zzgcu zzgcuVarZza = zzfhy.zza();
        zzhfk.zzb(zzgcuVarZza);
        return new zzcoa(zzaxsVar.zzc(), zzbnxVar, zzgcuVarZza);
    }
}
