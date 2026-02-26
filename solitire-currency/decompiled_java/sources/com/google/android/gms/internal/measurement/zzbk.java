package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbk implements zzbm {
    private final zzh zza;
    private final String zzb;

    public zzbk(zzh zzhVar, String str) {
        this.zza = zzhVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final zzh zza(zzaq zzaqVar) {
        zzh zzhVarZza = this.zza.zza();
        zzhVarZza.zzb(this.zzb, zzaqVar);
        return zzhVarZza;
    }
}
