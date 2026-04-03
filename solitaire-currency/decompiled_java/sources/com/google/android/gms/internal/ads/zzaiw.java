package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaiw {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final zzaf zzf;
    public final int zzg;

    @Nullable
    public final long[] zzh;

    @Nullable
    public final long[] zzi;
    public final int zzj;

    @Nullable
    private final zzaix[] zzk;

    public zzaiw(int i10, int i11, long j10, long j11, long j12, zzaf zzafVar, int i12, @Nullable zzaix[] zzaixVarArr, int i13, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = j10;
        this.zzd = j11;
        this.zze = j12;
        this.zzf = zzafVar;
        this.zzg = i12;
        this.zzk = zzaixVarArr;
        this.zzj = i13;
        this.zzh = jArr;
        this.zzi = jArr2;
    }

    @Nullable
    public final zzaix zza(int i10) {
        return this.zzk[i10];
    }
}
