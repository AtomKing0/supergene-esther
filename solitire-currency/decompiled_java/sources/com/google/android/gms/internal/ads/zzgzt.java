package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgzt {
    public static final /* synthetic */ int zza = 0;
    private static final zzgzt zzb = new zzgzt();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzhaf zzc = new zzgzb();

    private zzgzt() {
    }

    public static zzgzt zza() {
        return zzb;
    }

    public final zzhae zzb(Class cls) {
        zzgyl.zzc(cls, "messageType");
        zzhae zzhaeVarZza = (zzhae) this.zzd.get(cls);
        if (zzhaeVarZza == null) {
            zzhaeVarZza = this.zzc.zza(cls);
            zzgyl.zzc(cls, "messageType");
            zzhae zzhaeVar = (zzhae) this.zzd.putIfAbsent(cls, zzhaeVarZza);
            if (zzhaeVar != null) {
                return zzhaeVar;
            }
        }
        return zzhaeVarZza;
    }
}
