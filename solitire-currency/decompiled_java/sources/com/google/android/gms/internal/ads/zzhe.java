package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhe extends zzcc {
    private final int zzb;
    private final zzwa zzc;

    public zzhe(boolean z10, zzwa zzwaVar) {
        this.zzc = zzwaVar;
        this.zzb = zzwaVar.zzc();
    }

    private final int zzw(int i10, boolean z10) {
        if (z10) {
            return this.zzc.zzd(i10);
        }
        if (i10 >= this.zzb - 1) {
            return -1;
        }
        return i10 + 1;
    }

    private final int zzx(int i10, boolean z10) {
        if (z10) {
            return this.zzc.zze(i10);
        }
        if (i10 <= 0) {
            return -1;
        }
        return i10 - 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zza(Object obj) {
        int iZza;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int iZzp = zzp(obj2);
            if (iZzp != -1 && (iZza = zzu(iZzp).zza(obj3)) != -1) {
                return zzs(iZzp) + iZza;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzca zzd(int i10, zzca zzcaVar, boolean z10) {
        int iZzq = zzq(i10);
        int iZzt = zzt(iZzq);
        zzu(iZzq).zzd(i10 - zzs(iZzq), zzcaVar, z10);
        zzcaVar.zzc += iZzt;
        if (z10) {
            Object objZzv = zzv(iZzq);
            Object obj = zzcaVar.zzb;
            obj.getClass();
            zzcaVar.zzb = Pair.create(objZzv, obj);
        }
        return zzcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzcb zze(int i10, zzcb zzcbVar, long j10) {
        int iZzr = zzr(i10);
        int iZzt = zzt(iZzr);
        int iZzs = zzs(iZzr);
        zzu(iZzr).zze(i10 - iZzt, zzcbVar, j10);
        Object objZzv = zzv(iZzr);
        if (!zzcb.zza.equals(zzcbVar.zzb)) {
            objZzv = Pair.create(objZzv, zzcbVar.zzb);
        }
        zzcbVar.zzb = objZzv;
        zzcbVar.zzn += iZzs;
        zzcbVar.zzo += iZzs;
        return zzcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final Object zzf(int i10) {
        int iZzq = zzq(i10);
        return Pair.create(zzv(iZzq), zzu(iZzq).zzf(i10 - zzs(iZzq)));
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzg(boolean z10) {
        if (this.zzb != 0) {
            int iZza = z10 ? this.zzc.zza() : 0;
            while (zzu(iZza).zzo()) {
                iZza = zzw(iZza, z10);
                if (iZza == -1) {
                }
            }
            return zzt(iZza) + zzu(iZza).zzg(z10);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzh(boolean z10) {
        int i10 = this.zzb;
        if (i10 != 0) {
            int iZzb = z10 ? this.zzc.zzb() : i10 - 1;
            while (zzu(iZzb).zzo()) {
                iZzb = zzx(iZzb, z10);
                if (iZzb == -1) {
                }
            }
            return zzt(iZzb) + zzu(iZzb).zzh(z10);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzj(int i10, int i11, boolean z10) {
        int iZzr = zzr(i10);
        int iZzt = zzt(iZzr);
        int iZzj = zzu(iZzr).zzj(i10 - iZzt, i11 == 2 ? 0 : i11, z10);
        if (iZzj != -1) {
            return iZzt + iZzj;
        }
        int iZzw = zzw(iZzr, z10);
        while (iZzw != -1 && zzu(iZzw).zzo()) {
            iZzw = zzw(iZzw, z10);
        }
        if (iZzw != -1) {
            return zzt(iZzw) + zzu(iZzw).zzg(z10);
        }
        if (i11 == 2) {
            return zzg(z10);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzk(int i10, int i11, boolean z10) {
        int iZzr = zzr(i10);
        int iZzt = zzt(iZzr);
        int iZzk = zzu(iZzr).zzk(i10 - iZzt, 0, false);
        if (iZzk != -1) {
            return iZzt + iZzk;
        }
        int iZzx = zzx(iZzr, false);
        while (iZzx != -1 && zzu(iZzx).zzo()) {
            iZzx = zzx(iZzx, false);
        }
        if (iZzx != -1) {
            return zzt(iZzx) + zzu(iZzx).zzh(false);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzca zzn(Object obj, zzca zzcaVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iZzp = zzp(obj2);
        int iZzt = zzt(iZzp);
        zzu(iZzp).zzn(obj3, zzcaVar);
        zzcaVar.zzc += iZzt;
        zzcaVar.zzb = obj;
        return zzcaVar;
    }

    protected abstract int zzp(Object obj);

    protected abstract int zzq(int i10);

    protected abstract int zzr(int i10);

    protected abstract int zzs(int i10);

    protected abstract int zzt(int i10);

    protected abstract zzcc zzu(int i10);

    protected abstract Object zzv(int i10);
}
