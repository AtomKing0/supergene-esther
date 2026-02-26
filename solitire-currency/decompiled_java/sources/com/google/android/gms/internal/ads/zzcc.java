package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcc {
    public static final zzcc zza = new zzbz();

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    protected zzcc() {
    }

    public final boolean equals(@Nullable Object obj) {
        int iZzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcc)) {
            return false;
        }
        zzcc zzccVar = (zzcc) obj;
        if (zzccVar.zzc() == zzc() && zzccVar.zzb() == zzb()) {
            zzcb zzcbVar = new zzcb();
            zzca zzcaVar = new zzca();
            zzcb zzcbVar2 = new zzcb();
            zzca zzcaVar2 = new zzca();
            for (int i10 = 0; i10 < zzc(); i10++) {
                if (!zze(i10, zzcbVar, 0L).equals(zzccVar.zze(i10, zzcbVar2, 0L))) {
                    return false;
                }
            }
            for (int i11 = 0; i11 < zzb(); i11++) {
                if (!zzd(i11, zzcaVar, true).equals(zzccVar.zzd(i11, zzcaVar2, true))) {
                    return false;
                }
            }
            int iZzg = zzg(true);
            if (iZzg == zzccVar.zzg(true) && (iZzh = zzh(true)) == zzccVar.zzh(true)) {
                while (iZzg != iZzh) {
                    int iZzj = zzj(iZzg, 0, true);
                    if (iZzj != zzccVar.zzj(iZzg, 0, true)) {
                        return false;
                    }
                    iZzg = iZzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        zzcb zzcbVar = new zzcb();
        zzca zzcaVar = new zzca();
        int iZzc = zzc() + 217;
        int i11 = 0;
        while (true) {
            i10 = iZzc * 31;
            if (i11 >= zzc()) {
                break;
            }
            iZzc = i10 + zze(i11, zzcbVar, 0L).hashCode();
            i11++;
        }
        int iZzb = i10 + zzb();
        for (int i12 = 0; i12 < zzb(); i12++) {
            iZzb = (iZzb * 31) + zzd(i12, zzcaVar, true).hashCode();
        }
        int iZzg = zzg(true);
        while (iZzg != -1) {
            iZzb = (iZzb * 31) + iZzg;
            iZzg = zzj(iZzg, 0, true);
        }
        return iZzb;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzca zzd(int i10, zzca zzcaVar, boolean z10);

    public abstract zzcb zze(int i10, zzcb zzcbVar, long j10);

    public abstract Object zzf(int i10);

    public int zzg(boolean z10) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z10) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i10, zzca zzcaVar, zzcb zzcbVar, int i11, boolean z10) {
        int i12 = zzd(i10, zzcaVar, false).zzc;
        if (zze(i12, zzcbVar, 0L).zzo != i10) {
            return i10 + 1;
        }
        int iZzj = zzj(i12, i11, z10);
        if (iZzj == -1) {
            return -1;
        }
        return zze(iZzj, zzcbVar, 0L).zzn;
    }

    public int zzj(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == zzh(z10)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == zzh(z10) ? zzg(z10) : i10 + 1;
        }
        throw new IllegalStateException();
    }

    public int zzk(int i10, int i11, boolean z10) {
        if (i10 == zzg(false)) {
            return -1;
        }
        return i10 - 1;
    }

    public final Pair zzl(zzcb zzcbVar, zzca zzcaVar, int i10, long j10) {
        Pair pairZzm = zzm(zzcbVar, zzcaVar, i10, j10, 0L);
        pairZzm.getClass();
        return pairZzm;
    }

    @Nullable
    public final Pair zzm(zzcb zzcbVar, zzca zzcaVar, int i10, long j10, long j11) {
        zzdi.zza(i10, 0, zzc());
        zze(i10, zzcbVar, j11);
        if (j10 == C.TIME_UNSET) {
            long j12 = zzcbVar.zzl;
            j10 = 0;
        }
        int i11 = zzcbVar.zzn;
        zzd(i11, zzcaVar, false);
        while (i11 < zzcbVar.zzo) {
            long j13 = zzcaVar.zze;
            if (j10 == 0) {
                break;
            }
            int i12 = i11 + 1;
            long j14 = zzd(i12, zzcaVar, false).zze;
            if (j10 < 0) {
                break;
            }
            i11 = i12;
        }
        zzd(i11, zzcaVar, true);
        long j15 = zzcaVar.zze;
        long j16 = zzcaVar.zzd;
        if (j16 != C.TIME_UNSET) {
            j10 = Math.min(j10, j16 - 1);
        }
        long jMax = Math.max(0L, j10);
        Object obj = zzcaVar.zzb;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzca zzn(Object obj, zzca zzcaVar) {
        return zzd(zza(obj), zzcaVar, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
