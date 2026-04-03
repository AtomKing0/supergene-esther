package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacs {
    @Nullable
    public static zzbk zza(zzacl zzaclVar, boolean z10) throws Throwable {
        zzbk zzbkVarZza = new zzada().zza(zzaclVar, z10 ? null : zzagc.zza);
        if (zzbkVarZza == null || zzbkVarZza.zza() == 0) {
            return null;
        }
        return zzbkVarZza;
    }

    public static zzacu zzb(zzek zzekVar) {
        zzekVar.zzL(1);
        int iZzo = zzekVar.zzo();
        long jZzd = zzekVar.zzd();
        long j10 = iZzo;
        int i10 = iZzo / 18;
        long[] jArrCopyOf = new long[i10];
        long[] jArrCopyOf2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long jZzt = zzekVar.zzt();
            if (jZzt == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                break;
            }
            jArrCopyOf[i11] = jZzt;
            jArrCopyOf2[i11] = zzekVar.zzt();
            zzekVar.zzL(2);
            i11++;
        }
        zzekVar.zzL((int) ((jZzd + j10) - ((long) zzekVar.zzd())));
        return new zzacu(jArrCopyOf, jArrCopyOf2);
    }
}
