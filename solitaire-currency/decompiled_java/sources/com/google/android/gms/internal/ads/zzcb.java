package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcb {
    public static final Object zza = new Object();
    private static final zzbc zzp;

    @Nullable
    @Deprecated
    public Object zzc;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;

    @Nullable
    public zzav zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;
    public Object zzb = zza;
    public zzbc zzd = zzp;

    static {
        zzam zzamVar = new zzam();
        zzamVar.zza("androidx.media3.common.Timeline");
        zzamVar.zzb(Uri.EMPTY);
        zzp = zzamVar.zzc();
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcb.class.equals(obj.getClass())) {
            zzcb zzcbVar = (zzcb) obj;
            if (zzet.zzG(this.zzb, zzcbVar.zzb) && zzet.zzG(this.zzd, zzcbVar.zzd) && zzet.zzG(null, null) && zzet.zzG(this.zzj, zzcbVar.zzj) && this.zze == zzcbVar.zze && this.zzf == zzcbVar.zzf && this.zzg == zzcbVar.zzg && this.zzh == zzcbVar.zzh && this.zzi == zzcbVar.zzi && this.zzk == zzcbVar.zzk && this.zzm == zzcbVar.zzm && this.zzn == zzcbVar.zzn && this.zzo == zzcbVar.zzo) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.zzb.hashCode() + 217) * 31) + this.zzd.hashCode();
        zzav zzavVar = this.zzj;
        int iHashCode2 = ((iHashCode * 961) + (zzavVar == null ? 0 : zzavVar.hashCode())) * 31;
        long j10 = this.zze;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.zzf;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.zzg;
        int i12 = ((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
        long j13 = this.zzm;
        return ((((((i12 * 961) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + this.zzn) * 31) + this.zzo) * 31;
    }

    public final zzcb zza(Object obj, @Nullable zzbc zzbcVar, @Nullable Object obj2, long j10, long j11, long j12, boolean z10, boolean z11, @Nullable zzav zzavVar, long j13, long j14, int i10, int i11, long j15) {
        this.zzb = obj;
        this.zzd = zzbcVar == null ? zzp : zzbcVar;
        this.zzc = null;
        this.zze = C.TIME_UNSET;
        this.zzf = C.TIME_UNSET;
        this.zzg = C.TIME_UNSET;
        this.zzh = z10;
        this.zzi = z11;
        this.zzj = zzavVar;
        this.zzl = 0L;
        this.zzm = j14;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        return this.zzj != null;
    }
}
