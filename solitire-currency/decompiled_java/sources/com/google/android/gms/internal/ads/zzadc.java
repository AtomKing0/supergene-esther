package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadc {
    public int zza;

    @Nullable
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzadc() {
    }

    public zzadc(zzadc zzadcVar) {
        this.zza = zzadcVar.zza;
        this.zzb = zzadcVar.zzb;
        this.zzc = zzadcVar.zzc;
        this.zzd = zzadcVar.zzd;
        this.zze = zzadcVar.zze;
        this.zzf = zzadcVar.zzf;
        this.zzg = zzadcVar.zzg;
    }

    public final boolean zza(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!zzadd.zzm(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return false;
        }
        int i15 = i13 - 1;
        this.zza = i11;
        this.zzb = zzadd.zza[3 - i12];
        int i16 = zzadd.zzb[i14];
        this.zzd = i16;
        if (i11 == 2) {
            i16 /= 2;
            this.zzd = i16;
        } else if (i11 == 0) {
            i16 /= 4;
            this.zzd = i16;
        }
        int i17 = (i10 >>> 9) & 1;
        this.zzg = zzadd.zzl(i11, i12);
        if (i12 == 3) {
            int i18 = i11 == 3 ? zzadd.zzc[i15] : zzadd.zzd[i15];
            this.zzf = i18;
            this.zzc = (((i18 * 12) / i16) + i17) * 4;
        } else {
            if (i11 == 3) {
                int i19 = i12 == 2 ? zzadd.zze[i15] : zzadd.zzf[i15];
                this.zzf = i19;
                this.zzc = ((i19 * 144) / i16) + i17;
            } else {
                int i20 = zzadd.zzg[i15];
                this.zzf = i20;
                this.zzc = (((i12 == 1 ? 72 : 144) * i20) / i16) + i17;
            }
        }
        this.zze = ((i10 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
