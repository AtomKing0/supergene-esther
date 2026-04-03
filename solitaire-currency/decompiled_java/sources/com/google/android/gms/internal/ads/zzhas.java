package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzhas {
    zzhas() {
    }

    abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i10, int i11);

    abstract void zze(Object obj, int i10, long j10);

    abstract void zzf(Object obj, int i10, Object obj2);

    abstract void zzg(Object obj, int i10, zzgwm zzgwmVar);

    abstract void zzh(Object obj, int i10, long j10);

    abstract void zzi(Object obj);

    final boolean zzj(Object obj, zzgzw zzgzwVar) throws IOException {
        int iZzd = zzgzwVar.zzd();
        int i10 = iZzd >>> 3;
        int i11 = iZzd & 7;
        if (i11 == 0) {
            zzh(obj, i10, zzgzwVar.zzl());
            return true;
        }
        if (i11 == 1) {
            zze(obj, i10, zzgzwVar.zzk());
            return true;
        }
        if (i11 == 2) {
            zzg(obj, i10, zzgzwVar.zzp());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw zzgyn.zza();
            }
            zzd(obj, i10, zzgzwVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i12 = i10 << 3;
        while (zzgzwVar.zzc() != Integer.MAX_VALUE && zzj(objZzb, zzgzwVar)) {
        }
        if ((4 | i12) != zzgzwVar.zzd()) {
            throw zzgyn.zzb();
        }
        zzc(objZzb);
        zzf(obj, i10, objZzb);
        return true;
    }
}
