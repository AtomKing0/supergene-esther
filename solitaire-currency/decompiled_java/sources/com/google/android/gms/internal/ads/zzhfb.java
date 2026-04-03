package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfb implements zzhfl, zzhew {
    private static final Object zza = new Object();
    private volatile zzhfl zzb;
    private volatile Object zzc = zza;

    private zzhfb(zzhfl zzhflVar) {
        this.zzb = zzhflVar;
    }

    public static zzhew zza(zzhfl zzhflVar) {
        return zzhflVar instanceof zzhew ? (zzhew) zzhflVar : new zzhfb(zzhflVar);
    }

    public static zzhfl zzc(zzhfl zzhflVar) {
        return zzhflVar instanceof zzhfb ? zzhflVar : new zzhfb(zzhflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        Object objZzb = this.zzc;
        Object obj = zza;
        if (objZzb == obj) {
            synchronized (this) {
                objZzb = this.zzc;
                if (objZzb == obj) {
                    objZzb = this.zzb.zzb();
                    Object obj2 = this.zzc;
                    if (obj2 != obj && obj2 != objZzb) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZzb + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = objZzb;
                    this.zzb = null;
                }
            }
        }
        return objZzb;
    }
}
