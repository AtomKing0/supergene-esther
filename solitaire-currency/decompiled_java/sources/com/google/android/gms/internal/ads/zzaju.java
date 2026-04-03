package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaju {
    public static void zza(zzajv zzajvVar, zzajz zzajzVar, zzdn zzdnVar) {
        for (int i10 = 0; i10 < zzajvVar.zza(); i10++) {
            long jZzb = zzajvVar.zzb(i10);
            List listZzc = zzajvVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i10 == zzajvVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzajvVar.zzb(i10 + 1) - zzajvVar.zzb(i10);
                if (jZzb2 > 0) {
                    zzdnVar.zza(new zzajs(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
