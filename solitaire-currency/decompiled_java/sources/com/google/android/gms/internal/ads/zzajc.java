package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajc implements zzadi {
    final /* synthetic */ zzajd zza;

    /* synthetic */ zzajc(zzajd zzajdVar, zzajb zzajbVar) {
        this.zza = zzajdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        zzajd zzajdVar = this.zza;
        return zzajdVar.zzd.zzf(zzajdVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        zzajd zzajdVar = this.zza;
        long jZzg = zzajdVar.zzd.zzg(j10);
        long j11 = zzajdVar.zzb;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(jZzg);
        zzajd zzajdVar2 = this.zza;
        long jLongValue = j11 + bigIntegerValueOf.multiply(BigInteger.valueOf(zzajdVar2.zzc - zzajdVar2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzadj zzadjVar = new zzadj(j10, Math.max(this.zza.zzb, Math.min(jLongValue - 30000, r0.zzc - 1)));
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
