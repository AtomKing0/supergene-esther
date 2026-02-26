package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzca {

    @Nullable
    public Object zza;

    @Nullable
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    private zzb zzg = zzb.zza;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzca.class.equals(obj.getClass())) {
            zzca zzcaVar = (zzca) obj;
            if (zzet.zzG(this.zza, zzcaVar.zza) && zzet.zzG(this.zzb, zzcaVar.zzb) && this.zzc == zzcaVar.zzc && this.zzd == zzcaVar.zzd && this.zzf == zzcaVar.zzf && zzet.zzG(this.zzg, zzcaVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.zza;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzb;
        int iHashCode2 = ((((iHashCode + 217) * 31) + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.zzc;
        long j10 = this.zzd;
        return (((((iHashCode2 * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 961) + (this.zzf ? 1 : 0)) * 31) + this.zzg.hashCode();
    }

    public final int zza(int i10) {
        return this.zzg.zza(i10).zzb;
    }

    public final int zzb() {
        int i10 = this.zzg.zzb;
        return 0;
    }

    public final int zzc(long j10) {
        return -1;
    }

    public final int zzd(long j10) {
        this.zzg.zzb(-1);
        return -1;
    }

    public final int zze(int i10) {
        return this.zzg.zza(i10).zza(-1);
    }

    public final int zzf(int i10, int i11) {
        return this.zzg.zza(i10).zza(i11);
    }

    public final int zzg() {
        int i10 = this.zzg.zzd;
        return 0;
    }

    public final long zzh(int i10, int i11) {
        zza zzaVarZza = this.zzg.zza(i10);
        return zzaVarZza.zzb != -1 ? zzaVarZza.zzf[i11] : C.TIME_UNSET;
    }

    public final long zzi(int i10) {
        long j10 = this.zzg.zza(i10).zza;
        return 0L;
    }

    public final long zzj() {
        long j10 = this.zzg.zzc;
        return 0L;
    }

    public final long zzk(int i10) {
        long j10 = this.zzg.zza(i10).zzg;
        return 0L;
    }

    public final zzca zzl(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11, zzb zzbVar, boolean z10) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = i10;
        this.zzd = j10;
        this.zze = 0L;
        this.zzg = zzbVar;
        this.zzf = z10;
        return this;
    }

    public final boolean zzm(int i10) {
        zzb();
        if (i10 != -1) {
            return false;
        }
        this.zzg.zzb(-1);
        return false;
    }

    public final boolean zzn(int i10) {
        boolean z10 = this.zzg.zza(i10).zzh;
        return false;
    }
}
