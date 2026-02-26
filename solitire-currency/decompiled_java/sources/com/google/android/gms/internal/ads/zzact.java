package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzact implements zzadi {
    private final zzacv zza;
    private final long zzb;

    public zzact(zzacv zzacvVar, long j10) {
        this.zza = zzacvVar;
        this.zzb = j10;
    }

    private final zzadj zzb(long j10, long j11) {
        return new zzadj((j10 * 1000000) / ((long) this.zza.zze), this.zzb + j11);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        zzdi.zzb(this.zza.zzk);
        zzacv zzacvVar = this.zza;
        zzacu zzacuVar = zzacvVar.zzk;
        long[] jArr = zzacuVar.zza;
        long[] jArr2 = zzacuVar.zzb;
        int iZzc = zzet.zzc(jArr, zzacvVar.zzb(j10), true, false);
        zzadj zzadjVarZzb = zzb(iZzc == -1 ? 0L : jArr[iZzc], iZzc != -1 ? jArr2[iZzc] : 0L);
        if (zzadjVarZzb.zzb == j10 || iZzc == jArr.length - 1) {
            return new zzadg(zzadjVarZzb, zzadjVarZzb);
        }
        int i10 = iZzc + 1;
        return new zzadg(zzadjVarZzb, zzb(jArr[i10], jArr2[i10]));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
