package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaen extends zzabu {
    public zzaen(final zzacv zzacvVar, int i10, long j10, long j11) {
        long j12;
        Objects.requireNonNull(zzacvVar);
        zzabr zzabrVar = new zzabr() { // from class: com.google.android.gms.internal.ads.zzaek
            @Override // com.google.android.gms.internal.ads.zzabr
            public final long zza(long j13) {
                return zzacvVar.zzb(j13);
            }
        };
        zzaem zzaemVar = new zzaem(zzacvVar, i10, null);
        long jZza = zzacvVar.zza();
        long j13 = zzacvVar.zzj;
        int i11 = zzacvVar.zzd;
        if (i11 > 0) {
            j12 = ((((long) i11) + ((long) zzacvVar.zzc)) / 2) + 1;
        } else {
            int i12 = zzacvVar.zza;
            long j14 = 4096;
            if (i12 == zzacvVar.zzb && i12 > 0) {
                j14 = i12;
            }
            j12 = (((j14 * ((long) zzacvVar.zzg)) * ((long) zzacvVar.zzh)) / 8) + 64;
        }
        super(zzabrVar, zzaemVar, jZza, 0L, j13, j10, j11, j12, Math.max(6, zzacvVar.zzc));
    }
}
