package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaod implements zzadi {
    private final zzaoa zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaod(zzaoa zzaoaVar, int i10, long j10, long j11) {
        this.zza = zzaoaVar;
        this.zzb = i10;
        this.zzc = j10;
        long j12 = (j11 - j10) / ((long) zzaoaVar.zzd);
        this.zzd = j12;
        this.zze = zzb(j12);
    }

    private final long zzb(long j10) {
        return zzet.zzt(j10 * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.FLOOR);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        long jMax = Math.max(0L, Math.min((((long) this.zza.zzc) * j10) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long j11 = ((long) this.zza.zzd) * jMax;
        long jZzb = zzb(jMax);
        zzadj zzadjVar = new zzadj(jZzb, this.zzc + j11);
        if (jZzb >= j10 || jMax == this.zzd - 1) {
            return new zzadg(zzadjVar, zzadjVar);
        }
        long j12 = jMax + 1;
        return new zzadg(zzadjVar, new zzadj(zzb(j12), this.zzc + (j12 * ((long) this.zza.zzd))));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
