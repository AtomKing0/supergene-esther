package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfr implements zzhfl {
    private static final Object zza = new Object();
    private volatile zzhfl zzb;
    private volatile Object zzc = zza;

    private zzhfr(zzhfl zzhflVar) {
        this.zzb = zzhflVar;
    }

    public static zzhfl zza(zzhfl zzhflVar) {
        return ((zzhflVar instanceof zzhfr) || (zzhflVar instanceof zzhfb)) ? zzhflVar : new zzhfr(zzhflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhfl zzhflVar = this.zzb;
        if (zzhflVar == null) {
            return this.zzc;
        }
        Object objZzb = zzhflVar.zzb();
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }
}
