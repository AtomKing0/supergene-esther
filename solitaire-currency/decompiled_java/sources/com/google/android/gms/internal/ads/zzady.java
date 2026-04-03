package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzady implements zzadi {
    final /* synthetic */ zzaeb zza;
    private final long zzb;

    public zzady(zzaeb zzaebVar, long j10) {
        this.zza = zzaebVar;
        this.zzb = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        zzadg zzadgVarZza = this.zza.zzi[0].zza(j10);
        int i10 = 1;
        while (true) {
            zzaeb zzaebVar = this.zza;
            if (i10 >= zzaebVar.zzi.length) {
                return zzadgVarZza;
            }
            zzadg zzadgVarZza2 = zzaebVar.zzi[i10].zza(j10);
            if (zzadgVarZza2.zza.zzc < zzadgVarZza.zza.zzc) {
                zzadgVarZza = zzadgVarZza2;
            }
            i10++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
