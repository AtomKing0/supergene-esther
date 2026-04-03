package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzmt<T, B> {
    zzmt() {
    }

    abstract int zza(T t10);

    abstract B zza();

    abstract T zza(T t10, T t11);

    abstract void zza(B b10, int i10, int i11);

    abstract void zza(B b10, int i10, long j10);

    abstract void zza(B b10, int i10, zzij zzijVar);

    abstract void zza(B b10, int i10, T t10);

    abstract void zza(T t10, zznt zzntVar) throws IOException;

    abstract boolean zza(zzlv zzlvVar);

    final boolean zza(B b10, zzlv zzlvVar) throws IOException {
        int iZzd = zzlvVar.zzd();
        int i10 = iZzd >>> 3;
        int i11 = iZzd & 7;
        if (i11 == 0) {
            zzb(b10, i10, zzlvVar.zzl());
            return true;
        }
        if (i11 == 1) {
            zza(b10, i10, zzlvVar.zzk());
            return true;
        }
        if (i11 == 2) {
            zza((Object) b10, i10, zzlvVar.zzp());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw zzkb.zza();
            }
            zza((Object) b10, i10, zzlvVar.zzf());
            return true;
        }
        B bZza = zza();
        int i12 = 4 | (i10 << 3);
        while (zzlvVar.zzc() != Integer.MAX_VALUE && zza((Object) bZza, zzlvVar)) {
        }
        if (i12 != zzlvVar.zzd()) {
            throw zzkb.zzb();
        }
        zza(b10, i10, zze(bZza));
        return true;
    }

    abstract int zzb(T t10);

    abstract void zzb(B b10, int i10, long j10);

    abstract void zzb(T t10, zznt zzntVar) throws IOException;

    abstract void zzb(Object obj, B b10);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t10);

    abstract T zzd(Object obj);

    abstract T zze(B b10);

    abstract void zzf(Object obj);
}
